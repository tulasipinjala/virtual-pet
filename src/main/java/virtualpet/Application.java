package virtualpet;

import java.util.Collection;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter virtualPetShelter = new VirtualPetShelter();

		// This section determines pet;
		// chooses a pet name; allows user to choose help to find a list of commands
		String commands = "Commands\n Adopt - adopt a pet\n" 
				+ " Organic - choosing an animal pet\n"
				+ " Robotic - choosing a robot pet\n" 
				+ " Feed <petname> - feeds your pet\n"
				+ " Play <petname> - plays with your pet\n"
				+ " Vet <petname> - Takes your pet to the vet to improve health\n"
				+ " Adopt <petname> - This removes your pet from the shelter. THIS WILL BE PERMANENT.\n"
				+ " Clean <petname> - Cleans your pet and its space\n" + " Exit - Exits VPet";
		System.out.println("Please type in your first pet's name. Type \"help\" for list of commands.");
		String initPrompt = input.nextLine();

		if (initPrompt.toLowerCase().equals("help")) {
			System.out.println(commands);
			System.out.println("Please type in your pet's name");
			initPrompt = input.nextLine();
		}

		virtualPetShelter.addVirtualPet(new VirtualPet(initPrompt));
		System.out.println("Your pet's name is " + virtualPetShelter.get(printCapitalizedVersion(initPrompt)).getName());

		System.out.println("What would you like to do?");

		String userAction = input.nextLine();
		while (true) {
			if (userAction.trim().split("\\s+")[0].equalsIgnoreCase("feed")) {
				virtualPetShelter.get(printCapitalizedVersion(userAction.trim().split("\\s+")[1])).feed();
				
				Collection<VirtualPet> Pets = virtualPetShelter.getVirtualPets().values();
		        for (VirtualPet specificPet : Pets) {
		        		specificPet.getStatusChange();
		        		System.out.println("");
		        }
			} else if (userAction.trim().split("\\s+")[0].equalsIgnoreCase("clean")) {
				virtualPetShelter.get(printCapitalizedVersion(userAction.trim().split("\\s+")[1])).clean();
				virtualPetShelter.get(printCapitalizedVersion(userAction.trim().split("\\s+")[1])).getStatusChange();
			} else if (userAction.trim().split("\\s+")[0].equalsIgnoreCase("checkup")) {
				virtualPetShelter.get(printCapitalizedVersion(userAction.trim().split("\\s+")[1])).checkup();
				virtualPetShelter.get(printCapitalizedVersion(userAction.trim().split("\\s+")[1])).getStatusChange();
			} else if (userAction.trim().split("\\s+")[0].equalsIgnoreCase("play")) {
				virtualPetShelter.get(printCapitalizedVersion(userAction.trim().split("\\s+")[1])).play();
				virtualPetShelter.get(printCapitalizedVersion(userAction.trim().split("\\s+")[1])).getStatusChange();
			} else if (userAction.trim().split("\\s+")[0].equalsIgnoreCase("add")) {
				System.out.println("What is your new pet's name?");
				virtualPetShelter.addVirtualPet(new VirtualPet(input.nextLine()));
			}
			System.out.println("What would you like to do?");
			userAction = input.nextLine();
		}

	}
	
	private static String printCapitalizedVersion(String message) {
		return message.substring(0,1).toUpperCase() + message.substring(1).toLowerCase();
	}
} 
