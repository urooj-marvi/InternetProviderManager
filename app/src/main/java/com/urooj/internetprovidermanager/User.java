package com.urooj.internetprovidermanager;

public class User {
    private String name;
    private String phoneNumber;
    private double amount;

    private String id;
    // Change to appropriate data type as needed

    public User(String name, double amount, String phone, String pending) {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String name, String phoneNumber, double amount, String id){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getID() { return id;  }
}
