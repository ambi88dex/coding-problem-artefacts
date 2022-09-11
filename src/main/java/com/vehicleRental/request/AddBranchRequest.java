//package com.vehicleRental.request;
//
//import com.vehicleRental.Vehicle;
//import com.vehicleRental.VehicleType;
//
//import java.util.Arrays;
//
//public class AddBranchRequest extends Request {
//    VehicleType[] targetVehicles;
//    public AddBranchRequest(){
//        super();
//    }
//
//    AddBranchRequest build(RequestBuilder builder){
//        AddBranchRequest request = new AddBranchRequest();
//        super.build(builder);
//        request.targetVehicles = builder.targetVehicles;
//        return request;
//    }
//
//     static class RequestBuilder extends Request.RequestBuilder{
//        VehicleType[] targetVehicles;
//
//        RequestBuilder addVehicles(String[] vehicles){
//            this.targetVehicles = (VehicleType[]) Arrays.stream(vehicles).map(Vehicle::getVehicleType).toArray();
//            return this;
//        }
//    }
//
//}
