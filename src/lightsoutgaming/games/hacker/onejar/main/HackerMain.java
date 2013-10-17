package lightsoutgaming.games.hacker.onejar.main;

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
        
        System.out.println("Hacker OK.");
    }
    

}
