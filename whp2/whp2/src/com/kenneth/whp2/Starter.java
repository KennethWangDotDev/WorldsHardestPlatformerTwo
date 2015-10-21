package com.kenneth.whp2;

import com.badlogic.gdx.Game;
import com.kenneth.whp2.screens.FSScreen;
import com.kenneth.whp2.screens.GameScreen;
import com.kenneth.whp2.screens.LevelEditor;
import com.kenneth.whp2.screens.TitleScreen;


public class Starter extends Game {
	public final static int WIDTH = 800;
	public final static int HEIGHT = 480;
	public static Starter starter;

	@Override
	public void create() {
		starter = this;
		Assets.preload();
		setScreen(new FSScreen());
	}

	@Override
	public void dispose() {
		Assets.dispose();
//		titleScreen.dispose();
	}
}

