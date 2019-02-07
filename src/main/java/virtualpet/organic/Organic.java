package virtualpet.organic;

import java.io.File;
import java.util.Random;

import virtualpet.VirtualPet;
import virtualpet.extras.MakeSound;

public abstract class Organic extends VirtualPet {
	private int hunger;
	private int health;
	private int thirst;
	private String soundOrganic;

	
	private int prevHunger;
	private int prevHealth;
	private int prevThirst;
	
	public int getHunger() {
		return hunger;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getThirst() {
		return thirst;
	}

	public void getStatus() {
		System.out.println(getName() + "\n Hunger is at " + hunger + "\n Boredom is at " + getBoredom() + "\n Health is at "
				+ health + "\n Cleanliness is at " + getCleanliness() + "\n Thirst is at " + thirst);
	}

	public void getStatusChange() {
		System.out.println(getName() + " - " + getClass().getSimpleName()
				+ "\n Cleanliness \t" + barMaker(getCleanliness()) 
				+ "\n Boredom \t" + barMaker(getBoredom())
				+ "\n Health \t" + barMaker(health)
				+ "\n Hunger \t" + barMaker(hunger) 
				+ "\n Thirst \t" + barMaker(thirst));
	}

	//constructor
	public Organic(String name) {
		super(name);
		hunger = 1000;
		health = 1000;
		thirst = 1000;
		
		prevHunger = 1000;
		prevHealth = 1000;
		prevThirst = 1000;	
	}
	
	public void tick(int time) {
		super.tick(time);
		hunger -= time;
		health -= time;
		thirst -= time;
		
		
	}
	public void feed() { // Increase distance from 0 hunger
		hunger += 500;
		hunger = enforceMaxValue(hunger);
	}
	
	public void checkup() { // Increase distance from 0 health
		health = 1500;
	}
	
	public void water() { // Increase distance from 0 cleanliness
		thirst += 500;
		thirst = enforceMaxValue(thirst);
	}
	
	public void roar() {
		MakeSound.playSound(getDirectory() + File.separator + "soundfiles" + File.separator + soundOrganic + ".wav");
	}
	
	//Instead of using a setter, we would've needed to write 6 additional methods for each subclass setting the
	// soundOrganic variable to a particular value and then calling the method in the subclass constructor
	public void setSound(String organicType) {
		soundOrganic = organicType;
	}

	public void updatePrevProperties() {
		
		super.updatePrevProperties();
		prevHunger = hunger;
		prevHealth = health;
		prevThirst = thirst;
	}
	
	/*public static String getRandomSound() {
		String[] soundNames = {"dog","dolphin","hawk","lion", "wolf"};
	    int rnd = new Random().nextInt(soundNames.length);
	    return soundNames[rnd];
	}*/

	public void checkLowValue() {
		int warningIndex = 300;
		boolean cleanlinessFlag = (getCleanliness() < warningIndex);
		boolean boredomFlag = (getBoredom() < warningIndex);
		boolean healthFlag = (health < warningIndex); 
		boolean hungerFlag = (hunger < warningIndex);
		boolean thirstFlag = (thirst < warningIndex);
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
		if (healthFlag) {
			if (notFirstCounter) warningList = warningList + " , ";
			warningList = warningList + "Health";
			notFirstCounter = true;
		}
		if (hungerFlag) {
			if (notFirstCounter) warningList = warningList + " , ";
			warningList = warningList + "Hunger";
			notFirstCounter = true;
		}
		if (thirstFlag) {
			if (notFirstCounter) warningList = warningList + " , ";
			warningList = warningList + "Thirst";
			notFirstCounter = true;
		}
		if (cleanlinessFlag || boredomFlag || healthFlag  || hungerFlag|| thirstFlag) {
		System.out.println(getName() + " is low on: " + warningList);
		}
	}
	
	public void checkDeathValue() {
		if (getCleanliness() <= 0 || getBoredom() <= 0 ||  health <= 0 || hunger <= 0 ||  thirst <= 0) {
			System.out.println(getName() + " has been adopted by the Grim Reaper.");
			super.die();
		}
	}

}
