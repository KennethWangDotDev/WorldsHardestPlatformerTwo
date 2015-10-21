package com.kenneth.whp2.actors;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.screens.GameScreen;

public class StringTile extends Actor{

	private String type;
	public static ArrayList<StringTile> stringList = new ArrayList<StringTile>();
	private float speedX, speedY;

	
	public StringTile(float x, float y, String type) {
		this.type = type;
		stringList.add(this);
		setWidth(32);
		setHeight(32);
		setPosition(x * 32, y * 32);
		this.type = type;
	}
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		Assets.futuristicSmall.drawMultiLine(batch, type, getX(), getY());


	}
	
	public void act(float delta) {
		super.act(delta);
		if (GameScreen.gs.getWrap().getGameState() == 0) {
        speedX = Background.bg.getSpeedX()*5;
        setX(getX() + (speedX * delta));
		setY(getY() + (speedY * delta));
	}
	}
		
}
