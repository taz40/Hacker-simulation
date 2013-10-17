package lightsoutgaming.games.hacker.onejar.main;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import taz40.lightsoutgamingengine.V1.Button;
import taz40.lightsoutgamingengine.V1.Function;
import taz40.lightsoutgamingengine.V1.Screen;
import taz40.lightsoutgamingengine.V1.ScreenFactory;

public class OptionsScreen extends Screen {

	public OptionsScreen(ScreenFactory screenfactory) {
		super(screenfactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCustomCreate() {
		// TODO Auto-generated method stub
		this.addEntity(Button.createXCenteredButton("Fullscreen: On", 340, 180, 50, 2, texture.buttonpressed, texture.button, new Function(this){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Options.FullScreen = !Options.FullScreen;
				File f = new File("C:\\Hacker-Sim\\options.txt");
				f.delete();
	    		try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		FileWriter f0 = null;
	    		try {
					f0 = new FileWriter(f);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	    		String newLine = System.getProperty("line.separator");
	    		
	    		if(Options.FullScreen){
	    			try {
						f0.write("true"+newLine);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}else{
	    			try {
						f0.write("false"+newLine);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    		try {
					f0.flush();
					f0.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		s.getScreenFactory().getGame().setFullScreen(Options.FullScreen);
			}
			
		}, this));
		
		this.addEntity(Button.createXCenteredButton("Back", 400, 100, 50, 2, texture.buttonpressed, texture.button, new Function(this){

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
		if(Options.FullScreen){
			((Button)entities.get(0)).setTitle("FullScreen: On");
		}else{
			((Button)entities.get(0)).setTitle("FullScreen: Off");
		}
	}

}
