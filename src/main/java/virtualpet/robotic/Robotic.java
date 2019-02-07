package virtualpet.robotic;

import java.io.File;
import java.util.Random;

import virtualpet.VirtualPet;
import virtualpet.extras.MakeSound;


public abstract class Robotic extends VirtualPet {
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
				+ "\n Fragmentation is at " + fragmentation + "\n Cleanliness is at " + getCleanliness());
	}

	public void getStatusChange() {
		System.out.println(getName() + " - " + getClass().getSimpleName()
				+ "\n Cleanliness \t" + barMaker(getCleanliness()) 
				+ "\n Boredom \t" + barMaker(getBoredom())
				+ "\n Charge \t" + barMaker(charge) 
				+ "\n Fragmentation \t" + barMaker(fragmentation));
	}

	// constructor
	public Robotic(String name) {
		super(name);
		charge = 1000;
		fragmentation = 1500;

		prevCharge = 1000;
		prevFragmentation = 1500;

	}

	public void tick(int time) {
		super.tick(time);
		fragmentation -= time;
		charge -= time;
	}

	public void plugin() { // Increase distance from 0 health
		charge += 500;
		charge = enforceMaxValue(charge);
	}

	public void defrag() { // Increase distance from 0 Cleanliness
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

	public void setSound(String roboticType) { //setter for sounds
		soundRobotic = roboticType;
	}
	
	public void checkLowValue() {
		int warningIndex = 300;
		boolean cleanlinessFlag = (getCleanliness() < warningIndex);
		boolean boredomFlag = (getBoredom() < warningIndex);
		boolean chargeFlag = (charge < warningIndex); 
		boolean fragmentationFlag = (fragmentation < warningIndex);
		String warningList = "";
		boolean notFirstCounter = false;
		if (cleanlinessFlag) {
			warningList = warningList + "Cleanliness";
			notFirstCounter = true;
		}
		if (boredomFlag) {
			if (notFirstCounter) warningList = warningList + " , ";
			warningList = warningList + "Boredom";
			notFirstCounter = true;
		}
		if (chargeFlag) {
			if (notFirstCounter) warningList = warningList + " , ";
			warningList = warningList + "Charge";
			notFirstCounter = true;
		}
		if (fragmentationFlag) {
			if (notFirstCounter) warningList = warningList + " , ";
			warningList = warningList + "Fragmentation";
			notFirstCounter = true;
		}

		if (cleanlinessFlag || boredomFlag || chargeFlag|| fragmentationFlag) {
		System.out.println(getName() + " is low on: " + warningList);
		}
	}
	
	public void checkDeathValue() {
		if (getCleanliness() <= 0 || getBoredom() <= 0 ||  charge <= 0 || fragmentation <= 0) {
			System.out.println(getName() + " has been adopted by the Terminator.");
			super.die();
		}
	}
}
