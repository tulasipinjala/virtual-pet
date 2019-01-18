package main;

public class VirtualPet {
	// Properties 
	private int hunger;
	private int boredom;
	
	// Constructor
	public VirtualPet(int hunger, int boredom) {
		this.hunger = hunger;
		this.boredom = boredom;
	}
	
	// Method
	public void feed() {
		// Increase distance from 0 hunger
		hunger -= 20;
	}
}
