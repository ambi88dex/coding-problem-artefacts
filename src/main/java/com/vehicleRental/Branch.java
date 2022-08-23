package com.vehicleRental;

import java.util.*;
import java.util.stream.Collectors;

public class Branch {

    private static Branch instance;

    private Branch(){

    }

    public static Branch getInstance(){
        if(instance == null){
            instance = new Branch();
            instance.branchMap = new HashMap<>();
        }
        return instance;
    }

    public void addBranch(String name, String[] allowedVehicleTypes) {
        BranchUnit newBranch = new BranchUnit();
        newBranch.name = name;
        newBranch.allowedVehiclesTypes = Arrays.stream(allowedVehicleTypes).map(Vehicle::getVehicleType).collect(Collectors.toList());
        newBranch.allowedVehicles = new LinkedList<>();
        branchMap.put(name, newBranch);
    }

    public List<VehicleType> allowedVehicles(String branchName){
        if(branchMap.containsKey(branchName)){
            return branchMap.get(branchName).allowedVehiclesTypes;
        }
        return null;
    }

    static class BranchUnit{
        String name;
        List<VehicleType> allowedVehiclesTypes;
        List<Vehicle> allowedVehicles;
    }

    private Map<String, BranchUnit> branchMap;

}
