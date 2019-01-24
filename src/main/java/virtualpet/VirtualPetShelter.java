package virtualpet;

import java.util.HashMap;

public class VirtualPetShelter {

	private HashMap<String, VirtualPet> petList = new HashMap<String, VirtualPet>();
	
	private int cageCleanliness = 100;
	
	//Constructor
	public VirtualPetShelter() {
		
	}
	
	// Method
	public void addVirtualPet(VirtualPet petToAdd) {
		petList.put(petToAdd.getName(), petToAdd);
	}
	
	public int getVirtualPetCount() {
		return petList.size();
	}
	
	//Accessor method
	public int getCageCleanliness() {
		
		return cageCleanliness;
	}
	
	public HashMap<String, VirtualPet> getVirtualPets() {
		return petList;
	}

	public VirtualPet get(String initPrompt) {
		return petList.get(initPrompt);
	}
	
}
