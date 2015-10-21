package com.kenneth.whp2.actors;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.actors.objects.Characters;
import com.kenneth.whp2.screens.GameScreen;

public class Bullet extends Actor implements Poolable {
	
	private String type;
	private Texture image;
	public static ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	private float speedX, speedY;
	private Rectangle r = new Rectangle(0, 0, 0, 0);
	private float helper = 0;
	private float helper2 = 0;
	private float helperX;
	private float helperY;
	private boolean pass = true;
	private String parentCannon;
	private float speedVariable = 130;
	private boolean alive = false;
	
	public void init(float x, float y, String type, String parentCannon) {
		this.type = type;
		this.parentCannon = parentCannon;
		alive = true;
		bulletList.add(this);
		setWidth(13);
		setHeight(13);
		setPosition(x, y);
		image = Assets.bullet;
//		if (Background.bg.isHell()) {
//			image = Assets.bulletBlack;
//		}
		if (type.contains("big")) {
			setWidth(26);
			setHeight(26);
			image = Assets.bulletBig;
//			if (Background.bg.isHell()) {
//				image = Assets.bulletBigBlack;
//			}
		}
		if (parentCannon.contains("Spinner")) {
			setX(getX() + 16 - 6.5f);
			setY(getY() + 16 - 6.5f);
			if (isInteger((type))) {
				for (int i = 0; i < Integer.valueOf(type); i++) {
			        Bullet b = GameScreen.gs.getWrap().getBulletPool().obtain();
			        GameScreen.gs.getWrap().addActor(b);
					b.init((getX() + (13 * i)) + (32 / 2) - (13 / 2), getY() + (32 / 2) - (13 / 2), "spinnerFormula", type);
			        GameScreen.gs.getWrap().getActiveBullets().add(b);
					b.setHelper2(13 * i);
					b.setHelperX(getX());
					b.setHelperY(getY());
					 GameScreen.gs.getWrap().addActor(b);
					 b.setParentCannon("Spinner");
				}
			} else {
				for (int i = 0; i < 5; i++) {
			        Bullet b = GameScreen.gs.getWrap().getBulletPool().obtain();
			        GameScreen.gs.getWrap().addActor(b);
					b.init((getX() + (13 * i)) + (32 / 2) - (13 / 2), getY() + (32 / 2) - (13 / 2), "spinnerFormula", type);
			        GameScreen.gs.getWrap().getActiveBullets().add(b);
					b.setHelper2(13 * i);
					 GameScreen.gs.getWrap().addActor(b);
					 b.setParentCannon("Spinner");
				}
			}
			
			this.reset();
		}
	
	}
	
	public Bullet() {
		alive = false;

	}
	
	
	
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		batch.draw(image, getX(), getY(), getWidth(), getHeight());
	}
	
	public void act(float delta) {
		super.act(delta);
		if (GameScreen.gs.getWrap().getGameState() == 0) {
		if (alive) {
		if ((getX() <= -1800) || (getX() >= 1800) || (getY() >= 1000) || (getY() <= -200)) {
			if (parentCannon.contains("Spinner") == false)
			reset();
		}
		r.set(getX() + 2, getY() + 2, getWidth() - 4, getHeight() - 4);
		if (type.equals("left")) {
			speedX = -400;
		} else if (type.equals("right")) {
			speedX = 400;
		} else if (type.equals("up")) {
			speedY = 400;
		} else if (type.equals("down")) {
			speedY = -400;
		} else if (type.equals("upRight")) {
			speedX = 400;
			speedY = 400;
		} else if (type.equals("upLeft")) {
			speedX = -400;
			speedY = 400;
		} else if (type.equals("downRight")) {
			speedX = 400;
			speedY = -400;
		} else if (type.equals("downLeft")) {
			speedX = -400;
			speedY = -400;
		} else if (type.equals("bigLeft")) {
			speedX = -350;
		} else if (type.equals("bigRight")) {
			speedX = 350;
		} else if (type.equals("bigDown")) {
			speedY = -350;
		} else if (type.equals("bigUp")) {
			speedY = 350;
		} else if (type.equals("sinUp")) {
			helper += 0.05f;
			speedY = 100;
			speedX = (float) (160 * Math.cos(helper));
			if (helper == 360) {
				helper = 0;
			}
		} else if (type.equals("sinDown")) {
			helper += 0.05f;
			speedY = -100;
			speedX = (float) (160 * Math.cos(helper));
			if (helper == 360) {
				helper = 0;
			}
		} else if (type.equals("sinLeft")) {
			helper += 0.05f;
			speedY = (float) (160 * Math.cos(helper));
			speedX = -100;
			if (helper == 360) {
				helper = 0;
			}
		} else if (type.equals("sinRight")) {
			helper += 0.05f;
			speedY = (float) (160 * Math.cos(helper));
			speedX = 100;
			if (helper == 360) {
				helper = 0;
			}
		} else if (type.equals("trace")) {
			if (pass == true) {
				pass = false;
				speedX = Characters.mainCharacter.getX() - getX();
				speedY = Characters.mainCharacter.getY() - getY();
				float speedLimit = 550;
				if ((Math.abs(speedX) + Math.abs(speedY)) != speedLimit) {
					float total = Math.abs(speedX) + Math.abs(speedY);
					float coefficient = 1 / (total / speedLimit);
					speedX = speedX * coefficient;
					speedY = speedY * coefficient;
				}
			}
        } else if (type.equals("spinnerFormula")) {
        	
//        	 helper += speedVariable * 1f;
//             speedY = (float) ( helper2 * Math.cos(Math.toRadians(helper)));
//             speedX = (float) (  -1 * helper2 * Math.sin(Math.toRadians(helper)));
//            if (helper == 360) {
//                    helper = 0;
//            }
             helper += speedVariable * delta;
             float xFromCenter = helper2 * MathUtils.cosDeg(helper);
             float yFromCenter = -1 * helper2 * MathUtils.sinDeg(helper);
             
             helperX += (Background.bg.getSpeedX() * 5) * delta;
             setX(helperX + xFromCenter);
             setY(helperY + yFromCenter);
             speedY = 0;
             speedX = 0;
           
        }
		if (type.equals("spinnerFormula") == false) {
        setX(getX() + (speedX * delta) + ((Background.bg.getSpeedX() * 5) * delta));
		setY(getY() + (speedY * delta));
		}
		if ((parentCannon.contains("Spinner") == false)) {
		for (Tile t : Tile.nullifyTiles) {
				Rectangle tr = new Rectangle(0, 0, 0, 0);
				tr.set(t.getX(), t.getY(), t.getWidth(), t.getHeight());
				if ((tr.contains(r)) || (tr.overlaps(r))) {
					reset();
				}
			}
		}
		}
		
		}
	}
	
	
	
	   public static boolean isInteger(String s) {
		    try { 
		        Integer.parseInt(s); 
		    } catch(NumberFormatException e) { 
		        return false; 
		    }
		    // only got here if we didn't return false
		    return true;
		}

	public Rectangle getR() {
		return r;
	}

	public void setR(Rectangle r) {
		this.r = r;
	}

	public String getParentCannon() {
		return parentCannon;
	}

	public void setParentCannon(String parentCannon) {
		this.parentCannon = parentCannon;
	}


	public float getHelper() {
		return helper;
	}


	public void setHelper(float helper) {
		this.helper = helper;
	}


	public float getHelper2() {
		return helper2;
	}


	public void setHelper2(float helper2) {
		this.helper2 = helper2;
	}



	@Override
	public void reset() {
		alive = false;
		speedX = 0;
		speedY = 0;
		pass = true;
		parentCannon = "null";
		type = "null";
		setPosition(0, 1000);
		bulletList.remove(this);
		
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public float getHelperX() {
		return helperX;
	}

	public void setHelperX(float helperX) {
		this.helperX = helperX;
	}

	public float getHelperY() {
		return helperY;
	}

	public void setHelperY(float helperY) {
		this.helperY = helperY;
	}
	


}
