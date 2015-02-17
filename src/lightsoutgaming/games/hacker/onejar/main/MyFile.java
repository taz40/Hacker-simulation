package lightsoutgaming.games.hacker.onejar.main;


public class MyFile {

	public String name;
	public Type type;
	String newLine = System.getProperty("line.separator");
	public String content;
	TextArea text;
	
	public MyFile(String name, Type type, String content, TextArea textarea){
		this.name = name;
		this.type = type;
		this.content = content;
		text = textarea;
	}
	
	public void run(String msg, Computer comp){
		if(type == Type.txt){
			String[] strings = content.split(newLine);
			for(int i = 0; i < strings.length; i++){
				text.Received(this, strings[i].toUpperCase());
			}
		}else if(type == Type.exe){
			String[] cmds = content.split(newLine);
			for(int i = 0; i < cmds.length; i++){
				String cmd = cmds[i];
				if(cmd.startsWith("scan")){
					String[] args = cmd.split(" ");
					int port = Integer.parseInt(args[1]);
					Boolean portOpen = comp.scanPort(port);
					text.Received(this, Boolean.toString(portOpen));
				}// add port scan cmd for .exe files
			}
		}else if(type == Type.system){
			text.Received(this, "ACCESS DENIED");
		}
	}
	
	
	
}
