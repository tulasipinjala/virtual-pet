package virtualpet;

public class VirtualPet {
	// Properties
	private String name;
	private int hunger = 100;
	private int boredom = 100;
	private int health = 100;
	private int dirty = 100;


	// Constructor
	public VirtualPet(String name) {
		this.name = name;
	}

	// Method
	public void tick (int time) {
		hunger -= time;
		boredom -= time;
		health -= time;
		if (hunger < 0 || boredom < 0 || health < 0) {
			System.out.println("Your pet has fainted");
			System.exit(0);
		}
	}
	public void feed() {
		// Increase distance from 0 hunger
		hunger += 50;
	}
	public void play() {
		// Must play with your pet
		boredom += 50;
	}
	public void checkup() {
		// Increase distance from 0 hunger
		health += 50;
	}
	public void clean() {
		// Increase distance from 0 dirty
		dirty += 50;
	}
//Accessor methods
	public String getName() {
		return name;
	}

	public int getHunger() {
		return hunger;
	}

	public int getBoredom() {
		return boredom;
	}

	public int getHealth() {
		return health;
	}
	public int getDirty() {
		return dirty;
	}
	public void getStatus() {
		System.out.println(name + "\n Hunger is at " + hunger
				+ "\n Boredom is at " + boredom
				+ "\n Health is at " + health
				+ "\n Dirty is at " + dirty);
	}

 
	
		
		
}


