package com.kenneth.whp2.actors.wrap;

import java.util.Random;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;
import com.kenneth.whp2.actors.Background;
import com.kenneth.whp2.actors.Tile;
import com.kenneth.whp2.actors.objects.MainCharacter;



public class OptionsWrap extends Table{
	//Offset Values
	private float titleOffset = 22;



	public OptionsWrap() {
		setBounds(0, 0, 800, 480);
		addActor(new Background(getWidth(), getHeight()));


		
	}
	
	
	public void act(float delta) {
		super.act(delta);
	}
	
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		 Assets.futuristicTitle.draw(batch, "[OPTIONS]", 230, getHeight() - titleOffset);
		 String temp = "";
		 if (Parameters.handOrientation == 1) {
			 temp = "right";
		 } else {
			 temp = "left";
		 }
			TextureRegion test = new TextureRegion();
			test.setRegion(Assets.greysliderup);
			if (Parameters.onScreenControls == 1) {
			batch.draw(test, 500, 360 - 24, 500, 360 - 24, 42, 28, 1f, 1f, getRotation(), false);
			batch.draw(test, 500, 300 - 24, 500, 300 - 24, 42, 28, 1f, 1f, getRotation(), false);
	}
			batch.draw(test, 500, 240 - 24, 500, 240 - 24, 42, 28, 1f, 1f, getRotation(), false);
			batch.draw(test, 500, 180 - 24, 500, 180 - 24, 42, 28, 1f, 1f, getRotation(), false);
			if (Parameters.onScreenControls == 1)
			batch.draw(test, 500, 120 - 24, 500, 120 - 24, 42, 28, 1f, 1f, getRotation(), false);
if (Parameters.onScreenControls == 1) {
			batch.draw(test, 750, 360 - 24, 750, 360 - 24, 42, 28, 1f, 1f, getRotation(), true);
			batch.draw(test, 750, 300 - 24, 750, 300 - 24, 42, 28, 1f, 1f, getRotation(), true);
}
			batch.draw(test, 750, 240 - 24, 750, 240 - 24, 42, 28, 1f, 1f, getRotation(), true);
			batch.draw(test, 750, 180 - 24, 750, 180 - 24, 42, 28, 1f, 1f, getRotation(), true);
			if (Parameters.onScreenControls == 1)
			batch.draw(test, 750, 120 - 24, 750, 120 - 24, 42, 28, 1f, 1f, getRotation(), true);
			
			if (Parameters.onScreenControls == 1) {
			
			Assets.futuristicMedium.draw(batch, "LEFT/RIGHT HAND:", 25, 360);
			Assets.futuristicMedium.draw(batch, "     " + temp, 550, 360);
			 if (Parameters.deviceSize == 1) {
				 temp = "NORMAL";
			 } else {
				 temp = "TABLET";
			 }
			Assets.futuristicMedium.draw(batch, "DEVICE SIZE:", 25, 300);
			Assets.futuristicMedium.draw(batch, "  " + temp, 550, 300);
						 if (Parameters.sound == 1) {
				 temp = "ON";
			 } else {
				 temp = "OFF";
			 }
			}
			Assets.futuristicMedium.draw(batch, "Sound effects:", 25, 240);
			Assets.futuristicMedium.draw(batch, "        " + temp, 550, 240);
			 if (Parameters.music == 1) {
				 temp = "ON";
			 } else {
				 temp = "OFF";
			 }
				Assets.futuristicMedium.draw(batch, "MUSIC:", 25, 180);
				Assets.futuristicMedium.draw(batch, "        " + temp, 550, 180);
				
				if (Parameters.onScreenControls == 1) {
				Assets.futuristicMedium.draw(batch, "TRANSPARENCY:", 25, 120);
				Assets.futuristicMedium.draw(batch, "       " + Parameters.transparency + "%", 550, 120);
				}
				batch.draw(Assets.uiexit, 22, getHeight()-22-50);


	}
	
}
