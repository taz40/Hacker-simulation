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
	
	public void run(String msg){
		if(type == Type.txt){
			String[] strings = content.split(newLine);
			for(int i = 0; i < strings.length; i++){
				text.Received(this, strings[i].toUpperCase());
			}
		}else if(type == Type.exe){
			if(content.equals("crack") || content.equals("CRACK")){
				String[] tokens = msg.split(" ");
				if(tokens.length != 4){
					text.Received(this, "Usage: " + tokens[1] + " <IP> <PORT>");
				}else{
					
				}
			}
		}else if(type == Type.system){
			text.Received(this, "ACCESS DENIED");
		}
	}
	
	
	
}
