package virtualpet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import virtualpet.organic.Organic;
import virtualpet.robotic.Robotic;

public class VirtualPetShelter {

	private HashMap<String, VirtualPet> petList = new HashMap<String, VirtualPet>();

	private int cageCleanliness = 1500; // change
	private boolean cageLowWarningCounter = true;
	private boolean cageDeathWarningCounter = true;

	// Accessor method
	public int getCageCleanliness() {
		return cageCleanliness;
	}

	public HashMap<String, VirtualPet> getVirtualPets() {
		return petList;
	}

	public VirtualPet getPet(String initPrompt) {
		return petList.get(initPrompt);
	}

	// Constructor
	public VirtualPetShelter() {

	}

	// Method
	public void cleanCage() {
		cageCleanliness = 1500;
	}

	public void addVirtualPet(VirtualPet petToAdd) {
		petList.put(petToAdd.getName(), petToAdd);
	}

	public void adoptVirtualPet(String petToAdopt) {
		petList.remove(petToAdopt);
	}

	public int getVirtualPetCount() {
		return petList.size();
	}

	public void feedAll() {
		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Organic) {
				((Organic) specificPet).feed();
			}

		}
	}

	public void cleanAll() {
		cleanCage();
		for (VirtualPet specificPet : petList.values()) {
			specificPet.clean();

		}
	}

	public void playAll() {
		for (VirtualPet specificPet : petList.values()) {
			specificPet.play();

		}
	}

	public void waterAll() {
		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Organic) {
				((Organic) specificPet).water();
			}

		}
	}

	public void checkupAll() {
		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Organic) {
				((Organic) specificPet).checkup();
			}

		}
	}

	public void pluginAll() {
		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Robotic) {
				((Robotic) specificPet).plugin();
			}

		}
	}

	public void defragAll() {
		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Robotic) {
				((Robotic) specificPet).defrag();
			}

		}
	}

	public void tickAll(int time) {
		cageCleanliness -= time; // changes
		cageCleanliness = enforceLowValue(cageCleanliness);
		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Organic) {
				((Organic) specificPet).tick(time);
			} else if (specificPet instanceof Robotic) {
				((Robotic) specificPet).tick(time);
			}
			specificPet.tickCage(cageCleanliness, time);
		}

	}

	public void statusAll() {
		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Organic) {
				((Organic) specificPet).getStatus();
				System.out.println("");
			} else if (specificPet instanceof Robotic) {
				((Robotic) specificPet).getStatus();
				System.out.println("");
			}
		}
	}

	public void updatePrevPropertiesAll() {
		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Organic) {
				((Organic) specificPet).updatePrevProperties();
			} else if (specificPet instanceof Robotic) {
				((Robotic) specificPet).updatePrevProperties();
			}
		}

	}

	public String nameAll(Scanner input) {
		int counter;
		String userPetChoice;
		HashMap<Integer, String> numberWithPet = new HashMap<Integer, String>();

		while (true) {
			counter = 1;
			for (VirtualPet specificPet : petList.values()) {
				System.out.println(counter + ". " + specificPet.getName());
				numberWithPet.put(counter, specificPet.getName());
				counter++;
			}
			System.out.println(counter + ". All");
			numberWithPet.put(counter, "All");
			System.out.println("");
			userPetChoice = printCapitalizedVersion(input.nextLine());

			if (isNumeric(userPetChoice)) {
				if (numberWithPet.containsKey(Integer.parseInt(userPetChoice))) {
					userPetChoice = numberWithPet.get(Integer.parseInt(userPetChoice));
					break;
				} else {
					System.out.println("Please pick a better number.");
				}
			} else {
				break;
			}
		}
		return userPetChoice;
	}
	
	public String nameAllCage(Scanner input) {
		int counter;
		String userPetChoice;
		HashMap<Integer, String> numberWithPet = new HashMap<Integer, String>();

		while (true) {
			counter = 1;
			for (VirtualPet specificPet : petList.values()) {
				System.out.println(counter + ". " + specificPet.getName());
				numberWithPet.put(counter, specificPet.getName());
				counter++;
			}
			System.out.println(counter + ". Cages");
			numberWithPet.put(counter, "Cages");
			counter++;
			System.out.println(counter + ". All");
			numberWithPet.put(counter, "All");
			System.out.println("");
			userPetChoice = printCapitalizedVersion(input.nextLine());

			if (isNumeric(userPetChoice)) {
				if (numberWithPet.containsKey(Integer.parseInt(userPetChoice))) {
					userPetChoice = numberWithPet.get(Integer.parseInt(userPetChoice));
					break;
				} else {
					System.out.println("Please pick a better number.");
				}
			} else {
				break;
			}
		}
		return userPetChoice;
	}

	public String nameAllOrganic(Scanner input) {
		int counter;
		String userPetChoice;
		HashMap<Integer, String> numberWithPet = new HashMap<Integer, String>();

		while (true) {
			counter = 1;
			for (VirtualPet specificPet : petList.values()) {
				if (specificPet instanceof Organic) {
					System.out.println(counter + ". " + specificPet.getName());
					numberWithPet.put(counter, specificPet.getName());
					counter++;
				}
			}
			System.out.println(counter + ". All");
			numberWithPet.put(counter, "All");
			System.out.println("");
			userPetChoice = printCapitalizedVersion(input.nextLine());

			if (isNumeric(userPetChoice)) {
				if (numberWithPet.containsKey(Integer.parseInt(userPetChoice))) {
					userPetChoice = numberWithPet.get(Integer.parseInt(userPetChoice));
					break;
				} else {
					System.out.println("Please pick a better number.");
				}
			}
		}
		return userPetChoice;
	}
	
	public String nameAllRobotic(Scanner input) {
		int counter;
		String userPetChoice;
		HashMap<Integer, String> numberWithPet = new HashMap<Integer, String>();

		while (true) {
			counter = 1;
			for (VirtualPet specificPet : petList.values()) {
				if (specificPet instanceof Robotic) {
					System.out.println(counter + ". " + specificPet.getName());
					numberWithPet.put(counter, specificPet.getName());
					counter++;
				}
			}
			System.out.println(counter + ". All");
			numberWithPet.put(counter, "All");
			System.out.println("");
			userPetChoice = printCapitalizedVersion(input.nextLine());

			if (isNumeric(userPetChoice)) {
				if (numberWithPet.containsKey(Integer.parseInt(userPetChoice))) {
					userPetChoice = numberWithPet.get(Integer.parseInt(userPetChoice));
					break;
				} else {
					System.out.println("Please pick a better number.");
				}
			}
		}
		return userPetChoice;
	}

	public String nameAllAdopt(Scanner input) {
		int counter;
		String userPetChoice;
		HashMap<Integer, String> numberWithPet = new HashMap<Integer, String>();

		while (true) {
			counter = 1;
			for (VirtualPet specificPet : petList.values()) {
				System.out.println(counter + ". " + specificPet.getName());
				numberWithPet.put(counter, specificPet.getName());
				counter++;
			}
			System.out.println("");
			userPetChoice = printCapitalizedVersion(input.nextLine());

			if (isNumeric(userPetChoice)) {
				if (numberWithPet.containsKey(Integer.parseInt(userPetChoice))) {
					userPetChoice = numberWithPet.get(Integer.parseInt(userPetChoice));
					break;
				} else {
					System.out.println("Please pick a better number.");
				}
			}
		}
		return userPetChoice;
	}
	
	public void checkLowValueAll() {

		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Organic) {
				((Organic) specificPet).checkLowValue();
			}
			if (specificPet instanceof Robotic) {
				((Robotic) specificPet).checkLowValue();
			}
		}

		if (cageCleanliness < 150) {
			if (cageDeathWarningCounter) {
				System.out.println("Your cage is very dirty! Clean your cage ASAP!");
				cageDeathWarningCounter = false;
			}
		} else if (cageCleanliness < 600) {
			if (cageLowWarningCounter) {
				System.out.println("Your cage is getting dirty! This will affect the cleanliness of your pet!");
				cageLowWarningCounter = false;
			}
		} else {
			cageDeathWarningCounter = true;
			cageLowWarningCounter = true;
		}

	}

	public void checkDeathValueAll() {
		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Organic) {
				((Organic) specificPet).checkDeathValue();
			}
			if (specificPet instanceof Robotic) {
				((Robotic) specificPet).checkDeathValue();
			}
		}
	}

	public void adoptDeadPets() {
		List<String> toRemove = new ArrayList<String>();

		for (VirtualPet specificPet : petList.values()) {
			if (specificPet.getDeathFlag()) {
				toRemove.add(specificPet.getName());
			}
		}
		if (toRemove != null) {
			for (String deadNames : toRemove) {
				adoptVirtualPet(deadNames);
			}
		}
	}

	public void statusChangeAll() {
		List<VirtualPet> petsByName = new ArrayList<>(petList.values());

		Collections.sort(petsByName, Comparator.comparing(VirtualPet::getName));

		Boolean noneCheckOrganic = true;
		Boolean noneCheckRobotic = true;

		System.out.println("Cage Cleanliness\t" + VirtualPet.barMaker(cageCleanliness));
		System.out.println();
		System.out.println("Organic:");
		for (VirtualPet specificPet : petsByName) {
			if (specificPet instanceof Organic) {
				((Organic) specificPet).getStatusChange();
				((Organic) specificPet).roar();
				System.out.println("");
				noneCheckOrganic = false;
			}
		}
		if (noneCheckOrganic) {
			System.out.println("none");
			System.out.println();
		}

		System.out.println("Robotic:");
		for (VirtualPet specificPet : petsByName) {
			if (specificPet instanceof Robotic) {
				((Robotic) specificPet).getStatusChange();
				((Robotic) specificPet).soundEffect();
				System.out.println("");
				noneCheckRobotic = false;
			}
		}
		if (noneCheckRobotic) {
			System.out.println("none");
			System.out.println();
		}
	}

	public int enforceLowValue(int value) {
		if (value < 0) {
			value = 0;
		}
		return value;
	}

	public void removeDeadPets() {
		checkDeathValueAll();
		adoptDeadPets();
	}

	public void endTurn() {
		statusChangeAll();
		checkLowValueAll();
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

	public static boolean isNumeric(String strNum) {
		try {
			int d = Integer.parseInt(strNum);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}

}
