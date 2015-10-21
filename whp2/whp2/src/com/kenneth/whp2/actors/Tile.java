package com.kenneth.whp2.actors;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.actors.objects.Characters;
import com.kenneth.whp2.screens.GameScreen;


public class Tile extends Actor {
	private Texture image;
	private boolean collidable = true;
	public static ArrayList<Tile> screenTiles = new ArrayList<Tile>();
	public static ArrayList<Tile> allTiles = new ArrayList<Tile>();
	public static ArrayList<Tile> gateTiles = new ArrayList<Tile>();
	public static ArrayList<Tile> nullifyTiles = new ArrayList<Tile>();
	private float speedX, speedY;
	private String type;
	private boolean fade = false;
	private float alpha = 1;
	private int tileType = 0;

	
	public Tile(float x, float y, String type) {
		this.type = type;
		allTiles.add(this);
		setWidth(32);
		setHeight(32);
		setPosition(x * 32, y * 32);
		if (type.equals("tileNormal")) {
			image = Assets.tileRegular;
			tileType = 0;
		} else if (type.equals("tileNullifier")) {
			image = Assets.tileNullifier;
		} else if (type.equals("tileDroppable")) {
			image = Assets.tileDroppable;
			tileType = 4;
		}else if (type.equals("tileSpeed")) {
			image = Assets.tileFast;
			tileType = 2;
		}else if (type.equals("tileSlow")) {
			image = Assets.tileSlow;
			tileType = 3;
		} else if (type.equals("tileIce")) {
			image = Assets.tileIce;
			tileType = 1;
		} else if (type.contains("tileSpike")){
			image = Assets.tileSpike;
		} else if (type.contains("tileInvisible")) {
			image = Assets.tileInvisible;
		} else if (type.contains("gateVertical")) {
            image = Assets.gateVertical;
            gateTiles.add(this);
    } else if (type.contains("gateHorizontal")) {
            image = Assets.gateHorizontal; 
            gateTiles.add(this);
    } else if (type.contains("tileWalkway")) {
            image = Assets.tileWalkway;
    } 

		
	}
	
	

	

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		if (image == null) {
			image = Assets.tileInvisible;
		}
		if (type.contains("Up")) {
			batch.draw(image, getX(), getY(), getWidth(), getHeight());
		} else if (type.contains("Down")) {
			TextureRegion temp = new TextureRegion();
			temp.setRegion(image);
			temp.flip(false, true);
			batch.draw(temp, getX(), getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0);	
		} else if (type.contains("Left")) {
			TextureRegion temp = new TextureRegion();
			temp.setRegion(image);
			batch.draw(temp, getX(), getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, false);	
		} else if (type.contains("Right")) {
			TextureRegion temp = new TextureRegion();
			temp.setRegion(image);
			batch.draw(temp, getX(), getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, true);	
		} else {
			batch.draw(image, getX(), getY(), getWidth(), getHeight());
		}
	}
	
	public void act(float delta) {
		super.act(delta);
		if (GameScreen.gs.getWrap().getGameState() == 0) {
		if (fade) {
			alpha = alpha - 0.05f;
			this.setColor(getColor().r, getColor().g, getColor().b, alpha);
			if (alpha <= 0) {
	        	Actions.removeActor();
	    		allTiles.remove(this);
			}
		}

        speedX = Background.bg.getSpeedX()*5;
        setX(getX() + (speedX * delta));
		setY(getY() + (speedY * delta));
		
//		if (type.equals("tileNullifier")) {
//			Rectangle r = new Rectangle(0, 0, 0, 0);
//			r.set(getX() - 4, getY() + 4, getWidth() + 8, getHeight() + 8);
//			for (Bullet b : GameScreen.gs.getWrap().getActiveBullets()){
//				if ((b.getR().overlaps(r)) || (r.contains(b.getR()))) {
//					if (b.getParentCannon().contains("Spin")) {
//						
//					} else {
//					b.reset();
//					}
//					return;
//				}
//			}
//		}
	}
	}
	

	public int getTileType() {
		return tileType;
	}



	public void setTileType(int tileType) {
		this.tileType = tileType;
	}

	
	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}
	
	public static void updateScreenTiles() {
		screenTiles.clear();
		nullifyTiles.clear();
		for (Tile t : allTiles) {
			Rectangle r = new Rectangle(0, 0, 0, 0);
			if (Characters.mainCharacter != null) {
			r.set(Characters.mainCharacter.getX() - 64, Characters.mainCharacter.getY() -62, 150, 150);
			} else {
				r.set(0, 0, 800, 800);
			}
			Rectangle rect = new Rectangle(0, 0, 0, 0);
			rect.set(t.getX(), t.getY(), t.getWidth(), t.getHeight());
			if (r.contains(rect)) {
				screenTiles.add(t);
			}
			if (t.getType().equals("tileNullifier")) {
				nullifyTiles.add(t);
			}
		}
	}
	
	public boolean isCollidable() {
		return collidable;
	}

	public void setCollidable(boolean collidable) {
		this.collidable = collidable;
	}


	public boolean isFade() {
		return fade;
	}


	public void setFade(boolean gravity) {
		this.fade = gravity;
	}


	
	public float getSpeedX() {
		return speedX;
	}


	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public float getSpeedY() {
		return speedY;
	}


	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	
	
}