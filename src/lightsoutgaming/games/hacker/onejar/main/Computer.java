package lightsoutgaming.games.hacker.onejar.main;

import java.util.Random;

import taz40.lightsoutgamingengine.V1.Screen;

public class Computer {

	public int health, maxHealth, processingPower, totalProcessingPower, brainPower, maxBrainPower;
	public String ip;
	public static Random rand = new Random();
	FileSystem root;
	FileSystem currentdir;
	Screen s;
	public String path;
	public String help = "SHUTDOWN - REBOOTS THE COMPUTER/CLEAR - CLEARS THE COMPUTER TERMINAL/EXIT - QUITS THE GAME/DIR - SHOWS THE FOLDERS AND FILES IN THE CURRENT DIRECTORY/EXE <FILE> - EXECUTES THE FILE SPECIFIED/CD <DIR> - CHANGES THE CURRENT DIRECTORY/HELP - DISPLAYS THIS HELP MESSAGE";
	
	public Computer(int maxHealth, int totalProcessingPower, int maxBrainPower, Screen s){
		health = this.maxHealth = maxHealth;
		processingPower = this.totalProcessingPower = totalProcessingPower;
		brainPower = this.maxBrainPower = maxBrainPower;
		ip = rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt();
		this.s = s;
	}
	
	public void init(){
		path = root.name + "/";
	}
	
	public void processCMD(String msg, TextBox box, TextArea area){
		if(msg.equals("SHUTDOWN")){
			box.on = false;
			box.hasfocus = false;
			area.Received(this, "SYSTEM SHUTDOWN IN PROGRESS...");
			for(int i = 5; i >= 1; i--){
				area.Received(this, i+"...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			area.Clear();
			path = "";
			box.prefex = "";
			currentdir = root;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			area.onCreate();
			box.on = true;
			init();
		}else if(msg.equals("CLEAR")){
			area.Clear();
		}else if(msg.equals("EXIT")){
			s.getScreenFactory().showScreen(new MainMenu(s.getScreenFactory()));
		}else if(msg.equals("DIR")){
			currentdir.list(area);
		}else if(msg.startsWith("EXE")){
			String name = msg.split(" ")[1];
			for(int i = 0; i < currentdir.files.size(); i++){
				String capsname = currentdir.files.get(i).name.toUpperCase();
				if(capsname.equals(name)){
					currentdir.files.get(i).run(msg);
					break;
				}
			}
		}else if(msg.startsWith("CD")){
			String name = msg.substring(3, msg.length());
			if(name.equals("..")){
				if(!currentdir.name.equals("ROOT")){
					path = path.split(currentdir.name + "/")[0];
					currentdir = currentdir.parent;
				}
			}else{
				for(int i = 0; i < currentdir.folders.size(); i++){
					String capsname = currentdir.folders.get(i).name.toUpperCase();
					if(capsname.equals(name)){
						currentdir = currentdir.folders.get(i);
						path += currentdir.name + "/";
						break;
					}
				}
			}
		}else if(msg.startsWith("HELP")){
			String[] tokens = help.split("/");
			for(int i = 0; i < tokens.length; i++){
				area.Received(this, tokens[i]);
			}
		}
	}
	
}
