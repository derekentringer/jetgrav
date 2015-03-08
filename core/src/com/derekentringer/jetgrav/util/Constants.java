package com.derekentringer.jetgrav.util;

import com.badlogic.gdx.math.Vector2;

public class Constants {

    //game dimens
    public static final int GAME_WIDTH = 480;
    public static final int GAME_HEIGHT = 800;

    //gravity values
    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -1);

    //ground values
    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 50f;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;

    //ship values
    public static final float SHIP_WIDTH = 1f;
    public static final float SHIP_HEIGHT = 1f;
    public static final float SHIP_X = 2;
    public static final float SHIP_Y = GROUND_Y+GROUND_HEIGHT*4;
    public static float SHIP_DENSITY = 0.5f;

}
