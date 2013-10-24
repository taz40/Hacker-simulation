package lightsoutgaming.games.hacker.onejar.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.Date;

import javax.swing.UIManager;

import taz40.lightsoutgamingengine.V1.Entity;
import taz40.lightsoutgamingengine.V1.Screen;

public class TextBox extends Entity {
	
	char toLowerCase(char c){
	    if(c>=97 && c<=122)
	        return (char) (c-32);
	    else
	        return c;
	}

	public TextBox(Screen screen, int X, int Y, int W, int H, Receiver recv1) {
		super(screen);
		// TODO Auto-generated constructor stub
		x = X;
		y = Y;
		width = W;
		height = H;
		recv = recv1;
	}
	
	int interval = 0;
	char[] string = new char[256];
	int underscoretime;
	boolean underscore = true;
	int x,y,width,height;
	long prevtime = new Date().getTime();
	int xoffset = 5;
	boolean hasfocus = false;
	Receiver recv;
	boolean shifting = false;

	@Override
	public void onCustomCreate() {
		// TODO Auto-generated method stub
		for(int i = 0; i < string.length; i++){
			string[i] = (char) -1;
		}
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
		
		
		String fullstring = "";
		int specialoffset = 5;
		int interval = 0;
		for(int c = 0; c < string.length; c++){
			if(string[c] != (char) -1){
				fullstring += string[c];
				interval++;
			}
			if(interval == 4){
				specialoffset += 1;
				interval = 0;
			}
		}
		
		if(fullstring.isEmpty()){
			System.out.println("string is empty");
			xoffset = 5;
		}else{
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,false);     
		Font font = g.getFont();
		xoffset = 5+(int)(font.getStringBounds(fullstring, frc).getWidth());
		g.drawString(fullstring, x+5, y+15);
		}
		
		if(underscore && hasfocus){
			System.out.println("xoffset: "+xoffset);
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
		
		Integer[] keys = screen.getScreenFactory().getGame().getKeyboardListener().getPressedKeys();
		
		for(int i = 0; i < keys.length; i++){
			if(keys[i] != null){
				switch(keys[i]){
					case KeyEvent.VK_BACK_SPACE:
						if(interval > 0){
							interval--;
							string[interval] = (char) -1;
						}
					break;
					
					case KeyEvent.VK_ENTER:
						String fullstring = "";
						for(int c = 0; c < string.length; c++){
							if(string[c] != (char) -1){
								fullstring += string[c];
							}
						}
						recv.Received(this, fullstring);
						interval = 0;
						for(int i1 = 0; i1 < string.length; i1++){
							string[i1] = (char) -1;
						}
					break;
					
					default:
						//if(shifting){
							string[interval] = (char)(int)keys[i];
						//}else{
						//	string[interval] = toLowerCase((char)(int)keys[i]);
						//}
						interval++;
				}
				screen.getScreenFactory().getGame().getKeyboardListener().unpresskey(keys[i]);
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
