package com.kenneth.whp2.actors;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.screens.GameScreen;

public class Spinner extends Actor {
	
	private String type;
	private Texture image;
	public static ArrayList<Spinner> spinnerList = new ArrayList<Spinner>();
	private float speedX, speedY;
	private String length;
	private boolean first = true;
	
	public Spinner(float x, float y, String type, String length) {
		this.type = type;
		spinnerList.add(this);
		setWidth(32);
		setHeight(32);
		setPosition(x * 32, y * 32);
		this.length = length;
		image = Assets.cannonSpinner;
	}
	
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		batch.draw(image, getX(), getY(), getWidth(), getHeight());
	}
	
	public void act(float delta) {
		super.act(delta);
		if (GameScreen.gs.getWrap().getGameState() == 0) {
        speedX = Background.bg.getSpeedX()*5;
        setX(getX() + (speedX * delta));
		setY(getY() + (speedY * delta));
		if (first) {
			first = false;
	        Bullet b = GameScreen.gs.getWrap().getBulletPool().obtain();
	        GameScreen.gs.getWrap().getActiveBullets().add(b);
			 b.init(getX(), getY(), length, type);
		}
		}
	}
}
