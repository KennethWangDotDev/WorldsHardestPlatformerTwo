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


public class BlackScreen extends Actor {
	public static BlackScreen b;
	private float totalDelta;
	private int countDown = 5;
	public BlackScreen() {
		b = this;
		setWidth(5000);
		setHeight(6000);
		setPosition(0, 0);
		this.setColor(Color.BLACK);
	}
	
	public void act(float delta) {
		super.act(delta);
		if (GameScreen.gs.getWrap().getGameState() == 2) {
			totalDelta += delta;
			if (totalDelta >= 3f) {
				setPosition(-8000, -8000);
				GameScreen.gs.getWrap().addAction(Actions.removeActor(this));
				GameScreen.gs.getWrap().setGameState(0);
				b = null;
			} else if (totalDelta >= 2f) {
				countDown = 1;
			} else if (totalDelta >= 1f) {
				countDown = 2;
			} else if (totalDelta >= 0f) {
				countDown = 3;
			} 
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		if (GameScreen.gs.getWrap().getGameState() == 1) {
			batch.setColor(getColor().r, getColor().g, getColor().b, 0.5f);
			batch.draw(Assets.background, getX(), getY(), getWidth(), getHeight());
		}

		if (GameScreen.gs.getWrap().getGameState() == 2) {
			batch.setColor(getColor().r, getColor().g, getColor().b, 1f);
			Assets.futuristicTitle.draw(batch, String.valueOf(countDown), 395, 275);
		}
	}

	public static BlackScreen getB() {
		return b;
	}

	public static void setB(BlackScreen b) {
		BlackScreen.b = b;
	}



}
