package lightsoutgaming.games.hacker.onejar.main;

import java.awt.Color;
import java.awt.Graphics2D;

import taz40.lightsoutgamingengine.V1.Entity;
import taz40.lightsoutgamingengine.V1.Screen;

public class TextArea extends Entity {

	public TextArea(Screen screen, int X, int Y, int W, int H) {
		super(screen);
		// TODO Auto-generated constructor stub
		x = X;
		y = Y;
		width = W;
		height = H;
	}
	
	int x, y, width, height;

	@Override
	public void onCustomCreate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCustomDestroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCustomDraw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setBackground(Color.black);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void onCustomUpdate() {
		// TODO Auto-generated method stub
		
	}

}
