package com.derekentringer.jetgrav.actor;

import com.badlogic.gdx.physics.box2d.Body;
import com.derekentringer.jetgrav.actor.userdata.GroundUserData;

public class GroundActor extends BaseActor {

    public GroundActor(Body body) {
        super(body);
    }

    @Override
    public GroundUserData getUserData() {
        return (GroundUserData) userData;
    }

}