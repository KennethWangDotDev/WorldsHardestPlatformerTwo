package com.kenneth.whp2.actors.wrap;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.Parameters;
import com.kenneth.whp2.Starter;
import com.kenneth.whp2.actors.Background;
import com.kenneth.whp2.actors.Cannon;
import com.kenneth.whp2.actors.StringTile;
import com.kenneth.whp2.actors.Tile;
import com.kenneth.whp2.actors.leveleditor.BlackOverlay;
import com.kenneth.whp2.actors.leveleditor.Helper;
import com.kenneth.whp2.actors.leveleditor.Icons;
import com.kenneth.whp2.actors.leveleditor.MyTextInputListener;
import com.kenneth.whp2.actors.leveleditor.OrangeLinesHorizontal;
import com.kenneth.whp2.actors.leveleditor.OrangeLinesVertical;
import com.kenneth.whp2.actors.leveleditor.PointerLeft;
import com.kenneth.whp2.actors.leveleditor.PointerRight;
import com.kenneth.whp2.actors.objects.Coin;
import com.kenneth.whp2.actors.objects.DoubleJump;
import com.kenneth.whp2.actors.objects.MainCharacter;
import com.kenneth.whp2.actors.objects.ReverseGravity;
import com.kenneth.whp2.screens.FSScreen;
import com.kenneth.whp2.screens.GameScreen;
import com.kenneth.whp2.screens.LevelEditor;
import com.kenneth.whp2.screens.LevelScreen;
import com.kenneth.whp2.screens.PlayScreen;


public class EditorWrap extends Table implements GestureListener, TextInputListener{
	private Group background = new Group();
	private Group foreground = new Group();
	private Icons icons = new Icons();
	private PointerRight pointerRight = new PointerRight();
	private PointerLeft pointerLeft = new PointerLeft();
	private String selection;
	private ArrayList<Helper> whatToDraw = new ArrayList<Helper>();
	private int scrolledAmount;
	private int state = 0;
	private float timeLimit;
	private int levelType;
	private Pixmap pix = new Pixmap(102, 62, Pixmap.Format.RGBA8888);
	int page = 1;
	ArrayList<String> strList = new ArrayList<String>();

	public EditorWrap() {
		Gdx.input.setInputProcessor(new GestureDetector(this));
		setBounds(0, 0, 800, 480);
		addActor(background);
		addActor(foreground);
		background.addActor(new Background(getWidth(), getHeight()));

		
		setWidth(32);
		setHeight(32);
		
	}
	
	
	public void act(float delta) {
		super.act(delta);
	}
	
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		if (state == 1) {

		
		if (scrolledAmount > 0) {
			pointerLeft.setShow(true);
		} else {
			pointerLeft.setShow(false);
		}
		
		for (Helper h: whatToDraw) {
			if (h.getX() - scrolledAmount < (800 - 64)) {
			
				if (h.getType().equals("character")) {
					batch.draw(Assets.mainCharacterAnimation[0], h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("tileNormal")) {
					batch.draw(Assets.tileRegular, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("tileNullifier")) {
					batch.draw(Assets.tileNullifier, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("tileSpeed")) {
					batch.draw(Assets.tileFast, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("tileSlow")) {
					batch.draw(Assets.tileSlow, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("tileIce")) {
					batch.draw(Assets.tileIce, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("tileDroppable")) {
					batch.draw(Assets.tileDroppable, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("cannonNormalUp")) {
					batch.draw(Assets.cannonNormal, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("cannonNormalRight")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonNormal);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, true);	
				} else if (h.getType().equals("cannonNormalLeft")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonNormal);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, false);	
				} else if (h.getType().equals("cannonNormalDown")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonNormal);
					temp.flip(false, true);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0);	
				} else if (h.getType().equals("cannonFastUp")) {
					batch.draw(Assets.cannonSpeed, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("cannonFastRight")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonSpeed);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, true);	
				} else if (h.getType().equals("cannonFastLeft")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonSpeed);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, false);	
				} else if (h.getType().equals("cannonFastDown")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonSpeed);
					temp.flip(false, true);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0);	
				} else if (h.getType().equals("cannonSinUp")) {
					batch.draw(Assets.cannonYellow, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("cannonSinRight")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonYellow);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, true);	
				} else if (h.getType().equals("cannonSinLeft")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonYellow);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, false);	
				} else if (h.getType().equals("cannonSinDown")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonYellow);
					temp.flip(false, true);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0);	
				} else if (h.getType().equals("cannonBigUp")) {
					batch.draw(Assets.cannonDeadly, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("cannonBigRight")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonDeadly);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, true);	
				} else if (h.getType().equals("cannonBigLeft")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonDeadly);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, false);	
				} else if (h.getType().equals("cannonBigDown")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonDeadly);
					temp.flip(false, true);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0);	
				} else if (h.getType().equals("cannonMultiUp")) {
					batch.draw(Assets.cannonVariety, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("cannonMultiRight")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonVariety);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, true);	
				} else if (h.getType().equals("cannonMultiLeft")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonVariety);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, false);	
				} else if (h.getType().equals("cannonMultiDown")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.cannonVariety);
					temp.flip(false, true);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0);	
				} else if (h.getType().equals("tileSpikeUp")) {
					batch.draw(Assets.tileSpike, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("tileSpikeRight")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.tileSpike);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, true);	
				} else if (h.getType().equals("tileSpikeLeft")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.tileSpike);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, false);	
				} else if (h.getType().equals("tileSpikeDown")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.tileSpike);
					temp.flip(false, true);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0);	
				} else if (h.getType().equals("gateKey")) {
					batch.draw(Assets.gateKey[0], h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("gateHorizontal")) {
					batch.draw(Assets.gateHorizontal, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("gateVertical")) {
					batch.draw(Assets.gateVertical, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("powerupJump")) {
					batch.draw(Assets.powerUpDouble[0], h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("powerupGravity")) {
					batch.draw(Assets.powerUpReverse[0], h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("coin")) {
					batch.draw(Assets.starAnimation[0], h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("flag")) {
					batch.draw(Assets.flagUp, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("door")) {
					batch.draw(Assets.door, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("cannonQuadra")) {
					batch.draw(Assets.cannonQuadra, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("cannonTrace")) {
					batch.draw(Assets.cannonTrace, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("string")) {
					Assets.futuristicSmall.drawMultiLine(batch, h.getParameter().get(0),  h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("tileWalkwayLeft")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.tileWalkway);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, false);	
				} else if (h.getType().equals("tileWalkwayRight")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.tileWalkway);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, true);	
				} else if (h.getType().equals("moverUp")) {
					batch.draw(Assets.tileSpike, h.getX() - scrolledAmount, h.getY());
				} else if (h.getType().equals("moverRight")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.moverUp);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, true);	
				} else if (h.getType().equals("moverLeft")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.moverUp);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0, false);	
				} else if (h.getType().equals("moverDown")) {
					TextureRegion temp = new TextureRegion();
					temp.setRegion(Assets.moverUp);
					temp.flip(false, true);
					batch.draw(temp, h.getX() - scrolledAmount, h.getY(), 0, 0, getWidth(), getHeight(), 1f, 1f, 0);	
				} else if (h.getType().contains("Spinner")) {
					batch.draw(Assets.cannonSpinner, h.getX() - scrolledAmount, h.getY());
				}
			}
		}
		
		} else if (state == 0){
			batch.draw(Assets.background, 0, 0, 800, 480);
			Assets.futuristicMedium.draw(batch, "New", 200, 240);
			Assets.futuristicMedium.draw(batch, "Load", 550, 240);
		}  else if (state == 2) {
			batch.draw(Assets.black, 0, 400, 1000, 2);
			batch.draw(Assets.black, 0, 330, 1000, 2);
			batch.draw(Assets.black, 0, 260, 1000, 2);
			batch.draw(Assets.black, 0, 190, 1000, 2);
			batch.draw(Assets.black, 0, 120, 1000, 2);
			batch.draw(Assets.black, 0, 50, 1000, 2);
			FileHandle[] files = Gdx.files.local("editor/").list();
			strList.clear();
			for(FileHandle file: files) {
			   if (file.extension().equals("txt")) {
				   if (file.name().equals("testGamePlay1337.txt") == false)
				   strList.add(file.nameWithoutExtension());
			   }
			}
			
			if (strList.size() - 1 >= 0 + ((page - 1) * 5)) {
				Assets.futuristicSmall.draw(batch, (1 + ((page - 1) * 5)) + ".  " + strList.get(0 + ((page - 1) * 5)), 170, 375);
				batch.draw(Assets.uiexit, 750, 355, 32, 32);
				FileHandle f2 = Gdx.files.local("editor/" + strList.get(0 + ((page - 1) * 5)) + ".png");
				if (f2.exists()) {
					Texture t = new Texture(Gdx.files.local(f2.path()));
					batch.draw(t, 10, 335);
					
				}
				
			}
			if (strList.size() - 1 >= 1 + ((page - 1) * 5)) {
				Assets.futuristicSmall.draw(batch, (2 + ((page - 1) * 5)) + ".  " + strList.get(1 + ((page - 1) * 5)), 170, 300);
				batch.draw(Assets.uiexit, 750, 280, 32, 32);
				FileHandle f2 = Gdx.files.local("editor/" + strList.get(1 + ((page - 1) * 5)) + ".png");
				if (f2.exists()) {
					Texture t = new Texture(Gdx.files.local(f2.path()));
					batch.draw(t, 10, 265);
					
				}
			}
			if (strList.size() - 1 >= 2 + ((page - 1) * 5)) {
				Assets.futuristicSmall.draw(batch, (3 + ((page - 1) * 5)) + ".  " + strList.get(2 + ((page - 1) * 5)), 170, 230);
				batch.draw(Assets.uiexit, 750, 210, 32, 32);
				FileHandle f2 = Gdx.files.local("editor/" + strList.get(2 + ((page - 1) * 5)) + ".png");
				if (f2.exists()) {
					Texture t = new Texture(Gdx.files.local(f2.path()));
					batch.draw(t, 10, 195);
					
				}
			}
			if (strList.size() - 1 >= 3 + ((page - 1) * 5)) {
				Assets.futuristicSmall.draw(batch, (4 + ((page - 1) * 5)) + ".  " + strList.get(3 + ((page - 1) * 5)), 170, 160);
				batch.draw(Assets.uiexit, 750, 140, 32, 32);
				FileHandle f2 = Gdx.files.local("editor/" + strList.get(3 + ((page - 1) * 5)) + ".png");
				if (f2.exists()) {
					Texture t = new Texture(Gdx.files.local(f2.path()));
					batch.draw(t, 10, 125);
					
				}
			}
			if (strList.size() - 1 >= 4 + ((page - 1) * 5)) {
				Assets.futuristicSmall.draw(batch, (5 + ((page - 1) * 5)) + ".  " + strList.get(4 + ((page - 1) * 5)), 170, 90);
				batch.draw(Assets.uiexit, 750, 70, 32, 32);
				FileHandle f2 = Gdx.files.local("editor/" + strList.get(4 + ((page - 1) * 5)) + ".png");
				if (f2.exists()) {
					Texture t = new Texture(Gdx.files.local(f2.path()));
					batch.draw(t, 10, 55);
					
				}
			}
			
			if (strList.size() - 1 >= 5 + ((page - 1) * 5)) {
				Assets.futuristicMedium.draw(batch, "[MORE]", 320, 30);
			}
			
			if (page >= 2) {
				Assets.futuristicMedium.draw(batch, "[PREV]", 320, 450);
			}
		}
		batch.draw(Assets.uiexit, 22, 408);

	}

	public void load(String s) {
		Gdx.input.setInputProcessor(new GestureDetector(this));
		whatToDraw.clear();
		FileHandle file = Gdx.files.local(s);
		String map = file.readString();
		System.out.println(map);
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
		
		line = new Scanner(kb.nextLine());
		line.next();
		line.next();
		levelType = Integer.valueOf(line.next());
		for (int i = 24; i >= 0; i--) {
			line = new Scanner(kb.nextLine());
			line.useDelimiter("/");
			float xIndex = 0;
			while (line.hasNext()) {
				String temp = line.next();
				if (temp.contains("string")) {
				Scanner test = new Scanner(temp);
				test.useDelimiter("-");
				String firstPart = test.next();
				Helper h = new Helper(firstPart, xIndex * 32, i * 32);
				h.getParameter().add(test.next());
				whatToDraw.add(h);
				} else {
					whatToDraw.add(new Helper(temp, xIndex * 32, i*32));
				}

				xIndex++;
			}

		}
		
		state = 1;
	}

	public Icons getIcons() {
		return icons;
	}


	public void setIcons(Icons icons) {
		this.icons = icons;
	}

	
	public void inputProcessor() {
		Gdx.input.setInputProcessor(new GestureDetector(this));
	}
	
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean inBounds(float mouseX, float mouseY, int objectX, int objectY, int objectWidth, int objectHeight) {
		if ((mouseX >= objectX) && (mouseX <= objectX + objectWidth)) {
			if ((mouseY >= objectY) && (mouseY <= objectY + objectHeight)) {
				return true;
			}
		}
	return false;
	}
	
	public float customFloor(float value, float roundTo) {
	    return (float)Math.floor(value / roundTo) * roundTo;
	}
	
	@Override 
	public boolean tap(float x, float y, int count, int button) throws ConcurrentModificationException{
		float xc = x;
		float yc = y;
		 Vector3 temp = new Vector3(xc, yc, 0);
		 LevelEditor.stage.getCamera().unproject(temp);
		 xc = temp.x;
		 yc = temp.y;
		 System.out.println(xc + " " + yc);
		if (inBounds(xc, yc, 22, 408, 32, 32)) {
			LevelEditor.editor.getStage().clear();
			Starter.starter.setScreen(new PlayScreen());
			return false;
		}
		if (state == 1) {
		 if((button == Buttons.LEFT) && (count >= 0)){
				 if (inBounds(xc, yc, 800-64 - (42), 480/2 - (28 / 2), 42, 28)) {	
					 scrolledAmount += 32;
					 return false;
				 }
				 if (pointerLeft.isShow()) {
			if (inBounds(xc, yc, 0, 480/2 - (28 / 2), 42, 28)) {	
				 scrolledAmount -= 32;
				 return false;
			}
				 }
				 
			
			 
			 
			 if (selection != null) {
				 if (inBounds(xc, yc, 0, 0, 736, 480)) {
					 float xc1 = customFloor(xc, 32);
					 float yc1 = customFloor(yc, 32);
					 
					 if (selection.equals("eraser")) {
						for (Helper h: whatToDraw) {
							if ((h.getX() == xc1+ scrolledAmount) && (h.getY() == yc1)) {
								whatToDraw.remove(h);

								break;
							}
						}
					 } else 
					 
					 if (selection.equals("string")) {
						 MyTextInputListener listener = new MyTextInputListener();
						 MyTextInputListener.mode = 5;
						 MyTextInputListener.x = xc1;
						 MyTextInputListener.y = yc1;
						 Gdx.input.getTextInput(listener, "What to write?", "Text");
					 } else if (selection.contains("Spinner")) {
						 MyTextInputListener listener = new MyTextInputListener();
						 MyTextInputListener.mode = 6;
						 MyTextInputListener.x = xc1;
						 MyTextInputListener.y = yc1;
						 Gdx.input.getTextInput(listener, "Spinner Length (between 1 to 9)", "5");
						 
					 }else if (selection.equals("character")) {
						for (Helper h: whatToDraw) {
							if (h.getType().equals("character")) {
								whatToDraw.remove(h);
								break;
							}
						}
					 }
					 
					 if ((!(selection.equals("eraser"))) && (!(selection.equals("string")) && (!(selection.contains("Spinner"))))){
						 whatToDraw.add(new Helper(selection, scrolledAmount + xc1, yc1));
					
					 }
					 
				 }
			 }
			 if (getIcons().getMenu() == 0) {
				 if (inBounds(xc, yc, 740, 430, 50, 50)) {
					 timeLimit = timeLimit;
					 levelType = levelType;
					 save("editor/testGamePlay1337.txt");
					 Starter.starter.setScreen(new GameScreen("testGamePlay1337"));
					 GameScreen.gs.getWrap().setTestMode(true);
				 }
				 
				 if (inBounds(xc, yc, 740,  360, 50, 50)) {
					 getIcons().setMenu(1);
					 return false;
				 } else if (inBounds(xc, yc, 740, 290, 50, 50)) {
					 getIcons().setMenu(2);
					 return false;
				 } else if (inBounds(xc, yc, 740, 220, 50, 50)) {
					 getIcons().setMenu(3);
					 return false;
				 } else if (inBounds(xc, yc, 740, 150, 50, 50)) {
					 getIcons().setMenu(4);
					 return false;
				 } else if (inBounds(xc, yc, 740, 80, 50, 50)) {
					 selection = "eraser";
					 return false;
				 } else if (inBounds(xc, yc, 740, 10, 50, 50)) {
					 MyTextInputListener listener = new MyTextInputListener();
					 MyTextInputListener.mode = 2;
					 Gdx.input.getTextInput(listener, "File Name?", ".txt");
					 return false;
				 }
			 }
			 
			 if (getIcons().getMenu() == 1) {
				 
				 if (inBounds(xc, yc, 740, 440, 32, 32)) {
					 getIcons().setMenu(0);
				 } else if (inBounds(xc, yc, 740, 398, 32, 32)) {
					 selection = "character";
				 } else if (inBounds(xc, yc, 740, 324, 32, 64)) {
					 selection = "flag";
				 } else if (inBounds(xc, yc, 740, 208, 64, 96)) {
					selection = "door";
				 }
			 }
			 
			 if (getIcons().getMenu() == 2) {
				 
				 if (inBounds(xc, yc,740, 440 , 32, 32)) {
					 getIcons().setMenu(0);
				 } else if (inBounds(xc, yc,740, 398 , 32, 32)) {
					 selection = "tileNormal";
				 }else if (inBounds(xc, yc,740, 356 , 32, 32)) {
					 selection = "tileNullifier";
				 }else if (inBounds(xc, yc,740, 314 , 32, 32)) {
					 selection = "tileSpeed";
				 }else if (inBounds(xc, yc,740, 272 , 32, 32)) {
					 selection = "tileSlow";
				 }else if (inBounds(xc, yc,740, 230 , 32, 32)) {
					 selection = "tileIce";
				 }else if (inBounds(xc, yc,740, 188 , 32, 32)) {
					 selection = "tileDroppable";
				 }else if (inBounds(xc, yc, 740, 146, 32, 32)) {
						getIcons().setMenu(23);
				 } else if (inBounds(xc, yc, 740, 104, 32, 32)) {
					 getIcons().setMenu(21);
				 } else if (inBounds(xc, yc, 740, 62, 32, 32)) {
					 getIcons().setMenu(22);
				 }  else if (inBounds(xc, yc, 740, 20, 32, 32)) {
					 selection = "string";
				 }
			 }
			 
			 if (getIcons().getMenu() == 21) {
				 if (inBounds(xc, yc,740, 440 , 32, 32)) {
					 getIcons().setMenu(2);
				 } else if (inBounds(xc, yc,740, 398 , 32, 32)) {
					 selection = "tileSpikeUp";
				 }else if (inBounds(xc, yc,740, 356 , 32, 32)) {
					 selection = "tileSpikeRight";
				 }else if (inBounds(xc, yc,740, 314 , 32, 32)) {
					 selection = "tileSpikeLeft";
				 }else if (inBounds(xc, yc,740, 272 , 32, 32)) {
					 selection = "tileSpikeDown";
				 }
			 }
			 
			 if (getIcons().getMenu() == 22) {
				 if (inBounds(xc, yc,740, 440 , 32, 32)) {
					 getIcons().setMenu(2);
				 } else if (inBounds(xc, yc,740, 398 , 32, 32)) {
					 selection = "moverUp";
				 }else if (inBounds(xc, yc,740, 356 , 32, 32)) {
					 selection = "moverRight";
				 }else if (inBounds(xc, yc,740, 314 , 32, 32)) {
					 selection = "moverLeft";
				 }else if (inBounds(xc, yc,740, 272 , 32, 32)) {
					 selection = "moverDown";
				 }
			 }
			 
			 if (getIcons().getMenu() == 23) {
				 if (inBounds(xc, yc,740, 440 , 32, 32)) {
					 getIcons().setMenu(2);
				 } else if (inBounds(xc, yc,740, 398 , 32, 32)) {
					 selection = "tileWalkwayLeft";
				 }else if (inBounds(xc, yc,740, 356 , 32, 32)) {
					 selection = "tileWalkwayRight";
				 }
			 }
			 
			 if (getIcons().getMenu() == 3) {
				 
				 if (inBounds(xc, yc,740, 440 , 32, 32)) {
					 getIcons().setMenu(0);
				 } else if (inBounds(xc, yc,740, 398 , 32, 32)) {
					 getIcons().setMenu(31);
				 }else if (inBounds(xc, yc,740, 356 , 32, 32)) {
					 getIcons().setMenu(32);
				 }else if (inBounds(xc, yc,740, 314 , 32, 32)) {
					 getIcons().setMenu(33);
				 }else if (inBounds(xc, yc,740, 272 , 32, 32)) {
					 getIcons().setMenu(34);
				 }else if (inBounds(xc, yc,740, 230 , 32, 32)) {
					 getIcons().setMenu(35);
				 } else if (inBounds(xc, yc,740, 188 , 32, 32)) {
					 selection = "cannonQuadra";
				 } else if (inBounds(xc, yc,740, 146, 32, 32)) {
					 selection = "cannonTrace";
				 } else if (inBounds(xc, yc, 740, 104, 32 ,32)) {
					 selection = "cannonSpinner";
				 }
			 }
			 
			 if (getIcons().getMenu() == 31) {
				 if (inBounds(xc, yc,740, 440 , 32, 32)) {
					 getIcons().setMenu(3);
				 } else if (inBounds(xc, yc,740, 398 , 32, 32)) {
					 selection = "cannonNormalUp";
				 }else if (inBounds(xc, yc,740, 356 , 32, 32)) {
					 selection = "cannonNormalRight";
				 }else if (inBounds(xc, yc,740, 314 , 32, 32)) {
					 selection = "cannonNormalLeft";
				 }else if (inBounds(xc, yc,740, 272 , 32, 32)) {
					 selection = "cannonNormalDown";
				 }
			 }
			 
			 if (getIcons().getMenu() == 32) {
				 if (inBounds(xc, yc,740, 440 , 32, 32)) {
					 getIcons().setMenu(3);
				 } else if (inBounds(xc, yc,740, 398 , 32, 32)) {
					 selection = "cannonFastUp";
				 }else if (inBounds(xc, yc,740, 356 , 32, 32)) {
					 selection = "cannonFastRight";
				 }else if (inBounds(xc, yc,740, 314 , 32, 32)) {
					 selection = "cannonFastLeft";
				 }else if (inBounds(xc, yc,740, 272 , 32, 32)) {
					 selection = "cannonFastDown";
				 }
			 }
			 
			 if (getIcons().getMenu() == 33) {
				 if (inBounds(xc, yc,740, 440 , 32, 32)) {
					 getIcons().setMenu(3);
				 } else if (inBounds(xc, yc,740, 398 , 32, 32)) {
					 selection = "cannonSinUp";
				 }else if (inBounds(xc, yc,740, 356 , 32, 32)) {
					 selection = "cannonSinRight";
				 }else if (inBounds(xc, yc,740, 314 , 32, 32)) {
					 selection = "cannonSinLeft";
				 }else if (inBounds(xc, yc,740, 272 , 32, 32)) {
					 selection = "cannonSinDown";
				 }
			 }
			 
			 if (getIcons().getMenu() == 34) {
				 if (inBounds(xc, yc,740, 440 , 32, 32)) {
					 getIcons().setMenu(3);
				 } else if (inBounds(xc, yc,740, 398 , 32, 32)) {
					 selection = "cannonBigUp";
				 }else if (inBounds(xc, yc,740, 356 , 32, 32)) {
					 selection = "cannonBigRight";
				 }else if (inBounds(xc, yc,740, 314 , 32, 32)) {
					 selection = "cannonBigLeft";
				 }else if (inBounds(xc, yc,740, 272 , 32, 32)) {
					 selection = "cannonBigDown";
				 }
			 }
			 
			 if (getIcons().getMenu() == 35) {
				 if (inBounds(xc, yc,740, 440 , 32, 32)) {
					 getIcons().setMenu(3);
				 } else if (inBounds(xc, yc,740, 398 , 32, 32)) {
					 selection = "cannonMultiUp";
				 }else if (inBounds(xc, yc,740, 356 , 32, 32)) {
					 selection = "cannonMultiRight";
				 }else if (inBounds(xc, yc,740, 314 , 32, 32)) {
					 selection = "cannonMultiLeft";
				 }else if (inBounds(xc, yc,740, 272 , 32, 32)) {
					 selection = "cannonMultiDown";
				 }
			 }
			 
			 if (getIcons().getMenu() == 4) {
				 
				 if (inBounds(xc, yc,740, 440 , 32, 32)) {
					 getIcons().setMenu(0);
				 } else if (inBounds(xc, yc,740, 398 , 32, 32)) {
					 selection = "coin";
				 }else if (inBounds(xc, yc,740, 356 , 32, 32)) {
					 selection = "powerupJump";
				 }else if (inBounds(xc, yc,740, 314 , 32, 32)) {
					 selection = "powerupGravity";
				 }else if (inBounds(xc, yc,740, 272 , 32, 32)) {
					 selection = "gateKey";
				 }else if (inBounds(xc, yc,740, 230 , 32, 32)) {
					 selection = "gateHorizontal";
				 }else if (inBounds(xc, yc, 740, 188, 32, 32)) {
					 selection = "gateVertical";
				 }
			 }

	     }
		} else if (state == 0){
			 if (inBounds(xc, yc,200, 240 - 50 , 100, 100)) {
				 foreground.addActor(new BlackOverlay());
				 foreground.addActor(new OrangeLinesHorizontal());
				 foreground.addActor(new OrangeLinesVertical());
				 foreground.addActor(icons);
				 foreground.addActor(pointerRight);
				 foreground.addActor(pointerLeft);
				 state = 1;
			 } else if (inBounds(xc, yc, 550, 240 - 50, 100, 100)) {
				 System.out.println("TEST");
				 //LOAD SCREEN
//				 MyTextInputListener listener = new MyTextInputListener();
//				 MyTextInputListener.mode = 1;
//				 Gdx.input.getTextInput(listener, "File Name?", ".txt");
				 state = 2;
			 }
		} else if (state == 2) {
//			batch.draw(Assets.black, 0, 400, 1000, 2);
//			batch.draw(Assets.black, 0, 330, 1000, 2);
//			batch.draw(Assets.black, 0, 260, 1000, 2);
//			batch.draw(Assets.black, 0, 190, 1000, 2);
//			batch.draw(Assets.black, 0, 120, 1000, 2);
//			batch.draw(Assets.black, 0, 50, 1000, 2);
			if (strList.size() - 1 >= 0 + ((page - 1) * 5)) {
				if (inBounds(xc, yc, 0, 330, 700, 70)) {
					state = 1;
					 foreground.addActor(new BlackOverlay());
					 foreground.addActor(new OrangeLinesHorizontal());
					 foreground.addActor(new OrangeLinesVertical());
					 foreground.addActor(icons);
					 foreground.addActor(pointerRight);
					 foreground.addActor(pointerLeft);
					load("editor/" + strList.get(0 + ((page - 1) * 5)) + ".txt");
				} else if (inBounds(xc, yc, 730, 330, 70, 70)) {
					FileHandle file = Gdx.files.local("editor/" + strList.get(0 + ((page - 1) * 5)) + ".txt");
					if (file.exists())
					file.delete();
					file = Gdx.files.local("editor/" + strList.get(0 + ((page - 1) * 5)) + ".png");
					if (file.exists())
					file.delete();
					strList.remove(0 + ((page - 1) * 5));	
					System.out.println("test");
				}
			}
			if (strList.size() - 1 >= 1 + ((page - 1) * 5)) {
				if (inBounds(xc, yc, 0, 260, 700, 70)) {
					state = 1;
					 foreground.addActor(new BlackOverlay());
					 foreground.addActor(new OrangeLinesHorizontal());
					 foreground.addActor(new OrangeLinesVertical());
					 foreground.addActor(icons);
					 foreground.addActor(pointerRight);
					 foreground.addActor(pointerLeft);
					load("editor/" + strList.get(1 + ((page - 1) * 5)) + ".txt");
				} else if (inBounds(xc, yc, 730, 260, 70, 70)) {
					FileHandle file = Gdx.files.local("editor/" + strList.get(1 + ((page - 1) * 5)) + ".txt");
					if (file.exists())
					file.delete();
					file = Gdx.files.local("editor/" + strList.get(1 + ((page - 1) * 5)) + ".png");
					if (file.exists())
					file.delete();
					strList.remove(1 + ((page - 1) * 5));	
				}
			}
			if (strList.size() - 1 >= 2 + ((page - 1) * 5)) {
				if (inBounds(xc, yc, 0, 190, 700, 70)) {
					state = 1;
					 foreground.addActor(new BlackOverlay());
					 foreground.addActor(new OrangeLinesHorizontal());
					 foreground.addActor(new OrangeLinesVertical());
					 foreground.addActor(icons);
					 foreground.addActor(pointerRight);
					 foreground.addActor(pointerLeft);
					load("editor/" + strList.get(2 + ((page - 1) * 5)) + ".txt");
				} else if (inBounds(xc, yc, 730, 190, 70, 70)) {
					FileHandle file = Gdx.files.local("editor/" + strList.get(2 + ((page - 1) * 5)) + ".txt");
					if (file.exists())
					file.delete();
					file = Gdx.files.local("editor/" + strList.get(2 + ((page - 1) * 5)) + ".png");
					if (file.exists())
					file.delete();
					strList.remove(2 + ((page - 1) * 5));	
				}
			}
			if (strList.size() - 1 >= 3 + ((page - 1) * 5)) {
				if (inBounds(xc, yc, 0, 120, 700, 70)) {
					state = 1;
					 foreground.addActor(new BlackOverlay());
					 foreground.addActor(new OrangeLinesHorizontal());
					 foreground.addActor(new OrangeLinesVertical());
					 foreground.addActor(icons);
					 foreground.addActor(pointerRight);
					 foreground.addActor(pointerLeft);
					load("editor/" + strList.get(3 + ((page - 1) * 5)) + ".txt");
				} else if (inBounds(xc, yc, 730, 120, 70, 70)) {
					FileHandle file = Gdx.files.local("editor/" + strList.get(3 + ((page - 1) * 5)) + ".txt");
					if (file.exists())
					file.delete();
					file = Gdx.files.local("editor/" + strList.get(3 + ((page - 1) * 5)) + ".png");
					if (file.exists())
					file.delete();
					strList.remove(3 + ((page - 1) * 5));	
				}
			}
			if (strList.size() - 1 >= 4 + ((page - 1) * 5)) {
				if (inBounds(xc, yc, 0, 50, 700, 70)) {
					state = 1;
					 foreground.addActor(new BlackOverlay());
					 foreground.addActor(new OrangeLinesHorizontal());
					 foreground.addActor(new OrangeLinesVertical());
					 foreground.addActor(icons);
					 foreground.addActor(pointerRight);
					 foreground.addActor(pointerLeft);
					load("editor/" + strList.get(4 + ((page - 1) * 5)) + ".txt");
				} else if (inBounds(xc, yc, 730, 50, 70, 70)) {
					FileHandle file = Gdx.files.local("editor/" + strList.get(4 + ((page - 1) * 5)) + ".txt");
					if (file.exists())
					file.delete();
					file = Gdx.files.local("editor/" + strList.get(4 + ((page - 1) * 5)) + ".png");
					if (file.exists())
					file.delete();
					strList.remove(4 + ((page - 1) * 5));	
				}
			}
			
			if (strList.size() - 1 >= 5 + ((page - 1) * 5)) {
				if (inBounds(xc, yc, 0, 0, 1000, 80)) {
					page++;
				}
			}
			
			if (page >= 2) {
				if (inBounds(xc, yc, 0, 400, 1000, 80)) {
					page--;
				}
			}
		}
		
		return false;
	}


	public void save(String s) {
		float maxLength = 0;
		float characterLocation = 0;
		int tileCount = 0;
		for (Helper h: whatToDraw) {
			tileCount++;
			if (h.getType().equals("character")) {
				characterLocation = h.getX();
				if (characterLocation > 352) {
					characterLocation = characterLocation - (352);
				} else {
					characterLocation = 0;
				}
			}
			if (h.getX() > maxLength) {
				maxLength = h.getX();
			}
		}
		
		String map = "";
		map += "Character Starting Coordinates: " + characterLocation + "\n";
		map += "Tile Count: " + tileCount + "\n";
		map += "Time Limit: " + timeLimit + "\n";
		map += "Level Type: " + levelType + "\n";

		for (int i = 768; i >= 0; i = i - 32) {
			for (int j = 0; j <= maxLength; j = j + 32) {
				String temp = " /";
				for (Helper h: whatToDraw) {
					if ((h.getX() == j) && (h.getY() == i)) {
						temp = "";
						temp += h.getType();
						for (int k = 0; k < h.getParameter().size(); k++) {
							temp += "-";
							temp += h.getParameter().get(k);
						}
						temp += "/";
					}
				}
				map += temp;
			}
			map += "\n";
		}
		System.out.println(map);
		FileHandle file = Gdx.files.local(s);
		file.writeString(map, false);
        pix.setColor(Color.LIGHT_GRAY);
		pix.fill();
		float doorX = 0;
		float doorY = 0;

		for (Helper h : whatToDraw) {
		 if (h.getX() <= 798) {
			 if (h.getType().equals("character")) {
			     pix.setColor(Color.CYAN);
				} else if (h.getType().equals("tileNormal")) {
				     pix.setColor(Color.DARK_GRAY);
				} else if (h.getType().equals("tileNullifier")) {
				     pix.setColor(Color.GRAY);
				} else if (h.getType().equals("tileSpeed")) {
				     pix.setColor(Color.GREEN);
				} else if (h.getType().equals("tileSlow")) {
				     pix.setColor(Color.RED);
				} else if (h.getType().equals("tileIce")) {
				     pix.setColor(Color.BLUE);
				} else if (h.getType().equals("tileDroppable")) {
				     pix.setColor(Color.WHITE);
				} else if (h.getType().equals("cannonNormalUp")) {
				     pix.setColor(Color.BLACK);
				} else if (h.getType().equals("cannonNormalRight")) {
				     pix.setColor(Color.BLACK);
				} else if (h.getType().equals("cannonNormalLeft")) {
				     pix.setColor(Color.BLACK);
				} else if (h.getType().equals("cannonNormalDown")) {
				     pix.setColor(Color.BLACK);
				} else if (h.getType().equals("cannonFastUp")) {
				     pix.setColor(Color.GREEN);
				} else if (h.getType().equals("cannonFastRight")) {
				     pix.setColor(Color.GREEN);
				} else if (h.getType().equals("cannonFastLeft")) {
				     pix.setColor(Color.GREEN);
				} else if (h.getType().equals("cannonFastDown")) {
				     pix.setColor(Color.GREEN);
				} else if (h.getType().equals("cannonSinUp")) {
				     pix.setColor(Color.YELLOW);
				} else if (h.getType().equals("cannonSinRight")) {
				     pix.setColor(Color.YELLOW);
				} else if (h.getType().equals("cannonSinLeft")) {
				     pix.setColor(Color.YELLOW);
				} else if (h.getType().equals("cannonSinDown")) {
				     pix.setColor(Color.YELLOW);
				} else if (h.getType().equals("cannonBigUp")) {
				     pix.setColor(Color.RED);
				} else if (h.getType().equals("cannonBigRight")) {
				     pix.setColor(Color.RED);
				} else if (h.getType().equals("cannonBigLeft")) {
				     pix.setColor(Color.RED);
				} else if (h.getType().equals("cannonBigDown")) {
				     pix.setColor(Color.RED);
				} else if (h.getType().equals("cannonMultiUp")) {
					pix.setColor(Color.MAGENTA);
				} else if (h.getType().equals("cannonMultiRight")) {
					pix.setColor(Color.MAGENTA);
				} else if (h.getType().equals("cannonMultiLeft")) {
					pix.setColor(Color.MAGENTA);
				} else if (h.getType().equals("cannonMultiDown")) {
					pix.setColor(Color.MAGENTA);
				} else if (h.getType().equals("tileSpikeUp")) {
					pix.setColor(Color.GRAY);
				} else if (h.getType().equals("tileSpikeRight")) {
					pix.setColor(Color.GRAY);
				} else if (h.getType().equals("tileSpikeLeft")) {
					pix.setColor(Color.GRAY);
				} else if (h.getType().equals("tileSpikeDown")) {
					pix.setColor(Color.GRAY);
				} else if (h.getType().equals("gateKey")) {
					pix.setColor(Color.BLUE);
				} else if (h.getType().equals("gateHorizontal")) {
					pix.setColor(Color.RED);
				} else if (h.getType().equals("gateVertical")) {
					pix.setColor(Color.RED);
				} else if (h.getType().equals("powerupJump")) {
					pix.setColor(Color.BLUE);
				} else if (h.getType().equals("powerupGravity")) {
					pix.setColor(Color.BLUE);
				} else if (h.getType().equals("coin")) {
					pix.setColor(Color.YELLOW);
				} else if (h.getType().equals("door")) {
					pix.setColor(Color.ORANGE);
					doorX = h.getX();
					doorY = h.getY();
				} else if (h.getType().equals("cannonQuadra")) {
					pix.setColor(Color.RED);
				} else if (h.getType().equals("cannonTrace")) {
					pix.setColor(Color.RED);
				} else if (h.getType().equals("tileWalkwayLeft")) {
					pix.setColor(Color.YELLOW);
				} else if (h.getType().equals("tileWalkwayRight")) {
					pix.setColor(Color.YELLOW);
				} else if (h.getType().contains("Spinner")) {
					pix.setColor(Color.YELLOW);
				} else {
					pix.setColor(Color.LIGHT_GRAY);
				}

			 float y = h.getY();
			 y = 480 - y;
			 pix.fillRectangle((int)((h.getX() / 32) * 4) + 1, (int)((y / 32) * 4) - 3, 4, 4);
		 }
		}
		if (doorX != 0) {
		 doorY = 480 - doorY;
			pix.setColor(Color.ORANGE);
		 pix.fillRectangle((int)((doorX / 32) * 4) + 1, (int)((doorY / 32) * 4) - 11, 8, 12);
		}
        pix.setColor(Color.BLACK);
		pix.drawLine(0, 0, pix.getWidth()-1, 0);
		pix.drawLine(0, pix.getHeight() - 1, pix.getWidth()-1, pix.getHeight() - 1);
        pix.drawLine(0, 0, 0, pix.getHeight() - 1);
        pix.drawLine(pix.getWidth() - 1, 0, pix.getWidth() - 1, pix.getHeight() - 1);
		s = s.substring(0, s.length() - 4);
		FileHandle f = Gdx.files.local(s + ".png");
        PixmapIO pixIO = new PixmapIO();
        pixIO.writePNG(f, pix);
        
	}


	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void input(String text) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void canceled() {
		// TODO Auto-generated method stub
		
	}


	public float getTimeLimit() {
		return timeLimit;
	}


	public void setTimeLimit(float timeLimit) {
		this.timeLimit = timeLimit;
	}


	public int getLevelType() {
		return levelType;
	}


	public void setLevelType(int levelType) {
		this.levelType = levelType;
	}


	@Override
	public String toString() {
		return "EditorWrap [scrolledAmount=" + scrolledAmount + "]";
	}


	public int getScrolledAmount() {
		return scrolledAmount;
	}


	public void setScrolledAmount(int scrolledAmount) {
		this.scrolledAmount = scrolledAmount;
	}


	public ArrayList<Helper> getWhatToDraw() {
		return whatToDraw;
	}


	public void setWhatToDraw(ArrayList<Helper> whatToDraw) {
		this.whatToDraw = whatToDraw;
	}


	public String getSelection() {
		return selection;
	}


	public void setSelection(String selection) {
		this.selection = selection;
	}


	public Group getForeground() {
		return foreground;
	}


	public void setForeground(Group foreground) {
		this.foreground = foreground;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}



	
}
