package virtualpet;

import java.util.Random;

public class Organic extends VirtualPet {
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
				+ health + "\n Dirty is at " + getDirty() + "\n Thirst is at " + thirst);
	}

	public void getStatusChange() {
		System.out.println(getName() 
				+ "\n Hunger \t" + barMaker(hunger) 
				+ "\n Boredom \t" + barMaker(getBoredom())
				+ "\n Health \t" + barMaker(health)
				+ "\n Dirty \t\t" + barMaker(getDirty()) 
				+ "\n Thirst \t" + barMaker(thirst));
	}

	//constructor
	public Organic(String name) {
		super(name);
		hunger = 1000;
		health = 1000;
		thirst = 1000;
		soundOrganic = getRandomSound();
		
		prevHunger = 1000;
		prevHealth = 1000;
		prevThirst = 1000;	
	}
	
	public void tick(int time) {
		super.tick(time);
		hunger -= time;
		health -= time;
		thirst -= time;
		
		if (hunger < 0 || getBoredom() < 0 || health < 0 || thirst < 0|| getDirty() < 0) {
			System.out.println("Your pet has fainted");
			System.exit(0);
		}
	}
	public void feed() { // Increase distance from 0 hunger
		hunger += 500;
	}
	
	public void checkup() { // Increase distance from 0 health
		health = 1500;
	}
	
	public void water() { // Increase distance from 0 dirty
		thirst += 500;
	}
	
	public void roar() {
		MakeSound.playSound(getDirectory() + "\\soundfiles\\" + soundOrganic + ".wav");
	}
	
	public void updatePrevProperties() {
		
		super.updatePrevProperties();
		prevHunger = hunger;
		prevHealth = health;
		prevThirst = thirst;
	}
	
	public static String getRandomSound() {
		String[] soundNames = {"bulbasaur","charmander","squirtle","caterpie", "pikachu", "weedle"};
	    int rnd = new Random().nextInt(soundNames.length);
	    return soundNames[rnd];
	}


}
