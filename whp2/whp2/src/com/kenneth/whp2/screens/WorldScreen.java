package com.kenneth.whp2.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;
import com.kenneth.whp2.Starter;
import com.kenneth.whp2.actors.Background;
import com.kenneth.whp2.actors.objects.Characters;
import com.kenneth.whp2.actors.wrap.EditorWrap;
import com.kenneth.whp2.actors.wrap.GameWrap;
import com.kenneth.whp2.actors.wrap.PlayWrap;
import com.kenneth.whp2.actors.wrap.TitleWrap;
import com.kenneth.whp2.actors.wrap.WorldWrap;


public class WorldScreen implements Screen, GestureListener {
	private Stage stage;
	private WorldWrap wrap;


	public WorldScreen() {
		stage = new Stage();
		wrap = new WorldWrap();
		stage.addActor(wrap);
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
//		if (velocityY < -100) trafficGame.playerCar.tryMoveUp();
//		if (velocityY > 100) trafficGame.playerCar.tryMoveDown();
		return false;
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
		stage.dispose();
	}	
	@Override public boolean tap(float x, float y, int count, int button) {return false;}
	@Override public boolean touchDown(float x, float y, int pointer, int button) {
//					batch.draw(temp, 150 - 39, (480/2) - (28/2), 700, (480/2) - (28/2), 42, 28, 1f, 1f, 0, false);	
//	 }
	 
//		batch.draw(temp, (800/2) - 14, 50, (800/2) - 28, 100, 28, 42, 1f, 1f, 0);	
////		 }
//	 } else {
//		 
//	 }
//	batch.draw(Assets.greysliderup, (800/2) - 14, 380, 28, 42);
		 Vector3 temp = new Vector3(x, y, 0);
		 stage.getCamera().unproject(temp);
		 x = temp.x;
		 y = 480 - temp.y;
		 if(button == Buttons.LEFT){
			 //Play
			 if (inBounds(x, y, 200, 480-135, 401, 200)) {
				 if (Parameters.worldPlayable[wrap.getWorld()] == true) {
				dispose();
				 stage.clear();
				 Parameters.worldSelection = wrap.getWorld();
				 Parameters.saveWorlds();
				Starter.starter.setScreen(new LevelScreen(wrap.getWorld()));
				 }
			 } else if (inBounds(x, y, 22, 480-72+50, 50, 50)) {


					dispose();
					 stage.clear();
					Starter.starter.setScreen(new PlayScreen());
					Parameters.saveWorlds();

			 } else if (inBounds(x, y, 150 - 39 - 10, (480 / 2) - (28 / 2) + 28 + 10, 42 + 20, 28 + 20)) {
				 if ((wrap.getWorld() != 1) && (wrap.getWorld() != 11)) {
							 wrap.setWorld(wrap.getWorld() - 1);
					 	}
					 

			 } else if (inBounds(x, y, 650 - 10, (480 / 2) - (28 / 2) + 28 - 10, 42 + 20, 28 + 20)) {
				 if ((wrap.getWorld() != 10) && (wrap.getWorld() != 20)) {
					 if ((Parameters.worldPlayable[wrap.getWorld()]) || (Parameters.worldPlayable[wrap.getWorld() + 1])) {
						 wrap.setWorld(wrap.getWorld() + 1);
						 }
				 }
			 } else if (inBounds(x, y, (800/2) - 14, 50 + 42, 28, 42)) {
				 if (wrap.getWorld() <= 10) {
					 if ((Parameters.worldPlayable[wrap.getWorld() + 10]) || (wrap.getWorld() == 1)) {
						wrap.setWorld(wrap.getWorld() + 10); 
						Background.bg.setHell(true);
					 }
				 }
			 } else if (inBounds(x, y, (800/2) - 14, 380 + 42, 28, 42)) {
				 if (wrap.getWorld() > 10) {
					 wrap.setWorld(wrap.getWorld() - 10);
						Background.bg.setHell(false);
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


}
