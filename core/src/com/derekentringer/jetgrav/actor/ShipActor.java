package com.derekentringer.jetgrav.actor;

import com.badlogic.gdx.physics.box2d.Body;
import com.derekentringer.jetgrav.actor.data.ShipUserData;

public class ShipActor extends BaseActor {

    public ShipActor(Body body) {
        super(body);
    }

    @Override
    public ShipUserData getUserData() {
        return (ShipUserData) userData;
    }

    public void gotHit() {
        //TODO handle getting hit
    }

    public void thrust() {
        body.applyForce(getUserData().getThrustImpulse(), getUserData().getThrustImpulse(), false);
    }

    public void shoot() {

    }

}