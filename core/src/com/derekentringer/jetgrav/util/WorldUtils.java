package com.derekentringer.jetgrav.util;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.derekentringer.jetgrav.actor.userdata.GroundUserData;
import com.derekentringer.jetgrav.actor.userdata.ShipUserData;

public class WorldUtils {

    public static World createWorld() {
        return new World(Constants.WORLD_GRAVITY, true);
    }

    public static Body createGround(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(Constants.GROUND_X, Constants.GROUND_Y));
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.GROUND_WIDTH/2, Constants.GROUND_HEIGHT/2);
        body.createFixture(shape, Constants.GROUND_DENSITY);
        body.setUserData(new GroundUserData());
        shape.dispose();
        return body;
    }

    public static Body createShip(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(Constants.SHIP_X, Constants.SHIP_Y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.SHIP_WIDTH/2, Constants.SHIP_HEIGHT/2);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, Constants.SHIP_DENSITY);
        body.resetMassData();
        body.setUserData(new ShipUserData());
        shape.dispose();
        return body;
    }

}
