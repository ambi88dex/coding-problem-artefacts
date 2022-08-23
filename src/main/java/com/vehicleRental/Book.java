package com.vehicleRental;

public class Book {
    private static Book instance;

    private Book(){

    }

    public static Book getInstance() {
        if(instance == null){
            instance = new Book();
        }
        return instance;
    }

    public void addBooking(){

    }
}
