package com.vehicleRental;

import java.util.Map;

public class Vehicle {

    int price;
    String id;
    VehicleType type;

    static private Map<String, VehicleType> vehicleTypeMap;

    static {
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
        return vehicle;
    }





}
