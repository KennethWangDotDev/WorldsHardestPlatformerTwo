package com.kenneth.whp2.actors;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenneth.whp2.Assets;
import com.kenneth.whp2.screens.GameScreen;

public class Movers extends Actor{

	private String type;
	public static ArrayList<Movers> moversList = new ArrayList<Movers>();
	private Rectangle rect = new Rectangle(0, 0, 0, 0);
	private Rectangle rectLeft = new Rectangle(0, 0, 0, 0);
	private Rectangle rectRight = new Rectangle(0, 0, 0, 0);
	private float speedX;
	public static ArrayList<Tile> left = new ArrayList<Tile>();
	public static ArrayList<Tile> right = new ArrayList<Tile>();
	private boolean first;

	
	public Movers(float x, float y, String type) {
		this.type = type;
		moversList.add(this);
		setWidth(32);
		setHeight(32);
		setPosition(x * 32, y * 32);
		this.type = type;
	}
	
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

	}
	
	public void act(float delta) {
		super.act(delta);
		if (GameScreen.gs.getWrap().getGameState() == 0) {
        speedX = Background.bg.getSpeedX()*5;
        rect.set(getX() - 2, getY() - 2, getWidth() + 4, getHeight() + 4);
        setX(getX() + (speedX * delta));
        if (first) {
            rectRight.set(getX() + 16, getY() + 10, 20, 5);
            rectLeft.set(getX() - 10, getY() + 10, 20, 5);
        	first = false;
        	for (Tile t: Tile.allTiles) {
        		Rectangle r = new Rectangle(0, 0, 0, 0);
        		r.set(t.getX(), t.getY(), t.getWidth(), t.getHeight());
        		if (type.contains("left")) {
        			if (r.overlaps(rectLeft)) {
        				System.out.println("overlap");
        				left.add(t);
        			}
        		}
        		
        		if (type.contains("right")) {
        			if (r.overlaps(rectRight)) {
        				right.add(t);
        			}
        		}
        		
        	}
        }
        
        
    	for (Tile t: Tile.allTiles) {
    		Rectangle r = new Rectangle(0, 0, 0, 0);
    		r.set(t.getX(), t.getY(), t.getWidth(), t.getHeight());
    		if (rect.contains(r)) {
    			t.setPosition(getX(), getY());
    			if (type.contains("left")) {
    				left.add(t);
    				if (right.contains(t)) {
    					right.remove(t);
    				}
    			} else if (type.contains("right")) {
    				right.add(t);
    				if (left.contains(t)) {
    					left.remove(t);
    				}
    			}
    		}
    	}
    	
    	
    	for (Tile t: right) {
    		t.setSpeedX(t.getSpeedX() + 50);
    	}
    	
    	for (Tile t: left) {
    		t.setSpeedX(t.getSpeedX() - 50);
    	}
	}
	}
		
} 
