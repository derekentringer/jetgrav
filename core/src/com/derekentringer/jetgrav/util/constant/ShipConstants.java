package com.derekentringer.jetgrav.util.constant;

import com.badlogic.gdx.math.Vector2;

public class ShipConstants {

    public static final float SHIP_WIDTH = 1f;
    public static final float SHIP_HEIGHT = 1f;
    public static final float SHIP_X = 2;
    public static final float SHIP_Y = GroundConstants.GROUND_Y + GroundConstants.GROUND_HEIGHT * 4;
    public static float SHIP_DENSITY = 0.5f;
    //TODO update this for x and y
    public static final Vector2 SHIP_THRUST_IMPULSE = new Vector2(0, 13f);

}