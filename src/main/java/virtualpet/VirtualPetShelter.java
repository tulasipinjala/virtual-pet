package virtualpet;

import java.util.Collection;
import java.util.HashMap;

public class VirtualPetShelter {

	private HashMap<String, VirtualPet> petList = new HashMap<String, VirtualPet>();

	private int cageCleanliness = 100;

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
			specificPet.feed();

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
			specificPet.water();

		}
	}

	public void checkupAll() {
		for (VirtualPet specificPet : petList.values()) {
			specificPet.checkup();

		}
	}

	public void tickAll(int time) {
		for (VirtualPet specificPet : petList.values()) {
			specificPet.tick(time);
		}
	}

	public void statusAll() {
		for (VirtualPet specificPet : petList.values()) {
			specificPet.getStatus();
			System.out.println("");
		}
	}

	public void updatePrevPropertiesAll() {
		for (VirtualPet specificPet : petList.values()) {
			specificPet.updatePrevProperties();
		}
	}

	public void nameAll() {
		for (VirtualPet specificPet : petList.values()) {
			System.out.println(specificPet.getName());
		}
	}

	public void statusChangeAll() {
		for (VirtualPet specificPet : petList.values()) {
			specificPet.getStatusChange();
			System.out.println("");
		}
	}

}
