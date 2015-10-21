package com.kenneth.whp2.actors.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.kenneth.whp2.Assets;

public class DoubleJump extends Powerups{
	public DoubleJump(float x, float y) {
		setWidth(32);
		setHeight(32);
		setPosition(x * 32, y * 32);
		animation = Assets.powerUpDouble;
		animationTime = 0.05f;
	}
	public void act(float delta){
		super.act(delta);
        collision();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
	
	public boolean collision() {
		 if (super.collision()) {
			 Characters.mainCharacter.setDoubleJump(true);
			 return true;
		 }
		return false;
	}
}

