package lightsoutgaming.games.hacker.onejar.main;

import java.util.ArrayList;

public class FileSystem {
	
	public String name;
	public ArrayList<FileSystem> folders = new ArrayList<FileSystem>();
	public ArrayList<MyFile> files = new ArrayList<MyFile>();
	public FileSystem parent;
	
	public FileSystem(String name, FileSystem parent){
		this.parent = parent;
		this.name = name;
	}
	
	public void list(TextArea textarea){
		for(int i = 0; i < folders.size(); i++){
			textarea.Received(this, " + " + folders.get(i).name);
		}
		for(int i = 0; i < files.size(); i++){
			textarea.Received(this, " - " + files.get(i).name);
		}
	}
	
	public void add(FileSystem folder){
		folders.add(folder);
	}
	
	public void add(MyFile file){
		files.add(file);
	}
}
