package virtualpet;

public class VirtualPet {
	// Properties
	private String nameRaw;
	private int hunger = 100;
	private int boredom = 100;
	private int health = 100;
	private int dirty = 100;
	private int thirst = 100;

	private boolean organic = true;

	private int prevHunger = 100;
	private int prevBoredom = 100;
	private int prevHealth = 100;
	private int prevDirty = 100;
	private int prevThirst = 100;
	private String name;

	// Constructor
	public VirtualPet(String name) {
		this.nameRaw = name;
		this.name = printCapitalizedVersion(nameRaw);
	}

	// Method
	public void tick(int time) {
		hunger -= time;
		boredom -= time;
		health -= time;
		thirst -= time;
		dirty -= time;
		if (hunger < 0 || boredom < 0 || health < 0 || thirst < 0|| dirty < 0) {
			System.out.println("Your pet has fainted");
			System.exit(0);
		}
	}

	public void feed() { // Increase distance from 0 hunger
		hunger += 50;
	}

	public void play() { // Must play with your pet
		boredom += 50;
	}

	public void checkup() { // Increase distance from 0 hunger
		health += 50;
	}

	public void clean() { // Increase distance from 0 dirty
		dirty += 50;
	}

	public void water() { // Increase distance from 0 dirty
		thirst += 50;
	}
	
	

	public void updatePrevProperties() {
		prevHunger = hunger;
		prevBoredom = boredom;
		prevHealth = health;
		prevDirty = dirty;
		prevThirst = thirst;
	}

	// Accessor method
	public String getName() {
		return name;
	}

	public boolean getOrganic() {
		return organic;
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

	public int getThirst() {
		return thirst;
	}
	public void getStatus() {
		System.out.println(name + "\n Hunger is at " + hunger
				+ "\n Boredom is at " + boredom
				+ "\n Health is at " + health
				+ "\n Dirty is at " + dirty
				+ "\n Thirst is at " + thirst);
	}

//	public void getStatusChange() {
//		System.out.println(name + "\n Hunger \t" + prevHunger + "\t" 
//					+ appropriateArrow(prevHunger, hunger) + "\t" + hunger
//				+ "\n Boredom \t" + prevHunger + "\t" 
//				+ appropriateArrow(prevBoredom, boredom) + "\t"+ boredom
//				+ "\n Health \t" + prevHealth + "\t" 
//				+ appropriateArrow(prevHealth, health) + "\t"+ health
//				+ "\n Dirty \t \t" + prevDirty + "\t" 
//				+ appropriateArrow(prevDirty, dirty) + "\t"+ dirty);
//	}

	public void getStatusChange() {
	System.out.println(name + "\n Hunger \t" + prevHunger + "\t" 
				+ "=>" + "\t" + hunger
			+ "\n Boredom \t" + prevHunger + "\t" 
			+ "=>" + "\t"+ boredom
			+ "\n Health \t" + prevHealth + "\t" 
			+ "=>" + "\t"+ health
			+ "\n Dirty \t\t" + prevDirty + "\t" 
			+ "=>" + "\t"+ dirty
			+ "\n Thirst \t" + prevThirst + "\t" 
			+ "=>" + "\t"+ thirst);
}

	// special methods
	private static String printCapitalizedVersion(String message) {
		String[] messageSplit = message.trim().split("\\s+");
		if (messageSplit.length == 1) {
			return message.substring(0, 1).toUpperCase() + message.substring(1).toLowerCase();
		} else {
			String longName = "";
			for (int i = 0; i < message.trim().split("\\s+").length; i++) {
				longName = longName + " " + messageSplit[i].substring(0, 1).toUpperCase() + messageSplit[i].substring(1).toLowerCase();
			}
			return longName;
		}
	}

//	private String appropriateArrow(int int1, int int2) {
//		if (int1 > int2) {
//			return "\u2193";
//		} else if (int1 < int2){
//			return "\u2191";
//		} else {
//			return "=";
//		}
//	}

}
