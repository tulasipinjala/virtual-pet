package virtualpet;

public class VirtualPet {
	// Properties
	private String nameRaw;
	private int hunger;
	private int boredom;
	private int health;
	private int dirty;
	private int thirst;

	private int prevHunger;
	private int prevBoredom;
	private int prevHealth;
	private int prevDirty;
	private int prevThirst;
	private String name;

	// Accessor method
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

	public int getThirst() {
		return thirst;
	}

	public void getStatus() {
		System.out.println(name + "\n Hunger is at " + hunger + "\n Boredom is at " + boredom + "\n Health is at "
				+ health + "\n Dirty is at " + dirty + "\n Thirst is at " + thirst);
	}

	public void getStatusChange() {
		System.out.println(name + "\n Hunger \t" + prevHunger + "\t" + "=>" + "\t" + hunger + "\n Boredom \t"
				+ prevBoredom + "\t" + "=>" + "\t" + boredom + "\n Health \t" + prevHealth + "\t" + "=>" + "\t" + health
				+ "\n Dirty \t\t" + prevDirty + "\t" + "=>" + "\t" + dirty + "\n Thirst \t" + prevThirst + "\t" + "=>"
				+ "\t" + thirst);

	}

	// Constructor
	public VirtualPet(String name) {
		this.nameRaw = name;
		this.name = printCapitalizedVersion(nameRaw);
		hunger = 1000;
		boredom = 1000;
		health = 1000;
		dirty = 1000;
		thirst = 1000;

		prevHunger = 1000;
		prevBoredom = 1000;
		prevHealth = 1000;
		prevDirty = 1000;
		prevThirst = 1000;
	}

	// Method
	public void tick(int time) {
		hunger -= time;
		boredom -= time;
		health -= time;
		thirst -= time;
		dirty -= time;
		if (hunger < 0 || boredom < 0 || health < 0 || thirst < 0 || dirty < 0) {
			System.out.println(getName() + " has fainted");
		}
	}

	public void feed() { // Increase distance from 0 hunger
		hunger += 500;
	}

	public void play() { // Must play with your pet
		boredom += 500;
	}

	public void checkup() { // Increase distance from 0 hunger
		health = 1500;
	}

	public void clean() { // Increase distance from 0 dirty
		dirty += 500;
	}

	public void water() { // Increase distance from 0 dirty
		thirst += 500;
	}

	public void updatePrevProperties() {
		prevHunger = hunger;
		prevBoredom = boredom;
		prevHealth = health;
		prevDirty = dirty;
		prevThirst = thirst;
	}

	// special methods
	private static String printCapitalizedVersion(String message) {
		String[] messageSplit = message.trim().split("\\s+");
		if (messageSplit.length == 1) {
			return message.substring(0, 1).toUpperCase() + message.substring(1).toLowerCase();
		} else {
			String longName = "";
			for (int i = 0; i < messageSplit.length; i++) {
				longName = longName + " " + messageSplit[i].substring(0, 1).toUpperCase()
						+ messageSplit[i].substring(1).toLowerCase();
			}
			return longName;
		}
	}

}


