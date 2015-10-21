package com.kenneth.whp2.actors.leveleditor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenneth.whp2.Assets;


public class OrangeLinesHorizontal extends Actor {
	
	public OrangeLinesHorizontal() {
		setWidth(800-64);
		setHeight(1);
		setPosition(0, 0);
		setColor(Color.ORANGE);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		batch.draw(Assets.background, getX(), getY(), getWidth(), getHeight());
		for (int i = 32; i < 800; i = i + 32) {
			batch.draw(Assets.background, getX(), getY() + i, getWidth(), getHeight());
		}
	}
}
