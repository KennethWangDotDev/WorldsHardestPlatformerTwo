package com.kenneth.whp2.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;
import com.kenneth.whp2.Starter;
import com.kenneth.whp2.actors.objects.Characters;
import com.kenneth.whp2.actors.wrap.EditorWrap;
import com.kenneth.whp2.actors.wrap.GameWrap;
import com.kenneth.whp2.actors.wrap.LevelWrap;
import com.kenneth.whp2.actors.wrap.PlayWrap;
import com.kenneth.whp2.actors.wrap.TitleWrap;


public class LevelScreen implements Screen, GestureListener {
	private Stage stage;
	private LevelWrap wrap;
	public static LevelScreen ls;
	private int world;
	private int level;


	public LevelScreen(int world) {
		stage = new Stage();
		wrap = new LevelWrap(world);
		stage.addActor(wrap);
		this.world = world;
		ls = this;
	}

	public void resize(int width, int height) {
		stage.setViewport(Starter.WIDTH, Starter.HEIGHT, true);
		stage.getCamera().translate(-stage.getGutterWidth(), -stage.getGutterHeight(), 0);

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
		Gdx.input.setInputProcessor(new GestureDetector(this));
	}

	@Override 
    public void hide() {
    	Gdx.input.setInputProcessor(null);
    }
	
	@Override
	public boolean fling(float velocityX, float velocityY, int button) {

		return false;
	}

	
	private boolean inBounds(float mouseX, float mouseY, int objectX, int objectY, int objectWidth, int objectHeight) {
		if ((mouseX >= objectX) && (mouseX <= objectX + objectWidth)) {
			if ((mouseY >= objectY) && (mouseY <= objectY + objectHeight)) {
				return true;
			}
		}
	return false;
	}
	
	@Override public void resume() {}
	@Override public void pause() {}
	@Override public void dispose() {
		stage.dispose();
	}	
	@Override public boolean tap(float x, float y, int count, int button) {return false;}
	@Override public boolean touchDown(float x, float y, int pointer, int button) {
		 Vector3 temp = new Vector3(x, y, 0);
		 stage.getCamera().unproject(temp);
		 x = temp.x;
		 y = 480 - temp.y;
		 if(button == Buttons.LEFT){
			 System.out.println(y);
			 if (wrap.isDetails() == false) {
			 if (inBounds(x, y, 112, 145, 60, 60)) {

				 level = 1;
				 String s = "world" + world + "level" + level;
				 System.out.println("level" + level);
				 if (Parameters.levelPlayable[world][level]) {
					 	wrap.setDetails(true);
			 
				 }
			 } else if (inBounds(x, y, 112 + 60 + 70, 145, 60, 60)) {

					 level = 2;
					 String s = "world" + world + "level" + level;
					 System.out.println("level" + level);
					 if (Parameters.levelPlayable[world][level]) {
						 	wrap.setDetails(true);				 
					 }
			 } else if (inBounds(x, y, 112 + 60 + 70 + 60 + 70, 145, 60, 60)) {
 	
					 level = 3;
					 String s = "world" + world + "level" + level;
					 System.out.println("level" + level);
					 if (Parameters.levelPlayable[world][level]) {
						 	wrap.setDetails(true);			 
					 }
			 } else if (inBounds(x, y, 112 + 60 + 70 + 60 + 70 + 60 + 70, 145, 60, 60)) {

					 level = 4;
					 String s = "world" + world + "level" + level;
					 System.out.println("level" + level);
					 if (Parameters.levelPlayable[world][level]) {
						 	wrap.setDetails(true);				 
					 }
			 } else if (inBounds(x, y, 112 + 60 + 70 + 60 + 70 + 60 + 70 + 60 + 70, 145, 60, 60)) {

					 level = 5;
					 String s = "world" + world + "level" + level;
					 System.out.println("level" + level);
					 if (Parameters.levelPlayable[world][level]) {
						 	wrap.setDetails(true);			 
					 }
			 } else if (inBounds(x, y, 112, 283, 60, 60)) {
 	
							 level = 10;
							 String s = "world" + world + "level" + level;
							 System.out.println("level" + level);
							 if (Parameters.levelPlayable[world][level]) {
								 	wrap.setDetails(true);			 
							 }
						 } else if (inBounds(x, y, 112 + 60 + 70, 283, 60, 60)) {
 		
								 level = 9;
								 String s = "world" + world + "level" + level;
								 System.out.println("level" + level);
								 if (Parameters.levelPlayable[world][level]) {
									 	wrap.setDetails(true);				 
								 }
						 } else if (inBounds(x, y, 112 + 60 + 70 + 60 + 70, 283, 60, 60)) {
 							
								 level = 8;
								 String s = "world" + world + "level" + level;
								 System.out.println("level" + level);
								 if (Parameters.levelPlayable[world][level]) {
									 	wrap.setDetails(true);				 
								 }
						 } else if (inBounds(x, y, 112 + 60 + 70 + 60 + 70 + 60 + 70, 283, 60, 60)) {
 					
								 level = 7;
								 String s = "world" + world + "level" + level;
								 System.out.println("level" + level);
								 if (Parameters.levelPlayable[world][level]) {
									 	wrap.setDetails(true);			 
								 }
						 } else if (inBounds(x, y, 112 + 60 + 70 + 60 + 70 + 60 + 70 + 60 + 70, 283, 60, 60)) {
 						
								 level = 6;
								 String s = "world" + world + "level" + level;
								 System.out.println("level" + level);
								 if (Parameters.levelPlayable[world][level]) {
									 	wrap.setDetails(true);			 
								 }
						 } else if (inBounds(x, y, 22, 22, 50, 50)) {
								dispose();
								 stage.clear();
								 	wrap.setDetails(true);
									Starter.starter.setScreen(new WorldScreen());	
						 }
	     }else {
			 if (inBounds(x, y, 450, 188, 125, 125)) {
					dispose();
					 stage.clear();
					 String s = "world" + world + "level" + level;
						Starter.starter.setScreen(new GameScreen(s));	
			 } else if (inBounds(x, y, 201-20, 80, 40, 40)) {
				 wrap.setDetails(false);
//					if (Parameters.levelPlayable[world][LevelScreen.ls.getLevel() + 1] == false) {
//						batch.draw(Assets.greybutton, 270, yPosition - 85, 250, 70);
			 } else if (inBounds(x, y, 270, 470 - 70, 250, 70)) {
				 if (level != 10) {
				 if (Parameters.levelPlayable[world][LevelScreen.ls.getLevel() + 1] == false) {
					 Parameters.levelPlayable[world][level + 1] = true;
					 Parameters.levelSkips--;
					 Parameters.saveLevels(world);
					 Parameters.saveShop();
				 }
				} else if ((LevelScreen.ls.getLevel() == 10) && (Parameters.worldPlayable[LevelScreen.ls.getWorld() + 1] == false)) {
					 Parameters.levelSkips--;
					 Parameters.levelPass[world][10] = true;
					 Parameters.worldPlayable[world + 1] = true;
					 Parameters.saveLevels(world);
					 Parameters.saveLevels(world + 1);
					 Parameters.saveShop();
				}
			 }
			
		 }
		 } 
		return false;
		
	}
	@Override public boolean longPress(float x, float y) {return false;}
	@Override public boolean pan(float x, float y, float deltaX, float deltaY) {return false;}
	@Override public boolean zoom(float initialDistance, float distance) {return false;}
	@Override public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {return false;}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getWorld() {
		return world;
	}

	public void setWorld(int world) {
		this.world = world;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}


}
