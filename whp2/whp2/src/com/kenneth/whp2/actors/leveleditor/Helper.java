package com.kenneth.whp2.actors.leveleditor;

import java.util.ArrayList;

public class Helper {
	private String type;
	private float x;
	private float y;
	private ArrayList<String> parameter = new ArrayList<String>();
	
	public Helper(String type, float x, float y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public ArrayList<String> getParameter() {
		return parameter;
	}

	public void setParameter(ArrayList<String> parameter) {
		this.parameter = parameter;
	}


}
