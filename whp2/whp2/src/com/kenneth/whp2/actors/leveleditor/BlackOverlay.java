package com.kenneth.whp2.actors.leveleditor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenneth.whp2.Assets;


public class BlackOverlay extends Actor {
	
	public BlackOverlay() {
		setWidth(64);
		setHeight(480);
		setPosition(800-64, 0);
		setColor(Color.BLACK);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		batch.draw(Assets.background, getX(), getY(), getWidth(), getHeight());
	}
}
