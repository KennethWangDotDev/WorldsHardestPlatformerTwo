package com.kenneth.whp2.actors.wrap;

import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
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
import com.kenneth.whp2.actors.Spinner;
import com.kenneth.whp2.actors.StringTile;
import com.kenneth.whp2.actors.Tile;
import com.kenneth.whp2.actors.startGameTransition;
import com.kenneth.whp2.actors.objects.Characters;
import com.kenneth.whp2.actors.objects.Coin;
import com.kenneth.whp2.actors.objects.DoubleJump;
import com.kenneth.whp2.actors.objects.Key;
import com.kenneth.whp2.actors.objects.MainCharacter;
import com.kenneth.whp2.actors.objects.ReverseGravity;
import com.kenneth.whp2.screens.GameScreen;
import com.kenneth.whp2.screens.LevelEditor;
import com.kenneth.whp2.screens.LevelScreen;
import com.kenneth.whp2.screens.PlayScreen;


public class GameWrap extends Table {
	
	private Group character = new Group();
	private Group door = new Group();
	private Group midground = new Group();
	private Group movers = new Group();
	private Float timeLimit;
	private Integer levelType;
	private boolean testMode;
	private int gameState = 0;
	private float yPosition = 490;
	private float yourTime = 0f;
	private boolean firstTime = true;
	private String levelName;
    // array containing the active bullets.
    private final Array<Bullet> activeBullets = new Array<Bullet>();

    // bullet pool.
    private final Pool<Bullet> bulletPool = new Pool<Bullet>() {
        @Override
        protected Bullet newObject() {
                return new Bullet();
        }
    };
	public GameWrap(String s) {

        
		setBounds(0, 0, 800, 480);
		loadMap("levels/" + s + ".txt");
		addActor(new startGameTransition());
		if (levelType == 1) {
			addActor(new SpikeColumn());
		}

	}


	
	public void act(float delta) {
		Tile.updateScreenTiles();
        Bullet item;
        int len = activeBullets.size;
        for (int i = len; --i >= 0;) {
            item = activeBullets.get(i);
            if (item.isAlive() == false) {
                activeBullets.removeIndex(i);
                bulletPool.free(item);
        		Bullet.bulletList.remove(this);
            }
        }
		super.act(delta);
		if (gameState == 0)
		yourTime += delta;
		if (gameState == 3) {
		yPosition = yPosition - 80;
		if (yPosition <= 90) {
			yPosition = 90;
		} 
		}
	}
	
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		if (gameState == 0) {
			 //On Screen Controls
			batch.setColor(getColor().r, getColor().g, getColor().b, (float)(100 - Parameters.transparency) / (float)100);
		 if (Parameters.onScreenControls == 1) {
			 //Normal Right
			 if ((Parameters.deviceSize == 1) && (Parameters.handOrientation == 1)){
				 batch.draw(Assets.normalLeft, 4, 2, 190, 100);
				 batch.draw(Assets.normalRight, 4 + 190 + 7, 2, 190, 100);
				 batch.draw(Assets.normalJump, 4 + 190 + 7 + 25 + 190, 2, 380, 100);
			//Normal Left
			 } else if ((Parameters.deviceSize == 1) && (Parameters.handOrientation == 0)){
				 batch.draw(Assets.normalJump, 4, 2, 380, 100); 
				 batch.draw(Assets.normalLeft, 4 + 380 + 25, 2, 190, 100);
				 batch.draw(Assets.normalRight, 4 + 380 + 25 + 190 + 7, 2, 190, 100);
			//Tablet Right
			 } else if ((Parameters.deviceSize == 0) && (Parameters.handOrientation == 1)){
				 batch.draw(Assets.tabletLeft, 2, 1, 95, 49);
				 batch.draw(Assets.tabletRight, 2 + 4 + 95, 1, 95, 49);
				 batch.draw(Assets.tabletJump, 601, 1, 190, 49);
			//Tablet Left
			 } else if ((Parameters.deviceSize == 0) && (Parameters.handOrientation == 0)){
				 batch.draw(Assets.tabletJump, 2, 1, 190, 49); 
				 batch.draw(Assets.tabletLeft, 601, 1, 95, 49);
				 batch.draw(Assets.tabletRight, 601 + 95 + 7, 1, 95, 49);

			 }
		 }
			batch.setColor(getColor().r, getColor().g, getColor().b, 1);
	
		if (testMode == false) {
		 batch.draw(Assets.uipause, 22, getHeight()-22 - 32, 32, 32); 
		 Assets.futuristicSmall.draw(batch, "Time: " + String.format("%.2f", yourTime) + "  s", 800-140, 480-22-10);
		 Assets.futuristicSmall.draw(batch, "Stars: " + Integer.toString(Characters.mainCharacter.getCoinCurrent()) + "  /  " + Integer.toString(Coin.coinList.size()), 800-140, 480-22-10-20);
		 Assets.futuristicSmall.draw(batch, "Deaths: " + Integer.toString(Parameters.levelDeaths[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()]), 800-140, 480-22-10-40);

		} else {
			Assets.futuristicSmall.draw(batch, "Time: " + String.format("%.2f", yourTime) + "  s", 800-140, 480-22-10);
			 Assets.futuristicSmall.draw(batch, "Stars: " + Integer.toString(Characters.mainCharacter.getCoinCurrent()) + "  /  " + Integer.toString(Coin.coinList.size()), 800-140, 480-22-10-20);
		}
		} else if (gameState == 1){
			if (BlackScreen.b == null) {
				addActor(new BlackScreen());
			}
			batch.draw(Assets.uiplay, 22, getHeight()-22 - 32, 32, 32); 
			if (Parameters.sound == 1) {
				batch.draw(Assets.uisoundon, 22 + 32 + 10, getHeight()-22 - 32, 32, 32); 
			} else {
				batch.draw(Assets.uisoundoff, 22 + 32 + 10, getHeight()-22 - 32, 32, 32); 
			}

			if (Parameters.music == 1) {
				batch.draw(Assets.uimusicon, 22 + 32 + 10 + 32 + 10, getHeight()-22 - 32, 32, 32); 
			} else {
				batch.draw(Assets.uimusicoff, 22 + 32 + 10 + 32 + 10, getHeight()-22 - 32, 32, 32); 
			}
		
			
			Assets.futuristicMedium.draw(batch, "[RESUME]", 300, 350);
			Assets.futuristicMedium.draw(batch, "[RESTART]", 294, 225);
			Assets.futuristicMedium.draw(batch, "[EXIT TO MENU]", 250, 100);

			 Assets.futuristicSmall.draw(batch, "Time: " + String.format("%.2f", yourTime) + "  s", 800-140, 480-22-10);
			 Assets.futuristicSmall.draw(batch, "Stars: " + Integer.toString(Characters.mainCharacter.getCoinCurrent()) + "  /  " + Integer.toString(Coin.coinList.size()), 800-140, 480-22-10-20);
			 Assets.futuristicSmall.draw(batch, "Deaths: " + Integer.toString(Parameters.levelDeaths[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()]), 800-140, 480-22-10-40);
			 if (LevelScreen.ls.getWorld() <= 10) {
				 Assets.futuristicSmall.draw(batch, "World  " + LevelScreen.ls.getWorld() + " Level  " + LevelScreen.ls.getLevel(), 320, 480-22-10);
			 } else {
				 Assets.futuristicSmall.draw(batch, "Hell World  " + (LevelScreen.ls.getWorld() - 10) + " Level  " + LevelScreen.ls.getLevel(), 296, 480-22-10);
			 }
			 
			
			 
		} else if (gameState == 3) {
			batch.draw(Assets.levelDetailsWindow, 201, yPosition, 400, 300);
			int stars = 1;

			if (yourTime <= timeLimit) {
				stars++;
			}
			if (Characters.mainCharacter.getCoinCurrent() >= Coin.coinList.size()) {
				stars++;
			}
			Texture image = null;
			if (stars == 1) {
				image = Assets.singleStar;
			} else if (stars == 2) {
				image = Assets.doubleStars;
			} else if (stars == 3) {
				image = Assets.tripleStars;
			}
			batch.draw(image, 330, yPosition + 300 - 30, 150, 100);
			batch.draw(Assets.uiplay, 500, yPosition + 180, 70, 70);
			batch.draw(Assets.uiretry, 500, yPosition + 100, 70, 70);
			batch.draw(Assets.uimenu, 500, yPosition + 20, 70, 70);
			if (GameScreen.gs.getWrap().isTestMode() == false) 
			Assets.futuristicSubtitle.draw(batch, "World  " + LevelScreen.ls.getWorld() + "  Level  " + LevelScreen.ls.getLevel(), 260, yPosition + 280);
			Assets.futuristicSmall.draw(batch, "Time Limit:", 220, yPosition + 230);
			Assets.futuristicSmall.draw(batch, Float.toString(this.timeLimit) + "  s", 220, yPosition + 210);
			
			Assets.futuristicSmall.draw(batch, "Your Time:", 220, yPosition + 170);
			
			Assets.futuristicSmall.draw(batch, String.format("%.2f", yourTime) + "  s", 220, yPosition + 150);
			
			Assets.futuristicSmall.draw(batch, "Stars:", 220, yPosition + 110);
			
			Assets.futuristicSmall.draw(batch, Integer.toString(Characters.mainCharacter.getCoinCurrent()) + "  /  " + Integer.toString(Coin.coinList.size()), 220, yPosition + 90);
			if (GameScreen.gs.getWrap().isTestMode() == false) {
			if (stars > Parameters.levelStars[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()]) {
				Parameters.stars += stars - Parameters.levelStars[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()];
			}
			if (Parameters.levelStars[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()] <= stars) {
				Parameters.levelStars[LevelScreen.ls.getWorld()][LevelScreen.ls.getLevel()] = stars;
			}
	

			
			if (firstTime) {
				firstTime = false;
				Parameters.saveLevels(LevelScreen.ls.getWorld());
				Parameters.saveWorlds();
				Parameters.saveStats();
				Parameters.saveShop();
			}
			}

			

		}
	
		if (testMode) batch.draw(Assets.uiexit, 22, getHeight()-22-50);
	}
	
	public void loadMap(String s) {
		FileHandle file;
		if (s.equals("levels/testGamePlay1337.txt")) {
			file = Gdx.files.local("editor/testGamePlay1337.txt");
		} else {
			file = Gdx.files.internal(s);
		}
		levelName = s;
		System.out.println(s);
		String map = file.readString();
		Scanner kb = new Scanner(map);
		
		Scanner line = new Scanner(kb.nextLine());
		line.next();
		line.next();
		line.next();
		String backgroundScroll = line.next();
		
		kb.nextLine();
		line = new Scanner(kb.nextLine());
		line.next();
		line.next();
		timeLimit = Float.valueOf(line.next());
		
		line = new Scanner(kb.nextLine());
		line.next();
		line.next();
		levelType = Integer.valueOf(line.next());
		float f = Float.valueOf(backgroundScroll);
		f = f / 32;
		addActor(new Background(getWidth(), getHeight()));
		addActor(door);
		addActor(character);
		addActor(midground);
		addActor(movers);
		for (int i = 24; i >= 0; i--) {
			line = new Scanner(kb.nextLine());
			line.useDelimiter("/");
			float xIndex = 0 - f;
			while (line.hasNext()) {
				String temp = line.next();
				if (!(temp.equals(" "))) {
					if (temp.contains("character")) {
						character.addActor(new MainCharacter(xIndex, i));
					} else if (temp.contains("string")) {
						Scanner test = new Scanner(temp);
						test.useDelimiter("-");
						test.next();
						midground.addActor(new StringTile(xIndex, i, test.next()));
					} else if (temp.contains("Spinner")) {
						Scanner test = new Scanner(temp);
						test.useDelimiter("-");
						test.next();
						midground.addActor(new Spinner(xIndex, i, temp ,test.next()));
						midground.addActor(new Tile(xIndex, i, "tileInvisible"));
					} else if (temp.contains("cannon")) {
						midground.addActor(new Cannon(xIndex, i, temp));
						midground.addActor(new Tile(xIndex, i, "tileInvisible"));
					} else if (temp.contains("powerup")) {
						if (temp.contains("Gravity")) {
							midground.addActor(new ReverseGravity(xIndex, i));
						} else if (temp.contains("Jump")) {
							midground.addActor(new DoubleJump(xIndex, i));
						}
					} else if (temp.equals("coin")) {
						midground.addActor(new Coin(xIndex, i));
					} else if (temp.contains("mover")) {
						movers.addActor(new Movers(xIndex, i, temp));
					} else if (temp.contains("tile")) {
						midground.addActor(new Tile(xIndex, i, temp));
					} else if (temp.equals("door")) {
						door.addActor(new Door(xIndex, i));
					} else if (temp.equals("flag")) {
						if (Flag.flag == null) {
							door.addActor(new Flag(xIndex, i));
						} else {
							Flag.flag.setPosition(xIndex * 32, i * 32);
						}
					} else if (temp.contains("gateKey")) {
						midground.addActor(new Key(xIndex, i));
					} else if (temp.equals("gateVertical")) {
						midground.addActor(new Tile(xIndex, i, temp));
					} else if (temp.equals("gateHorizontal")) {
						midground.addActor(new Tile(xIndex, i, temp));
					}
				}
				xIndex++;
			}

		}
		
		
		if (Flag.flag != null) {
			if (Flag.flag.isUp()) {
			while (Flag.flag.getX() > 352) {
				for (Tile t : Tile.allTiles) {
					t.setX(t.getX() - 32);
				}
				for (Cannon c: Cannon.cannonList) {
					c.setX(c.getX() - 32);
				}

				for (Bullet b: Bullet.bulletList) {
					b.setX(b.getX() - 32);
				}
				for (StringTile z : StringTile.stringList) {
					z.setX(z.getX() - 32);
				}
				for (Movers m : Movers.moversList) {
					m.setX(m.getX() - 32);
				}	
				for (Key k : Key.keyList){
					k.setX(k.getX() - 32);
				}
				
				if (Door.door != null) {
					Door.door.setX(Door.door.getX() - 32);
				}
				Flag.flag.setX(Flag.flag.getX() - 32);
			}
			Characters.mainCharacter.setX(Flag.flag.getX());
			Characters.mainCharacter.setY(Flag.flag.getY());
			Background.bg.setTotalX(100000000);
			Characters.mainCharacter.setBackgroundScroll(true);
			}
		}
		
		if (Characters.mainCharacter != null) {
			Characters.mainCharacter.setBackgroundScroll(false);
		}
		if (Float.valueOf(backgroundScroll) != 0) {
			Background.bg.setTotalX(Float.valueOf(backgroundScroll) * 10000);
			Characters.mainCharacter.setBackgroundScroll(true);
		}
		
	}
	
	

	public boolean isTestMode() {
		return testMode;
	}


	public void setTestMode(boolean testMode) {
		this.testMode = testMode;
	}



	public Float getTimeLimit() {
		return timeLimit;
	}



	public void setTimeLimit(Float timeLimit) {
		this.timeLimit = timeLimit;
	}



	public Integer getLevelType() {
		return levelType;
	}



	public void setLevelType(Integer levelType) {
		this.levelType = levelType;
	}



	public int getGameState() {
		return gameState;
	}



	public void setGameState(int gameState) {
		this.gameState = gameState;
	}



	public float getYourTime() {
		return yourTime;
	}



	public void setYourTime(float yourTime) {
		this.yourTime = yourTime;
	}



	public Array<Bullet> getActiveBullets() {
		return activeBullets;
	}



	public Pool<Bullet> getBulletPool() {
		return bulletPool;
	}





	
			
		
		

}
	

