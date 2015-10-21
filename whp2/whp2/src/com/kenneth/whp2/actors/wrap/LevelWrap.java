package com.kenneth.whp2.actors.wrap;

import java.util.Random;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;
import com.kenneth.whp2.actors.Background;
import com.kenneth.whp2.actors.Tile;
import com.kenneth.whp2.actors.objects.MainCharacter;
import com.kenneth.whp2.screens.LevelScreen;



public class LevelWrap extends Table{
	private int world;
	
	//Offset Values
	private float titleOffset = 22;
	private float dividerX = 70;
	private float buttonWidth = 60;
	private float starterX = 112;
	
	private boolean details;
	private float yPosition = 490;
	

	public LevelWrap(int world) {
		setBounds(0, 0, 800, 480);
		addActor(new Background(getWidth(), getHeight()));
		this.world = world;
		System.out.println(world);
		System.out.println(Parameters.levelPlayable[world][1]);
		
	}
	
	
	public void act(float delta) {
		super.act(delta);
		if (details) {
			yPosition = yPosition - 80;
			if (yPosition <= 90) {
				yPosition = 90;
			}
		} else {
			yPosition = 490;
		}
	}
	
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		

		if (world <= 10) {
		 Assets.futuristicTitle.draw(batch, "[WORLD  " + world + "]", 210, getHeight() - titleOffset);
		} else {
			 Assets.futuristicTitle.draw(batch, "[HELL WORLD  " + (world - 10) + "]", 100, getHeight() - titleOffset);
		}
		 Texture image;
		 
		 if (Parameters.levelPlayable[world][1]) {
			 image = Assets.characterNoAnimation;
		 } else {
			 image = Assets.tileRegular;
		 }
		 batch.draw(image, starterX, 275, 60, 60);
		 if (Parameters.levelPlayable[world][1]) {
			 Assets.futuristicMedium.draw(batch, "1", starterX + (buttonWidth / 2) - 8, 315);
			 Texture image2;
			 if (Parameters.levelStars[world][1] == 0) {
				 image2 = Assets.noStars;
			 } else if (Parameters.levelStars[world][1] == 1) {
				 image2 = Assets.singleStar;
			 } else if (Parameters.levelStars[world][1] == 2) {
				 image2 = Assets.doubleStars;
			 } else {
				 image2 = Assets.tripleStars;
			 }
			 batch.draw(image2, 112 + 5, 275+50, 47, 30);
		 }
		 batch.draw(Assets.black, starterX + buttonWidth, 275 + 30, dividerX, 5);
		 if (Parameters.levelPlayable[world][2]) {
			 image = Assets.characterNoAnimation;
			 
		 } else {
			 image = Assets.tileRegular;
		 }
		 batch.draw(image, starterX + buttonWidth + dividerX, 275, 60, 60);
		 if (Parameters.levelPlayable[world][2]) {
			 Assets.futuristicMedium.draw(batch, "2", starterX + buttonWidth + dividerX + (buttonWidth / 2) - 10, 315);
			 Texture image2;
			 if (Parameters.levelStars[world][2] == 0) {
				 image2 = Assets.noStars;
			 } else if (Parameters.levelStars[world][2] == 1) {
				 image2 = Assets.singleStar;
			 } else if (Parameters.levelStars[world][2] == 2) {
				 image2 = Assets.doubleStars;
			 } else {
				 image2 = Assets.tripleStars;
			 }
			 batch.draw(image2, 112 + 5 + buttonWidth + dividerX, 275+50, 47, 30);
		 }
		 batch.draw(Assets.black, starterX + buttonWidth + dividerX + buttonWidth, 275 + 30, dividerX, 5);
		 if (Parameters.levelPlayable[world][3]) {
			 image = Assets.characterNoAnimation;
		 } else {
			 image = Assets.tileRegular;
		 }
		 batch.draw(image, starterX + buttonWidth + dividerX + buttonWidth + dividerX, 275, 60, 60);
		 if (Parameters.levelPlayable[world][3]) {
			 Assets.futuristicMedium.draw(batch, "3", starterX + buttonWidth + dividerX + buttonWidth + dividerX + (buttonWidth / 2) - 10, 315);
			 Texture image2;
			 if (Parameters.levelStars[world][3] == 0) {
				 image2 = Assets.noStars;
			 } else if (Parameters.levelStars[world][3] == 1) {
				 image2 = Assets.singleStar;
			 } else if (Parameters.levelStars[world][3] == 2) {
				 image2 = Assets.doubleStars;
			 } else {
				 image2 = Assets.tripleStars;
			 }
			 batch.draw(image2, 112 + 5 + buttonWidth + dividerX + buttonWidth + dividerX, 275+50, 47, 30);
		 }
		 batch.draw(Assets.black, starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth, 275 + 30, dividerX, 5);
		 if (Parameters.levelPlayable[world][4]) {
			 image = Assets.characterNoAnimation;
		 } else {
			 image = Assets.tileRegular;
		 }
		 batch.draw(image, starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX, 275, 60, 60);
		 if (Parameters.levelPlayable[world][4]) {
			 Assets.futuristicMedium.draw(batch, "4", starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX + (buttonWidth / 2) - 10, 315);
			 Texture image2;
			 if (Parameters.levelStars[world][4] == 0) {
				 image2 = Assets.noStars;
			 } else if (Parameters.levelStars[world][4] == 1) {
				 image2 = Assets.singleStar;
			 } else if (Parameters.levelStars[world][4] == 2) {
				 image2 = Assets.doubleStars;
			 } else {
				 image2 = Assets.tripleStars;
			 }
			 batch.draw(image2, 112 + 5 + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX, 275+50, 47, 30);
		 }
		 batch.draw(Assets.black, starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth, 275 + 30, dividerX, 5);
		 if (Parameters.levelPlayable[world][5]) {
			 image = Assets.characterNoAnimation;
		 } else {
			 image = Assets.tileRegular;
		 }
		 batch.draw(image, starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX, 275, 60, 60);
		 if (Parameters.levelPlayable[world][5]) {
			 Assets.futuristicMedium.draw(batch, "5", starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX + (buttonWidth / 2) - 10, 315);
			 Texture image2;
			 if (Parameters.levelStars[world][5] == 0) {
				 image2 = Assets.noStars;
			 } else if (Parameters.levelStars[world][5] == 1) {
				 image2 = Assets.singleStar;
			 } else if (Parameters.levelStars[world][5] == 2) {
				 image2 = Assets.doubleStars;
			 } else {
				 image2 = Assets.tripleStars;
			 }
			 batch.draw(image2, 112 + 5 + buttonWidth + dividerX + buttonWidth + buttonWidth + dividerX + dividerX + buttonWidth + dividerX, 275+50, 47, 30);
		 }
		 batch.draw(Assets.black, starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth, 275 + 30, dividerX, 5);
		 batch.draw(Assets.black, starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX + (buttonWidth / 2), 135, 5, 140);
		 	 	 	 	 
		 if (Parameters.levelPlayable[world][10]) {
			 image = Assets.characterNoAnimation;
		 } else {
			 image = Assets.tileRegular;
		 }
		 batch.draw(image, starterX, 135, 60, 60);
		 if (Parameters.levelPlayable[world][10]) {
			 Assets.futuristicMedium.draw(batch, "10", starterX + (buttonWidth / 2) - 20, 135 + 30 + 10);
			 Texture image2;
			 if (Parameters.levelStars[world][10] == 0) {
				 image2 = Assets.noStars;
			 } else if (Parameters.levelStars[world][10] == 1) {
				 image2 = Assets.singleStar;
			 } else if (Parameters.levelStars[world][10] == 2) {
				 image2 = Assets.doubleStars;
			 } else {
				 image2 = Assets.tripleStars;
			 }
			 batch.draw(image2, 112 + 5, 135+50, 47, 30);
		 }
		 batch.draw(Assets.black, starterX + buttonWidth, 135 + 30, dividerX, 5);
		 if (Parameters.levelPlayable[world][9]) {
			 image = Assets.characterNoAnimation;
		 } else {
			 image = Assets.tileRegular;
		 }
		 batch.draw(image, starterX + buttonWidth + dividerX, 135, 60, 60);
		 if (Parameters.levelPlayable[world][9]) {
			 Assets.futuristicMedium.draw(batch, "9", starterX + dividerX + buttonWidth + (buttonWidth / 2) - 10, 135 + 30 + 10);
			 Texture image2;
			 if (Parameters.levelStars[world][9] == 0) {
				 image2 = Assets.noStars;
			 } else if (Parameters.levelStars[world][9] == 1) {
				 image2 = Assets.singleStar;
			 } else if (Parameters.levelStars[world][9] == 2) {
				 image2 = Assets.doubleStars;
			 } else {
				 image2 = Assets.tripleStars;
			 }
			 batch.draw(image2, 112 + 5 + buttonWidth + dividerX, 135+50, 47, 30);
		 }
		 batch.draw(Assets.black, starterX + buttonWidth + dividerX + buttonWidth, 135 + 30, dividerX, 5);
		 if (Parameters.levelPlayable[world][8]) {
			 image = Assets.characterNoAnimation;
		 } else {
			 image = Assets.tileRegular;
		 }
		 batch.draw(image, starterX + buttonWidth + dividerX + buttonWidth + dividerX, 135, 60, 60);
		 if (Parameters.levelPlayable[world][8]) {
			 Assets.futuristicMedium.draw(batch, "8", starterX + dividerX + buttonWidth + dividerX + buttonWidth + (buttonWidth / 2) - 10, 135 + 30 + 10);
			 Texture image2;
			 if (Parameters.levelStars[world][8] == 0) {
				 image2 = Assets.noStars;
			 } else if (Parameters.levelStars[world][8] == 1) {
				 image2 = Assets.singleStar;
			 } else if (Parameters.levelStars[world][8] == 2) {
				 image2 = Assets.doubleStars;
			 } else {
				 image2 = Assets.tripleStars;
			 }
			 batch.draw(image2, 112 + 5 + buttonWidth + dividerX + buttonWidth + dividerX, 135+50, 47, 30);
		 }
		 batch.draw(Assets.black, starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth, 135 + 30, dividerX, 5);
		 if (Parameters.levelPlayable[world][7]) {
			 image = Assets.characterNoAnimation;
		 } else {
			 image = Assets.tileRegular;
		 }
		 batch.draw(image, starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX, 135, 60, 60);
		 if (Parameters.levelPlayable[world][7]) {
			 Assets.futuristicMedium.draw(batch, "7", starterX + dividerX + buttonWidth + dividerX + buttonWidth + buttonWidth + dividerX + (buttonWidth / 2) - 10, 135 + 30 + 10);
			 Texture image2;
			 if (Parameters.levelStars[world][7] == 0) {
				 image2 = Assets.noStars;
			 } else if (Parameters.levelStars[world][7] == 1) {
				 image2 = Assets.singleStar;
			 } else if (Parameters.levelStars[world][7] == 2) {
				 image2 = Assets.doubleStars;
			 } else {
				 image2 = Assets.tripleStars;
			 }
			 batch.draw(image2, 112 + 5 + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX, 135+50, 47, 30);
		 }
		 batch.draw(Assets.black, starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth, 135 + 30, dividerX, 5);
		 if (Parameters.levelPlayable[world][6]) {
			 image = Assets.characterNoAnimation;
		 } else {
			 image = Assets.tileRegular;
		 }
		 batch.draw(image, starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX, 135, 60, 60);
		 if (Parameters.levelPlayable[world][6]) {
			 Assets.futuristicMedium.draw(batch, "6", starterX + dividerX + buttonWidth + dividerX + buttonWidth + buttonWidth + dividerX + buttonWidth + dividerX + (buttonWidth / 2) - 10, 135 + 30 + 10);
			 Texture image2;
			 if (Parameters.levelStars[world][6] == 0) {
				 image2 = Assets.noStars;
			 } else if (Parameters.levelStars[world][6] == 1) {
				 image2 = Assets.singleStar;
			 } else if (Parameters.levelStars[world][6] == 2) {
				 image2 = Assets.doubleStars;
			 } else {
				 image2 = Assets.tripleStars;
			 }
			 batch.draw(image2, 112 + 5 + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX, 135+50, 47, 30);
		 }
		 batch.draw(Assets.black, starterX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth + dividerX + buttonWidth, 135 + 30, dividerX, 5);
		 
		 
		 batch.draw(Assets.uiexit, 22, getHeight()-22-50); 
		 Assets.futuristicMedium.draw(batch, "[DEATHS: " + Parameters.worldDeaths[world] + "]", 92, 82);
		 batch.draw(Assets.bigStar, 430, 47, 50, 50);
		 Assets.futuristicMedium.draw(batch, Parameters.worldStars[world] + " / 30", 490, 82);
			if (details) {
				batch.draw(Assets.levelDetailsWindow, 201, yPosition, 400, 300);
				batch.draw(Assets.uiplay, 450, yPosition + 80, 125, 125);
				batch.draw(Assets.uiexit, 201 - 20, yPosition + 300 - 30, 40, 40);
				Assets.futuristicSubtitle.draw(batch, "World  " + world + "  Level  " + LevelScreen.ls.getLevel(), 260, yPosition + 280);
				Assets.futuristicSmall.draw(batch, "Precompletion Deaths:", 220, yPosition + 230);
				Assets.futuristicSmall.draw(batch, Integer.toString(Parameters.levelAttempts[world][LevelScreen.ls.getLevel()]), 220, yPosition + 210);
				
				Assets.futuristicSmall.draw(batch, "Total Deaths:", 220, yPosition + 170);
				Assets.futuristicSmall.draw(batch, Integer.toString(Parameters.levelDeaths[world][LevelScreen.ls.getLevel()]), 220, yPosition + 150);
				
				Assets.futuristicSmall.draw(batch, "Fastest Time:", 220, yPosition + 50);
				Assets.futuristicSmall.draw(batch, String.format("%.2f", Parameters.levelFastestTime[world][LevelScreen.ls.getLevel()])+ "  s", 220, yPosition + 30);
				
				float timeLimit = 0;
					FileHandle file;
					file = Gdx.files.internal("levels/world" + world + "level" + LevelScreen.ls.getLevel() + ".txt");
					String map = file.readString();
					Scanner kb = new Scanner(map);
					
					Scanner line = new Scanner(kb.nextLine());
					line.next();
					line.next();
					line.next();
					String backgroundScroll = line.next();
					
					kb.nextLine();
					line = new Scanner(kb.nextLine());
					line.next();
					line.next();
					timeLimit = Float.valueOf(line.next());
				
				
				Assets.futuristicSmall.draw(batch, "Target Time:", 220, yPosition + 110);
				Assets.futuristicSmall.draw(batch, String.format("%.2f", timeLimit) + "  s", 220, yPosition + 90);
				
				if (LevelScreen.ls.getLevel() != 10) {
				if (Parameters.levelPlayable[world][LevelScreen.ls.getLevel() + 1] == false) {
					batch.draw(Assets.greybutton, 270, yPosition - 85, 250, 70);
					Assets.futuristicSmallBlack.draw(batch, "Level Skips: " + Parameters.levelSkips, 323, yPosition - 95 + 60);
					Assets.futuristicSmallBlack.draw(batch, "Unlock next level!", 285, yPosition - 95 + 45);
				}
				} else if ((LevelScreen.ls.getLevel() == 10) && (Parameters.worldPlayable[LevelScreen.ls.getWorld() + 1] == false)) {
					batch.draw(Assets.greybutton, 270, yPosition - 85, 250, 70);
					Assets.futuristicSmallBlack.draw(batch, "Level Skips: " + Parameters.levelSkips, 323, yPosition - 95 + 60);
					Assets.futuristicSmallBlack.draw(batch, "Unlock next level!", 285, yPosition - 95 + 45);
				}
			}
	}


	public boolean isDetails() {
		return details;
	}


	public void setDetails(boolean details) {
		this.details = details;
	}
	
}
