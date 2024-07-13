package com.firstapi.firstapi;

public class User {

    private int userId;
    private String name;

    private String emailId;

    private String phnNumber;

    public User(int userId, String name, String emailId, String phnNumber) {
        this.userId = userId;
        this.name = name;
        this.emailId = emailId;
        this.phnNumber = phnNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhnNumber() {
        return phnNumber;
    }

    public void setPhnNumber(String phnNumber) {
        this.phnNumber = phnNumber;
    }

}
