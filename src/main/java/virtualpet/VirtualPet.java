package virtualpet;

public abstract class VirtualPet {
	// Properties
	private String nameRaw;
	private int boredom;
	private int dirty;
	private String directory = System.getProperty("user.dir").replace("\\", "\\\\");

	private int prevBoredom;
	private int prevDirty;
	private String name;
	public boolean Organic;

	// Accessor method
	public String getName() {
		return name;
	}

	public int getBoredom() {
		return boredom;
	}

	public int getDirty() {
		return dirty;
	}

	public String getDirectory() {
		return directory;
	}
	
	public int getPrevBoredom() {
		return prevBoredom;
	}

	public int getPrevDirty() {
		return prevDirty;
	}

	// Constructor
	public VirtualPet(String name) {
		this.nameRaw = name;
		this.name = printCapitalizedVersion(nameRaw);
		boredom = 1000;
		dirty = 1000;

		prevBoredom = 1000;
		prevDirty = 1000;
	}

	// Method
	public void tick(int time) {
		boredom -= time;
		dirty -= time;
	}

	public void play() { // Must play with your pet
		boredom += 500;
	}

	public void clean() { // Increase distance from 0 dirty
		dirty += 500;
	}

	
	public void updatePrevProperties() {
		
		prevBoredom = boredom;
		prevDirty = dirty;
		
	}

	// special methods
	public String barMaker(int stat) {
		String littleSpaces;
		int activeBars = Math.round(stat/75);
		int inactiveBars = Math.round((1500-stat)/75);
		int percent = Math.round(stat/15);
		String littleTicks = new String(new char[activeBars]).replace("\0", "-");
		if (inactiveBars <1) {
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
