package virtualpet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class VirtualPetShelter {

	private HashMap<String, VirtualPet> petList = new HashMap<String, VirtualPet>();

	private int cageCleanliness = 1000;

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
		cageCleanliness -= time;
		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Organic) {
				((Organic) specificPet).tick(time);
			} else if (specificPet instanceof Robotic) {
				((Robotic) specificPet).tick(time);
			}
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

	public void nameAll() {
		for (VirtualPet specificPet : petList.values()) {
			System.out.println(specificPet.getName());
		}
	}

	public void nameAllOrganic() {
		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Organic) {
				System.out.println(specificPet.getName());
			}
		}
	}

	public void nameAllRobotic() {
		for (VirtualPet specificPet : petList.values()) {
			if (specificPet instanceof Robotic) {
				System.out.println(specificPet.getName());
			}
		}
	}

	public void statusChangeAll() {
		List<VirtualPet> petsByName = new ArrayList<>(petList.values());

		Collections.sort(petsByName, Comparator.comparing(VirtualPet::getName));
		
		Boolean noneCheckOrganic = true; 
		Boolean noneCheckRobotic = true;
		
		System.out.println("Cage Cleanliness is at " + cageCleanliness);
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
	
}
