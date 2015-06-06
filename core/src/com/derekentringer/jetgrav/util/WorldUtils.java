package com.derekentringer.jetgrav.util;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.derekentringer.jetgrav.actor.data.GroundUserData;
import com.derekentringer.jetgrav.actor.data.ShipUserData;
import com.derekentringer.jetgrav.util.constant.GroundConstants;
import com.derekentringer.jetgrav.util.constant.ShipConstants;
import com.derekentringer.jetgrav.util.constant.WorldConstants;

public class WorldUtils {

    public static World createWorld() {
        return new World(WorldConstants.WORLD_ONE_GRAVITY, true);
    }

    public static Body createGround(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(GroundConstants.GROUND_X, GroundConstants.GROUND_Y));
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(GroundConstants.GROUND_WIDTH/2, GroundConstants.GROUND_HEIGHT/2);
        body.createFixture(shape, GroundConstants.GROUND_DENSITY);
        body.setUserData(new GroundUserData());
        shape.dispose();
        return body;
    }

    public static Body createShip(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(ShipConstants.SHIP_X, ShipConstants.SHIP_Y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(ShipConstants.SHIP_WIDTH/2, ShipConstants.SHIP_HEIGHT/2);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, ShipConstants.SHIP_DENSITY);
        body.resetMassData();
        body.setUserData(new ShipUserData());
        shape.dispose();
        return body;
    }

}