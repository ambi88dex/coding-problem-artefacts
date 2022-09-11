package com.vehicleRental;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vehicle {

    int price;
    String id;
    VehicleType type;
    List<BookingTimeStamp> bookingTimeStampList;

    static private Map<String, VehicleType> vehicleTypeMap;

    static {
        vehicleTypeMap = new HashMap<>();
        for (VehicleType value : VehicleType.values()) {
            vehicleTypeMap.put(value.name(), value);
        }
    }

    public static class VehicleBuilder{
        int price;
        String id;
        VehicleType type;

        public VehicleBuilder addPrice(int price){
            this.price = price;
            return this;
        }

        public VehicleBuilder addVehicleType(String vehicleType) {
            this.type = getVehicleType(vehicleType);
            return this;
        }

        public VehicleBuilder addVehicleId(String id) {
            this.id = id;
            return this;
        }
    }

    static public VehicleType getVehicleType(String vehicleType){
        if(vehicleTypeMap.isEmpty() || !vehicleTypeMap.containsKey(vehicleType)){
            return null;
        }
        return vehicleTypeMap.get(vehicleType);
    }

    public Vehicle build(VehicleBuilder builder){
        Vehicle vehicle = new Vehicle();
        vehicle.id = builder.id;
        vehicle.price = builder.price;
        vehicle.type = builder.type;
        vehicle.bookingTimeStampList = new ArrayList<>();
        return vehicle;
    }

    static class BookingTimeStamp{
        int startTime;
        int endTime;

        public BookingTimeStamp(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }





}
