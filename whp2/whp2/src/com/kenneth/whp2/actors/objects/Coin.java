package com.kenneth.whp2.actors.objects;
 
import java.util.ArrayList;
 
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.actors.Background;
import com.kenneth.whp2.screens.GameScreen;
 
public class Coin extends Powerups {
	private float x;
	private float y;
	public static ArrayList<Coin> coinList = new ArrayList<Coin>();
	
	//Parameters that must be set at constructor:
	//protected Texture[] animation;
	//protected float animationTime;
       
	public Coin(float x, float y) {
		setWidth(32);
		setHeight(32);
		setPosition(x * 32, y * 32);
		animation = Assets.starAnimation;
		animationTime = 0.1f;
		coinList.add(this);
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
			 Characters.mainCharacter.setCoinCurrent(Characters.mainCharacter.getCoinCurrent() + 1);
			 return true;
		 }
		return false;
	}
}