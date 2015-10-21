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



public class StatsWrap extends Table{
	//Offset Values
	private float titleOffset = 22;



	public StatsWrap() {
		setBounds(0, 0, 800, 480);
		addActor(new Background(getWidth(), getHeight()));


		
	}
	
	
	public void act(float delta) {
		super.act(delta);
	}
	
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		 Assets.futuristicTitle.draw(batch, "[STATS]", 230, getHeight() - titleOffset);
			Assets.futuristicSmall.draw(batch, "Total Play Time: " + Parameters.totalPlayTimeMinutes + "  min", 100, 380);
		Assets.futuristicSmall.draw(batch, "Deaths: " + Parameters.deathsTotal, 100, 360);
		Assets.futuristicSmall.draw(batch, "Deaths from Falling: " + Parameters.deathsFalling, 100, 320);
		Assets.futuristicSmall.draw(batch, "Deaths from Spikes: " + Parameters.deathsSpikes, 100, 280);
		Assets.futuristicSmall.draw(batch, "Deaths from Spike Column: " + Parameters.deathsSpikeColumn, 100, 260);
		Assets.futuristicSmall.draw(batch, "Deaths from Normal Cannon: " + Parameters.deathsCannonNormal, 100, 220);
		Assets.futuristicSmall.draw(batch, "Deaths from Speed Cannon: " + Parameters.deathsCannonFast, 100, 200);
		Assets.futuristicSmall.draw(batch, "Deaths from Big Cannon: " + Parameters.deathsCannonBig, 100, 180);
		Assets.futuristicSmall.draw(batch, "Deaths from Medusa Cannon: " + Parameters.deathsCannonSin, 100, 160);
		Assets.futuristicSmall.draw(batch, "Deaths from Multishot Cannon: " + Parameters.deathsCannonMulti, 100, 140);
		Assets.futuristicSmall.draw(batch, "Deaths from Quadra Cannon: " + Parameters.deathsCannonQuadra, 100, 120);
		Assets.futuristicSmall.draw(batch, "Deaths from Trace Cannon: " + Parameters.deathsCannonTrace, 100, 100);
		Assets.futuristicSmall.draw(batch, "Deaths from Spinner: " + Parameters.deathsSpinner, 100, 80);
		Assets.futuristicSmall.draw(batch, "Deaths from Exiting Game and restarting: " + Parameters.deathsExit, 100, 40);
		 
		 batch.draw(Assets.uiexit, 22, getHeight()-22-50);


	}
	
}
