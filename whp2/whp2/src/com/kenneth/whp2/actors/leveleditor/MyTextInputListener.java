package com.kenneth.whp2.actors.leveleditor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.kenneth.whp2.screens.LevelEditor;

public class MyTextInputListener implements TextInputListener {
		public static int mode;
		public static String input;
		public static float x, y;
	   @Override
	   public void input (String text) {
		   if (mode == 6) {
			   if (isInteger(text)) {
				   int temp = Integer.parseInt(text);
					   	Helper h = new Helper("cannonSpinner", LevelEditor.wrap.getScrolledAmount() + x, y);
					   	h.getParameter().add(text);
						 LevelEditor.wrap.getWhatToDraw().add(h);
					   return;
				 
			   }
			   mode = 6;
				 Gdx.input.getTextInput(this, "Spinner Length (between 1 to 9)", "5");
			   
			   
		   }
		   
		   if (mode == 5) {

			   	if (text.contains("/")) {
			   		mode = 5;
					 Gdx.input.getTextInput(this, "Text to write", "Text");
			   	} else {
			   	Helper h = new Helper("string", LevelEditor.wrap.getScrolledAmount() + x, y);
			   	h.getParameter().add(text);
				 LevelEditor.wrap.getWhatToDraw().add(h);
			   	}
		   }
		   
		   if (mode == 4) {
			   if (isFloat(text)) {
				   LevelEditor.wrap.setTimeLimit(Float.valueOf(text));
				   LevelEditor.wrap.save(input);
			   } else {
				   mode = 4;
					 Gdx.input.getTextInput(this, "Time Limit to earn star? Enter number (in seconds)", "10.5");
			   }
		   }
		   
		   
		   if (mode == 3) {
			   if ((text.equals("1")) || (text.equals("0"))){
				   mode = 4;
				   LevelEditor.wrap.setLevelType(Integer.valueOf(text));
					 Gdx.input.getTextInput(this, "Time Limit to earn star? Enter number (in seconds)", "10.5");
			   } else {
					 mode = 3;
					 Gdx.input.getTextInput(this, "Scrolling Background?", "Enter 0 for no, and 1 for yes");
			   }
		   }
		   
		   
		   if (mode ==2) {
			   if (!(text.endsWith(".txt"))) {
				   text = text + ".txt";
			   }
			   input = "editor/" + text;
				 mode = 3;
				 Gdx.input.getTextInput(this, "Scrolling Background?", "Enter 0 for no, and 1 for yes");
		   }
		   
		   if (mode == 1) {
			   if (!(text.endsWith(".txt"))) {
				   text = text + ".txt";
			   }
			   LevelEditor.wrap.load("editor/" + text);
		   }
		   


		   
		   
		   
		   
		   
	   }

	   @Override
	   public void canceled () {
	   }
	   
	   public static boolean isFloat(String s) {
		    try { 
		        Float.parseFloat(s); 
		    } catch(NumberFormatException e) { 
		        return false; 
		    }
		    // only got here if we didn't return false
		    return true;
		}
	   
	   
	   public static boolean isInteger(String s) {
		    try { 
		        Integer.parseInt(s); 
		    } catch(NumberFormatException e) { 
		        return false; 
		    }
		    // only got here if we didn't return false
		    return true;
		}
	}