package com.derekentringer.jetgrav.actor;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.derekentringer.jetgrav.actor.enums.UserData;

public abstract class BaseActor extends Actor {

    protected Body body;
    protected UserData userData;

    public BaseActor(Body body) {
        this.body = body;
        this.userData = (UserData) body.getUserData();
    }

    public abstract UserData getUserData();

}