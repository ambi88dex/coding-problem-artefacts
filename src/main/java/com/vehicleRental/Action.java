package com.vehicleRental;

import com.vehicleRental.request.Request;

import java.util.Map;

public class Action {

    static void perform(Request request){
        ActionType currentActionType = getActionType(request.actionType);
        if(currentActionType == null){
            return;
        }
        switch (currentActionType) {
            case ADD_BRANCH:
                addBranch(request);
                break;
            case ADD_VEHICLE:
                addVehicle(request);
                break;
            case BOOK:
                addBooking(request);
                break;
            default:
                System.out.println("No Correct action found");
                break;
        }
    }

    private static void addBooking(Request request) {
    }

    private static void addVehicle(Request request) {
        VehicleHelper.getInstance().addVehicle(request.targetBranch, request.otherArguments[0], request.otherArguments[1], Integer.parseInt(request.otherArguments[3]));
    }

    private static void addBranch(Request request) {
        Branch.getInstance().addBranch(request.targetBranch, request.otherArguments);
    }

    static private Map<String, ActionType> actionTypeMap;

    static {
        for (ActionType value : ActionType.values()) {
            actionTypeMap.put(value.name(), value);
        }
    }

    static ActionType getActionType(String actionType){

        if(actionTypeMap.isEmpty() || !actionTypeMap.containsKey(actionType)){
            return null;
        }
        return actionTypeMap.get(actionType);
    }
}
