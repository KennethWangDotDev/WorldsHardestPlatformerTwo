package com.kenneth.whp2;

import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Parameters {
	
	public static int onScreenControls = 0;
	
	//Options
	public static int handOrientation = 1;
	public static int music = 1;
	public static int sound = 1;
	public static int deviceSize = 1;
	public static int transparency = 60;
	
	//Stats
	public static int totalStars = 0;
	public static int totalPlayTimeMinutes = 0;
	public static float totalPlayTimeSeconds = 0f;
	public static int deathsTotal = 0;
	public static int deathsExit = 0;
	public static int deathsCannonNormal = 0;
	public static int deathsCannonFast = 0;
	public static int deathsCannonSin = 0;
	public static int deathsCannonMulti = 0;
	public static int deathsCannonBig = 0;
	public static int deathsCannonTrace = 0;
	public static int deathsCannonQuadra = 0;
	public static int deathsSpikes = 0;
	public static int deathsFalling = 0;
	public static int deathsSpikeColumn = 0;
	public static int deathsSpinner = 0;
	
	//Worlds
	public static int worldSelection = 1;
	public static boolean[] worldPass = new boolean[21];
	public static int[] worldDeaths = new int[21];
	public static int[] worldStars = new int[21];
	public static boolean[] worldPlayable = new boolean[21];
	
	//Levels
	public static boolean[][] levelPass = new boolean[21][11];
	public static int[][] levelStars = new int[21][11];
	public static int[][] levelDeaths = new int[21][11];
	public static int[][] levelAttempts = new int[21][11];
	public static float[][] levelElapsedTime = new float[21][11];
	public static float[][] levelFastestTime = new float[21][11];
	public static boolean[][] levelPlayable = new boolean[21][11];
	
	//Shop
	public static int stars = 0;
	public static boolean[] skins = new boolean[9];
	public static int levelSkips = 3;
	public static int currentSkin = 0;
	
	public static void load() {
		if (Gdx.files.local("stats.txt").exists()) {
			FileHandle file = Gdx.files.local("stats.txt");
			String text = file.readString();
			Scanner scanner = new Scanner(text);
			try {
			while (scanner.hasNext()) {
				Scanner inDepth = new Scanner(scanner.next());
				inDepth.useDelimiter("=");
				String temp = inDepth.next();
				if (temp.equals("totalStars")) {
					totalStars = Integer.valueOf(inDepth.next());
				} else if (temp.equals("totalPlayTimeMinutes")) {
					totalPlayTimeMinutes = Integer.valueOf(inDepth.next());
				} else if (temp.equals("totalPlayTimeSeconds")) {
					totalPlayTimeSeconds = Float.valueOf(inDepth.next());
				} else if (temp.equals("deathsTotal")) {
					deathsTotal = Integer.valueOf(inDepth.next());
				} else if (temp.equals("deathsExit")) {
					deathsExit = Integer.valueOf(inDepth.next());
				} else if (temp.equals("deathsCannonNormal")) {
					deathsCannonNormal = Integer.valueOf(inDepth.next());
				} else if (temp.equals("deathsCannonFast")) {
					deathsCannonFast = Integer.valueOf(inDepth.next());
				} else if (temp.equals("deathsCannonSin")) {
					deathsCannonSin = Integer.valueOf(inDepth.next());
				} else if (temp.equals("deathsCannonMulti")) {
					deathsCannonMulti = Integer.valueOf(inDepth.next());
				} else if (temp.equals("deathsCannonBig")) {
					deathsCannonBig = Integer.valueOf(inDepth.next());
				} else if (temp.equals("deathsSpikes")) {
					deathsSpikes = Integer.valueOf(inDepth.next());
				} else if (temp.equals("deathsFalling")) {
					deathsFalling = Integer.valueOf(inDepth.next());
				} else if (temp.equals("deathsCannonTrace")) {
					deathsCannonTrace = Integer.valueOf(inDepth.next());
				} else if (temp.equals("deathsSpinner")) {
					deathsSpinner = Integer.valueOf(inDepth.next());
				} else if (temp.equals("deathsSpikeColumn")) {
					deathsSpikeColumn = Integer.valueOf(inDepth.next());
				} else if (temp.equals("deathsCannonQuadra")) {
					deathsCannonQuadra = Integer.valueOf(inDepth.next());
				}
		
			}
			deathsTotal = 0;
			deathsTotal = deathsExit + deathsCannonNormal + deathsCannonFast + deathsCannonSin + deathsCannonMulti + deathsCannonBig + deathsSpikes + deathsFalling + deathsCannonTrace + deathsSpinner + deathsSpikeColumn + deathsCannonQuadra;
			
			
		} catch (NumberFormatException nfe) {
            saveStats();
            System.out.println("Exception: Stats");
          } 
		} else {
			saveStats();
		}
		
		for (int i = 1; i <= 20; i++) {
		
		if (Gdx.files.local("world" + i + ".txt").exists()) {
			FileHandle file = Gdx.files.local("world" + i + ".txt");
			String text = file.readString();
			Scanner scanner = new Scanner(text);
			try {
			while (scanner.hasNext()) {
				Scanner inDepth = new Scanner(scanner.next());
				inDepth.useDelimiter("=");
				String temp = inDepth.next();
				if (temp.contains("levelPass")) {
					boolean bool;
					if (inDepth.next().equals("1")) {
						bool = true;
					} else {
						bool = false;
					}
					int world;
					if (isInteger((temp.substring(1, 2)))) {
						world = Integer.valueOf(temp.substring(0, 2));
					} else {
						world = Integer.valueOf(temp.substring(0, 1));
					}
					int level = Integer.valueOf(temp.substring(temp.length() - 1, temp.length()));
					if (level == 0) level = 10;
					levelPass[world][level] = bool;
				} else if (temp.contains("levelStars")) {
					int world;
					if (isInteger((temp.substring(1, 2)))) {
						world = Integer.valueOf(temp.substring(0, 2));
					} else {
						world = Integer.valueOf(temp.substring(0, 1));
					}
					int level = Integer.valueOf(temp.substring(temp.length() - 1, temp.length()));
					if (level == 0) level = 10;
					levelStars[world][level] = Integer.valueOf(inDepth.next());
				} else if (temp.contains("levelDeaths")) {
					int world;
					if (isInteger((temp.substring(1, 2)))) {
						world = Integer.valueOf(temp.substring(0, 2));
					} else {
						world = Integer.valueOf(temp.substring(0, 1));
					}
					int level = Integer.valueOf(temp.substring(temp.length() - 1, temp.length()));
					if (level == 0) level = 10;
					levelDeaths[world][level] = Integer.valueOf(inDepth.next());
				} else if (temp.contains("levelAttempts")) {
					int world;
					if (isInteger((temp.substring(1, 2)))) {
						world = Integer.valueOf(temp.substring(0, 2));
					} else {
						world = Integer.valueOf(temp.substring(0, 1));
					}
					int level = Integer.valueOf(temp.substring(temp.length() - 1, temp.length()));
					if (level == 0) level = 10;
					levelAttempts[world][level] = Integer.valueOf(inDepth.next());
				} else if (temp.contains("levelElapsedTime")) {
					int world;
					if (isInteger((temp.substring(1, 2)))) {
						world = Integer.valueOf(temp.substring(0, 2));
					} else {
						world = Integer.valueOf(temp.substring(0, 1));
					}
					int level = Integer.valueOf(temp.substring(temp.length() - 1, temp.length()));
					if (level == 0) level = 10;
					levelElapsedTime[world][level] = Float.valueOf(inDepth.next());
				} else if (temp.contains("levelFastestTime")) {
					int world;
					if (isInteger((temp.substring(1, 2)))) {
						world = Integer.valueOf(temp.substring(0, 2));
					} else {
						world = Integer.valueOf(temp.substring(0, 1));
					}
					int level = Integer.valueOf(temp.substring(temp.length() - 1, temp.length()));
					if (level == 0) level = 10;
					levelFastestTime[world][level] = Float.valueOf(inDepth.next());
				} else if (temp.contains("levelPlayable")) {
					boolean bool;
					if (inDepth.next().equals("1")) {
						bool = true;
					} else {
						bool = false;
					}
					int world;
					if (isInteger((temp.substring(1, 2)))) {
						world = Integer.valueOf(temp.substring(0, 2));
					} else {
						world = Integer.valueOf(temp.substring(0, 1));
					}
					int level = Integer.valueOf(temp.substring(temp.length() - 1, temp.length()));
					if (level == 0) level = 10;
					levelPlayable[world][level] = bool;
				}
			}
			} catch (NumberFormatException nfe) {
	            System.out.println("Exception: Levels");
	  			levelPlayable[1][1] = true;
				levelPlayable[1][2] = true;
	              saveLevels(i);
	            } 
			
		} else {
			levelPlayable[1][1] = true;
			levelPlayable[1][2] = true;
			saveLevels(i);
		}
		}
		
		if (Gdx.files.local("worlds.txt").exists()) {
			FileHandle file = Gdx.files.local("worlds.txt");
			String text = file.readString();
			Scanner scanner = new Scanner(text);
			try {
			while (scanner.hasNext()) {
				Scanner inDepth = new Scanner(scanner.next());
				inDepth.useDelimiter("=");
				String temp = inDepth.next();
				if (temp.equals("worldSelection")) {
					worldSelection = Integer.valueOf(inDepth.next());
				}
				if (temp.equals("handOrientation")) {
					handOrientation = Integer.valueOf(inDepth.next());
				}
				if (temp.equals("deviceSize")) {
					deviceSize = Integer.valueOf(inDepth.next());
				}
				if (temp.equals("sound")) {
					sound = Integer.valueOf(inDepth.next());
				}
				if (temp.equals("music")) {
					music = Integer.valueOf(inDepth.next());
				}
				if (temp.equals("transparency")) {
					transparency = Integer.valueOf(inDepth.next());
				}
			}
			for (int k = 1; k <= worldPass.length - 1; k++) {
				worldPass[k] = true;
				worldDeaths[k] = 0;
				worldStars[k] = 0;
			}
			for (int j = 1; j <= worldPass.length - 1; j++) {
				for (int i = 1; i <= levelPass[0].length - 1; i++) {
					if ((levelPass[j][i]) == false) {
						worldPass[j] = false;
					}
					worldDeaths[j] += levelDeaths[j][i];
					worldStars[j] += levelStars[j][i];
					
				}
			}
			
			levelPass[0][10] = true;
			for (int i = 1; i <= 10; i++) {
				if ((levelPass[i-1][10]) || (worldStars[i - 1] >= 20)) {
					worldPlayable[i] = true;
					levelPlayable[i][1] = true;
					levelPlayable[i][2] = true;
				}
			}
			for (int i = 11; i <= 20; i++) {
				if (worldStars[i-10] == 30) {
					worldPlayable[i] = true;
					levelPlayable[i][1] = true;
					levelPlayable[i][2] = true;
				}
				
				if (worldPlayable[i]) {
					worldPlayable[i-10] = true;
				}
				
				if (i != 20) {
				if ((levelPass[i][10]) || (worldStars[i] >= 20)) {
					worldPlayable[i+1] = true;
					levelPlayable[i + 1][1] = true;
					levelPlayable[i + 1][2] = true;
				}
				}
				
				if (worldPlayable[i]) {
					worldPlayable[i-10] = true;
					levelPlayable[i-10][1] = true;
					levelPlayable[i-10][2] = true;
				}
			}
			
		} catch (NumberFormatException nfe) {
            saveWorlds();
            System.out.println("Exception: Worlds");
          } 
		} else {
			saveWorlds();
		}
		
		if (Gdx.files.local("shop.txt").exists()) {
			skins[0] = true;
			FileHandle file = Gdx.files.local("shop.txt");
			String text = file.readString();
			Scanner scanner = new Scanner(text);
			try {
			while (scanner.hasNext()) {
				Scanner inDepth = new Scanner(scanner.next());
				inDepth.useDelimiter("=");
				String temp = inDepth.next();

				if (temp.equals("stars")) {
					stars = Integer.valueOf(inDepth.next());
				} else if (temp.contains("skins")) {
					boolean bool;
					if (inDepth.next().equals("1")) {
						bool = true;
					} else {
						bool = false;
					}
					int skindex = Integer.valueOf(temp.substring(temp.length() - 1, temp.length()));
					if (skindex < skins.length) {
					skins[skindex] = bool;
					System.out.println("skindex[" + skindex + "]: " + bool);
					}
				} else if (temp.equals("currentSkin")) {
					currentSkin =  Integer.valueOf(inDepth.next());
				} else if (temp.equals("levelSkips")) {
					levelSkips = Integer.valueOf(inDepth.next());
				}
			}
		} catch (NumberFormatException nfe) {
            saveShop();
            System.out.println("Exception: Shop");
          } 
		} else {
			saveShop();
		}

	}
	
	public static void saveStats() {
		FileHandle file = Gdx.files.local("stats.txt");
		deathsTotal = 0;
		deathsTotal = deathsExit + deathsCannonNormal + deathsCannonFast + deathsCannonSin + deathsCannonMulti + deathsCannonBig + deathsSpikes + deathsFalling + deathsCannonTrace + deathsSpinner + deathsSpikeColumn + deathsCannonQuadra;
		file.writeString("totalStars=" + totalStars + "\n", false);
		file.writeString("totalPlayTimeMinutes=" + totalPlayTimeMinutes + "\n", true);
		file.writeString("totalPlayTimeSeconds=" + totalPlayTimeSeconds + "\n", true);
		file.writeString("deathsTotal=" + deathsTotal + "\n", true);
		file.writeString("deathsExit=" + deathsExit + "\n", true);
		file.writeString("deathsCannonNormal=" + deathsCannonNormal + "\n", true);
		file.writeString("deathsCannonFast=" + deathsCannonFast + "\n", true);
		file.writeString("deathsCannonSin=" + deathsCannonSin + "\n", true);
		file.writeString("deathsCannonMulti=" + deathsCannonMulti + "\n", true);
		file.writeString("deathsCannonBig=" + deathsCannonBig + "\n", true);
		file.writeString("deathsCannonTrace=" + deathsCannonTrace + "\n", true);
		file.writeString("deathsCannonQuadra=" + deathsCannonQuadra + "\n", true);
		file.writeString("deathsSpikes=" + deathsSpikes + "\n", true);
		file.writeString("deathsFalling=" + deathsFalling + "\n", true);
		file.writeString("deathsSpikeColumn=" + deathsSpikeColumn + "\n", true);
		file.writeString("deathsSpinner=" + deathsSpinner, true);
		
	}
	
	public static void saveWorlds() {
//		public static boolean[] worldPass = new boolean[21];
//		public static int[] worldDeaths = new int[21];
//		public static int[] worldStars = new int[21];
		FileHandle file = Gdx.files.local("worlds.txt");
		file.writeString("worldSelection=" + worldSelection + "\n", false);
		file.writeString("deviceSize=" + deviceSize+ "\n", true);
		file.writeString("handOrientation=" + handOrientation+ "\n", true);
		file.writeString("sound=" + sound+ "\n", true);
		file.writeString("transparency=" + transparency+ "\n", true);
		file.writeString("music=" + music, true);
		System.out.println("Testing Success");
		if (Gdx.files.local("worlds.txt").exists()) {
			System.out.println("Success!");
		}
		for (int k = 1; k <= worldPass.length - 1; k++) {
			worldPass[k] = true;
			worldDeaths[k] = 0;
			worldStars[k] = 0;
		}
		for (int j = 1; j <= worldPass.length - 1; j++) {
			for (int i = 1; i <= levelPass[0].length - 1; i++) {
				if ((levelPass[j][i]) == false) {
					worldPass[j] = false;
				}
				worldDeaths[j] += levelDeaths[j][i];
				worldStars[j] += levelStars[j][i];
				
			}
		}
		levelPass[0][10] = true;
		for (int i = 1; i <= 10; i++) {
			if ((levelPass[i-1][10]) || (worldStars[i - 1] >= 20)) {
				worldPlayable[i] = true;
				levelPlayable[i][1] = true;
				levelPlayable[i][2] = true;
			}
		}
		for (int i = 11; i <= 20; i++) {
			if (worldStars[i-10] == 30) {
				worldPlayable[i] = true;
				levelPlayable[i][1] = true;
				levelPlayable[i][2] = true;
			}
			
			if (worldPlayable[i]) {
				worldPlayable[i-10] = true;
			}
			
			if (i != 20) {
			if ((levelPass[i][10]) || (worldStars[i] >= 20)) {
				worldPlayable[i+1] = true;
				levelPlayable[i + 1][1] = true;
				levelPlayable[i + 1][2] = true;
			}
			}
			if (worldPlayable[i]) {
				worldPlayable[i-10] = true;
				levelPlayable[i-10][1] = true;
				levelPlayable[i-10][2] = true;
			}
		}
		
		
	}
	

	
	public static void saveLevels(int x) {
		levelPass[0][10] = true;
		FileHandle file = Gdx.files.local("world" + x + ".txt");
		file.writeString("", false);
			for (int j = 1; j <= levelPass[0].length - 1; j++) {
				int helper = 0;
				if (levelPass[x][j]) {
					helper = 1;
				} else {
					helper = 0;
				}
				file.writeString(x + "levelPass" + j + "=" + helper + "\n", true);
				file.writeString(x + "levelStars" + j + "=" + levelStars[x][j] + "\n", true);
				file.writeString(x + "levelDeaths" + j + "=" + levelDeaths[x][j] + "\n", true);
				file.writeString(x + "levelAttempts" + j + "=" + levelAttempts[x][j] + "\n", true);
				file.writeString(x + "levelElapsedTime" + j + "=" + levelElapsedTime[x][j] + "\n", true);
				file.writeString(x + "levelFastestTime" + j + "=" + levelFastestTime[x][j] + "\n", true);
				if (levelPlayable[x][j]) {
					helper = 1;
				} else {
					helper = 0;
				}
				file.writeString(x + "levelPlayable" + j + "=" + helper + "\n", true);
			}
	}

	
	public static void saveShop() {
//		public static int stars;
//		public static boolean[] skins = new boolean[11];
		FileHandle file = Gdx.files.local("shop.txt");
		file.writeString("stars=" + stars + "\n", false);
		skins[0] = true;
		for (int i = 1; i <= skins.length - 1; i++) { 
			int helper = 0;
			if (skins[i]) {
				helper = 1;
			} else {
				helper = 0;
			}
			file.writeString("skins" + i + "=" + helper + "\n", true);
		}
		file.writeString("currentSkin=" + currentSkin + "\n", true);
		file.writeString("levelSkips=" + levelSkips, true);
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
