package com.kenneth.whp2.actors;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;
import com.kenneth.whp2.screens.GameScreen;

public class Cannon extends Actor {
	
	private String type;
	private Texture image;
	public static ArrayList<Cannon> cannonList = new ArrayList<Cannon>();
	private float speedX, speedY;
	private float shootSpeed = 1.5f;
	private float totalX = 0.5f;
	private boolean initialShoot = true;
	private String extra;
	
	public Cannon(float x, float y, String type) {
		this.type = type;
		cannonList.add(this);
		setWidth(32);
		setHeight(32);
		setPosition(x * 32, y * 32);
		if (type.contains("cannonNormal")) {
			image = Assets.cannonNormal;
		} else if (type.contains("cannonFast")) {
			image = Assets.cannonSpeed;
			shootSpeed = 0.75f;
		} else if (type.contains("cannonSin")) {
			image = Assets.cannonYellow;
		} else if (type.contains("cannonBig")) {
			image = Assets.cannonDeadly;
		} else if (type.contains("cannonMulti")) {
			image = Assets.cannonVariety;
		} else if (type.equals("cannonTrace")) {
			image = Assets.cannonTrace;
		}else if (type.equals("cannonQuadra")) {
			image = Assets.cannonQuadra;
		} else if (type.contains("cannonSpinner")) { 
			image = Assets.cannonSpinner;
		}
	}
	
	public Cannon(float x, float y, String type, String extra) {
		this.type = type;
		cannonList.add(this);
		setWidth(32);
		setHeight(32);
		setPosition(x * 32, y * 32);
		this.extra = extra;
		if (type.contains("cannonNormal")) {
			image = Assets.cannonNormal;
		} else if (type.contains("cannonFast")) {
			image = Assets.cannonSpeed;
			shootSpeed = 0.75f;
		} else if (type.contains("cannonSin")) {
			image = Assets.cannonYellow;
		} else if (type.contains("cannonBig")) {
			image = Assets.cannonDeadly;
		} else if (type.contains("cannonMulti")) {
			image = Assets.cannonVariety;
		} else if (type.equals("cannonTrace")) {
			image = Assets.cannonTrace;
		}else if (type.equals("cannonQuadra")) {
			image = Assets.cannonQuadra;
		} else if (type.contains("cannonSpinner")) { 
			image = Assets.cannonSpinner;
		}
	}
	
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
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
        speedX = Background.bg.getSpeedX()*5;
        setX(getX() + (speedX * delta));
		setY(getY() + (speedY * delta));
		totalX += delta;
		if (totalX >= shootSpeed) {
			totalX = 0;
			if (type.contains("Spinner")) {
				if (initialShoot) {
					initialShoot = false;
					shoot();
				}
			} else {
				shoot();
			}
		}
		}
	}
	
	public void shoot() {
		if ((getX() >= -200) && (getX() <= 1600)) {
		if (Parameters.sound == 1)
		Assets.shoot.play(0.23f);
		Assets.manageMusic();
        Bullet b = GameScreen.gs.getWrap().getBulletPool().obtain();
        GameScreen.gs.getWrap().getActiveBullets().add(b);
        GameScreen.gs.getWrap().addActor(b);
		if (type.contains("cannonNormal")) {
			if (type.contains("Up")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "up", type);
			} else if (type.contains("Down")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "down", type);
			} else if (type.contains("Left")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "left", type);
			} else if (type.contains("Right")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "right", type);
			}
		} else if (type.contains("cannonFast")) {
			if (type.contains("Up")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "up", type);
			} else if (type.contains("Down")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "down", type);
			} else if (type.contains("Left")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "left", type);
			} else if (type.contains("Right")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "right", type);
			}
		} else if (type.contains("cannonSin")) {
			if (type.contains("Up")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "sinUp", type);
			} else if (type.contains("Down")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "sinDown", type);
			} else if (type.contains("Left")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "sinLeft", type);
			} else if (type.contains("Right")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "sinRight", type);
			}
		} else if (type.contains("cannonBig")) {
			if (type.contains("Up")) {
				b.init(getX() + (getWidth() / 2) - (26 / 2), getY() + (getHeight() / 2) - (26 / 2), "bigUp", type);
			} else if (type.contains("Down")) {
				b.init(getX() + (getWidth() / 2) - (26 / 2), getY() + (getHeight() / 2) - (26 / 2), "bigDown", type);
			} else if (type.contains("Left")) {
				b.init(getX() + (getWidth() / 2) - (26 / 2), getY() + (getHeight() / 2) - (26 / 2), "bigLeft", type);
			} else if (type.contains("Right")) {
				b.init(getX() + (getWidth() / 2) - (26 / 2), getY() + (getHeight() / 2) - (26 / 2), "bigRight", type);
			}
		} else if (type.contains("cannonMulti")) {
			if (type.contains("Up")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "up", type);
		        Bullet c = GameScreen.gs.getWrap().getBulletPool().obtain();
		        GameScreen.gs.getWrap().getActiveBullets().add(c);
		        GameScreen.gs.getWrap().addActor(c);
				c.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "upRight", type);
		        Bullet d = GameScreen.gs.getWrap().getBulletPool().obtain();
		        GameScreen.gs.getWrap().getActiveBullets().add(d);
		        GameScreen.gs.getWrap().addActor(d);
				d.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "upLeft", type);
			} else if (type.contains("Down")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "down", type);
		        Bullet c = GameScreen.gs.getWrap().getBulletPool().obtain();
		        GameScreen.gs.getWrap().getActiveBullets().add(c);
		        GameScreen.gs.getWrap().addActor(c);
				c.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "downRight", type);
		        Bullet d = GameScreen.gs.getWrap().getBulletPool().obtain();
		        GameScreen.gs.getWrap().getActiveBullets().add(d);
		        GameScreen.gs.getWrap().addActor(d);
				d.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "downLeft", type);
			} else if (type.contains("Left")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "left", type);
				 Bullet c = GameScreen.gs.getWrap().getBulletPool().obtain();
			        GameScreen.gs.getWrap().getActiveBullets().add(c);
			        GameScreen.gs.getWrap().addActor(c);
				c.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "upLeft", type);
				 Bullet d = GameScreen.gs.getWrap().getBulletPool().obtain();
			        GameScreen.gs.getWrap().getActiveBullets().add(d);
			        GameScreen.gs.getWrap().addActor(d);
				d.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "downLeft", type);
			} else if (type.contains("Right")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "right", type);
				   Bullet c = GameScreen.gs.getWrap().getBulletPool().obtain();
			        GameScreen.gs.getWrap().getActiveBullets().add(c);
			        GameScreen.gs.getWrap().addActor(c);
				c.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "upRight", type);
		        Bullet d = GameScreen.gs.getWrap().getBulletPool().obtain();
		        GameScreen.gs.getWrap().getActiveBullets().add(d);
		        GameScreen.gs.getWrap().addActor(d);
				d.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "downRight", type);
			}
		} else if (type.equals("cannonTrace")) {
			b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "trace", type);
		} else if (type.equals("cannonQuadra")) {
				b.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "up", type);
		        Bullet c = GameScreen.gs.getWrap().getBulletPool().obtain();
		        GameScreen.gs.getWrap().getActiveBullets().add(c);
		        GameScreen.gs.getWrap().addActor(c);
				c.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "down", type);
		        Bullet d = GameScreen.gs.getWrap().getBulletPool().obtain();
		        GameScreen.gs.getWrap().getActiveBullets().add(d);
		        GameScreen.gs.getWrap().addActor(d);
				d.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "left", type);
		        Bullet a = GameScreen.gs.getWrap().getBulletPool().obtain();
		        GameScreen.gs.getWrap().getActiveBullets().add(a);
		        GameScreen.gs.getWrap().addActor(a);
				a.init(getX() + (getWidth() / 2) - (13 / 2), getY() + (getHeight() / 2) - (13 / 2), "right", type);
		} else if (type.contains("cannonSpinner")) {
			 b.init(getX(), getY(), type, type);

		}
				
	}
	}

}
