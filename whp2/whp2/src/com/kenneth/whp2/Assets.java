package com.kenneth.whp2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Assets {
	public static Texture black; 
	public static Texture fslogo, titleDecorate, buttonEditor, buttonMulti, buttonSingle, levelDetailsWindow, padlock, noStars, singleStar, doubleStars, tripleStars, star, bigStar;
	public static Texture[] worldFrames;
	public static Texture[] mainCharacterAnimation;
	public static Texture background, door, flagDown, flagUp, characterNoAnimation, spikeColumn;
	public static Texture tileRegular, tileDroppable, tileFast, tileNullifier, tileSlow, tileIce, tileInvisible, tileWalkway;
	public static Texture cannonYellow, cannonVariety, cannonSpeed, cannonNormal, cannonDeadly, cannonQuadra, cannonTrace, bullet, bulletBig, bulletBlack, bulletBigBlack, cannonSpinner;
	public static Texture editorCannon, editorObject, editorSave, editorStart, editorTile, editorEraser, moverUp, editorPlay;
	public static Texture[] starAnimation;
	
	public static Texture tileSpike; 
	public static Texture[] powerUpDouble, powerUpReverse;
	public static Texture[] gateKey;
	public static Texture gateHorizontal, gateVertical;

	public static int currentState = 0;
	public static BitmapFont futuristicTitle = new BitmapFont();
	public static BitmapFont futuristicSubtitle = new BitmapFont();
	public static BitmapFont futuristicSmall = new BitmapFont();
	public static BitmapFont futuristicSmallBlack = new BitmapFont();
	public static BitmapFont futuristicMedium = new BitmapFont();
	public static Texture greybox, greyboxcheck, greybutton, greysliderup, onScreenJoystick, onScreenJump, uiexit, uioptions, uipause, uiplay, uisave, uishop, uimenu, uiretry, uisoundoff, uisoundon, uimusicon, uimusicoff, uistats, normalLeft, normalRight, normalJump, tabletLeft, tabletRight, tabletJump;
	
	public static Sound coin, jump, shoot, victory;
	public static Music[] songs;
	
	public static int musicIndex = 0 + (int)(Math.random() * ((4 - 0) + 1));
	public static Music currentMusic;
	
	
	
	public static void preload() {
		Texture.setEnforcePotImages(false);
		fslogo = new Texture(Gdx.files.internal("textures/Fortune's Solace 16-9.png"));
	}
	
	public static void manageMusic() {
		if (currentMusic.isPlaying() == false) {
			musicIndex++;
			if (musicIndex >= songs.length) {
				musicIndex = 0;
			}
			currentMusic = songs[musicIndex];
			if (Parameters.music == 1)
			currentMusic.play();
			currentMusic.setVolume(0.68f);
		}
	}
	
	public static void load() {
		Parameters.load();
		coin = Gdx.audio.newSound(Gdx.files.internal("sounds/coin.wav"));
		jump = Gdx.audio.newSound(Gdx.files.internal("sounds/jump.wav"));
		shoot = Gdx.audio.newSound(Gdx.files.internal("sounds/shoot.wav"));
		victory = Gdx.audio.newSound(Gdx.files.internal("sounds/victory.wav"));
		songs = new Music[5];
		songs[0] = Gdx.audio.newMusic(Gdx.files.internal("sounds/song1.mp3"));
		songs[1] = Gdx.audio.newMusic(Gdx.files.internal("sounds/song2.mp3"));
		songs[2] = Gdx.audio.newMusic(Gdx.files.internal("sounds/song3.mp3"));
		songs[3] = Gdx.audio.newMusic(Gdx.files.internal("sounds/song4.mp3"));
		songs[4] = Gdx.audio.newMusic(Gdx.files.internal("sounds/song5.mp3"));
		currentMusic = songs[musicIndex];
		
		spikeColumn = new Texture(Gdx.files.internal("textures/spikeColumn.png"));
		black = new Texture(Gdx.files.internal("textures/black.png")); 
		levelDetailsWindow = new Texture(Gdx.files.internal("textures/levelDetailsWindow.png")); 
		padlock = new Texture(Gdx.files.internal("textures/padlock.png"));
		noStars = new Texture(Gdx.files.internal("textures/stars/noStars.png"));
		singleStar = new Texture(Gdx.files.internal("textures/stars/singleStar.png"));
		doubleStars = new Texture(Gdx.files.internal("textures/stars/doubleStars.png"));
		tripleStars = new Texture(Gdx.files.internal("textures/stars/tripleStars.png"));
		star = new Texture(Gdx.files.internal("textures/stars/star.png"));
		bigStar = new Texture(Gdx.files.internal("textures/stars/starBig.png"));
		titleDecorate = new Texture(Gdx.files.internal("textures/titleDecorate.png")); 
		buttonSingle = new Texture(Gdx.files.internal("textures/ui/button_singleplayer.png")); 
		buttonMulti = new Texture(Gdx.files.internal("textures/ui/button_multiplayer.png")); 
		buttonEditor = new Texture(Gdx.files.internal("textures/ui/button_editor.png")); 
		
		worldFrames = new Texture[21];
		for (int i = 1; i <= 10; i++) {
			worldFrames[i] = new Texture(Gdx.files.internal("textures/worldframes/world" + i + "Frame.png"));
		}
		for (int i = 11; i <= 20; i++) {
			worldFrames[i] = new Texture(Gdx.files.internal("textures/worldframes/world" + (i - 10) + "Frame.png"));
		}
		
		mainCharacterAnimation = new Texture[7];
		mainCharacterAnimation[0] = new Texture(Gdx.files.internal("textures/mainCharacter/character1.png")); 
		mainCharacterAnimation[1] = new Texture(Gdx.files.internal("textures/mainCharacter/character2.png")); 
		mainCharacterAnimation[2] = new Texture(Gdx.files.internal("textures/mainCharacter/character3.png")); 
		mainCharacterAnimation[3] = new Texture(Gdx.files.internal("textures/mainCharacter/character4.png")); 
		mainCharacterAnimation[4] = new Texture(Gdx.files.internal("textures/mainCharacter/character5.png")); 
		mainCharacterAnimation[5] = new Texture(Gdx.files.internal("textures/mainCharacter/character6.png")); 
		mainCharacterAnimation[6] = new Texture(Gdx.files.internal("textures/mainCharacter/character7.png")); 
		characterNoAnimation = new Texture(Gdx.files.internal("textures/mainCharacter/characterNoAnimation.png")); 
		
		door = new Texture(Gdx.files.internal("textures/door.png"));
		flagDown = new Texture(Gdx.files.internal("textures/flagDown.png"));
		flagUp = new Texture(Gdx.files.internal("textures/flag.png"));
		
		tileRegular = new Texture(Gdx.files.internal("textures/tiles/tileRegular.png"));
		tileSlow = new Texture(Gdx.files.internal("textures/tiles/tileSlow.png"));
		tileNullifier = new Texture(Gdx.files.internal("textures/tiles/tileNullifier.png"));
		tileFast = new Texture(Gdx.files.internal("textures/tiles/tileFast.png"));
		tileDroppable = new Texture(Gdx.files.internal("textures/tiles/tileDroppable.png"));
		tileIce = new Texture(Gdx.files.internal("textures/tiles/tileIce.png"));
		tileSpike = new Texture(Gdx.files.internal("textures/tiles/tileSpikeUp.png"));
		tileInvisible = new Texture(Gdx.files.internal("textures/tiles/tileInvisible.png"));
		tileWalkway = new Texture(Gdx.files.internal("textures/tiles/tileWalkway.png"));
		
		powerUpDouble = new Texture[1];
		powerUpReverse = new Texture[1];
		powerUpDouble[0] = new Texture(Gdx.files.internal("textures/objects/powerupDoubleJump.png"));
		powerUpReverse[0] = new Texture(Gdx.files.internal("textures/objects/powerupReverseGravity.png"));

		gateKey = new Texture[1];
		gateKey[0] =  new Texture(Gdx.files.internal("textures/objects/key.png"));
		gateVertical =  new Texture(Gdx.files.internal("textures/objects/gateVertical.png"));
		gateHorizontal =  new Texture(Gdx.files.internal("textures/objects/gateHorizontal.png"));
		
		bullet = new Texture(Gdx.files.internal("textures/bullet.png"));
		bulletBig = new Texture(Gdx.files.internal("textures/bulletBig.png"));
		bulletBlack = new Texture(Gdx.files.internal("textures/bulletBlack.png"));
		bulletBigBlack = new Texture(Gdx.files.internal("textures/bulletBigBlack.png"));
		cannonDeadly = new Texture(Gdx.files.internal("textures/cannons/cannonDeadly.png"));
		cannonNormal = new Texture(Gdx.files.internal("textures/cannons/cannonNormal.png"));
		cannonSpeed = new Texture(Gdx.files.internal("textures/cannons/cannonSpeed.png"));
		cannonVariety = new Texture(Gdx.files.internal("textures/cannons/cannonVariety.png"));
		cannonYellow = new Texture(Gdx.files.internal("textures/cannons/cannonYellow.png"));
		cannonQuadra = new Texture(Gdx.files.internal("textures/cannons/cannonQuadra.png"));
		cannonTrace = new Texture(Gdx.files.internal("textures/cannons/cannonTrace.png"));
		cannonSpinner = new Texture(Gdx.files.internal("textures/cannons/cannonSpinner.png"));
	
		background = new Texture(Gdx.files.internal("textures/grayOverlay.png"));
		
		editorCannon = new Texture(Gdx.files.internal("textures/editor/editor_cannon.png"));
		editorObject = new Texture(Gdx.files.internal("textures/editor/editor_object.png"));
		editorSave = new Texture(Gdx.files.internal("textures/editor/editor_save.png"));
		editorStart = new Texture(Gdx.files.internal("textures/editor/editor_start.png"));
		editorTile = new Texture(Gdx.files.internal("textures/editor/editor_tile.png"));
		editorEraser = new Texture(Gdx.files.internal("textures/editor/editor_eraser.png"));
		editorPlay = new Texture(Gdx.files.internal("textures/editor/editor_play.png"));
		
		normalLeft = new Texture(Gdx.files.internal("textures/ui/normalLeft.png"));
		normalRight = new Texture(Gdx.files.internal("textures/ui/normalRight.png"));
		normalJump = new Texture(Gdx.files.internal("textures/ui/normalJump.png"));
		tabletLeft = new Texture(Gdx.files.internal("textures/ui/tabletLeft.png"));
		tabletRight = new Texture(Gdx.files.internal("textures/ui/tabletRight.png"));
		tabletJump = new Texture(Gdx.files.internal("textures/ui/tabletJump.png"));
		
		moverUp = new Texture(Gdx.files.internal("textures/tiles/moverUp.png"));
		
		starAnimation = new Texture[1];
		starAnimation[0] = new Texture(Gdx.files.internal("textures/stars/star.png"));
		
		FileHandle fontFile = Gdx.files.internal("kenvector_future.ttf");
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 64;
        parameter.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk/lm'nopqrstu.,vwx%yz[]01234!56789: ";
        futuristicTitle = generator.generateFont(parameter);
        generator.dispose();
        futuristicTitle.setColor(1, 1, 1, 1); 
//        
		FileHandle fontFile1 = Gdx.files.internal("kenvector_future.ttf");
		FreeTypeFontGenerator generator1 = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontParameter parameter1 = new FreeTypeFontParameter();
        parameter1.size = 25;
        parameter1.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklm/nopq.%r,'stuvwxyz[]012345!6789: ";
        futuristicSubtitle = generator1.generateFont(parameter1);
        generator1.dispose();
        futuristicSubtitle.setColor(1, 1, 1, 1); 
//        
		FileHandle fontFile2 = Gdx.files.internal("kenvector_future.ttf");
		FreeTypeFontGenerator generator2 = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontParameter parameter2 = new FreeTypeFontParameter();
        parameter2.size = 35;
        parameter2.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZab/cdefghijklm.nopqrs't%uvw,xyz[]012345!6789: ";
        futuristicMedium = generator2.generateFont(parameter2);
        generator2.dispose();
        futuristicMedium.setColor(1, 1, 1, 1); 
        
		FileHandle fontFile3 = Gdx.files.internal("kenvector_future.ttf");
		FreeTypeFontGenerator generator3 = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontParameter parameter3 = new FreeTypeFontParameter();
        parameter3.size = 16;
        parameter3.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefgh/ijklm.nopq'rstuvw,!x%yz[]0123456789: ";
        futuristicSmall = generator3.generateFont(parameter3);
        futuristicSmallBlack = generator3.generateFont(parameter3);
        generator3.dispose();
        futuristicSmall.setColor(1, 1, 1, 1); 
        futuristicSmallBlack.setColor(0, 0, 0, 1); 
        
     
		greybox = new Texture(Gdx.files.internal("textures/ui/grey_box.png")); 
		greyboxcheck = new Texture(Gdx.files.internal("textures/ui/grey_boxCheckmark.png")); 
		greybutton = new Texture(Gdx.files.internal("textures/ui/grey_button.png")); 
		greysliderup = new Texture(Gdx.files.internal("textures/ui/grey_sliderUp.png")); 
		onScreenJoystick = new Texture(Gdx.files.internal("textures/ui/onScreenJoystick.png")); 
		onScreenJump = new Texture(Gdx.files.internal("textures/ui/onScreenJump.png")); 
		uiexit = new Texture(Gdx.files.internal("textures/ui/ui_exit.png")); 
		uioptions = new Texture(Gdx.files.internal("textures/ui/ui_options.png")); 
		uipause = new Texture(Gdx.files.internal("textures/ui/ui_pause.png")); 
		uiplay = new Texture(Gdx.files.internal("textures/ui/ui_play.png")); 
		uisave = new Texture(Gdx.files.internal("textures/ui/ui_save.png")); 
		uishop = new Texture(Gdx.files.internal("textures/ui/ui_shop.png")); 
		uisoundoff = new Texture(Gdx.files.internal("textures/ui/ui_soundOff.png")); 
		uisoundon = new Texture(Gdx.files.internal("textures/ui/ui_soundOn.png")); 
		uimusicoff = new Texture(Gdx.files.internal("textures/ui/ui_musicOff.png")); 
		uimusicon = new Texture(Gdx.files.internal("textures/ui/ui_musicOn.png")); 
		uishop = new Texture(Gdx.files.internal("textures/ui/ui_shop.png")); 
		uistats = new Texture(Gdx.files.internal("textures/ui/ui_stats.png")); 
		uimenu = new Texture(Gdx.files.internal("textures/ui/ui_menu.png")); 
		uiretry = new Texture(Gdx.files.internal("textures/ui/ui_retry.png")); 

		
		
	}

	public static void dispose() {
//		atlas.dispose();
	}
	

}
