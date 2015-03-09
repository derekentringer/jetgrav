package com.derekentringer.jetgrav.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.derekentringer.jetgrav.actor.GroundActor;
import com.derekentringer.jetgrav.actor.ShipActor;
import com.derekentringer.jetgrav.util.WorldUtils;

public class GameStage extends Stage implements ContactListener
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

    private Rectangle screenLeftSide;
    private Vector3 touchPoint;

    public GameStage() {
        setupWorld();
        setupCamera();
        setupLeftTouch();
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

    private void setupLeftTouch() {
        touchPoint = new Vector3();
        screenLeftSide = new Rectangle(getCamera().viewportWidth/2, getCamera().viewportWidth/2, 0, getCamera().viewportHeight);
        Gdx.input.setInputProcessor(this);
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

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        translateScreenToWorldCoordinates(x, y);
        if(leftSideTouched(touchPoint.x, touchPoint.y)) {
            ship.thrust();
        }
        return super.touchDown(x, y, pointer, button);
    }

    private boolean leftSideTouched(float x, float y) {
        return screenLeftSide.contains(x, y);
    }

    /**
     * Helper function to get the actual coordinates in the world
     * @param x
     * @param y
     */
    private void translateScreenToWorldCoordinates(int x, int y) {
        getCamera().unproject(touchPoint.set(x, y, 0));
    }

    @Override
    public void beginContact(Contact contact) {

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
    
}