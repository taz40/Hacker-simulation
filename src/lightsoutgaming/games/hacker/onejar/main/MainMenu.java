package lightsoutgaming.games.hacker.onejar.main;

import java.awt.Graphics2D;

import lightsoutgaming.lifeless.textures.textureclass;

import taz40.lightsoutgamingengine.V1.Button;
import taz40.lightsoutgamingengine.V1.Function;
import taz40.lightsoutgamingengine.V1.Screen;
import taz40.lightsoutgamingengine.V1.ScreenFactory;

public class MainMenu extends Screen {

	public MainMenu(ScreenFactory screenfactory) {
		super(screenfactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCustomCreate() {
		// TODO Auto-generated method stub
		load();
		
		this.addEntity(Button.createXCenteredButton("Play", 280, 100, 50, 2, texture.buttonpressed, texture.button, new Function(this){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				s.getScreenFactory().showScreen(new GameScreen(s.getScreenFactory()));
			}
			
		}, this));
		
		this.addEntity(Button.createXCenteredButton("Options", 340, 100, 50, 2, texture.buttonpressed, texture.button, new Function(this){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				s.getScreenFactory().showScreen(new OptionsScreen(s.getScreenFactory()));
			}
			
		}, this));
		
		this.addEntity(Button.createXCenteredButton("Exit", 400, 100, 50, 2, texture.buttonpressed, texture.button, new Function(this){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				this.s.getScreenFactory().getGame().Exit();
			}
			
		}, this));
	}
	
	public void load(){
		texture.button = screenfactory.getGame().texturerenderer.LoadTexture("Gui/Button.png", textureclass.class);
		texture.buttonpressed = screenfactory.getGame().texturerenderer.LoadTexture("Gui/Button_Pressed.png", textureclass.class);
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
