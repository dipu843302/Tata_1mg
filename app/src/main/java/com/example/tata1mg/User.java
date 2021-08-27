package com.example.tata1mg;

public class User {
    private String name;
    private String email;
   User(){

   }
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
