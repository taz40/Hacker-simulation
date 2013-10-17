package lightsoutgaming.games.hacker.onejar.main;

import java.awt.Graphics2D;

import taz40.lightsoutgamingengine.V1.Button;
import taz40.lightsoutgamingengine.V1.Function;
import taz40.lightsoutgamingengine.V1.Screen;
import taz40.lightsoutgamingengine.V1.ScreenFactory;

public class GamePauseMenu extends Screen {

	public GamePauseMenu(ScreenFactory screenfactory) {
		super(screenfactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCustomCreate() {
		// TODO Auto-generated method stub
		this.addEntity(Button.createXCenteredButton("Resume", 340, 100, 50, 2, texture.buttonpressed, texture.button, new Function(this){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				s.getScreenFactory().showScreen(new GameScreen(s.getScreenFactory()));
			}
			
		}, this));
		
		this.addEntity(Button.createXCenteredButton("Quit", 400, 100, 50, 2, texture.buttonpressed, texture.button, new Function(this){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				s.getScreenFactory().showScreen(new MainMenu(s.getScreenFactory()));
			}
			
		}, this));
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
		
	}

}
