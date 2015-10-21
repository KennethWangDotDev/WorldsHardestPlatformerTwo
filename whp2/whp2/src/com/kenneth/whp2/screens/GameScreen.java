package com.kenneth.whp2.screens;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.TouchInfo;
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
import com.kenneth.whp2.actors.leveleditor.BlackOverlay;
import com.kenneth.whp2.actors.leveleditor.Icons;
import com.kenneth.whp2.actors.leveleditor.OrangeLinesHorizontal;
import com.kenneth.whp2.actors.leveleditor.OrangeLinesVertical;
import com.kenneth.whp2.actors.leveleditor.PointerLeft;
import com.kenneth.whp2.actors.leveleditor.PointerRight;
import com.kenneth.whp2.actors.objects.Characters;
import com.kenneth.whp2.actors.objects.Coin;
import com.kenneth.whp2.actors.objects.Key;
import com.kenneth.whp2.actors.wrap.GameWrap;


public class GameScreen implements Screen, InputProcessor {
	private Stage stage;
	private GameWrap wrap;
	public static GameScreen gs;
	private String level;
	 public static HashMap<Integer, TouchInfo> touches = new HashMap<Integer,TouchInfo>();

	public GameScreen(String s) {
		gs = this;
		stage = new Stage();
		wrap = new GameWrap(s);
		stage.addActor(wrap);
		level = s;
		for(int i = 0; i < 5; i++){
            touches.put(i, new TouchInfo());
        }
	}

	public void resize(int width, int height) {
		stage.setViewport(Starter.WIDTH, Starter.HEIGHT, true);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();	
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(this);
	}

	@Override 
    public void hide() {
    	Gdx.input.setInputProcessor(null);
    }
	


	
	private boolean inBounds(float mouseX, float mouseY, int objectX, int objectY, int objectWidth, int objectHeight) {
		if ((mouseX >= objectX) && (mouseX <= objectX + objectWidth)) {
			if ((mouseY >= 480 - objectY) && (mouseY <= 480 - objectY + objectHeight)) {
				return true;
			}
		}
	return false;
	}
	
	@Override public void resume() {}
	@Override public void pause() {}
	@Override public void dispose() {
		if (stage != null)
		stage.dispose();
	}	





	@Override
	public String toString() {
		return "GameScreen [stage=" + stage + ", wrap=" + wrap + "]";
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public GameWrap getWrap() {
		return wrap;
	}

	public void setWrap(GameWrap wrap) {
		this.wrap = wrap;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		 Vector3 temp = new Vector3(screenX, screenY, 0);
		 stage.getCamera().unproject(temp);
		 screenX = (int) temp.x;
		 screenY = (int) (480 - temp.y);
		 
		if (wrap.isTestMode()) {
		 if (inBounds(screenX, screenY, 22, 480-72+50, 50, 50)) {
			 Characters.charactersList.remove(this);
				for (Tile t: Tile.allTiles) {
					GameScreen.gs.getWrap().addAction(Actions.removeActor(t));
				}
				Tile.allTiles.clear();
				Tile.screenTiles.clear();
				Actions.addAction(Actions.removeActor());
				for (Cannon c: Cannon.cannonList) {
					GameScreen.gs.getWrap().addAction(Actions.removeActor(c));
				}
				Cannon.cannonList.clear();
				for (Bullet b: Bullet.bulletList) {
					GameScreen.gs.getWrap().addAction(Actions.removeActor(b));
				}
				Bullet.bulletList.clear();
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
				Key.keyList.clear();
				
				Movers.moversList.clear();
				Movers.left.clear();
				Movers.right.clear();
				GameScreen.gs.getWrap().addAction(Actions.removeActor(Background.bg));
				GameScreen.gs.getStage().clear();
				GameScreen.gs.dispose();
				Starter.starter.setScreen(new LevelEditor());
				LevelEditor.wrap.load("editor/testGamePlay1337.txt");
				 LevelEditor.wrap.getForeground().addActor(new BlackOverlay());
				 LevelEditor.wrap.getForeground().addActor(new OrangeLinesHorizontal());
				 LevelEditor.wrap.getForeground().addActor(new OrangeLinesVertical());
				 Icons i = new Icons();
				 LevelEditor.wrap.setIcons(i);
				 LevelEditor.wrap.getForeground().addActor(i);
				 LevelEditor.wrap.getForeground().addActor(new PointerLeft());
				 LevelEditor.wrap.getForeground().addActor(new PointerRight());
				 LevelEditor.wrap.setState(1);

		 }
	 } 
		 
		 
		 
		 if (inBounds(screenX, screenY, 22 - 10, 480-22 + 10, 42, 42)) {
			 if (GameScreen.gs.getWrap().getGameState() == 0) {
				 GameScreen.gs.getWrap().setGameState(1);
			 } else if (GameScreen.gs.getWrap().getGameState() == 1) {
				 Parameters.saveWorlds();
				 GameScreen.gs.getWrap().setGameState(2);
			 }
		 } else if (GameScreen.gs.getWrap().getGameState() == 3) {
//				batch.draw(Assets.uiplay, 450, yPosition + 80, 125, 125);
			 if (inBounds(screenX, screenY, 500, 110 + 70, 70, 70)) {

				 Characters.charactersList.remove(this);
					for (Tile t: Tile.allTiles) {
						GameScreen.gs.getWrap().addAction(Actions.removeActor(t));
					}
					Tile.allTiles.clear();
					Tile.screenTiles.clear();
					Actions.addAction(Actions.removeActor());
					for (Cannon c: Cannon.cannonList) {
						GameScreen.gs.getWrap().addAction(Actions.removeActor(c));
					}
					Cannon.cannonList.clear();
					for (Bullet b: Bullet.bulletList) {
						GameScreen.gs.getWrap().addAction(Actions.removeActor(b));
					}		
					Bullet item;
			        int len = GameScreen.gs.getWrap().getActiveBullets().size;
			        for (int i = len; --i >= 0;) {
			            item = GameScreen.gs.getWrap().getActiveBullets().get(i);
			            GameScreen.gs.getWrap().getActiveBullets().removeIndex(i);
			            GameScreen.gs.getWrap().getBulletPool().free(item);
			        }
					Bullet.bulletList.clear();
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
					Key.keyList.clear();
					for (Coin z : Coin.coinList){
						GameScreen.gs.getWrap().addAction(Actions.removeActor(z));
					}
					Coin.coinList.clear();
					
					Movers.moversList.clear();
					Movers.left.clear();
					Movers.right.clear();
					GameScreen.gs.getWrap().addAction(Actions.removeActor(Background.bg));
					GameScreen.gs.getStage().clear();
					GameScreen.gs.dispose();
					if (wrap.isTestMode()) {
						System.out.println("test");
						Starter.starter.setScreen(new LevelEditor());
						LevelEditor.wrap.load("editor/testGamePlay1337.txt");
						 LevelEditor.wrap.getForeground().addActor(new BlackOverlay());
						 LevelEditor.wrap.getForeground().addActor(new OrangeLinesHorizontal());
						 LevelEditor.wrap.getForeground().addActor(new OrangeLinesVertical());
						 Icons i = new Icons();
						 LevelEditor.wrap.setIcons(i);
						 LevelEditor.wrap.getForeground().addActor(i);
						 LevelEditor.wrap.getForeground().addActor(new PointerLeft());
						 LevelEditor.wrap.getForeground().addActor(new PointerRight());
						 LevelEditor.wrap.setState(1);
					} else {
						Starter.starter.setScreen(new LevelScreen(LevelScreen.ls.getWorld()));
					}
			 } else if (inBounds(screenX, screenY, 500, 90 + 180 + 70, 70, 70)) {
//					batch.draw(Assets.uiplay, 500, yPosition + 180, 70, 70);
//					batch.draw(Assets.uiretry, 500, yPosition + 100, 70, 70);
//					batch.draw(Assets.uimenu, 500, yPosition + 20, 70, 70);
				 Characters.charactersList.remove(this);
					for (Tile t: Tile.allTiles) {
						GameScreen.gs.getWrap().addAction(Actions.removeActor(t));
					}
					Tile.allTiles.clear();
					Tile.screenTiles.clear();
					Actions.addAction(Actions.removeActor());
					for (Cannon c: Cannon.cannonList) {
						GameScreen.gs.getWrap().addAction(Actions.removeActor(c));
					}
					Cannon.cannonList.clear();
					for (Bullet b: Bullet.bulletList) {
						GameScreen.gs.getWrap().addAction(Actions.removeActor(b));
					}		
					Bullet item;
			        int len = GameScreen.gs.getWrap().getActiveBullets().size;
			        for (int i = len; --i >= 0;) {
			            item = GameScreen.gs.getWrap().getActiveBullets().get(i);
			            GameScreen.gs.getWrap().getActiveBullets().removeIndex(i);
			            GameScreen.gs.getWrap().getBulletPool().free(item);
			        }
					Bullet.bulletList.clear();
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
					Key.keyList.clear();
					for (Coin z : Coin.coinList){
						GameScreen.gs.getWrap().addAction(Actions.removeActor(z));
					}
					Coin.coinList.clear();
					
					Movers.moversList.clear();
					Movers.left.clear();
					Movers.right.clear();
					GameScreen.gs.getWrap().addAction(Actions.removeActor(Background.bg));
					GameScreen.gs.getStage().clear();
					GameScreen.gs.dispose();
					if (wrap.isTestMode()) {
						Starter.starter.setScreen(new LevelEditor());
						LevelEditor.wrap.load("editor/testGamePlay1337.txt");
						 LevelEditor.wrap.getForeground().addActor(new BlackOverlay());
						 LevelEditor.wrap.getForeground().addActor(new OrangeLinesHorizontal());
						 LevelEditor.wrap.getForeground().addActor(new OrangeLinesVertical());
						 Icons i = new Icons();
						 LevelEditor.wrap.setIcons(i);
						 LevelEditor.wrap.getForeground().addActor(i);
						 LevelEditor.wrap.getForeground().addActor(new PointerLeft());
						 LevelEditor.wrap.getForeground().addActor(new PointerRight());
						 LevelEditor.wrap.setState(1);
					} else {
						if (LevelScreen.ls.getLevel() != 10) {
							LevelScreen.ls.setLevel(LevelScreen.ls.getLevel() + 1);
						} else {
							if (!(LevelScreen.ls.getWorld() == 10)) {
								if (!(LevelScreen.ls.getWorld() == 20)) {
									LevelScreen.ls.setLevel(1);
									LevelScreen.ls.setWorld(LevelScreen.ls.getWorld() + 1);
									Parameters.worldSelection = LevelScreen.ls.getWorld();
									Parameters.saveWorlds();
								}
							}

						}
						Starter.starter.setScreen(new GameScreen("world" + LevelScreen.ls.getWorld() + "level" + (LevelScreen.ls.getLevel())));
					}

			 } else if (inBounds(screenX, screenY, 500, 190 + 70, 70, 70)) {
				 Characters.charactersList.remove(this);
					for (Tile t: Tile.allTiles) {
						GameScreen.gs.getWrap().addAction(Actions.removeActor(t));
					}
					Tile.allTiles.clear();
					Tile.screenTiles.clear();
					Actions.addAction(Actions.removeActor());
					for (Cannon c: Cannon.cannonList) {
						GameScreen.gs.getWrap().addAction(Actions.removeActor(c));
					}
					Cannon.cannonList.clear();
					for (Bullet b: Bullet.bulletList) {
						GameScreen.gs.getWrap().addAction(Actions.removeActor(b));
					}		
					Bullet item;
			        int len = GameScreen.gs.getWrap().getActiveBullets().size;
			        for (int i = len; --i >= 0;) {
			            item = GameScreen.gs.getWrap().getActiveBullets().get(i);
			            GameScreen.gs.getWrap().getActiveBullets().removeIndex(i);
			            GameScreen.gs.getWrap().getBulletPool().free(item);
			        }
					Bullet.bulletList.clear();
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
					Key.keyList.clear();
					for (Coin z : Coin.coinList){
						GameScreen.gs.getWrap().addAction(Actions.removeActor(z));
					}
					Coin.coinList.clear();
					
					Movers.moversList.clear();
					Movers.left.clear();
					Movers.right.clear();
					GameScreen.gs.getWrap().addAction(Actions.removeActor(Background.bg));
					GameScreen.gs.getStage().clear();
					GameScreen.gs.dispose();
					if (wrap.isTestMode()) {
						Starter.starter.setScreen(new LevelEditor());
						LevelEditor.wrap.load("editor/testGamePlay1337.txt");
						 LevelEditor.wrap.getForeground().addActor(new BlackOverlay());
						 LevelEditor.wrap.getForeground().addActor(new OrangeLinesHorizontal());
						 LevelEditor.wrap.getForeground().addActor(new OrangeLinesVertical());
						 Icons i = new Icons();
						 LevelEditor.wrap.setIcons(i);
						 LevelEditor.wrap.getForeground().addActor(i);
						 LevelEditor.wrap.getForeground().addActor(new PointerLeft());
						 LevelEditor.wrap.getForeground().addActor(new PointerRight());
						 LevelEditor.wrap.setState(1);
					} else {
						Starter.starter.setScreen(new GameScreen("world" + LevelScreen.ls.getWorld() + "level" + (LevelScreen.ls.getLevel())));
					}
			 }
		 } else if (GameScreen.gs.getWrap().getGameState() == 1) {

			 if (inBounds(screenX, screenY, 22 + 32 + 10, 480-22 + 10, 42, 42)) {
					if (Parameters.sound == 1) {
					Parameters.sound = 0;
				} else {
					Parameters.sound = 1;
				}
			 }
			 
			 if (inBounds(screenX, screenY, 22 + 32 + 10 + 32 + 10, 480-22 + 10, 42, 42)) {
					if (Parameters.music == 1) {
					Parameters.music = 0;
					Assets.currentMusic.setVolume(0f);
				} else {
					Parameters.music = 1;
					 if (Assets.currentMusic.isPlaying() == false) {
						 Assets.currentMusic.play();
					 }
					 Assets.currentMusic.setVolume(0.68f);

				}
			 }
			 
			 if (inBounds(screenX, screenY, 240, 480 - 180 + 102, 376, 90)) {
				 GameScreen.gs.getWrap().setGameState(2);
			 }
			 
			 if (inBounds(screenX, screenY, 240, 480 - 440 + 102, 376, 90)) {
				 BlackScreen.b = null;
				 Characters.mainCharacter.setCauseOfDeath("nothing");
				 Parameters.deathsExit++;
				 Parameters.saveStats();
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
					Bullet item;
			        int len = GameScreen.gs.getWrap().getActiveBullets().size;
			        for (int i = len; --i >= 0;) {
			            item = GameScreen.gs.getWrap().getActiveBullets().get(i);
			            GameScreen.gs.getWrap().getActiveBullets().removeIndex(i);
			            GameScreen.gs.getWrap().getBulletPool().free(item);
			        }
					Bullet.bulletList.clear();
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
					Starter.starter.setScreen(new LevelScreen(LevelScreen.ls.getWorld()));
			 }
			 
			 if (inBounds(screenX, screenY, 240, 480 - 317 + 102, 376, 90)) {
				 Characters.mainCharacter.setCauseOfDeath("nothing");
				 BlackScreen.b = null;
					Parameters.deathsExit++;
				 Characters.mainCharacter.death();
			 }
			 
		 }
		 
	 
		
		 if(pointer < 5){
	            touches.get(pointer).touchX = screenX;
	            touches.get(pointer).touchY = screenY;
	            touches.get(pointer).touched = true;
	        }
	        return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(pointer < 5){
            touches.get(pointer).touchX = 0;
            touches.get(pointer).touchY = 0;
            touches.get(pointer).touched = false;
        }
        return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
//        if(pointer < 5){
//            touches.get(pointer).touchX = screenX;
//            touches.get(pointer).touchY = screenX;
//            touches.get(pointer).touched = true;
//        }
        return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}


}
