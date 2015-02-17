package lightsoutgaming.games.hacker.onejar.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import taz40.lightsoutgamingengine.V1.Screen;
import taz40.lightsoutgamingengine.V1.ScreenFactory;
import taz40.lightsoutgamingengine.V1.Function;

public class GameScreen extends Screen implements Receiver {

	public GameScreen(ScreenFactory screenfactory) {
		super(screenfactory);
		// TODO Auto-generated constructor stub
		this.addEntity(textArea);
		this.addEntity(textBox);
		loadFileSystem("C:\\Hacker-Sim\\HackingSimDemoFile.txt");
		comp.currentdir = comp.root;
		comp.init();
	}
	
	TextArea textArea = new TextArea(this,10,10, 780, 502);
	TextBox textBox = new TextBox(this,10,515, 780, 20, this);
	Computer comp = new Computer(100, 100, 100, this);
	Computer ecomp = new Computer(100, 100, 100, null);

	@Override
	public void onCustomCreate() {
		
	}

	@Override
	public void onCustomDestroy() {
		// TODO Auto-generated method stub
		//screenfactory.getGame().gamethread.remove(jtext);
		System.out.println("destroy");
	}

	@Override
	public void onCustomDraw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(10, 540, 100, 12);
		g.setColor(Color.green);
		g.drawString(comp.ip, 10, 550);
	}

	@Override
	public void onCustomUpdate() {
		// TODO Auto-generated method stub
		if(screenfactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_ESCAPE)){
			screenfactory.showScreen(new GamePauseMenu(screenfactory, this));
			screenfactory.getGame().getKeyboardListener().unpresskey(KeyEvent.VK_ESCAPE);
		}
		if(!comp.path.equals(""))textBox.prefex = comp.path + " > ";
	}


	@Override
	public void Received(Object o, String msg) {
		// TODO Auto-generated method stub
		textArea.Received(this, comp.path + " > " + msg);
		comp.processCMD(msg, textBox, textArea);
	}
	
	public void loadFileSystem(String string){
		String newLine = System.getProperty("line.separator");
		File f = new File(string);
    	if(f.exists()){
    		
    		BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		String line;
    		try {
    			FileSystem thisfolder = comp.root = new FileSystem("ROOT", null);
				while ((line = br.readLine()) != null) {
					if(thisfolder == null) break;
					if(line.startsWith("+")){
						FileSystem nextfolder = new FileSystem(line.substring(2).toUpperCase(), thisfolder);
						thisfolder = nextfolder;
					}
					if(line.startsWith("=")){
						FileSystem nextfolder = thisfolder.parent;
						nextfolder.add(thisfolder);
						thisfolder = nextfolder;
					}
					if(line.startsWith("-")){
						int typeint = Integer.parseInt(line.substring(2, 3)); 
						Type type = intToType(typeint);
						if(type == Type.txt || type == Type.exe){
							String data = line;
							String content = "";
							while((line = br.readLine()) != null){
								if(line.startsWith("=")){
									break;
								}else{
									if(line.contains("%ip")){
										line = line.replace("%ip", comp.ip);
									}
									if(line.contains("%eip")){
										line = line.replace("%eip", ecomp.ip);
									}
									if(!content.equals("")){
										content += newLine;
									}
									content += line;
								}
							}
							MyFile file = new MyFile(data.substring(4).toUpperCase(), type, content, textArea);
							thisfolder.add(file);
						}else if(type == Type.system){
							MyFile file = new MyFile(line.substring(4).toUpperCase(), type, "", textArea);
							thisfolder.add(file);
						}
					}
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}else{
    	}
	}
	
	public Type intToType(int i){
		if(i == 0) return Type.txt;
		if(i == 1) return Type.exe;
		if(i == 2) return Type.system;
		return null;
	}

}
