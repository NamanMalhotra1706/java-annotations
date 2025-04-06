package com.bridgelabz.advancedlevel.JSONSerialization;

public class User {

    @JsonField(name= "user_name")
    private String username;

    @JsonField(name="email_id")
    private String emailId;

    private String password;

    User(String username, String emailId, String password){
        this.emailId = emailId;
        this.username = username;
        this.password =password;
    }
}
