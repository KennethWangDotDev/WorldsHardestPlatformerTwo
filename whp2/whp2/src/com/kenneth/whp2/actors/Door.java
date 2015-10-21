package com.kenneth.whp2.actors;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.actors.objects.Characters;
import com.kenneth.whp2.screens.GameScreen;

public class Door extends Actor{

	public static Door door;
	private float speedX, speedY;
	private Rectangle rect = new Rectangle(0, 0, 0, 0);

	
	public Door(float x, float y) {
		door = this;
		setWidth(64);
		setHeight(96);
		setPosition(x * 32, y * 32);
	}
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
//		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
//		batch.draw(Assets.door, getX(), getY(), getWidth(), getHeight());
	}
	
	public void act(float delta) {
		super.act(delta);

	}
	
	public void render(float delta) {
		if (GameScreen.gs.getWrap().getGameState() == 0) {
        speedX = Background.bg.getSpeedX()*5;
        setX(getX() + (speedX * delta));
		setY(getY() + (speedY * delta));
		rect.set(getX() + 24, getY(), 16, 7);
		if (rect.overlaps(Characters.mainCharacter.getRectBottom())) {
			Characters.mainCharacter.win();
		}
	}
	}
		
}
