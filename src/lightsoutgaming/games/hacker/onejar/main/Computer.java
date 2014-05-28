package lightsoutgaming.games.hacker.onejar.main;

public class Computer {

	public int health, maxHealth, processingPower, totalProcessingPower, brainPower, maxBrainPower;
	
	
	public Computer(int maxHealth, int totalProcessingPower, int maxBrainPower){
		health = this.maxHealth = maxHealth;
		processingPower = this.totalProcessingPower = totalProcessingPower;
		brainPower = this.maxBrainPower = maxBrainPower;
	}
	
}
