package com.derekentringer.jetgrav;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class JetGrav extends ApplicationAdapter {

    private World mWorld;
    private Body mBody;

    private SpriteBatch mSpriteBatch;
    private Sprite mShipSprite;
    private Texture mTexture;
	
	@Override
	public void create () {
        mSpriteBatch = new SpriteBatch();

        mTexture = new Texture(Gdx.files.internal("ship.png"));
        mShipSprite = new Sprite(mTexture);
        mShipSprite.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);

        mWorld = new World(new Vector2(0, -98f), true);

        BodyDef mBodyDef = new BodyDef();
        mBodyDef.type = BodyDef.BodyType.DynamicBody;

        mBodyDef.position.set(mShipSprite.getX(), mShipSprite.getY());

        mBody = mWorld.createBody(mBodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(mShipSprite.getWidth() / 2, mShipSprite.getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        Fixture fixture = mBody.createFixture(fixtureDef);

        shape.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mWorld.step(Gdx.graphics.getDeltaTime(), 6, 2);

        mShipSprite.setPosition(mBody.getPosition().x, mBody.getPosition().y);

        mSpriteBatch.begin();
        mSpriteBatch.draw(mShipSprite, mShipSprite.getX(), mShipSprite.getY());
        mSpriteBatch.end();
	}

    @Override
    public void dispose() {
        mTexture.dispose();
        mWorld.dispose();
    }
}
