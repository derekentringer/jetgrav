package com.derekentringer.jetgrav.actor;

import com.badlogic.gdx.physics.box2d.Body;
import com.derekentringer.jetgrav.actor.userdata.ShipUserData;

public class ShipActor extends BaseActor {

    public ShipActor(Body body) {
        super(body);
    }

    @Override
    public ShipUserData getUserData() {
        return (ShipUserData) userData;
    }

    //TODO add functionality to move here

    public void thrust() {
        body.applyForce(getUserData().getThrustImpulse(), getUserData().getThrustImpulse(), false);
    }

    public void shoot() {

    }

}