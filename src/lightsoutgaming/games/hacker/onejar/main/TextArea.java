package lightsoutgaming.games.hacker.onejar.main;

import java.awt.Color;
import java.awt.Graphics2D;

import taz40.lightsoutgamingengine.V1.Entity;
import taz40.lightsoutgamingengine.V1.Screen;

public class TextArea extends Entity implements Receiver {

	public TextArea(Screen screen, int X, int Y, int W, int H) {
		super(screen);
		// TODO Auto-generated constructor stub
		x = X;
		y = Y;
		width = W;
		height = H;
	}
	
	int interval = 0;
	String[] text = new String[50];
	int x, y, width, height;

	@Override
	public void onCustomCreate() {
		// TODO Auto-generated method stub
		/*for(int i = 0; i < 50; i++){
			text[i] = ""+i;
			interval++;
		}*/
	}

	@Override
	public void onCustomDestroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCustomDraw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.setColor(Color.green);
		for(int i = 0; i < 50; i++){
			if(text[i] != null){
				g.drawString(text[i], 11, (i*10)+20);
			}
		}
	}

	@Override
	public void onCustomUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Received(Object o, String msg) {
		// TODO Auto-generated method stub
		if(interval == 50){
			for(int i = 0; i < 50; i++){
				if(i == 0){
					text[i] = null;
				}else{
					text[i-1] = text[i];
				}
				
			}
			text[interval-1] = msg;
		}else{
			text[interval] = msg;
			interval++;
		}
	}

}
