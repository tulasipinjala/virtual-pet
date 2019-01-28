package virtualpet;

import java.util.Collection;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter virtualPetShelter = new VirtualPetShelter();

		// This section determines pet;
		// chooses a pet name; allows user to choose help to find a list of commands
		String intro = "Pet types \n" + " Organic - choosing an animal pet\n" + " Robotic - choosing a robot pet\n\n"
				+ "WARNING" + " If you let any of the pet's properties go to zero, it will be adopted by Mr. Reaper.";

		String commands = "Commands\n" 
				+ " 1. Feed <petname><all>\t\t- feeds your pet\n"
				+ " 2. Play <petname><all>\t\t- plays with your pet\n"
				+ " 3. Checkup <petname><all>\t- Takes your pet to the vet to improve health\n"
				+ " 4. Clean <petname><all>\t- Cleans your pet\n" + " 5. Water <petname><all>\t- Give your pet water\n"

				+ " 8. Add <petname>\t\t- Give your pet water\n"
				+ " 9. Adopt <petname>\t\t- This removes your pet from the shelter. THIS WILL BE PERMANENT.\n"
				+ " 0. Exit - Exits VPet";
		System.out.println("Please type in your first pet's name. Type \"help\" for list of commands.");
		String userInput = input.nextLine();

		if (userInput.toLowerCase().equals("help")) {
			System.out.println(intro);
			System.out.println(commands);
			System.out.println("Please type in your pet's name");
			userInput = input.nextLine();
		}

		virtualPetShelter.addVirtualPet(new VirtualPet(userInput));
		System.out.println(
				"Your pet's name is " + virtualPetShelter.getPet(printCapitalizedVersion(userInput)).getName());

		System.out.println("What would you like to do?");
		long startTime = System.nanoTime();
		long endTime;
		long timeElapsed;
		String userAction = "";
		String userPetChoice = "";
		userInput = input.nextLine();
		String[] userInputSplit = userInput.trim().split("\\s+");
		if (userInputSplit.length == 1) {
			userAction = userInput;
		} else if (userInputSplit.length == 2) {
			userAction = userInputSplit[0];
			userPetChoice = printCapitalizedVersion(userInputSplit[1]);
		} else {
			userAction = userInputSplit[0];
			String longPetname = "";
			for (int i = 0; i < userInputSplit.length; i++) {
				longPetname = longPetname + " " + userInputSplit[i];
			}
			userPetChoice = printCapitalizedVersion(longPetname);
		}

		while (true) {
			endTime = System.nanoTime();
			timeElapsed = (endTime - startTime)/1000000000; 
			virtualPetShelter.tickAll((int) timeElapsed);
			if (userAction.equalsIgnoreCase("feed") || userAction.equalsIgnoreCase("1")) {
				userPetChoice = chooseAPet(input, virtualPetShelter, userPetChoice, userInputSplit);
				
				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(100);
					virtualPetShelter.feedAll();
				} else {
					virtualPetShelter.tickAll(50);
					virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)).feed();
				}
				
				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("clean") || userAction.equalsIgnoreCase("2")) {
				userPetChoice = chooseAPet(input, virtualPetShelter, userPetChoice, userInputSplit);

				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(100);
					virtualPetShelter.cleanAll();
				} else {
					virtualPetShelter.tickAll(50);
					virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)).clean();
				}
				
				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("checkup") || userAction.equalsIgnoreCase("3")) {
				userPetChoice = chooseAPet(input, virtualPetShelter, userPetChoice, userInputSplit);
				
				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(100);
					virtualPetShelter.checkupAll();
				} else {
					virtualPetShelter.tickAll(50);
					virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)).checkup();
				}
				
				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("play") || userAction.equalsIgnoreCase("4")) {
				userPetChoice = chooseAPet(input, virtualPetShelter, userPetChoice, userInputSplit);
				
				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(100);
					virtualPetShelter.playAll();
				} else {
					virtualPetShelter.tickAll(50);
					virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)).play();
				}
				
				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("water") || userAction.equalsIgnoreCase("50")) {
				userPetChoice = chooseAPet(input, virtualPetShelter, userPetChoice, userInputSplit);
				
				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(100);
					virtualPetShelter.waterAll();
				} else {
					virtualPetShelter.tickAll(50);
					virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)).water();
				}
				
				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("help")) {
				System.out.println(commands);
			} else if (userAction.equalsIgnoreCase("exit") || userAction.equalsIgnoreCase("0")) {
				System.exit(0);
			} else if (userAction.equalsIgnoreCase("add")) {
				System.out.println("What is your new pet's name?");
				virtualPetShelter.addVirtualPet(new VirtualPet(input.nextLine()));
			} else {
				System.out.println(commands);
			}
			virtualPetShelter.updatePrevPropertiesAll();
			System.out.println("What would you like to do?");
			startTime = System.nanoTime();
			userInput = input.nextLine();
			userInputSplit = userInput.trim().split("\\s+");
			if (userInputSplit.length == 1) {
				userAction = userInput;
			} else if (userInputSplit.length == 2) {
				userAction = userInputSplit[0];
				userPetChoice = printCapitalizedVersion(userInputSplit[1]);
			} else {
				userAction = userInputSplit[0];
				String longPetname = "";
				for (int i = 0; i < userInputSplit.length; i++) {
					longPetname = longPetname + " " + userInputSplit[i];
				}
				userPetChoice = printCapitalizedVersion(longPetname);
			}

		}

	}

	private static String chooseAPet(Scanner input, VirtualPetShelter virtualPetShelter, String userPetChoice,
			String[] userInputSplit) {
		if (userInputSplit.length == 1) {
			System.out.println("Which pet?");
			virtualPetShelter.nameAll();
			System.out.println("");
			userPetChoice = input.nextLine();
		}
		return userPetChoice;
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
