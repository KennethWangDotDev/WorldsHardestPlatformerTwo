package com.kenneth.whp2.actors.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.screens.GameScreen;




public class MainCharacter extends Players{

	//Parameters that must be set at constructor:
	//protected Texture[] animation;
	//protected float animationTime;
    //private boolean tileCollision;
    //private boolean gravity;
	
	
    private int totalX = 0;
    
	public MainCharacter(float x, float y) {
		setWidth(32);
		setHeight(32);
		setPosition(x * 32, y * 32);
		mainCharacter = this;
		animation = Assets.mainCharacterAnimation;
		animationTime = 0.035f;
		tileCollision = true;
		gravity = true;
		
	}
	
	public void act(float delta) {
		if (GameScreen.gs.getWrap().getGameState() == 0) {
		super.act(delta);
		}

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		
	}


}