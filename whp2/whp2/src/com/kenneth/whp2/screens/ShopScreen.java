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
import com.kenneth.whp2.actors.wrap.PlayWrap;
import com.kenneth.whp2.actors.wrap.ShopWrap;
import com.kenneth.whp2.actors.wrap.StatsWrap;
import com.kenneth.whp2.actors.wrap.TitleWrap;
import com.kenneth.whp2.actors.wrap.WorldWrap;


public class ShopScreen implements Screen, GestureListener {
	private Stage stage;
	private ShopWrap wrap;


	public ShopScreen() {
		stage = new Stage();
		wrap = new ShopWrap();
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
		
//		 Assets.futuristicSubtitle.draw(batch, "Costumes", 135, 360);
//		 batch.draw(Assets.mainCharacterAnimation[0], 80, 270, 50, 50);
//		 batch.setColor(1f, 0f, 0f, getColor().a);
//		 batch.draw(Assets.mainCharacterAnimation[0], 200, 270, 50 ,50);
//		 batch.setColor(1f, 0f, 0.9f, getColor().a);
//		 batch.draw(Assets.mainCharacterAnimation[0], 320, 270, 50 ,50);
//		 
//		 batch.setColor(0f, 0f, 1f, getColor().a);
//		 batch.draw(Assets.mainCharacterAnimation[0], 80, 170, 50, 50);
//		 batch.setColor(0f, 1f, 0.235f, getColor().a);
//		 batch.draw(Assets.mainCharacterAnimation[0], 200, 170, 50 ,50);
//		 batch.setColor(1f, 0.93f, 0f, getColor().a);
//		 batch.draw(Assets.mainCharacterAnimation[0], 320, 170, 50 ,50);
//		 
//		 batch.setColor(1f, 0.5f, 0f, getColor().a);
//		 batch.draw(Assets.mainCharacterAnimation[0], 80, 70, 50, 50);
//		 batch.setColor(0.5f, 0.5f, 0.5f, getColor().a);
//		 batch.draw(Assets.mainCharacterAnimation[0], 200, 70, 50 ,50);
//		 batch.setColor(0.15f, 0.15f, 0.15f, getColor().a);
//		 batch.draw(Assets.mainCharacterAnimation[0], 320, 70, 50 ,50);
//		 batch.draw(Assets.uiexit, 22, 408);
		 
		 Vector3 temp = new Vector3(x, y, 0);
		 stage.getCamera().unproject(temp);
		 x = temp.x;
		 y = 480 - temp.y;
		 if(button == Buttons.LEFT){
			if (inBounds(x, y, 22, 408+50, 50, 50)) {
					dispose();
					 stage.clear();
					Starter.starter.setScreen(new TitleScreen());
					Parameters.saveWorlds();
			 } else if (inBounds(x, y, 80, 270 + 50, 50, 50)) {
				 wrap.setSkinSelection(0);
			 } else if (inBounds(x, y, 200, 270 + 50, 50, 50)) {
				 wrap.setSkinSelection(1);
			 } else if (inBounds(x, y, 320, 270 + 50, 50, 50)) {
				 wrap.setSkinSelection(2);
			 } else if (inBounds(x, y, 80, 170  + 50, 50, 50)) {
				 wrap.setSkinSelection(3);
			 } else if(inBounds(x, y, 200, 170 + 50, 50, 50)) {
				 wrap.setSkinSelection(4);
			 } else if(inBounds(x, y,  320, 170 + 50, 50, 50)) {
				 wrap.setSkinSelection(5);
			 } else if (inBounds(x, y, 80, 70  + 50, 50, 50)) {
				 wrap.setSkinSelection(6);
			 } else if(inBounds(x, y, 200, 70 + 50, 50, 50)) {
				 wrap.setSkinSelection(7);
			 } else if(inBounds(x, y,  320, 70 + 50, 50, 50)) {
				 wrap.setSkinSelection(8);
			 }  else if (inBounds(x, y, 457, 220 + 50, 300, 50)) {
				 if (Parameters.skins[wrap.getSkinSelection()]) {
					 Parameters.currentSkin = wrap.getSkinSelection();
					 Parameters.saveShop();
				 } else {
					 if (Parameters.stars >= wrap.getPrice()[wrap.getSkinSelection()]) {
						 Parameters.skins[wrap.getSkinSelection()] = true;
						 Parameters.currentSkin = wrap.getSkinSelection();
						 Parameters.stars -= wrap.getPrice()[wrap.getSkinSelection()];
						 Parameters.saveShop();
					 }
				 }
			 } else if (inBounds(x, y, 457, 80 + 50, 300, 50)) {
				 if (Parameters.stars >= 15) {
					 Parameters.stars -= 15;
					 Parameters.levelSkips++;
					 Parameters.saveShop();
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
