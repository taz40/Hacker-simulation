package lightsoutgaming.games.hacker.onejar.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;

import taz40.lightsoutgamingengine.V1.Screen;
import taz40.lightsoutgamingengine.V1.ScreenFactory;

public class GameScreen extends Screen {

	public GameScreen(ScreenFactory screenfactory) {
		super(screenfactory);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void onCustomCreate() {
		this.addEntity(new TextArea(this,10,10, 780, 500));
		this.addEntity(new TextBox(this,10,515, 780, 20));
	}

	@Override
	public void onCustomDestroy() {
		// TODO Auto-generated method stub
		//screenfactory.getGame().gamethread.remove(jtext);
	}

	@Override
	public void onCustomDraw(Graphics2D g) {
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
