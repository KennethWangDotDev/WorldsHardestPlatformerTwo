package com.kenneth.whp2.actors.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Timer;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;
import com.kenneth.whp2.Starter;
import com.kenneth.whp2.actors.Background;
import com.kenneth.whp2.actors.BlackScreen;
import com.kenneth.whp2.actors.Bullet;
import com.kenneth.whp2.actors.Cannon;
import com.kenneth.whp2.actors.Door;
import com.kenneth.whp2.actors.Flag;
import com.kenneth.whp2.actors.Movers;
import com.kenneth.whp2.actors.SpikeColumn;
import com.kenneth.whp2.actors.StringTile;
import com.kenneth.whp2.actors.Tile;
import com.kenneth.whp2.actors.gameOverTransition;
import com.kenneth.whp2.actors.startGameTransition;
import com.kenneth.whp2.screens.GameScreen;
import com.kenneth.whp2.screens.LevelScreen;

public class Players extends Characters {

	private int impulse;
	private int coinCurrent;
	private int coinTotal;
	private boolean initial;
	protected int tileWalkwayOrientation;
	private boolean firstTime = true;
	private String causeOfDeath;
	private boolean left = false;
	private boolean right = false;
	private boolean jump = false;
	//Parameters that must be set at constructor:
    //private boolean tileCollision;
    //private boolean gravity;
    //protected int jumpState;
    // protected boolean movement = true;
	
	private boolean inBounds(float mouseX, float mouseY, int objectX, int objectY, int objectWidth, int objectHeight) {
		if ((mouseX >= objectX) && (mouseX <= objectX + objectWidth)) {
			if ((mouseY >= 480 - objectY) && (mouseY <= 480 - objectY + objectHeight)) {
				return true;
			}
		}
	return false;
	}
	
	public void act(float delta){
		super.act(delta);
		if (Door.door != null) {
//			Door.door.render(delta);
		}
		if ((getX() <= -200) || (getX() >= 1000) || (getY() <= -100)  || (getY() >= 1500)){
			causeOfDeath = "falling";
			death();
		}
		if (Parameters.onScreenControls == 1) {
		left = false;
		right = false;
		jump = false;
        for(int i = 0; i < 5; i++){
            if(GameScreen.touches.get(i).touched) {
            	 if (Parameters.onScreenControls == 1) {
        			 //Normal Right
        			 if ((Parameters.deviceSize == 1) && (Parameters.handOrientation == 1)){
//        				 batch.draw(Assets.normalLeft, 4, 2, 190, 100);
//        				 batch.draw(Assets.normalRight, 4 + 190 + 7, 2, 190, 100);
//        				 batch.draw(Assets.normalJump, 4 + 190 + 7 + 25 + 190, 2, 380, 100)

        				 if (inBounds(GameScreen.touches.get(i).touchX, GameScreen.touches.get(i).touchY, 4, 2 + 100 + 300, 190, 100 + 300)) {
        					 left = true;
        				 } 
        				 if (inBounds(GameScreen.touches.get(i).touchX, GameScreen.touches.get(i).touchY, 4 + 190 + 7, 2 + 100 + 300, 190, 100 + 300)) {
        					 right = true;
        				 } 
        				 
        				 if (inBounds(GameScreen.touches.get(i).touchX, GameScreen.touches.get(i).touchY, 4 + 190 + 7 + 25+ 190, 2 + 100 + 300, 380 + 100, 100 + 300)) {
        					 jump = true;
        				 } 
        				 
        			//Normal Left
        			 } else if ((Parameters.deviceSize == 1) && (Parameters.handOrientation == 0)){
//        				 batch.draw(Assets.normalJump, 4, 2, 380, 100); 
//        				 batch.draw(Assets.normalLeft, 4 + 380 + 25, 2, 190, 100);
//        				 batch.draw(Assets.normalRight, 4 + 380 + 25 + 190 + 7, 2, 190, 100);
        				 if (inBounds(GameScreen.touches.get(i).touchX, GameScreen.touches.get(i).touchY, 4, 2 + 100 + 300, 380, 100 + 300)) {
        					 jump = true;
        				 } 
        				 if (inBounds(GameScreen.touches.get(i).touchX, GameScreen.touches.get(i).touchY, 4 + 380 + 25, 2 + 100 + 300, 190, 100 + 300)) {
        					 left = true;
        				 } 
        				 
        				 if (inBounds(GameScreen.touches.get(i).touchX, GameScreen.touches.get(i).touchY, 4 + 380 + 7 + 25+ 190, 2 + 100 + 300, 190 + 100, 100 + 300)) {
        					 right = true;
        				 } 
        			//Tablet Right
        			 } else if ((Parameters.deviceSize == 0) && (Parameters.handOrientation == 1)){
//        				 batch.draw(Assets.tabletLeft, 2, 1, 95, 49);
//        				 batch.draw(Assets.tabletRight, 2 + 4 + 95, 1, 95, 49);
//        				 batch.draw(Assets.tabletJump, 601, 1, 190, 49);
        				 if (inBounds(GameScreen.touches.get(i).touchX, GameScreen.touches.get(i).touchY, 2, 1 + 100 + 300, 95, 100 + 300)) {
        					 left = true;
        				 } 
        				 if (inBounds(GameScreen.touches.get(i).touchX, GameScreen.touches.get(i).touchY, 2 + 4 + 95,12 + 100 + 300, 200, 100 + 300)) {
        					 right = true;
        				 } 
        				 
        				 if (inBounds(GameScreen.touches.get(i).touchX, GameScreen.touches.get(i).touchY, 400, 2 + 100 + 300, 400 + 100, 100 + 300)) {
        					 jump = true;
        				 } 
        			//Tablet Left
        			 } else if ((Parameters.deviceSize == 0) && (Parameters.handOrientation == 0)){
//        				 batch.draw(Assets.tabletJump, 2, 1, 190, 49); 
//        				 batch.draw(Assets.tabletLeft, 601, 1, 95, 49);
//        				 batch.draw(Assets.tabletRight, 601 + 95 + 7, 1, 95, 49);
        				 if (inBounds(GameScreen.touches.get(i).touchX, GameScreen.touches.get(i).touchY, 2, 2 + 100 + 300, 400, 100 + 300)) {
        					 jump = true;
        				 } 
        				 
        				 if (inBounds(GameScreen.touches.get(i).touchX, GameScreen.touches.get(i).touchY, 401, 1 + 100 + 300, 95, 100 + 300)) {
        					 left = true;
        				 } 
        				 if (inBounds(GameScreen.touches.get(i).touchX, GameScreen.touches.get(i).touchY, 601 + 95 + 7, 1 + 100 + 300, 95 + 100, 100 + 300)) {
        					 right = true;
        				 } 
        				 


        			 }
        		 }
            }
        }
		}
		
		if ((jumpRelease == true) && (jumpState == 0) && (!reverseGravity) && ((Gdx.input.isKeyPressed(Input.Keys.UP)) || (jump) || (Gdx.input.isKeyPressed(Input.Keys.SPACE)))) {
			if (speedY >= 0) {
			impulse = 0;
			jump();
			jumpRelease = false;
			jumpState = 1;
			if (tileTypeMain == 1) {
				tileTypeMain = 2;
			} else if (tileTypeMain == 3) {
				
			} else if (tileTypeMain == 2){
			} else {
				tileTypeMain = 0;
			}
			mainCharacter.tileWalkwayOrientation = 0;
		}
	}
		if ((jumpRelease == true) && (jumpState == 0) && (reverseGravity) && ((Gdx.input.isKeyPressed(Input.Keys.UP)) || (jump) || (Gdx.input.isKeyPressed(Input.Keys.SPACE)))) {
			if (speedY <= 0) {
				impulse = 0;
			jump();
			jumpRelease = false;
			jumpState = 1;
			if (tileTypeMain == 1) {
				tileTypeMain = 2;
			} else if (tileTypeMain == 3) {
				
			} else if (tileTypeMain == 2){
			} else {
				tileTypeMain = 0;
			}
			mainCharacter.tileWalkwayOrientation = 0;
		}
	}

		
		if(doubleJump == true && doubleJumpReady == true && jumpRelease == true) {
			 if((Gdx.input.isKeyPressed(Input.Keys.UP)) || (jump) || (Gdx.input.isKeyPressed(Input.Keys.SPACE))){
	        		doubleJumpReady = false;
				    speedY = 1;
					jump();
					jumpRelease = false;
					jumpState = 1;
					if (tileTypeMain == 1) {
						tileTypeMain = 2;
					} else if (tileTypeMain == 3) {
						
					} else if (tileTypeMain == 2){
					} else {
						tileTypeMain = 0;
					}
					mainCharacter.tileWalkwayOrientation = 0;
			 }
		}
		
		if (jumpState == 1) {
	        if((Gdx.input.isKeyPressed(Input.Keys.UP)) || (jump) || (Gdx.input.isKeyPressed(Input.Keys.SPACE))){
	           	if(reverseGravity) { 
		        	impulse -= 2000 * delta;

	        		if (impulse <= -550) {
		        		speedY = speedY - (impulse + 550);
	            		jumpState = 2;
	            		impulse = 0; 
	            	} else {
			        	speedY -= 2000 * delta;
	            	}
	           	}
	        		else {
	        	impulse += 35;

	        	if (impulse >= 600) {
	        		speedY = speedY - (impulse - 600);
	        		System.out.println(impulse + "  " + speedY);
	        		jumpState = 2;
	        		impulse = 0; 
	        	} else {
		        	speedY += 35;
	        	}
	        }
	           	
	       	} else {
	       		mainCharacter.tileWalkwayOrientation = 0;
	       		jumpState = 2;
	       		impulse = 0;
	       	}
	        if (speedY <= 0 && (gravity)) {
	        	mainCharacter.tileWalkwayOrientation = 0;
	        	jumpState = 2;
	        	impulse = 0;
	        }
	        if (speedY >= 0 && (!gravity)) {
	        	mainCharacter.tileWalkwayOrientation = 0;
	        	jumpState = 2;
	        	impulse = 0;
	        }
		}
		
		if (speedX == 0) {
			Background.bg.setSpeedX(0);
		}
		
		if ((movement == false) || (friction == false)) {
			speedX = 0;
			Background.bg.setSpeedX(0);
		} else if (friction){
			if (getX() >= 352) {
				Background.bg.setSpeedX(-speedX / 5);
			}
		}
		
		if ((speedY > 0) && (reverseGravity)) {
			tileWalkwayOrientation = 0;
		}
		
		if ((speedY < 0) && (reverseGravity == false)) {
			tileWalkwayOrientation = 0;
		}
		
		if (tileWalkwayOrientation == 1) {
			speedX = speedX - 60;
		} else if (tileWalkwayOrientation == 2) {
			speedX = speedX + 60;
		}
		

		

		
		if ((Gdx.input.isKeyPressed(Input.Keys.LEFT)) || (left)) {
			speedX -= 225;
			if ((Background.bg.getTotalX() <= 0)) {
				Background.bg.setSpeedX(0);
				backgroundScroll = false;
			} else {
				applyMovementModifier();
				backgroundScroll = true;
				collision();
				Background.bg.setSpeedX(-speedX / 5);
			}
		} else 

		
		if ((Gdx.input.isKeyPressed(Input.Keys.RIGHT)) || (right)){
			speedX += 225;
//			if ((Background.bg.getTotalX() <= 0)) {
//					Background.bg.setSpeedX(0);
//					backgroundScroll = false;
//			}
			
			if ((initial == false) && (Background.bg.getTotalX() > 0)){
				applyMovementModifier();
				backgroundScroll = true;
				collision();
				Background.bg.setSpeedX(-speedX / 5);
			} else if ((initial == false) && (Background.bg.getTotalX() <= 0)) {
				initial = true;
				backgroundScroll = false;
				Background.bg.setSpeedX(0);
			}
			

			if (((getX() >= 352)) && (initial == true)){
				if (GameScreen.gs.getWrap().getLevelType() != 1) {
				initial = false;
				applyMovementModifier();
				backgroundScroll = true;
				collision();
				Background.bg.setSpeedX(-speedX / 5);
				}
			} 
			
			

			

		} else  		if ((getX() >= 352) && (Background.bg.getTotalX() >= 0)) {
			if (friction == false) {
			Background.bg.setSpeedX(-speedX / 5);
			speedX = 0;
			}
			if (SpikeColumn.spikeColumn == null)
			backgroundScroll = true;
		} else  		if ((getX() >= 352) && (Background.bg.getTotalX() < 0)) {
			backgroundScroll = false;
		}
		




				
		if(!((Gdx.input.isKeyPressed(Input.Keys.UP)) || (jump) || (Gdx.input.isKeyPressed(Input.Keys.SPACE)))){
			jumpRelease = true;
		}
		
		if(keyCurrent == Key.keyList.size()) {
            for (Tile t: Tile.gateTiles) {
                    GameScreen.gs.getWrap().addAction(Actions.removeActor(t));
                    Tile.allTiles.remove(t);
                    
            }      
            Tile.gateTiles.clear();
          
 
    }

		
			
	}
	
	public void death() {
		if (GameScreen.gs.getWrap().isTestMode() == false) {
		Parameters.levelDeaths[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()] += 1;
		Parameters.totalPlayTimeSeconds += GameScreen.gs.getWrap().getYourTime();
		while (Parameters.totalPlayTimeSeconds >= 60) {
			Parameters.totalPlayTimeSeconds -= 60;
			Parameters.totalPlayTimeMinutes += 1;
		}
		if (Parameters.levelStars[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()] == 0) {
			Parameters.levelAttempts[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()] += 1;
		}
		
		Parameters.levelElapsedTime[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()] += GameScreen.gs.getWrap().getYourTime();
		System.out.println(causeOfDeath);
		if (causeOfDeath.equals("null")) {
			System.out.println("ERROR");
		}
		if (causeOfDeath.contains("falling")) {
			Parameters.deathsFalling += 1;
		} else if (causeOfDeath.contains("cannonNormal")) {
			Parameters.deathsCannonNormal += 1;
		} else if (causeOfDeath.contains("cannonFast")) {
			Parameters.deathsCannonFast += 1;
		} else if (causeOfDeath.contains("cannonSin")) {
			Parameters.deathsCannonSin += 1;
		} else if (causeOfDeath.contains("cannonBig")) {
			Parameters.deathsCannonBig += 1;
		} else if (causeOfDeath.contains("cannonMulti")) {
			Parameters.deathsCannonMulti += 1;
		} else if (causeOfDeath.contains("cannonTrace")) {
			Parameters.deathsCannonTrace += 1;
		} else if (causeOfDeath.contains("cannonQuadra")) {
			Parameters.deathsCannonQuadra += 1;
		} else if (causeOfDeath.contains("spikes")) {
			Parameters.deathsSpikes += 1;
		} else if (causeOfDeath.contains("spikeColumn")) {
			Parameters.deathsSpikeColumn += 1;
		} else if (causeOfDeath.contains("Spinner")) {
			Parameters.deathsSpinner += 1;
		}
		}
		Characters.charactersList.remove(this);
		for (Tile t: Tile.allTiles) {
			GameScreen.gs.getWrap().addAction(Actions.removeActor(t));
		}
		Tile.allTiles.clear();
		Tile.screenTiles.clear();
		Tile.gateTiles.clear();
		Actions.addAction(Actions.removeActor());
		for (Cannon c: Cannon.cannonList) {
			GameScreen.gs.getWrap().addAction(Actions.removeActor(c));
		}
		Cannon.cannonList.clear();
		for (Bullet b: Bullet.bulletList) {
			GameScreen.gs.getWrap().addAction(Actions.removeActor(b));
		}
		Bullet.bulletList.clear();
		Bullet item;
        int len = GameScreen.gs.getWrap().getActiveBullets().size;
        for (int i = len; --i >= 0;) {
            item = GameScreen.gs.getWrap().getActiveBullets().get(i);
            GameScreen.gs.getWrap().getActiveBullets().removeIndex(i);
            GameScreen.gs.getWrap().getBulletPool().free(item);
        }
        
		for (StringTile s : StringTile.stringList) {
			GameScreen.gs.getWrap().addAction(Actions.removeActor(s));
		}
		StringTile.stringList.clear();
		
		for (Movers m : Movers.moversList) {
			GameScreen.gs.getWrap().addAction(Actions.removeActor(m));
		}
		
		for (Key k : Key.keyList){
			GameScreen.gs.getWrap().addAction(Actions.removeActor(k));
		}
		
		for (Coin z : Coin.coinList){
			GameScreen.gs.getWrap().addAction(Actions.removeActor(z));
		}
		Coin.coinList.clear();
		Key.keyList.clear();
		
		Movers.moversList.clear();
		Movers.left.clear();
		Movers.right.clear();
		SpikeColumn.spikeColumn = null;
		Door.door = null;
		if (Flag.flag != null) {
		if (Flag.flag.isUp() == false) {
			Flag.flag = null;
		}
		}
		
		GameScreen.gs.getWrap().addAction(Actions.removeActor(Background.bg));
		GameScreen.gs.getStage().clear();
		GameScreen.gs.dispose();
		float delay = 0.1f; // seconds

		Timer.schedule(new Timer.Task(){
		    @Override
		    public void run() {
		    	boolean test = false;
		    	if (GameScreen.gs.getWrap().isTestMode()) {
		    		test = true;
		    	}
				Starter.starter.setScreen(new GameScreen(GameScreen.gs.getLevel()));
				if (test)
				GameScreen.gs.getWrap().setTestMode(true);
		    }
		}, delay);
		

	}
	
	public void win() {

		if (firstTime) {
			if (Parameters.sound == 1)
			Assets.victory.play();
			firstTime = false;
			GameScreen.gs.getWrap().setGameState(3);
			Parameters.totalPlayTimeSeconds += GameScreen.gs.getWrap().getYourTime();
			while (Parameters.totalPlayTimeSeconds >= 60) {
				Parameters.totalPlayTimeSeconds -= 60;
				Parameters.totalPlayTimeMinutes += 1;
			}
			if (GameScreen.gs.getWrap().isTestMode() == false) {
		Parameters.levelElapsedTime[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()] += GameScreen.gs.getWrap().getYourTime();
		if (Parameters.levelStars[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()] == 0) {
			Parameters.levelFastestTime[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()] = GameScreen.gs.getWrap().getYourTime();
		}
		
		if (GameScreen.gs.getWrap().getYourTime() <= Parameters.levelFastestTime[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()]) {
			Parameters.levelFastestTime[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()] = GameScreen.gs.getWrap().getYourTime();
		}
		if (LevelScreen.ls.getLevel() <= 8) {
			Parameters.levelPlayable[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel() + 1] = true;
			Parameters.levelPlayable[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel() + 2] = true;
		} else if (LevelScreen.ls.getLevel() == 9) {
			Parameters.levelPlayable[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel() + 1] = true;
		} else if (LevelScreen.ls.getLevel() == 10) {
			if (LevelScreen.ls.getWorld() != 10) {
				if (LevelScreen.ls.getWorld() != 20) {
					Parameters.levelPlayable[LevelScreen.ls.getWorld() + 1][1] = true;
					Parameters.levelPlayable[LevelScreen.ls.getWorld() + 1][2] = true;
					Parameters.worldPlayable[LevelScreen.ls.getWorld() + 1] = true;
					Parameters.levelPass[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()] = true;
				}
			}
		}
		Parameters.saveLevels(LevelScreen.ls.getWorld());
		Parameters.saveWorlds();
		}
		}
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (Door.door != null) {
			Door.door.render(Gdx.graphics.getDeltaTime());
			batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
			batch.draw(Assets.door, Door.door.getX(), Door.door.getY(), Door.door.getWidth(), Door.door.getHeight());
		}
		super.draw(batch, parentAlpha);
	}

	public int getCoinCurrent() {
		return coinCurrent;
	}

	public void setCoinCurrent(int coinCurrent) {
		this.coinCurrent = coinCurrent;
	}

	public int getCoinTotal() {
		return coinTotal;
	}

	public void setCoinTotal(int coinTotal) {
		this.coinTotal = coinTotal;
	}

	public String getCauseOfDeath() {
		return causeOfDeath;
	}

	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isJump() {
		return jump;
	}

	public void setJump(boolean jump) {
		this.jump = jump;
	}

	
	
}