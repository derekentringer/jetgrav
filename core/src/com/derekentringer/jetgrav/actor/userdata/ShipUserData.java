package com.derekentringer.jetgrav.actor.userdata;

import com.badlogic.gdx.math.Vector2;
import com.derekentringer.jetgrav.actor.enums.UserData;
import com.derekentringer.jetgrav.util.Constants;

public class ShipUserData extends UserData {

    public Vector2 thrustImpulse;

    public ShipUserData() {
        super();

        //TODO set other params for ship here
        thrustImpulse = Constants.SHIP_THRUST_IMPULSE;

        userDataType = UserDataType.SHIP;
    }

    public Vector2 getThrustImpulse() {
        return thrustImpulse;
    }

}