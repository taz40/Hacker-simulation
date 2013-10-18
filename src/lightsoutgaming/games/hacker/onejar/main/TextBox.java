package lightsoutgaming.games.hacker.onejar.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Date;

import taz40.lightsoutgamingengine.V1.Entity;
import taz40.lightsoutgamingengine.V1.Screen;

public class TextBox extends Entity {

	public TextBox(Screen screen, int X, int Y, int W, int H) {
		super(screen);
		// TODO Auto-generated constructor stub
		x = X;
		y = Y;
		width = W;
		height = H;
	}
	
	int underscoretime;
	boolean underscore = true;
	int x,y,width,height;
	long prevtime = new Date().getTime();
	int xoffset = 5;
	boolean hasfocus = false;

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
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.setColor(Color.green);
		if(underscore && hasfocus){
			g.drawString("_", x+xoffset, y+15);
		}
	}

	@Override
	public void onCustomUpdate() {
		// TODO Auto-generated method stub
		if(hasfocus){
		if(!underscore){
			if(underscoretime >= 500){
				underscore = true;
				prevtime = new Date().getTime();
				underscoretime = 0;
			}else{
				long timepassed = new Date().getTime() - prevtime;
				underscoretime += timepassed;
				prevtime = new Date().getTime();
			}
		}else{
			if(underscoretime >= 500){
				underscore = false;
				prevtime = new Date().getTime();
				underscoretime = 0;
			}else{
				long timepassed = new Date().getTime() - prevtime;
				underscoretime += timepassed;
				prevtime = new Date().getTime();
			}
			}
		}
			if(screen.getScreenFactory().getGame().getMousePadListener().isMousePressed()){
				int crx = screen.getScreenFactory().getGame().getMousePadListener().getX();
				int cry = screen.getScreenFactory().getGame().getMousePadListener().getY();
				if(!screen.getScreenFactory().getGame().fullscreen){
					cry -= 25;
				}
				if(cry >= y && cry <= y+height){
					if(crx >= x && crx <= x+width){
						hasfocus = true;
					}else{
						hasfocus = false;
					}
				}else{
					hasfocus = false;
				}
			}
	}

}