package lightsoutgaming.games.hacker.onejar.main;

import taz40.lightsoutgamingengine.V1.Function;

public class File {

	public String name;
	public Type type;
	public Function func;
	
	public File(String name, Type type, Function func){
		this.name = name;
		this.type = type;
		this.func = func;
	}
	
	public void run(){
		new Thread("run file " + name){
			public void run(){
				func.run();
			}
		}.start();
	}
	
}
