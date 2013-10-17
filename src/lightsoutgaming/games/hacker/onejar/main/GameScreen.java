package lightsoutgaming.games.hacker.onejar.main;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import taz40.lightsoutgamingengine.V1.Screen;
import taz40.lightsoutgamingengine.V1.ScreenFactory;

public class GameScreen extends Screen {

	public GameScreen(ScreenFactory screenfactory) {
		super(screenfactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCustomCreate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCustomDestroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCustomDraw(Graphics2D arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCustomUpdate() {
		// TODO Auto-generated method stub
		if(screenfactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_ESCAPE)){
			screenfactory.showScreen(new GamePauseMenu(screenfactory));
			screenfactory.getGame().getKeyboardListener().unpresskey(KeyEvent.VK_ESCAPE);
		}
	}

}
