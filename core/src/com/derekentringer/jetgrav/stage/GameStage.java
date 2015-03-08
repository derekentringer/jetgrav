package com.derekentringer.jetgrav.stage;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.derekentringer.jetgrav.actor.GroundActor;
import com.derekentringer.jetgrav.actor.ShipActor;
import com.derekentringer.jetgrav.util.WorldUtils;

public class GameStage extends Stage
{
    private static final int VIEWPORT_WIDTH = 13;
    private static final int VIEWPORT_HEIGHT = 20;

    private World world;
    private GroundActor ground;
    private ShipActor ship;

    private final float TIME_STEP = 1/300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;

    public GameStage() {
        setupWorld();
        setupCamera();
        renderer = new Box2DDebugRenderer();
    }

    private void setupWorld() {
        world = WorldUtils.createWorld();
        setupGround();
        setupShip();
    }

    private void setupGround() {
        ground = new GroundActor(WorldUtils.createGround(world));
        addActor(ground);
    }

    private void setupShip() {
        ship = new ShipActor(WorldUtils.createShip(world));
        addActor(ship);
    }

    private void setupCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);
        camera.update();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //fixed timestep
        accumulator += delta;

        while(accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }

        //TODO interpolation
    }

    @Override
    public void draw() {
        super.draw();
        renderer.render(world, camera.combined);
    }

}