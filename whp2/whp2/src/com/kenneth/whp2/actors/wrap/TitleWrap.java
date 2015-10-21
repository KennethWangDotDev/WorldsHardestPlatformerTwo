package com.kenneth.whp2.actors.wrap;

import java.util.Random;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.actors.Background;
import com.kenneth.whp2.actors.Tile;
import com.kenneth.whp2.actors.objects.MainCharacter;



public class TitleWrap extends Table{
	//Offset Values
	private float titleOffset = 22;
	private float divider = 60;
	private float buttonOffset = 22;
	private float fontSizeHeight = 55;
	private float buttonSize = 40;
	private String version = "updated 4.30.14";

	public TitleWrap() {
		setBounds(0, 0, 800, 480);
		addActor(new Background(getWidth(), getHeight()));


		
	}
	
	
	public void act(float delta) {
		super.act(delta);
		Tile.updateScreenTiles();
	}
	
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		 batch.draw(Assets.titleDecorate, 800 - 624 + 4, 0 , 624 + 100, 249);
		 Assets.futuristicTitle.draw(batch, "[WHP2]", titleOffset, getHeight() - titleOffset);
		 
		 batch.draw(Assets.uiplay, titleOffset, getHeight() - (titleOffset + divider + fontSizeHeight ) , 40, 40);
		 Assets.futuristicSubtitle.draw(batch, "Play", titleOffset + buttonSize + buttonOffset, getHeight() - (divider + fontSizeHeight - 7));
		 
		 batch.draw(Assets.uistats, titleOffset, getHeight() - (titleOffset + divider + fontSizeHeight + buttonOffset+ buttonSize) , 40, 40);
		 Assets.futuristicSubtitle.draw(batch, "Stats", titleOffset + buttonSize + buttonOffset, getHeight() - (divider + divider + fontSizeHeight - 5));
		 
		 batch.draw(Assets.uishop, titleOffset, getHeight() - (titleOffset + divider + fontSizeHeight + buttonOffset + buttonOffset+ buttonSize+ buttonSize) , 40, 40);
		 Assets.futuristicSubtitle.draw(batch, "Shop", titleOffset + buttonSize + buttonOffset, getHeight() - (divider + divider + divider + fontSizeHeight - 3));
		 
		 batch.draw(Assets.uioptions, titleOffset, getHeight() - (titleOffset + divider + fontSizeHeight + buttonOffset + buttonOffset + buttonOffset+ buttonSize+ buttonSize+ buttonSize) , 40, 40);
		 Assets.futuristicSubtitle.draw(batch, "Options", titleOffset + buttonSize + buttonOffset, getHeight() - (divider + divider+divider + divider + fontSizeHeight - 1));
		 
		 batch.draw(Assets.uiexit, titleOffset, getHeight() - (titleOffset + divider + fontSizeHeight + buttonOffset + buttonOffset + buttonOffset + buttonOffset+ buttonSize+ buttonSize+ buttonSize+ buttonSize) , 40, 40);
		 Assets.futuristicSubtitle.draw(batch, "Exit", titleOffset + buttonSize + buttonOffset, getHeight() - (divider + divider + divider+ divider + divider + fontSizeHeight + 1));
		 
		 Assets.futuristicSmall.draw(batch,  version, 0, 10);

	}
	
}
