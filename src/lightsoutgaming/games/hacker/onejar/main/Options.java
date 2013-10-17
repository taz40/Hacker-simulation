package lightsoutgaming.games.hacker.onejar.main;

import taz40.lightsoutgamingengine.V1.Game;

public class Options {
	public static boolean FullScreen = false;
	public static void update(Game game){
		game.setFullScreen(FullScreen);
	}
}
