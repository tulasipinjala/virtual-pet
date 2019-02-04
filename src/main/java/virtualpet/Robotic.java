package virtualpet;

import java.io.File;
import java.util.Random;

public class Robotic extends VirtualPet {
	private int fragmentation;
	private int charge;
	private String soundRobotic; 
	
	private int prevFragmentation;
	private int prevCharge;

	public int getCharge() {
		return charge;
	}

	public int getFragmentation() {
		return fragmentation;
	}

	public void getStatus() {
		System.out.println(getName() + "\n Charge is at " + charge + "\n Boredom is at " + getBoredom()
				+ "\n Fragmentation is at " + fragmentation + "\n Dirty is at " + getDirty());
	}

	public void getStatusChange() {
		System.out.println(getName() 
				+ "\n Charge \t" + barMaker(charge) 
				+ "\n Boredom \t" + barMaker(getBoredom())
				+ "\n Fragmentation \t" + barMaker(fragmentation)
				+ "\n Dirty \t\t" + barMaker(getDirty())); 
	}

	// constructor
	public Robotic(String name) {
		super(name);
		charge = 1000;
		fragmentation = 1500;
		soundRobotic = getRandomSound();

		prevCharge = 1000;
		prevFragmentation = 1500;

	}

	public void tick(int time) {

		super.tick(time);
		fragmentation -= time;
		charge -= time;

		if (charge < 50 || getBoredom() < 50 || fragmentation < 50 || getDirty() < 50) {
			System.out.println("Your pet has fainted");
			System.exit(0);
		} else if (charge <= 0 || getBoredom() <= 0 || fragmentation <= 50 || getDirty() <= 50) {
				System.out.println("Your pet has died");
				System.exit(0);
		}
	}

	public void plugin() { // Increase distance from 0 health
		charge += 500;
	}

	public void defrag() { // Increase distance from 0 dirty
		fragmentation = 1500;
	}
	
	public void soundEffect() {
		MakeSound.playSound(getDirectory() + File.separator + "soundfiles" + File.separator + soundRobotic + ".wav");
	}
	
	public void updatePrevProperties() {
		super.updatePrevProperties();
		prevCharge = charge;
		prevFragmentation = fragmentation;
	}
	
	public static String getRandomSound() {
		String[] soundNames = {"bulbasaur","charmander","squirtle","caterpie", "pikachu", "weedle"};
	    int rnd = new Random().nextInt(soundNames.length);
	    return soundNames[rnd];
	}
}
