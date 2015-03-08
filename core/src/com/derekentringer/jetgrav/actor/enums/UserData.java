package com.derekentringer.jetgrav.actor.enums;

import com.derekentringer.jetgrav.actor.userdata.UserDataType;

public abstract class UserData {

    protected UserDataType userDataType;

    public UserData() {

    }

    public UserDataType getUserDataType() {
        return userDataType;
    }

}