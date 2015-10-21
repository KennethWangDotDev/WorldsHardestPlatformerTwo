package com.kenneth.whp2.actors;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import com.badlogic.gdx.graphics.g2d.Batch;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.forever;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.actors.objects.Characters;


public class Background extends Actor {
	public static Background bg;
	private float speedX;
	private float totalX;
	private boolean forceMovement;
	private boolean force;
	private boolean hell;
	public Background(float width, float height) {
		setWidth(width);
		setHeight(height);
		setPosition(width, 0);
		hell = false;
		if (Background.bg != null) {
		if (Background.bg.hell) hell = true;
		}
		bg = this;
	}
	
	public void act(float delta) {
		super.act(delta);
		totalX -= speedX;
        setX(getX() + (speedX * delta));
		if ((getX() <= 0)  || (getX() >= 800 )){
			setPosition(getWidth(), 0);
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		if (hell) 		batch.setColor(0.513f, 0f, 0f, getColor().a);
		batch.draw(Assets.background, getX()-getWidth()-getWidth(), getY(), getWidth(), getHeight());
		batch.draw(Assets.background, getX()-getWidth(), getY(), getWidth(), getHeight());
		batch.draw(Assets.background, getX(), getY(), getWidth(), getHeight());
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getTotalX() {
		return totalX;
	}

	public void setTotalX(float totalX) {
		this.totalX = totalX;
	}

	public boolean isForceMovement() {
		return forceMovement;
	}

	public void setForceMovement(boolean forceMovement) {
		this.forceMovement = forceMovement;
	}

	public boolean isForce() {
		return force;
	}

	public void setForce(boolean force) {
		this.force = force;
	}

	public boolean isHell() {
		return hell;
	}

	public void setHell(boolean hell) {
		this.hell = hell;
	}

}
