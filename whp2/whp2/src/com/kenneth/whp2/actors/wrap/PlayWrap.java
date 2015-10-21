package com.kenneth.whp2.actors.wrap;

import java.util.Random;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;
import com.kenneth.whp2.actors.Background;
import com.kenneth.whp2.actors.Tile;
import com.kenneth.whp2.actors.objects.MainCharacter;



public class PlayWrap extends Table{
	//Offset Values
	private float titleOffset = 22;
	private float divider = 55;
	private float buttonWidth = 195;

	public PlayWrap() {
		setBounds(0, 0, 800, 480);
		addActor(new Background(getWidth(), getHeight()));
		Background.bg.setHell(false);


		
	}
	
	
	public void act(float delta) {
		super.act(delta);
	}
	
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		 Assets.futuristicTitle.draw(batch, "[MODE]", 250, getHeight() - titleOffset);
		 
		 batch.draw(Assets.buttonSingle, 50 + 25 + 50, 135);
		 batch.draw(Assets.buttonEditor, 150 + 50 + 20 + buttonWidth + divider, 135);
		 if (Parameters.worldPlayable[4] == false) {
			 batch.draw(Assets.padlock, 150 + 50 + 20 + buttonWidth + divider + 10 + 7+5, 155, 150, 150);
			 Assets.futuristicSmall.drawMultiLine(batch, "Unlock world 4 to\n access the editor", 150 + 50 + 20 + buttonWidth + divider, 120);
		 }

		 
		 batch.draw(Assets.uiexit, 22, getHeight()-22-50);

		 


	}
	
}
