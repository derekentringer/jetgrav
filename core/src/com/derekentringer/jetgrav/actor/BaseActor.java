package com.derekentringer.jetgrav.actor;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.derekentringer.jetgrav.actor.data.UserData;

public abstract class BaseActor extends Actor {

    protected Body body;
    protected UserData userData;

    public abstract UserData getUserData();

    public BaseActor(Body body) {
        this.body = body;
        this.userData = (UserData) body.getUserData();
    }

}