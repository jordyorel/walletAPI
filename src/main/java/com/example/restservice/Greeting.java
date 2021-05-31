package com.example.restservice;

public class Greeting {

    private final long id;
    private final String userName;
    private int phoneNumber;

    public Greeting(long id, String userName, int phoneNumber){
        this.id = id;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public String getuserName() {
        return userName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
    
}
