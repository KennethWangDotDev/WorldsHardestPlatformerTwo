package com.kenneth.whp2.actors.leveleditor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenneth.whp2.Assets;


public class Icons extends Actor {
	private int menu = 0;


	
	public Icons() {
		setWidth(50);
		setHeight(50);
		setPosition(800-64 + 7, 0);

	}
	
	public void act(float delta) {

	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		
		if (menu == 0) {

			setWidth(50);
			setHeight(50);
			batch.draw(Assets.editorSave, getX(), getY() + 7, getWidth(), getHeight());
			batch.draw(Assets.editorEraser, getX(), getY() + 77, getWidth(), getHeight());
			batch.draw(Assets.editorObject, getX(), getY() + 147, getWidth(), getHeight());
			batch.draw(Assets.editorCannon, getX(), getY() + 217, getWidth(), getHeight());
			batch.draw(Assets.editorTile, getX(), getY() + 287, getWidth(), getHeight());
			batch.draw(Assets.editorStart, getX(), getY() + 357, getWidth(), getHeight());
			batch.draw(Assets.editorPlay, getX(), getY() + 427, getWidth(), getHeight());
		} else if (menu == 1) {

			setWidth(32);
			setHeight(32);
			batch.draw(Assets.uiexit, getX() + 8, getY() + 440, getWidth(), getHeight());
			batch.draw(Assets.mainCharacterAnimation[0], getX() + 8, getY() + 398, getWidth(), getHeight());
			setHeight(64);
			batch.draw(Assets.flagUp, getX() + 8, getY() + 324, getWidth(), getHeight());
			setWidth(64);
			setHeight(96);
			batch.draw(Assets.door, getX(), getY() + 208, getWidth(), getHeight());

		} else if (menu == 2)  {

			setWidth(32);
			setHeight(32);
			batch.draw(Assets.uiexit, getX() + 8, getY() + 440, getWidth(), getHeight());
			batch.draw(Assets.tileRegular, getX() + 8, getY() + 398, getWidth(), getHeight());
			batch.draw(Assets.tileNullifier, getX() + 8, getY() + 356, getWidth(), getHeight());
			batch.draw(Assets.tileFast, getX() + 8, getY() + 314, getWidth(), getHeight());
			batch.draw(Assets.tileSlow, getX() + 8, getY() + 272, getWidth(), getHeight());
			batch.draw(Assets.tileIce, getX() + 8, getY() + 230, getWidth(), getHeight());
			batch.draw(Assets.tileDroppable, getX() + 8, getY() + 188, getWidth(), getHeight());
			TextureRegion temp = new TextureRegion();
			temp.setRegion(Assets.tileWalkway);
			batch.draw(temp, getX() +8, getY() + 146, 0, 0, getWidth(), getHeight(), 1f, 1f, 0, false);	
			batch.draw(Assets.tileSpike, getX() + 8, getY() + 104, getWidth(), getHeight());
			batch.draw(Assets.moverUp, getX() + 8, getY() + 62, getWidth(), getHeight());
			Assets.futuristicSmall.draw(batch, "[Str]", getX() + 5, getY() + 40);
		} else if (menu == 21) {
			batch.draw(Assets.uiexit, getX() + 8, getY() + 440, getWidth(), getHeight());
			
			TextureRegion test = new TextureRegion();
			test.setRegion(Assets.tileSpike);
			batch.draw(test, getX() + 8, getY() + 398, (getX() + 8)/2, (getY() + 398)/2, getWidth(), getHeight(), 1f, 1f, 0);
			batch.draw(test, getX() + 8, getY() + 356, (getX() + 8)/2, (getY() + 356)/2, getWidth(), getHeight(), 1f, 1f, 0, true);		
			batch.draw(test, getX() + 8, getY() + 314, (getX() + 8)/2, (getY() + 314)/2, getWidth(), getHeight(), 1f, 1f, 0, false);
			test.flip(false, true);
			batch.draw(test, getX() + 8, getY() + 272, (getX() + 8)/2, (getY() + 272)/2, getWidth(), getHeight(), 1f, 1f, 0);
		}  else if (menu == 22) {
			batch.draw(Assets.uiexit, getX() + 8, getY() + 440, getWidth(), getHeight());
			
			TextureRegion test = new TextureRegion();
			test.setRegion(Assets.moverUp);
			batch.draw(test, getX() + 8, getY() + 398, (getX() + 8)/2, (getY() + 398)/2, getWidth(), getHeight(), 1f, 1f, 0);
			batch.draw(test, getX() + 8, getY() + 356, (getX() + 8)/2, (getY() + 356)/2, getWidth(), getHeight(), 1f, 1f, 0, true);		
			batch.draw(test, getX() + 8, getY() + 314, (getX() + 8)/2, (getY() + 314)/2, getWidth(), getHeight(), 1f, 1f, 0, false);
			test.flip(false, true);
			batch.draw(test, getX() + 8, getY() + 272, (getX() + 8)/2, (getY() + 272)/2, getWidth(), getHeight(), 1f, 1f, 0);
		
		} else if (menu == 23) {
			batch.draw(Assets.uiexit, getX() + 8, getY() + 440, getWidth(), getHeight());
			TextureRegion temp = new TextureRegion();
			temp.setRegion(Assets.tileWalkway);
			batch.draw(temp, getX() +8, getY() + 398, 0, 0, getWidth(), getHeight(), 1f, 1f, 0, false);	
			batch.draw(temp, getX() +8, getY() + 356, 0, 0, getWidth(), getHeight(), 1f, 1f, 0, true);	
			
		} else if (menu == 3) {

			setWidth(32);
			setHeight(32);
			batch.draw(Assets.uiexit, getX() + 8, getY() + 440, getWidth(), getHeight());
			batch.draw(Assets.cannonNormal, getX() + 8, getY() + 398, getWidth(), getHeight());
			batch.draw(Assets.cannonSpeed, getX() + 8, getY() + 356, getWidth(), getHeight());
			batch.draw(Assets.cannonYellow, getX() + 8, getY() + 314, getWidth(), getHeight());
			batch.draw(Assets.cannonDeadly, getX() + 8, getY() + 272, getWidth(), getHeight());
			batch.draw(Assets.cannonVariety, getX() + 8, getY() + 230, getWidth(), getHeight());
			batch.draw(Assets.cannonQuadra, getX() + 8, getY() + 188, getWidth(), getHeight());
			batch.draw(Assets.cannonTrace, getX() + 8, getY() + 146, getWidth(), getHeight());
			batch.draw(Assets.cannonSpinner, getX() + 8, getY() + 104, getWidth(), getHeight());
			
		} else if (menu == 31) {
			setWidth(32);
			setHeight(32);
			batch.draw(Assets.uiexit, getX() + 8, getY() + 440, getWidth(), getHeight());
			TextureRegion test = new TextureRegion();
			test.setRegion(Assets.cannonNormal);
			batch.draw(test, getX() + 8, getY() + 398, (getX() + 8)/2, (getY() + 398)/2, getWidth(), getHeight(), 1f, 1f, 0);
			batch.draw(test, getX() + 8, getY() + 356, (getX() + 8)/2, (getY() + 356)/2, getWidth(), getHeight(), 1f, 1f, 0, true);		
			batch.draw(test, getX() + 8, getY() + 314, (getX() + 8)/2, (getY() + 314)/2, getWidth(), getHeight(), 1f, 1f, 0, false);
			test.flip(false, true);
			batch.draw(test, getX() + 8, getY() + 272, (getX() + 8)/2, (getY() + 272)/2, getWidth(), getHeight(), 1f, 1f, 0);
		} else if (menu == 32) {
			setWidth(32);
			setHeight(32);
			batch.draw(Assets.uiexit, getX() + 8, getY() + 440, getWidth(), getHeight());
			TextureRegion test = new TextureRegion();
			test.setRegion(Assets.cannonSpeed);
			batch.draw(test, getX() + 8, getY() + 398, (getX() + 8)/2, (getY() + 398)/2, getWidth(), getHeight(), 1f, 1f, 0);
			batch.draw(test, getX() + 8, getY() + 356, (getX() + 8)/2, (getY() + 356)/2, getWidth(), getHeight(), 1f, 1f, 0, true);		
			batch.draw(test, getX() + 8, getY() + 314, (getX() + 8)/2, (getY() + 314)/2, getWidth(), getHeight(), 1f, 1f, 0, false);
			test.flip(false, true);
			batch.draw(test, getX() + 8, getY() + 272, (getX() + 8)/2, (getY() + 272)/2, getWidth(), getHeight(), 1f, 1f, 0);
		} else if (menu == 33) {
			setWidth(32);
			setHeight(32);
			batch.draw(Assets.uiexit, getX() + 8, getY() + 440, getWidth(), getHeight());
			TextureRegion test = new TextureRegion();
			test.setRegion(Assets.cannonYellow);
			batch.draw(test, getX() + 8, getY() + 398, (getX() + 8)/2, (getY() + 398)/2, getWidth(), getHeight(), 1f, 1f, 0);
			batch.draw(test, getX() + 8, getY() + 356, (getX() + 8)/2, (getY() + 356)/2, getWidth(), getHeight(), 1f, 1f, 0, true);		
			batch.draw(test, getX() + 8, getY() + 314, (getX() + 8)/2, (getY() + 314)/2, getWidth(), getHeight(), 1f, 1f, 0, false);
			test.flip(false, true);
			batch.draw(test, getX() + 8, getY() + 272, (getX() + 8)/2, (getY() + 272)/2, getWidth(), getHeight(), 1f, 1f, 0);
		} else if (menu == 34) {
			setWidth(32);
			setHeight(32);
			batch.draw(Assets.uiexit, getX() + 8, getY() + 440, getWidth(), getHeight());
			TextureRegion test = new TextureRegion();
			test.setRegion(Assets.cannonDeadly);
			batch.draw(test, getX() + 8, getY() + 398, (getX() + 8)/2, (getY() + 398)/2, getWidth(), getHeight(), 1f, 1f, 0);
			batch.draw(test, getX() + 8, getY() + 356, (getX() + 8)/2, (getY() + 356)/2, getWidth(), getHeight(), 1f, 1f, 0, true);		
			batch.draw(test, getX() + 8, getY() + 314, (getX() + 8)/2, (getY() + 314)/2, getWidth(), getHeight(), 1f, 1f, 0, false);
			test.flip(false, true);
			batch.draw(test, getX() + 8, getY() + 272, (getX() + 8)/2, (getY() + 272)/2, getWidth(), getHeight(), 1f, 1f, 0);
		} else if (menu == 35) {
			setWidth(32);
			setHeight(32);
			batch.draw(Assets.uiexit, getX() + 8, getY() + 440, getWidth(), getHeight());
			TextureRegion test = new TextureRegion();
			test.setRegion(Assets.cannonVariety);
			batch.draw(test, getX() + 8, getY() + 398, (getX() + 8)/2, (getY() + 398)/2, getWidth(), getHeight(), 1f, 1f, 0);
			batch.draw(test, getX() + 8, getY() + 356, (getX() + 8)/2, (getY() + 356)/2, getWidth(), getHeight(), 1f, 1f, 0, true);		
			batch.draw(test, getX() + 8, getY() + 314, (getX() + 8)/2, (getY() + 314)/2, getWidth(), getHeight(), 1f, 1f, 0, false);
			test.flip(false, true);
			batch.draw(test, getX() + 8, getY() + 272, (getX() + 8)/2, (getY() + 272)/2, getWidth(), getHeight(), 1f, 1f, 0);
			
		} else if (menu == 4) {

			setWidth(32);
			setHeight(32);
			batch.draw(Assets.uiexit, getX() + 8, getY() + 440, getWidth(), getHeight());
			batch.draw(Assets.starAnimation[0], getX() + 8, getY() + 398, getWidth(), getHeight());
			batch.draw(Assets.powerUpDouble[0], getX() + 8, getY() + 356, getWidth(), getHeight());
			batch.draw(Assets.powerUpReverse[0], getX() + 8, getY() + 314, getWidth(), getHeight());
			batch.draw(Assets.gateKey[0], getX() + 8, getY() + 272, getWidth(), getHeight());
			batch.draw(Assets.gateHorizontal, getX() + 8, getY() + 230, getWidth(), getHeight());
			batch.draw(Assets.gateVertical, getX() + 8, getY() + 188, getWidth(), getHeight());
		}
			
		
	}

	public int getMenu() {
		return menu;
	}

	public void setMenu(int menu) {
		this.menu = menu;
	}


}
