package virtualpet;

import java.util.Collection;
import java.util.HashMap;

public class VirtualPetShelter {

	private HashMap<String, VirtualPet> petList = new HashMap<String, VirtualPet>();

	private int cageCleanliness = 100;

	// Constructor
	public VirtualPetShelter() {

	}

	// Method
	public void addVirtualPet(VirtualPet petToAdd) {
		petList.put(petToAdd.getName(), petToAdd);
	}

	public int getVirtualPetCount() {
		return petList.size();
	}

	// Accessor method
	public int getCageCleanliness() {

		return cageCleanliness;
	}

	public HashMap<String, VirtualPet> getVirtualPets() {
		return petList;
	}

	public VirtualPet get(String initPrompt) {
		return petList.get(initPrompt);
	}

	public void feedAll() {
		Collection<VirtualPet> Pets = getVirtualPets().values();
		for (VirtualPet specificPet : Pets) {
			specificPet.feed();

		}
	}

	public void cleanAll() {
		Collection<VirtualPet> Pets = getVirtualPets().values();
		for (VirtualPet specificPet : Pets) {
			specificPet.clean();

		}
	}

	public void playAll() {
		Collection<VirtualPet> Pets = getVirtualPets().values();
		for (VirtualPet specificPet : Pets) {
			specificPet.play();

		}
	}

	public void waterAll() {
		Collection<VirtualPet> Pets = getVirtualPets().values();
		for (VirtualPet specificPet : Pets) {
			specificPet.water();

		}
	}

	public void checkupAll() {
		Collection<VirtualPet> Pets = getVirtualPets().values();
		for (VirtualPet specificPet : Pets) {
			specificPet.checkup();

		}
	}

	public void statusAll() {
		Collection<VirtualPet> Pets = getVirtualPets().values();
		for (VirtualPet specificPet : Pets) {
			specificPet.getStatus();
            System.out.println("");
		}
	}
	public void statusChangeAll() {
		Collection<VirtualPet> Pets = getVirtualPets().values();
		for (VirtualPet specificPet : Pets) {
			specificPet.getStatusChange();
            System.out.println("");
		}
	}
	
	public void nameAll() {
		Collection<VirtualPet> Pets = getVirtualPets().values();
		for (VirtualPet specificPet : Pets) {
            System.out.println(specificPet.getName());
		}
	}

}
