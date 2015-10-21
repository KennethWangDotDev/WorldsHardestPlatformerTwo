package com.kenneth.whp2.actors;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.forever;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.actors.objects.Characters;
import com.kenneth.whp2.screens.GameScreen;


public class startGameTransition extends Actor {
	private float alpha = 1f;
	public startGameTransition() {
		setWidth(800);
		setHeight(480);
	}
	
	public void act(float delta) {
		super.act(delta);
		setColor(Color.BLACK);
		alpha -= 0.1f;
		if (alpha <= 0f) {
			setPosition(-8000, -8000);
			GameScreen.gs.getWrap().addAction(Actions.removeActor(this));
		}
		
		
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, alpha);
		batch.draw(Assets.background, getX()-getWidth()-getWidth(), getY(), getWidth(), getHeight());
		batch.draw(Assets.background, getX()-getWidth(), getY(), getWidth(), getHeight());
		batch.draw(Assets.background, getX(), getY(), getWidth(), getHeight());
	}



}
