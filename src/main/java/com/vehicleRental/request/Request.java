package com.vehicleRental.request;

import com.vehicleRental.ActionType;
import com.vehicleRental.Branch;

public class Request {
    public String actionType;
    public String targetBranch;
    public String[] otherArguments;


    // created a package-private constructor so that Request will be instantiated only via children classes.
    Request(){

    }

    Request build(RequestBuilder builder){
        Request request = new Request();
        request.actionType = builder.actionType;
        request.targetBranch = builder.targetBranch;
        return request;
    }

    static class RequestBuilder{
        String actionType;
        String targetBranch;
    }
}
