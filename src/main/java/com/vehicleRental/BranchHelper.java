package com.vehicleRental;

import java.util.*;
import java.util.stream.Collectors;

public class BranchHelper {

    private static BranchHelper instance;

    private BranchHelper(){

    }

    static class Branch {
        String name;

        List<VehicleType> allowedVehiclesTypes;
        List<Vehicle> allowedVehicles;

        Branch(){
            allowedVehicles = new ArrayList<>();
            allowedVehiclesTypes = new ArrayList<>();
        }
    }



    private Map<String, Branch> branchMap;

    public static BranchHelper getInstance(){
        if(instance == null){
            instance = new BranchHelper();
            instance.branchMap = new HashMap<>();
        }
        return instance;
    }

    public void addBranch(String name, String[] allowedVehicleTypes) {
        Branch newBranch = new Branch();
        newBranch.name = name;
        newBranch.allowedVehiclesTypes = Arrays.stream(allowedVehicleTypes).map(Vehicle::getVehicleType).collect(Collectors.toList());
        newBranch.allowedVehicles = new LinkedList<>();
        branchMap.put(name, newBranch);
    }

    public void addVehicleInABranch(String branchId, Vehicle newVehicle){
        instance.branchMap.get(branchId).allowedVehicles.add(newVehicle);
    }

    public List<VehicleType> getAllowedVehicleTypes(String branchName){
        if(branchMap.containsKey(branchName)){
            return branchMap.get(branchName).allowedVehiclesTypes;
        }
        return null;
    }

    public List<Vehicle> getAllowedVehicles(String branchName){
        if(branchMap.containsKey(branchName)){
            return branchMap.get(branchName).allowedVehicles;
        }
        return null;
    }



}
