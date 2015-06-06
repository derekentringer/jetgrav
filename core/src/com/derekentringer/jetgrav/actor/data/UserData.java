package com.derekentringer.jetgrav.actor.data;

public abstract class UserData {

    protected UserDataType userDataType;

    public UserData() {
    }

    public UserDataType getUserDataType() {
        return userDataType;
    }

}