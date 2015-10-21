package com.kenneth.whp2.actors.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;
import com.kenneth.whp2.Starter;
import com.kenneth.whp2.actors.Bullet;
import com.kenneth.whp2.actors.Tile;
import com.kenneth.whp2.screens.GameScreen;

public class Characters extends MoveableObject {
	
	public static ArrayList<Characters> charactersList = new ArrayList<Characters>();
	public static Players mainCharacter;
    
    protected boolean tileCollision;
    protected boolean gravity;
    protected int jumpState;
    protected boolean jumpRelease = true;
    protected boolean movement = true;

    protected float frictionValue = 10f;
    protected int tileTypeMain = 0;
    protected boolean friction = false;
    protected boolean backgroundScroll = false;

    protected int keyCurrent = 0;
    
    protected boolean reverseGravity = false;
    protected boolean doubleJump = false; 
    protected boolean doubleJumpReady = false;
    private boolean god = false;
	//Parameters that must be set at constructor:
	//protected Texture[] animation;
	//protected float animationTime;
    //protected boolean tileCollision;
    //protected boolean gravity;
    //protected boolean movement;

	public void act(float delta){
		super.act(delta);
		applyGravity();
		updateRectangles();
		applyMovementModifier();
		applyPowerup();
		collision();
		if (backgroundScroll == false) {
			setX(getX() + (speedX * delta));
		}
		setY(getY() + (speedY * delta));
	}
	
	 public void collision() {
         if (god == false) {
         for (Bullet b : Bullet.bulletList) {
                 if (b.getR().overlaps(rectAbsolute)) {
                	 			mainCharacter.setCauseOfDeath(b.getParentCannon());
                                mainCharacter.death();
                                return;
                 }
         }
       
//                 if ((SpikeColumn.spike.getR().overlaps(rectTop)) || (SpikeColumn.spike.getR().overlaps(rectBottom))) {
//                                mainCharacter.death();
//                                return;
//                 }
         
         }
         
         if (tileCollision == false) {
                        return;
        }
    for (int i = 0; i < Tile.screenTiles.size(); i++) {
    	boolean cont = true;
        Tile t = (Tile) Tile.screenTiles.get(i);
        Rectangle r = new Rectangle();
        r.set(t.getX(), t.getY(), t.getWidth(), t.getHeight());
        
        if ((t.getType().contains("Spike")) || (t.getType().contains("gate"))) {
        	r.set(t.getX() + 8, t.getY() + 8, t.getWidth() - 16, t.getHeight() - 16);
        	if (r.overlaps(rectAbsolute)) {
        			Characters.mainCharacter.setCauseOfDeath("spikes");
                	mainCharacter.death();
                        return;
                
        	}
        	cont = false;
        }
        if (cont) {  


                if(r.overlaps(rectBottomCenter) && (gravity)) {
                        this.tileTypeMain = t.getTileType();   

                }
               
                if(r.overlaps(rectTopCenter) && (reverseGravity)) {
                        this.tileTypeMain = t.getTileType();           

                }
               
                if ((r.overlaps(rectTop)) && (r.overlaps(rectRight))) {
                        setX(r.getX() - 32);
//                      speedX = 0;
                        speedY = 0;
                        updateRectangles();
                        
                } else if ((r.overlaps(rectTop)) && (r.overlaps(rectLeft))){
                        setX(r.getX() + 32);
//                      speedX = 0;
                        speedY = 0;
                        updateRectangles();

                } else
               
                if ((r.overlaps(rectBottom)) && (r.overlaps(rectRight))) {
                        setX(r.getX() - 32);
                        speedX = 0;
                        speedY = 0;
                        updateRectangles();

                }
                else if ((r.overlaps(rectBottom)) && (r.overlaps(rectLeft))) {
                        setX(r.getX() + 32);
                        speedX = 0;
                        speedY = 0;
                        updateRectangles();

                } else

               
                if (   r.overlaps(rectBottom)){
                        if(gravity) {
                                doubleJumpReady = true;
                        }
                       
                        if (t.getType().equals("tileDroppable")) {
                                t.setFade(true);
                        }
                       mainCharacter.tileWalkwayOrientation = 0;
                        if (t.getType().equals("tileWalkwayLeft")) {
                                mainCharacter.tileWalkwayOrientation = 1;
                        }
                       
                        if (t.getType().equals("tileWalkwayRight")) {
                            mainCharacter.tileWalkwayOrientation = 2;
                        }

                        setY(t.getY() + 32);
                        jumpState = 0;
                        if (speedY <= 0) speedY = 0;
                        if (!gravity) {
                                jumpState = 1;
                        }

                               

                } else if (   r.overlaps(rectTop)){
                        setY(t.getY() - 32);

                        if(reverseGravity) {
                        doubleJumpReady = true;
                        }
                        if (t.getType().equals("tileDroppable") && (reverseGravity)) {
                                t.setFade(true);

                        }
                       
                        if (t.getType().equals("tileWalkwayLeft") && (reverseGravity)) {
                                speedX -= 60;

                        }
                       
                        if (t.getType().equals("tileWalkwayRight") && (reverseGravity)) {
                                speedX += 60;

                        }
                        jumpState = 0;
                        if (speedY >= 0) speedY = 0;
                        if (((t.getType().contains("gateVertical") || (t.getType().contains("gateHorizontal")) || (t.getType().contains("Spike") && (god == false))))){
                			Characters.mainCharacter.setCauseOfDeath("spikes");
                        	mainCharacter.death();
                                return;
                        }

                }
               
                updateRectangles();
       
                r.set(t.getX(), t.getY(), t.getWidth(), t.getHeight());
                if (t.getType().contains("Spike")) {
                	r.set(t.getX() + 8, t.getY() + 8, t.getWidth() - 16, t.getHeight() - 16);
                }
                
        if ((r.overlaps(rectRight))) {
                        setX(t.getX() - 32);
                       
                        if (speedX > 0) {
                                speedX = 0;
                        }


        } else if ((r.overlaps(rectLeft))){
                        setX(t.getX() + 32);
                        if (speedX < 0) speedX = 0;


        }}
    }
 }
	 
	 public void jump() {
		 if (Parameters.sound == 1)
		 Assets.jump.play();
		 if (this == mainCharacter && (gravity)) {		
			 speedY += 380;
		 } else if (this == mainCharacter && (!gravity)) {
			 speedY -= 380;
		 }
		 else {
			 speedY += 640;
		 }
		 currentState = 0;	 	 
	 }
	  
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

	
	}
	
	public void applyGravity() {
		if (gravity) speedY = speedY - 40;
	    if (!gravity) speedY = speedY + 40;

	}
	
	
	public void applyMovementModifier() {		
		if (speedX > 300) speedX = 300;
		if (speedX < -300) speedX = -300;
		friction = false;
		if (movement) {
			if(tileTypeMain == 1) {			
				friction = true;
				 if (speedX > 0)  {      
		               speedX = speedX - frictionValue;       
				 } else if (speedX < 0) {
		               frictionValue = Math.abs(frictionValue);
		               speedX = speedX + frictionValue;
				 }
			} else if(tileTypeMain == 2) {
				float newSpeedX = speedX * 1.5f; 	
				speedX = newSpeedX;				
			} else if(tileTypeMain == 3) {
				float newSpeedX = speedX * .5f;
				speedX = newSpeedX;		
			} 
			
		}
	}

	public void applyPowerup() {
		if (reverseGravity == true) {
			gravity = false;
		} else {
			gravity = true;
		}
	}
	public float getFrictionValue() {
		return frictionValue;
	}


	public void setFrictionValue(float frictionValue) {
		this.frictionValue = frictionValue;
	}


	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public Rectangle getRectTop() {
		return rectTop;
	}

	public void setRectTop(Rectangle rectTop) {
		this.rectTop = rectTop;
	}

	public Rectangle getRectBottom() {
		return rectBottom;
	}

	public void setRectBottom(Rectangle rectBottom) {
		this.rectBottom = rectBottom;
	}

	public Rectangle getRectLeft() {
		return rectLeft;
	}

	public void setRectLeft(Rectangle rectLeft) {
		this.rectLeft = rectLeft;
	}

	public Rectangle getRectRight() {
		return rectRight;
	}

	public void setRectRight(Rectangle rectRight) {
		this.rectRight = rectRight;
	}
	public int getTileTypeMain() {
		return tileTypeMain;
	}

	public void setTileTypeMain(int tileTypeMain) {
		this.tileTypeMain = tileTypeMain;
	}


	public boolean isReverseGravity() {
		return reverseGravity;
	}


	public void setReverseGravity(boolean reverseGravity) {
		this.reverseGravity = reverseGravity;
	}


	public boolean isDoubleJump() {
		return doubleJump;
	}


	public void setDoubleJump(boolean doubleJump) {
		this.doubleJump = doubleJump;
	}


	public int getKeyCurrent() {
		return keyCurrent;
	}


	public void setKeyCurrent(int keyCurrent) {
		this.keyCurrent = keyCurrent;
	}

	public boolean isBackgroundScroll() {
		return backgroundScroll;
	}

	public void setBackgroundScroll(boolean backgroundScroll) {
		this.backgroundScroll = backgroundScroll;
	}
}