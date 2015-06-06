package com.derekentringer.jetgrav.actor.userdata;

import com.badlogic.gdx.math.Vector2;
import com.derekentringer.jetgrav.actor.enums.UserData;
import com.derekentringer.jetgrav.util.Constants;

public class ShipUserData extends UserData {

    public Vector2 thrustImpulse;

    public ShipUserData() {
        super();

        userDataType = UserDataType.SHIP;

        thrustImpulse = Constants.SHIP_THRUST_IMPULSE;
    }

    public Vector2 getThrustImpulse() {
        return thrustImpulse;
    }

}