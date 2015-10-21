package com.kenneth.whp2.actors;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.actors.objects.Characters;
import com.kenneth.whp2.actors.objects.Coin;
import com.kenneth.whp2.actors.objects.Key;
import com.kenneth.whp2.screens.GameScreen;

public class SpikeColumn extends Actor{

	public static SpikeColumn spikeColumn;
	private Rectangle r = new Rectangle(0, 0, 0, 0);

	
	public SpikeColumn() {
		spikeColumn = this;
		setWidth(32);
		setHeight(800);
		setPosition(0, 0);
		r.set(getX(), getY(), getWidth(), getHeight());
		
	}
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(Assets.spikeColumn, getX(), getY());
	}
	
	public void act(float delta) {
		super.act(delta);
		if (GameScreen.gs.getWrap().getGameState() == 0) {
		if (r.overlaps(Characters.mainCharacter.getRectTop())) {
			Characters.mainCharacter.setCauseOfDeath("spikeColumn");
			Characters.mainCharacter.death();
		}
		
		if (Characters.mainCharacter != null) {
			Characters.mainCharacter.setX(Characters.mainCharacter.getX() - 1);
		}
		for (Tile t : Tile.allTiles) {
			t.setX(t.getX() - 1);
		}
		for (Cannon c: Cannon.cannonList) {
			c.setX(c.getX() - 1);
		}

		for (Bullet b: Bullet.bulletList) {
			b.setX(b.getX() - 1);
		}
		for (StringTile s : StringTile.stringList) {
			s.setX(s.getX() - 1);
		}
		for (Movers m : Movers.moversList) {
			m.setX(m.getX() - 1);
		}	
		for (Key k : Key.keyList){
			k.setX(k.getX() - 1);
		}
		
		for (Coin k : Coin.coinList){
			k.setX(k.getX() - 1);
		}
		
		if (Door.door != null) {
			Door.door.setX(Door.door.getX() - 1);
		}
	}
	}
		
}
