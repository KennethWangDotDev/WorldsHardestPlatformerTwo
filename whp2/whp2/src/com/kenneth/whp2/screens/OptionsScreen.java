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
import com.kenneth.whp2.actors.objects.Characters;
import com.kenneth.whp2.actors.wrap.EditorWrap;
import com.kenneth.whp2.actors.wrap.GameWrap;
import com.kenneth.whp2.actors.wrap.OptionsWrap;
import com.kenneth.whp2.actors.wrap.PlayWrap;
import com.kenneth.whp2.actors.wrap.StatsWrap;
import com.kenneth.whp2.actors.wrap.TitleWrap;
import com.kenneth.whp2.actors.wrap.WorldWrap;


public class OptionsScreen implements Screen, GestureListener {
	private Stage stage;
	private OptionsWrap wrap;


	public OptionsScreen() {
		stage = new Stage();
		wrap = new OptionsWrap();
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
		 Vector3 temp = new Vector3(x, y, 0);
		 stage.getCamera().unproject(temp);
		 x = temp.x;
		 y = 480 - temp.y;
		 if(button == Buttons.LEFT){
			 //				batch.draw(Assets.uiexit, 22, getHeight()-22-50);
			if (inBounds(x, y, 22, 480-72+50, 50, 50)) {

					
					dispose();
					 stage.clear();
					Starter.starter.setScreen(new TitleScreen());
					Parameters.saveWorlds();
//					batch.draw(test, 500, 360 - 24, 500, 360 - 24, 42, 28, 1f, 1f, getRotation(), false);
//					batch.draw(test, 500, 300 - 24, 500, 300 - 24, 42, 28, 1f, 1f, getRotation(), false);
//					batch.draw(test, 500, 240 - 24, 500, 240 - 24, 42, 28, 1f, 1f, getRotation(), false);
//					batch.draw(test, 500, 180 - 24, 500, 180 - 24, 42, 28, 1f, 1f, getRotation(), false);
//
//					batch.draw(test, 750, 360 - 24, 750, 360 - 24, 42, 28, 1f, 1f, getRotation(), true);
//					batch.draw(test, 750, 300 - 24, 750, 300 - 24, 42, 28, 1f, 1f, getRotation(), true);
//					batch.draw(test, 750, 240 - 24, 750, 240 - 24, 42, 28, 1f, 1f, getRotation(), true);
//					batch.draw(test, 750, 180 - 24, 750, 180 - 24, 42, 28, 1f, 1f, getRotation(), true);
			 }else if (inBounds(x, y, 500, 360 - 24 + 28, 42, 28)) {
				 if (Parameters.handOrientation == 1) {
					 Parameters.handOrientation = 0;
				 } else {
					 Parameters.handOrientation = 1;
				 }
			 } else if (inBounds(x, y, 750, 360 - 24 + 28, 42, 28)) {
				 if (Parameters.handOrientation == 1) {
					 Parameters.handOrientation = 0;
				 } else {
					 Parameters.handOrientation = 1;
				 }
			 } else if (inBounds(x, y, 500, 300 - 24 + 28, 42, 28)) {
				 if (Parameters.deviceSize == 1) {
					 Parameters.deviceSize = 0;
				 } else {
					 Parameters.deviceSize = 1;
				 }
			 } else if (inBounds(x, y, 750, 300 - 24 + 28, 42, 28)) {
				 if (Parameters.deviceSize == 1) {
					 Parameters.deviceSize = 0;
				 } else {
					 Parameters.deviceSize = 1;
				 }
			 } else if (inBounds(x, y, 500, 240 - 24 + 28, 42, 28)) {
				 if (Parameters.sound == 1) {
					 Parameters.sound = 0;
				 } else {
					 Parameters.sound = 1;
				 }
			 } else if (inBounds(x, y, 750, 240 - 24 + 28, 42, 28)) {
				 if (Parameters.sound == 1) {
					 Parameters.sound = 0;
				 } else {
					 Parameters.sound = 1;
				 }
			 } else if (inBounds(x, y, 500, 180 - 24 + 28, 42, 28)) {
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
			 } else if (inBounds(x, y, 750, 180 - 24 + 28, 42, 28)) {
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
			 } else if (inBounds(x, y, 500, 120 - 24 + 28, 42, 28)) {
				 Parameters.transparency = Parameters.transparency - 10;
				 if (Parameters.transparency <= 0) {
					 Parameters.transparency = 0;
				 }
			 } else if (inBounds(x, y, 750, 120 - 24 + 28, 42, 28)) {
				 Parameters.transparency = Parameters.transparency + 10;
				 if (Parameters.transparency >= 100) {
					 Parameters.transparency = 100;
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
