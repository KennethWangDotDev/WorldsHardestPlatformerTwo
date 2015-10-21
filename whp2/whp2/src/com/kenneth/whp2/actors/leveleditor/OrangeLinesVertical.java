package com.kenneth.whp2.actors.leveleditor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenneth.whp2.Assets;


public class OrangeLinesVertical extends Actor {
	
	public OrangeLinesVertical() {
		setWidth(800-64);
		setHeight(1);
		setPosition(0, 0);
		setColor(Color.ORANGE);
		rotateBy(90);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		TextureRegion test = new TextureRegion();
		test.setRegion(Assets.background);
		for (int i = 32; i < 800 - 32; i = i + 32) {
			batch.draw(test, getX() + i, getY(), getX(), getY(), getWidth(), getHeight(), 1f, 1f, getRotation(), true);
		}
	}
}
