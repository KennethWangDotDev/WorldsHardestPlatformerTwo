package com.kenneth.whp2.actors.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;

public class MoveableObject extends Actor {

	// The amount of X and Y movement to occur on the next frame
	protected float speedX, speedY;
	
	//Animation
	protected Texture[] animation;
	protected float animationTime;
	protected int currentState = 0;
	protected float stateTime;
	private float colorValue = 0;
	private boolean colorIncrease = true;
	
	//Collision
    protected Rectangle rectTop = new Rectangle(0, 0, 0, 0); //Side (x, y, width, height)
    protected Rectangle rectBottom = new Rectangle(0, 0, 0, 0); //Vertical
    protected Rectangle rectLeft = new Rectangle(0, 0, 0, 0); //Vertical
    protected Rectangle rectRight = new Rectangle(0, 0, 0, 0); //Vertical
    protected Rectangle rectBottomCenter = new Rectangle(0, 0, 0, 0); //Vertical
    protected Rectangle rectTopCenter = new Rectangle(0, 0, 0, 0); //Vertical
    protected Rectangle rectAbsolute = new Rectangle(0, 0, 0, 0);
	
	//Parameters that must be set at constructor:
	//protected Texture[] animation;
	//protected float animationTime;

	@Override
	public void act(float delta){
		super.act(delta);
		stateTime += delta;
		if (stateTime > animationTime) {
			animate();
			stateTime = 0;
		}
		
		if (colorIncrease) {
			colorValue += 0.01f;
		} else {
			colorValue -= 0.01f;
		}
		
		if (colorValue < 0f) {
			colorValue = 0f;
			colorIncrease = true;
		}
		
		if (colorValue >= 1f) {
			colorValue = 1f;
			colorIncrease = false;
		} 
	}
	
	public void updateRectangles() {
		rectAbsolute.set(getX(), getY(), getWidth(), getHeight());
		  rectTopCenter.set(getX() + (getWidth() / 2), getY() + 32, getWidth() / 8, getHeight() / 8);
		rectBottomCenter.set(getX() + (getWidth() / 2), getY() - 2, getWidth() / 8, getHeight() / 8);
		if (speedY >= 0) {
			rectTop.set(getX() + 0.5f, getY() + (getWidth() / 2), getWidth() - 1, (getHeight() / 2) + (speedY * Gdx.graphics.getDeltaTime())); //Top rectangle with speedY modifier
			rectBottom.set(getX() + 0.5f, getY(), getWidth() - 1, (getHeight() / 2)); //Bottom rectangle with no modifier

		} else {
			rectTop.set(getX() + 0.5f, getY() + (getWidth() / 2), getWidth() - 1, (getHeight() / 2)); //Top rectangle with no modifier
			rectBottom.set(getX() + 0.5f, getY() + (speedY * Gdx.graphics.getDeltaTime()), getWidth() - 1, (getHeight() / 2) - (speedY * Gdx.graphics.getDeltaTime())); //Bottom rectangle with speedY modifier
		}
		
		if (speedX >= 0) {
			rectLeft.set(getX() + 0.5f, getY(),( getWidth() / 2) - 1, getHeight()); //Left rectangle with no modifier
			rectRight.set(getX() + 0.5f + (getWidth() / 2), getY(), (getWidth() / 2) + (speedX * Gdx.graphics.getDeltaTime()) - 1, getHeight()); //Right rectangle with speedX modifier
		} else {
			rectLeft.set(getX() + 0.5f + (speedX * Gdx.graphics.getDeltaTime()), getY(), (getWidth() / 2) - (speedX * Gdx.graphics.getDeltaTime()) - 1, getHeight()); //Left rectangle with speedX modifier
			rectRight.set(getX() + 0.5f+ (getWidth() / 2), getY(), (getWidth() / 2) - 1, getHeight()); //Right rectangle with no modifier
			
		}
  
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		 if (Parameters.currentSkin == 0) {
			batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		 } else if (Parameters.currentSkin == 1){
			 batch.setColor(1f, 0f, 0f, getColor().a);
		 } else if (Parameters.currentSkin == 2){
			 batch.setColor(0f, 1f, 0.235f, getColor().a);
		 } else if (Parameters.currentSkin == 3) {
			 batch.setColor(1f, 0f, 0.9f, getColor().a);
		 } else if (Parameters.currentSkin == 4) {
			 batch.setColor(1f, 1f, 0.6f, getColor().a);
		 } else if (Parameters.currentSkin == 5) {
			 batch.setColor(1f, 0.5f, 0f, getColor().a);
		 } else if (Parameters.currentSkin == 6) {
			 batch.setColor(1f, colorValue, colorValue, getColor().a);
		 } else if (Parameters.currentSkin == 7) {
			 batch.setColor(colorValue, 1-colorValue, 1f, getColor().a);
		 } else if (Parameters.currentSkin == 8) {
			 batch.setColor(1f, 1f, colorValue, getColor().a);
		 }
		batch.draw(animation[currentState], getX(), getY(), getWidth(), getHeight());
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
	}
	
	public void animate() {
		currentState++;
		if (currentState == animation.length) currentState = 0;
	}



}
