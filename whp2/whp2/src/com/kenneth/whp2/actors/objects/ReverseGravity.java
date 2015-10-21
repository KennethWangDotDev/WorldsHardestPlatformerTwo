package com.kenneth.whp2.actors.objects;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.kenneth.whp2.Assets;

public class ReverseGravity extends Powerups{
	private float x;
	private float y;
	
	//Parameters that must be set at constructor:
	//protected Texture[] animation;
	//protected float animationTime;

		public ReverseGravity(float x, float y) {
			setWidth(32);
			setHeight(32);
			setPosition(x * 32, y * 32);
			animation = Assets.powerUpReverse;
			animationTime = 0.01f;
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
				 if(Characters.mainCharacter.isReverseGravity()) {
					 Characters.mainCharacter.setReverseGravity(false); 		
				 } else {
					 Characters.mainCharacter.setReverseGravity(true);
				 }
				 return true;
			 }
			return false;
		}
}

