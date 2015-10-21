package com.kenneth.whp2.actors.wrap;

import java.util.Random;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;
import com.kenneth.whp2.actors.Background;
import com.kenneth.whp2.actors.Tile;
import com.kenneth.whp2.actors.objects.MainCharacter;



public class ShopWrap extends Table{
	//Offset Values
	private float titleOffset = 22;
	private int[] price = new int[10];
	private float colorValue = 0;
	private boolean colorIncrease = true;
	//Animation
	protected Texture[] animation;
	protected float animationTime;
	protected int currentState = 0;
	protected float stateTime;
	
	public int getSkinSelection() {
		return skinSelection;
	}


	public void setSkinSelection(int skinSelection) {
		this.skinSelection = skinSelection;
	}

	private int skinSelection = Parameters.currentSkin;


	public ShopWrap() {
		setBounds(0, 0, 800, 480);
		addActor(new Background(getWidth(), getHeight()));
		price[0] = 20;
		price[1] = 20;
		price[2] = 20;
		price[3] = 60;
		price[4] = 60;
		price[5] = 60;
		price[6] = 120;
		price[7] = 120;
		price[8] = 120;
		animation = Assets.mainCharacterAnimation;
		animationTime = 0.035f;
		
	}
	
	
	public void act(float delta) {
		super.act(delta);
		System.out.println(Parameters.skins[1]);
		stateTime += delta;
		if (stateTime > animationTime) {
			animate();
			stateTime = 0;
		}
		
		if (colorIncrease) {
			colorValue += 0.01f;
		} else {
			colorValue -= 0.01f;
		}
		
		if (colorValue < 0f) {
			colorValue = 0f;
			colorIncrease = true;
		}
		
		if (colorValue >= 1f) {
			colorValue = 1f;
			colorIncrease = false;
		} 
	}
	
	public void animate() {
		currentState++;
		if (currentState == animation.length) currentState = 0;
	}
	
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		 Assets.futuristicTitle.draw(batch, "[SHOP]", 235, getHeight() - titleOffset);
		 Assets.futuristicSubtitle.draw(batch, "STARS:  " + Parameters.stars, 600, getHeight() - titleOffset);
		 
		 batch.draw(Assets.levelDetailsWindow, 50, 40, 350, 340);
		 batch.draw(Assets.levelDetailsWindow, 445, 210, 325, 160);
		 batch.draw(Assets.levelDetailsWindow, 445, 40, 325, 160);
		 
		 Assets.futuristicSubtitle.draw(batch, "Costumes", 135, 360);
		 batch.draw(Assets.mainCharacterAnimation[currentState], 80, 270, 50, 50);
		 batch.setColor(1f, 0f, 0f, getColor().a);
		 batch.draw(Assets.mainCharacterAnimation[currentState], 200, 270, 50 ,50);
		 if (Parameters.skins[1] == false) {
			 batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
			 batch.draw(Assets.padlock, 230, 250, 40, 40);
		 }
		 batch.setColor(0f, 1f, 0.235f, getColor().a);
		 batch.draw(Assets.mainCharacterAnimation[currentState], 320, 270, 50 ,50);
		 if (Parameters.skins[2] == false) {
			 batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
			 batch.draw(Assets.padlock, 350, 250, 40, 40);
		 }
		 
		 batch.setColor(1f, 0f, 0.9f, getColor().a);
		 batch.draw(Assets.mainCharacterAnimation[currentState], 80, 170, 50, 50);
		 if (Parameters.skins[3] == false) {
			 batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
			 batch.draw(Assets.padlock, 110, 150, 40, 40);
		 }
		 batch.setColor(1f, 1f, 0.6f, getColor().a);
		 batch.draw(Assets.mainCharacterAnimation[currentState], 200, 170, 50 ,50);
		 if (Parameters.skins[4] == false) {
			 batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
			 batch.draw(Assets.padlock, 230, 150, 40, 40);
		 }
		 batch.setColor(1f, 0.5f, 0f, getColor().a);
		 batch.draw(Assets.mainCharacterAnimation[currentState], 320, 170, 50 ,50);
		 if (Parameters.skins[5] == false) {
			 batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
			 batch.draw(Assets.padlock, 350, 150, 40, 40);
		 }
		 
		 
		 batch.setColor(1f, colorValue, colorValue, getColor().a);
		 batch.draw(Assets.mainCharacterAnimation[currentState], 80, 70, 50, 50);
		 if (Parameters.skins[6] == false) {
			 batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
			 batch.draw(Assets.padlock, 110, 50, 40, 40);
		 }
		 batch.setColor(colorValue, 1-colorValue, 1f, getColor().a);
		 batch.draw(Assets.mainCharacterAnimation[currentState], 200, 70, 50 ,50);
		 if (Parameters.skins[7] == false) {
			 batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
			 batch.draw(Assets.padlock, 230, 50, 40, 40);
		 }
		 batch.setColor(1f, 1f, colorValue, getColor().a);
		 batch.draw(Assets.mainCharacterAnimation[currentState], 320, 70, 50 ,50);
		 if (Parameters.skins[8] == false) {
			 batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
			 batch.draw(Assets.padlock, 350, 50, 40, 40);
		 }

		

		 
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		 
		 
		 batch.draw(Assets.uiexit, 22, getHeight()-22-50);
		 
		 if (skinSelection == 0) {
			 batch.draw(Assets.mainCharacterAnimation[currentState], 580, 300, 50, 50);
		 } else if (skinSelection == 1){
			 batch.setColor(1f, 0f, 0f, getColor().a);
			 batch.draw(Assets.mainCharacterAnimation[currentState], 580, 300, 50 ,50);
		 } else if (skinSelection == 2){
			 batch.setColor(0f, 1f, 0.235f, getColor().a);
			 batch.draw(Assets.mainCharacterAnimation[currentState], 580, 300, 50 ,50);
		 } else if (skinSelection == 3) {
			 batch.setColor(1f, 0f, 0.9f, getColor().a);
			 batch.draw(Assets.mainCharacterAnimation[currentState], 580, 300, 50, 50);
		 } else if (skinSelection == 4) {
			 batch.setColor(1f, 1f, 0.6f, getColor().a);
			 batch.draw(Assets.mainCharacterAnimation[currentState], 580, 300, 50 ,50);
		 } else if (skinSelection == 5) {
			 batch.setColor(1f, 0.5f, 0f, getColor().a);
			 batch.draw(Assets.mainCharacterAnimation[currentState], 580, 300, 50 ,50);
		 } else if (skinSelection == 6) {
			 batch.setColor(1f, colorValue, colorValue, getColor().a);
			 batch.draw(Assets.mainCharacterAnimation[currentState], 580, 300, 50, 50);
		 } else if (skinSelection == 7) {
			 batch.setColor(colorValue, 1-colorValue, 1f, getColor().a);
			 batch.draw(Assets.mainCharacterAnimation[currentState], 580, 300, 50 ,50);
		 } else if (skinSelection == 8) {
			 batch.setColor(1f, 1f, colorValue, getColor().a);
			 batch.draw(Assets.mainCharacterAnimation[currentState], 580, 300, 50 ,50);
		 }

		 if (Parameters.currentSkin == skinSelection) {
			 Assets.futuristicSubtitle.draw(batch, "Equipped", 525, 250);
		 } else {
			batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
			 batch.draw(Assets.greybutton, 457, 220, 300, 50);
			 if (Parameters.skins[skinSelection]) {
				 Assets.futuristicSmallBlack.draw(batch, "Equip!", 570, 250);
			 } else {
				 Assets.futuristicSmallBlack.draw(batch, "Buy for " + price[skinSelection] + " stars", 520, 250);
			 }
		 }
	 
			batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);		 	
		 Assets.futuristicSubtitle.draw(batch, "level Skips:  " + Parameters.levelSkips, 485, 175);
		 batch.draw(Assets.greybutton, 457, 80, 300, 50);
		 Assets.futuristicSmallBlack.draw(batch, "Buy 1 more for 15 stars", 483, 110);
	}


	public int[] getPrice() {
		return price;
	}


	public void setPrice(int[] price) {
		this.price = price;
	}
	
}
