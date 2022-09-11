package com.vehicleRental;

import com.vehicleRental.request.Request;

public class Main {
    public static void main(String[] args) {

        Request request = new Request();
        request.actionType = String.valueOf(ActionType.ADD_BRANCH);
        request.targetBranch = "B1";
        request.otherArguments = new String[5];
        request.otherArguments[0] = VehicleType.CAR.name();
        request.otherArguments[1] = VehicleType.BIKE.name();
        request.otherArguments[2] = VehicleType.VAN.name();
        Action.perform(request);

        request.actionType = String.valueOf(ActionType.ADD_VEHICLE);
        request.targetBranch = "B1";
        request.otherArguments = new String[5];
        request.otherArguments[0] = VehicleType.CAR.name();
        request.otherArguments[1] = "V1";
        request.otherArguments[2] = "500";
        Action.perform(request);

        request.actionType = String.valueOf(ActionType.ADD_VEHICLE);
        request.targetBranch = "B1";
        request.otherArguments = new String[5];
        request.otherArguments[0] = VehicleType.CAR.name();
        request.otherArguments[1] = "V2";
        request.otherArguments[2] = "1000";
        Action.perform(request);

        request.actionType = String.valueOf(ActionType.ADD_VEHICLE);
        request.targetBranch = "B1";
        request.otherArguments = new String[5];
        request.otherArguments[0] = VehicleType.BIKE.name();
        request.otherArguments[1] = "V3";
        request.otherArguments[2] = "250";
        Action.perform(request);

        request.actionType = String.valueOf(ActionType.ADD_VEHICLE);
        request.targetBranch = "B1";
        request.otherArguments = new String[5];
        request.otherArguments[0] = VehicleType.BIKE.name();
        request.otherArguments[1] = "V4";
        request.otherArguments[2] = "300";
        Action.perform(request);

        request.actionType = String.valueOf(ActionType.ADD_VEHICLE);
        request.targetBranch = "B1";
        request.otherArguments = new String[5];
        request.otherArguments[0] = VehicleType.BUS.name();
        request.otherArguments[1] = "V5";
        request.otherArguments[2] = "2500";
        Action.perform(request);

        request.actionType = String.valueOf(ActionType.BOOK);
        request.targetBranch = "B1";
        request.otherArguments = new String[5];
        request.otherArguments[0] = VehicleType.VAN.name();
        request.otherArguments[1] = "1";
        request.otherArguments[2] = "5";
        Action.perform(request);

        request.actionType = String.valueOf(ActionType.BOOK);
        request.targetBranch = "B1";
        request.otherArguments = new String[5];
        request.otherArguments[0] = VehicleType.CAR.name();
        request.otherArguments[1] = "1";
        request.otherArguments[2] = "3";
        Action.perform(request);

        request.actionType = String.valueOf(ActionType.BOOK);
        request.targetBranch = "B1";
        request.otherArguments = new String[5];
        request.otherArguments[0] = VehicleType.BIKE.name();
        request.otherArguments[1] = "2";
        request.otherArguments[2] = "3";
        Action.perform(request);

        request.actionType = String.valueOf(ActionType.BOOK);
        request.targetBranch = "B1";
        request.otherArguments = new String[5];
        request.otherArguments[0] = VehicleType.BIKE.name();
        request.otherArguments[1] = "2";
        request.otherArguments[2] = "5";
        Action.perform(request);

        request.actionType = String.valueOf(ActionType.DISPLAY_VEHICLES);
        request.targetBranch = "B1";
        request.otherArguments = new String[5];
        request.otherArguments[0] = "1";
        request.otherArguments[1] = "5";
        Action.perform(request);
    }

    void print(){

    }

}
