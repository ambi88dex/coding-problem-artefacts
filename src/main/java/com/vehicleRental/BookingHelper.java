package com.vehicleRental;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BookingHelper {
    private static BookingHelper instance;
    PriorityQueue<BookingEntry> queue;

    private BookingHelper(){

    }

    public static BookingHelper getInstance() {
        if(instance == null){
            instance = new BookingHelper();
        }
        return instance;
    }

    public long addBooking(String targetBranch, String vehicleType, int startTime, int endTime){
        Booking newBooking = new Booking();
        newBooking = new BookingBuilder()
                .build(new BookingBuilder()
                        .addBranch(targetBranch)
                        .addVehicleType(vehicleType)
                        .addStartTime(startTime)
                        .addEndTime(endTime));
        Vehicle bookedVehicle = ifEligibleThenGetVehicle(newBooking);
        if(bookedVehicle == null){
            return -1;
        }
        else{
            newBooking.vehicleId = bookedVehicle.id;
            bookedVehicle.bookingTimeStampList.add(new Vehicle.BookingTimeStamp(startTime,endTime));
            return bookedVehicle.price;
        }

    }

    private Vehicle ifEligibleThenGetVehicle(Booking newBooking) {
        String branchId = newBooking.branchId;
        VehicleType vehicleType = newBooking.vehicleType;
        List<Vehicle> vehicleList = BranchHelper.getInstance().getAllowedVehicles(branchId);
        if(vehicleList == null){
            return null;
        }
        for (Vehicle vehicle : vehicleList) {
            if(vehicle.type.equals(vehicleType)){
                boolean isAnyTimestampOverlapping = false;
                for (Vehicle.BookingTimeStamp bookingTimeStamp : vehicle.bookingTimeStampList) {
                    if((bookingTimeStamp.startTime <= newBooking.startTime && bookingTimeStamp.endTime >= newBooking.endTime)
                    || (bookingTimeStamp.startTime <= newBooking.startTime && bookingTimeStamp.endTime >= newBooking.startTime)
                    || (bookingTimeStamp.startTime <= newBooking.endTime && bookingTimeStamp.endTime >= newBooking.endTime)){
                        isAnyTimestampOverlapping = true;
                    }
                }
                if(!isAnyTimestampOverlapping){
                    return vehicle;
                }
            }
        }
        return null;
    }

    public List<Vehicle> getAllEligibleVehicles(String branchId, int startTime, int endTime){
        List<Vehicle> vehicleList = BranchHelper.getInstance().getAllowedVehicles(branchId);
        List<Vehicle> filteredVehicleList = new ArrayList<>();
        if(vehicleList == null){
            return filteredVehicleList;
        }
        for (Vehicle vehicle : vehicleList) {
            boolean isAnyTimestampOverlapping = false;
            for (Vehicle.BookingTimeStamp bookingTimeStamp : vehicle.bookingTimeStampList) {
                if((bookingTimeStamp.startTime <= startTime && bookingTimeStamp.endTime >= endTime)
                        || (bookingTimeStamp.startTime <= startTime && bookingTimeStamp.endTime >= startTime)
                        || (bookingTimeStamp.startTime <= endTime && bookingTimeStamp.endTime >= endTime)){
                    isAnyTimestampOverlapping = true;
                }
            }
            if(!isAnyTimestampOverlapping){
                filteredVehicleList.add(vehicle);
            }
        }
        return filteredVehicleList;
    }

    public static class Booking {
        String branchId;
        VehicleType vehicleType;
        String vehicleId;
        int startTime;
        int endTime;
    }

    static class BookingBuilder {
        String branchId;
        VehicleType vehicleType;
        String vehicleId;
        int startTime;
        int endTime;

        Booking build(BookingBuilder builder){
            Booking newBooking = new Booking();
            branchId = builder.branchId;
            vehicleType = builder.vehicleType;
            vehicleId = builder.vehicleId;
            startTime = builder.startTime;
            endTime = builder.endTime;
            return newBooking;
        }

        BookingBuilder addBranch(String branchId){
            this.branchId = branchId;
            return this;
        }

        BookingBuilder addVehicleType(String vehicleType){
            this.vehicleType = Vehicle.getVehicleType(vehicleType);
            return this;
        }

        BookingBuilder addVehicleId(String vehicleId){
            this.vehicleId = vehicleId;
            return this;
        }

        BookingBuilder addStartTime(int startTime){
            this.startTime = startTime;
            return this;
        }

        BookingBuilder addEndTime(int endTime){
            this.endTime = endTime;
            return this;
        }
    }

    static class BookingEntry{
        LocalDateTime timestamp;
        Booking bookingDetails;
        BookingEntryType type;
    }

    static enum BookingEntryType{
        ADD,
        REMOVE
    }


}
