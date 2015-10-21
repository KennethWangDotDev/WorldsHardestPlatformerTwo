package com.kenneth.whp2.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Starter;
import com.kenneth.whp2.actors.objects.Characters;
import com.kenneth.whp2.actors.wrap.EditorWrap;
import com.kenneth.whp2.actors.wrap.GameWrap;


public class LevelEditor implements Screen {
	public static EditorWrap wrap;
	public static LevelEditor editor;
	public static Stage stage;

	private int x = 0;


	public LevelEditor() {
		stage = new Stage();
		wrap = new EditorWrap();
		stage.addActor(wrap);
		editor = this;
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
		
	}

	public EditorWrap getWrap() {
		return wrap;
	}

	public void setWrap(EditorWrap wrap) {
		this.wrap = wrap;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public static LevelEditor getEditor() {
		return editor;
	}

	public static void setEditor(LevelEditor editor) {
		LevelEditor.editor = editor;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	



}
