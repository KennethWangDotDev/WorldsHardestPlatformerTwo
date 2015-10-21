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



public class WorldWrap extends Table{
	//Offset Values
	private float titleOffset = 22;
	private float divider = 55;
	private float buttonWidth = 195;
	private int world = Parameters.worldSelection;

	public int getWorld() {
		return world;
	}


	public void setWorld(int world) {
		this.world = world;
	}


	public WorldWrap() {
		setBounds(0, 0, 800, 480);
		addActor(new Background(getWidth(), getHeight()));
		if (world >= 11) Background.bg.setHell(true);


		
	}
	
	
	public void act(float delta) {
		super.act(delta);
	}
	
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		 Assets.futuristicTitle.draw(batch, "[WORLD]", 230, getHeight() - titleOffset);
		 if (world <= 10) {
			 Assets.futuristicSubtitle.draw(batch, "World  " + world, 330, getHeight() - titleOffset - 100);
		 } else {
			 Assets.futuristicSubtitle.draw(batch, "Hell World  " + (world - 10), 300, getHeight() - titleOffset - 100);
		 }
		 batch.draw(Assets.worldFrames[world], 200, 135);
		 if ((world != 1) && (world != 11)) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.greysliderup);
					batch.draw(temp, 150 - 39, (480/2) - (28/2), 700, (480/2) - (28/2), 42, 28, 1f, 1f, 0, false);
		 }
	
		 
		 
		 if ((world != 10) && (world != 20)) {
			 	if ((Parameters.worldPlayable[world]) || (Parameters.worldPlayable[world+1])){
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.greysliderup);
					batch.draw(temp, 650, (480/2) - (28/2), 700, (480/2) - (28/2), 42, 28, 1f, 1f, 0, true);
				 }
		}
	
		 
		 
		 if (Parameters.worldPlayable[world] == false) {
			 batch.draw(Assets.padlock, (800/2) - (150 / 2), 153, 150, 150);
			 if (world <= 10) {
			 Assets.futuristicSmall.drawMultiLine(batch, "To unlock this world, beat World  " + (world-1) + " level 10, \n             or get over 20 stars on world " + (world-1),  (800/2) - 235, 100);
			 } else {
				 if (world == 11) {
				 Assets.futuristicSmall.drawMultiLine(batch, "To unlock this world, get 30 stars on World 1",  (800/2) - 243, 100);
				 } else {
					 Assets.futuristicSmall.drawMultiLine(batch, "To unlock this world, beat Hell  World  " + (world-11) + " level 10, \n                  or get over 20 stars on hell world " + (world-11) + ",\n                             or get 30 stars on World  " + (world - 10),  (800/2) - 270, 100);
				 }
			 }
		 } else {
			 Assets.futuristicMedium.draw(batch, "[DEATHS: " + Parameters.worldDeaths[world] + "]", 92, 82);
			 batch.draw(Assets.bigStar, 430, 47, 50, 50);
			 Assets.futuristicMedium.draw(batch, Parameters.worldStars[world] + " / 30", 490, 82);
		 }
		 if (world <= 10) {
			 if ((Parameters.worldPlayable[world + 10]) || (world == 1)) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.greysliderup);
					temp.flip(false, true);
					batch.draw(temp, (800/2) - 14, 50, (800/2) - 28, 100, 28, 42, 1f, 1f, 0);	
			 }
		 } else {
				batch.draw(Assets.greysliderup, (800/2) - 14, 380, 28, 42); 
		 }

		 
		 batch.draw(Assets.uiexit, 22, getHeight()-22-50);



	}
	
}
