package com.kenneth.whp2.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;
import com.kenneth.whp2.Starter;
import com.kenneth.whp2.actors.wrap.TitleWrap;


public class TitleScreen implements Screen, GestureListener {
	private Stage stage;
	private TitleWrap wrap;;


	public TitleScreen() {
		stage = new Stage();
		wrap = new TitleWrap();
		stage.addActor(wrap);
		if (Parameters.music == 1)
		Assets.currentMusic.play();

		
	}

	public void resize(int width, int height) {
		stage.setViewport(Starter.WIDTH, Starter.HEIGHT, true);
//
		stage.getCamera().update();

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
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		
	}
	
	private boolean inBounds(float mouseX, float mouseY, int objectX, int objectY, int objectWidth, int objectHeight) {
		if ((mouseX >= objectX) && (mouseX <= objectX + objectWidth)) {
			if ((mouseY >= 480 - objectY) && (mouseY <= 480 - objectY + objectHeight)) {
				return true;
			}
		}
	return false;
	}

	@Override public boolean touchDown(float x, float y, int pointer, int button) {
		 if(button == Buttons.LEFT){
			 Vector3 temp = new Vector3(x, y, 0);
			 stage.getCamera().unproject(temp);
			 x = temp.x;
			 y = 480 - temp.y;
			 System.out.println(x + " " + y);
			 //Play
			 if (inBounds(x, y, 16, 480 - 90, 175, 50)) {
				 stage.clear();
				 stage.dispose();
				Starter.starter.setScreen(new PlayScreen());

				 
			 } else if (inBounds(x, y, 16, 480 - 157, 175, 50)) {
				 stage.clear();
				 stage.dispose();
					Starter.starter.setScreen(new StatsScreen());
			 } else if (inBounds(x, y, 16, 480 - 220, 175, 50)) {
				 stage.clear();
				 stage.dispose();
					Starter.starter.setScreen(new ShopScreen());
			 } else if (inBounds(x, y, 16, 480 - 281, 175, 50)) {
				 stage.clear();
				 stage.dispose();
					Starter.starter.setScreen(new OptionsScreen());
			 } else if (inBounds(x, y, 16, 480 - 348, 175, 50)) {
				 stage.clear();
				 stage.dispose();
				 Gdx.app.exit();
			 }
	     }
		return false;
		
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}



}
