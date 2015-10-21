package com.kenneth.whp2.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
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
import com.kenneth.whp2.actors.wrap.PlayWrap;
import com.kenneth.whp2.actors.wrap.TitleWrap;


public class PlayScreen implements Screen, GestureListener {
	private Stage stage;
	private PlayWrap wrap;


	public PlayScreen() {
		stage = new Stage();
		wrap = new PlayWrap();
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
//		 batch.draw(Assets.buttonSingle, 50, 135);
//		 batch.draw(Assets.buttonEditor, 50 + buttonWidth + divider, 135);
//		 batch.draw(Assets.buttonMulti, 50 + buttonWidth + divider + buttonWidth + divider, 135);
//		 	private float titleOffset = 22;
//		private float divider = 55;
//		private float buttonWidth = 195;
//		 batch.draw(Assets.uiexit, 22, getHeight()-22-50);
		 Vector3 temp = new Vector3(x, y, 0);
		 stage.getCamera().unproject(temp);
		 x = temp.x;
		 y = 480 - temp.y;
		 if(button == Buttons.LEFT){
			 //Play
			 if (inBounds(x, y, 50 + 25 + 50, 480-135, 195, 195)) {
				dispose();
				 stage.clear();
				Starter.starter.setScreen(new WorldScreen());
			 } else if (inBounds(x, y, 150 + 50 + 20 + 195 + 55, 480-135, 195, 195)) {
				 if (Parameters.worldPlayable[4]) {
					dispose();
					 stage.clear();
					Starter.starter.setScreen(new LevelEditor());
					LevelEditor.wrap.inputProcessor();
				 }
			 } else if (inBounds(x, y, 50 + 195 + 55 + 195 + 55, 480-135, 195, 195)) {
//					dispose();
//					 stage.clear();
//					Starter.starter.setScreen(new GameScreen());
			 } else if (inBounds(x, y, 22, 480-72+50, 50, 50)) {
					dispose();
					 stage.clear();
					Starter.starter.setScreen(new TitleScreen());
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
