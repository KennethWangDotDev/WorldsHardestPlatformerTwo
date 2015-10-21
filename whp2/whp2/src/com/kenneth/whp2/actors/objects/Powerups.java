package com.kenneth.whp2.actors.objects;
 
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;
import com.kenneth.whp2.actors.Background;
import com.kenneth.whp2.screens.GameScreen;
 
public class Powerups extends MoveableObject {
	
	//Parameters that must be set at constructor:
	//protected Texture[] animation;
	//protected float animationTime;     
	
	private boolean gravity = false;
	private boolean dead;
	
	public void act(float delta){
		if (GameScreen.gs.getWrap().getGameState() == 0) {
		super.act(delta);
		updateRectangles();
		applyGravity();
        speedX = Background.bg.getSpeedX()*5;
        setX(getX() + (speedX * delta));
		setY(getY() + (speedY * delta));
		}
	}
	
	private void applyGravity() {
		if (gravity) speedY = speedY - 30;
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		batch.draw(animation[currentState], getX(), getY(), getWidth(), getHeight());
	}
	
	public boolean collision() {
	    if ((rectBottom.overlaps(Characters.mainCharacter.getRectLeft()) || rectBottom.overlaps(Characters.mainCharacter.getRectRight()) || rectTop.overlaps(Characters.mainCharacter.getRectLeft()) || rectTop.overlaps(Characters.mainCharacter.getRectRight())) && (dead == false)) {
    		speedY = 450;
    		gravity = true;
    		dead = true;
   		 if (Parameters.sound == 1)
    		Assets.coin.play();
    		clearActions();
    		addAction(sequence(fadeOut(0.5f), run(new Runnable() {
    	        public void run () {
    	        	Actions.removeActor();
    	        }
    	})));
    		return true;
    	 }
	    return false;

	}
	
	
}