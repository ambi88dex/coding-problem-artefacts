//package com.vehicleRental.request;
//
//import com.vehicleRental.Vehicle;
//import com.vehicleRental.VehicleType;
//
//import java.util.Arrays;
//
//public class AddVehicleRequest extends Request {
//    Vehicle carDescription;
//    public AddVehicleRequest(){
//        super();
//    }
//
//    AddVehicleRequest build(RequestBuilder builder){
//        AddVehicleRequest request = new AddVehicleRequest();
//        super.build(builder);
//        request.carDescription = builder.carDescription;
//        return request;
//    }
//
//    static class RequestBuilder extends Request.RequestBuilder{
//        Vehicle carDescription;
//
//        RequestBuilder addVehicleType(String vehicleType){
//            Vehicle.VehicleBuilder builder = new Vehicle.VehicleBuilder();
//            builder.addVehicleType(vehicleType);
//            builder.addveh
//            this.carDescription = new Vehicle().build( new Vehicle.VehicleBuilder()
//                    .addVehicleType(vehicleType)
//                    .addPrice()) ;
//            return this;
//        }
//    }
//
//}