package lightsoutgaming.games.hacker.onejar.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import taz40.lightsoutgamingengine.V1.Game;

public class HackerMain {
    
    public static void main(String args[]) {
        if (args == null)
            args = new String[0];
        System.out.println("Hacker main entry point, args=" + Arrays.asList(args));
        new HackerMain().run();
    }
    
    // Bring up the application: only expected to exit when user interaction
    // indicates so.
    public void run() {
        System.out.println("Hacker main is running");
        // Implement the functionality of the application. 
        loadOptions();
        Game game = new Game(800, 600, "Hacking Sim",100);
        game.getScreenFactory().showScreen(new MainMenu(game.getScreenFactory()));
		Options.update(game.getScreenFactory().getGame());
        System.out.println("Hacker OK.");
    }
    
    public void loadOptions(){
    	File f = new File("C:\\Hacker-Sim\\options.txt");
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
				while ((line = br.readLine()) != null) {
				   if(line.equals("true")){
					   Options.FullScreen = true;
				   }else{
					   Options.FullScreen = false;
				   }
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}else{
    		f = new File("C:\\Hacker-Sim");
    		f.mkdirs();
    		f = new File("C:\\Hacker-Sim\\options.txt");
    		try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		FileWriter f0 = null;
    		try {
				f0 = new FileWriter(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    		String newLine = System.getProperty("line.separator");
    		
    		if(Options.FullScreen){
    			try {
					f0.write("true"+newLine);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}else{
    			try {
					f0.write("false"+newLine);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		try {
				f0.flush();
				f0.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	
    }
    

}
