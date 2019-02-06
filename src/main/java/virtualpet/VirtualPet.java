package virtualpet;

public abstract class VirtualPet {
	// Properties
	private String nameRaw;
	private int boredom;
	private int cleanliness;
	private String directory = System.getProperty("user.dir").replace("\\", "\\\\");
	private boolean deathFlag; // default is false

	private int prevBoredom;
	private int prevCleanliness;
	private String name;
	public boolean Organic;

	// Accessor method
	public String getName() {
		return name;
	}

	public int getBoredom() {
		return boredom;
	}

	public int getCleanliness() {
		return cleanliness;
	}

	public String getDirectory() {
		return directory;
	}

	public int getPrevBoredom() {
		return prevBoredom;
	}

	public int getPrevCleanliness() {
		return prevCleanliness;
	}

	public boolean getDeathFlag() {
		return deathFlag;
	}

	// Constructor
	public VirtualPet(String name) {
		this.nameRaw = name;
		this.name = printCapitalizedVersion(nameRaw);
		boredom = 1000;
		cleanliness = 1000;

		prevBoredom = 1000;
		prevCleanliness = 1000;
	}

	// Method
	public void tick(int time) {
		boredom -= time;
		cleanliness -= time;		
		
	}
	
	public void tickCage(int cageCleanliness, int time) {
		if (cageCleanliness < 150) {
			cleanliness -= time*15;	
		} else if (cageCleanliness < 600) {
			cleanliness -= time*5;
		}
	}

	public void play() { // Must play with your pet
		boredom += 500;
		boredom = enforceMaxValue(boredom);
	}

	public void clean() { // Increase distance from 0 cleanliness
		cleanliness += 500;
		cleanliness = enforceMaxValue(cleanliness);
	}

	public void die() {
		deathFlag = true;
	}

	public void updatePrevProperties() {

		prevBoredom = boredom;
		prevCleanliness = cleanliness;

	}

	public int enforceMaxValue(int value) {
		if (value > 1500) {
			value = 1500;
		}
		return value;
	}

	// special methods
	public static String barMaker(int stat) {
		String littleSpaces;
		int activeBars = Math.round(stat / 75);
		int inactiveBars = 20 - activeBars;
		int percent = Math.round(stat / 15);
		String littleTicks = new String(new char[activeBars]).replace("\0", "-");

		if (inactiveBars <= 0) {
			littleSpaces = "";
		} else {
			littleSpaces = new String(new char[inactiveBars]).replace("\0", " ");
		}
		String statusBar = "|" + littleTicks + littleSpaces + "| " + percent + "%";
		return statusBar;
	}

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
