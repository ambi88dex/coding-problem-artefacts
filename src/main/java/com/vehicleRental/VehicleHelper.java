package com.vehicleRental;

import java.util.HashMap;
import java.util.Map;

public class VehicleHelper {

    private static VehicleHelper instance;

    public static VehicleHelper getInstance(){
        if(instance == null){
            instance = new VehicleHelper();
            instance.vehicleIdToVehicleObjMap = new HashMap<>();
            instance.vehicleIdToBranchMap = new HashMap<>();
        }
        return instance;
    }

    private Map<String, Vehicle> vehicleIdToVehicleObjMap;

    private Map<String, String> vehicleIdToBranchMap;

    public void addVehicle(String targetBranch, String vehicleType, String vehicleId, int price){
        Vehicle newVehicle = new Vehicle();
        newVehicle = newVehicle.build(new Vehicle.VehicleBuilder()
                .addPrice(price)
                .addVehicleId(vehicleId)
                .addVehicleType(vehicleType));
        instance.vehicleIdToVehicleObjMap.put(vehicleId, newVehicle);
        instance.vehicleIdToBranchMap.put(newVehicle.id, targetBranch);
        BranchHelper.getInstance().addVehicleInABranch(targetBranch, newVehicle);
    }


}
