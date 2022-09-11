package com.vehicleRental.request;

public class Request {
    public String actionType;
    public String targetBranch;
    public String[] otherArguments;


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
