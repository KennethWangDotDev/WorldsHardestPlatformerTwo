package com.kenneth.whp2.actors.leveleditor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenneth.whp2.Assets;


public class PointerRight extends Actor {
	private boolean show = true;
	public PointerRight() {
		setWidth(42);
		setHeight(28);
		setPosition(800-64 - (getWidth()), 480/2 - (getHeight() / 2));
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		TextureRegion test = new TextureRegion();
		test.setRegion(Assets.greysliderup);
		if (show)
		batch.draw(test, getX(), getY(), getX(), getY(), getWidth(), getHeight(), 1f, 1f, getRotation(), true);
	}
	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}
}
