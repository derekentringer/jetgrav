package com.derekentringer.jetgrav.actor.data;

import com.badlogic.gdx.math.Vector2;
import com.derekentringer.jetgrav.util.constant.Constants;

public class ShipUserData extends UserData {

    public Vector2 mThrustImpulse;

    public ShipUserData() {
        super();

        userDataType = UserDataType.SHIP;

        mThrustImpulse = Constants.SHIP_THRUST_IMPULSE;
    }

    public Vector2 getThrustImpulse() {
        return mThrustImpulse;
    }

    public void setThrustImpulse(Vector2 thrustImpulse) {
        mThrustImpulse.set(thrustImpulse);
    }

}