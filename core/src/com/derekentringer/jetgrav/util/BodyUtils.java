package com.derekentringer.jetgrav.util;

import com.badlogic.gdx.physics.box2d.Body;
import com.derekentringer.jetgrav.actor.data.UserData;
import com.derekentringer.jetgrav.actor.data.UserDataType;

public class BodyUtils {

    public static boolean bodyIsShip(Body body) {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.SHIP;
    }

    public static boolean bodyIsGround(Body body) {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    }

}