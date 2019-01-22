package virtualpet;

public class VirtualPet {
	// Properties
	private String name;
	private int hunger = 100;
	private int boredom = 100;
	private int health = 100;

	// Constructor
	public VirtualPet(String name) {
		this.name = name;
	}

	// Method
	public void tick (int time) {
		hunger -= time;
		boredom -= time;
		health -= time;
	}
	public void feed() {
		// Increase distance from 0 hunger
		hunger += 50;
	}
	public void play() {
		// Must play with your pet
		boredom += 50;
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
 

		
		
}


