package virtualpet;

import java.util.Collection;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter virtualPetShelter = new VirtualPetShelter();
		long startTime;
		long endTime;
		long timeElapsed;
		String userAction;
		String userPetChoice;
		String[] userInputSplit;
		String longPetname;

		// This section determines pet;
		// chooses a pet name; allows user to choose help to find a list of commands
		String intro = "Pet types \n" + " Organic - choosing an animal pet\n" + " Robotic - choosing a robot pet\n\n"
				+ "WARNING" + " If you let any of the pet's properties go to zero, it will be adopted by Mr. Reaper.";

		String commands = "Commands\n" + " 1. Feed <petname><all>\t\t- feeds your Organic pet\n"
				+ " 2. Play <petname><all>\t\t- plays with your pet\n"
				+ " 3. Checkup <petname><all>\t- Takes your Organic pet to the vet to improve health\n"
				+ " 4. Clean <petname><all>\t- Cleans your pet\n"
				+ " 5. Water <petname><all>\t- Give your Organic pet water\n"
				+ " 6. Plugin <petname><all>\t- Charge Robotic pet\n"
				+ " 7. Defrag <petname><all>\t- Defrag Robotic pet\n" 
				+ " 8. Add <petname>\t\t- Admit a new pet\n"
				+ " 9. Adopt <petname>\t\t- This removes your pet from the shelter. THIS WILL BE PERMANENT.\n"
				+ " 0. List \t\t\t- Displays all pets and their stats.\n"
				+ " Exit \t\t\t\t- Exits VPet";
		System.out.println("Please type in your first pet's name. Type \"help\" for list of commands.");
		String userInput = input.nextLine();

		if (userInput.toLowerCase().equals("help")) {
			System.out.println(intro);
			System.out.println(commands);
			System.out.println("Please type in your pet's name");
			userInput = input.nextLine();
		}
		System.out.println("Is your pet Organic or Robotic?");
		String userType = input.nextLine();
		userType = createPet(input, virtualPetShelter, userInput, userType);

		System.out.println(
				"Your pet's name is " + virtualPetShelter.getPet(printCapitalizedVersion(userInput)).getName());

		// Action 'while' loop
		while (true) {
			System.out.println("What would you like to do?");
			startTime = System.nanoTime();
			userAction = "";
			userPetChoice = "";
			userInput = input.nextLine();
			userInputSplit = userInput.trim().split("\\s+");
			if (userInputSplit.length == 1) {
				userAction = userInput.trim();
			} else if (userInputSplit.length == 2) {
				userAction = userInputSplit[0];
				userPetChoice = printCapitalizedVersion(userInputSplit[1]);
			} else {
				userAction = userInputSplit[0];
				longPetname = "";
				for (int i = 0; i < userInputSplit.length; i++) {
					longPetname = longPetname + " " + userInputSplit[i];
				}
				userPetChoice = printCapitalizedVersion(longPetname);
			}

			if (userAction.equalsIgnoreCase("feed") || userAction.equalsIgnoreCase("1")) {
				userPetChoice = chooseAOrganicPet(input, virtualPetShelter, userPetChoice, userInputSplit);
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);

				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(20);
					virtualPetShelter.cleanAll();
				} else {
					virtualPetShelter.tickAll(10);
					((Organic) virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice))).feed();
				}

				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("clean") || userAction.equalsIgnoreCase("2")) {
				userPetChoice = chooseAPet(input, virtualPetShelter, userPetChoice, userInputSplit);
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);

				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(20);
					virtualPetShelter.cleanAll();
				} else {
					virtualPetShelter.tickAll(10);
					virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)).clean();
				}

				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("checkup") || userAction.equalsIgnoreCase("3")) {
				userPetChoice = chooseAOrganicPet(input, virtualPetShelter, userPetChoice, userInputSplit);
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);

				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(20);
					virtualPetShelter.cleanAll();
				} else {
					virtualPetShelter.tickAll(10);
					((Organic) virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice))).checkup();
				}

				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("play") || userAction.equalsIgnoreCase("4")) {
				userPetChoice = chooseAPet(input, virtualPetShelter, userPetChoice, userInputSplit);
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);

				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(20);
					virtualPetShelter.cleanAll();
				} else {
					virtualPetShelter.tickAll(10);
					virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)).play();
				}

				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("water") || userAction.equalsIgnoreCase("5")) {
				userPetChoice = chooseAOrganicPet(input, virtualPetShelter, userPetChoice, userInputSplit);
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);

				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(20);
					virtualPetShelter.cleanAll();
				} else {
					virtualPetShelter.tickAll(10);
					((Organic) virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice))).water();
				}

				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("plugin") || userAction.equalsIgnoreCase("6")) {
				userPetChoice = chooseARoboticPet(input, virtualPetShelter, userPetChoice, userInputSplit);
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);

				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(20);
					virtualPetShelter.cleanAll();
				} else {
					virtualPetShelter.tickAll(10);
					((Robotic) virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice))).plugin();
				}

				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("defrag") || userAction.equalsIgnoreCase("7")) {
				userPetChoice = chooseARoboticPet(input, virtualPetShelter, userPetChoice, userInputSplit);
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);

				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(20);
					virtualPetShelter.cleanAll();
				} else {
					virtualPetShelter.tickAll(10);
					((Robotic) virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice))).defrag();
				}

				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("add") || userAction.equalsIgnoreCase("8")) {
				System.out.println("What is your new pet's name?");
				userInput = input.nextLine();
				System.out.println("Is your pet Organic or Robotic?");
				userType = input.nextLine();

				userType = createPet(input, virtualPetShelter, userInput, userType);
			} else if (userAction.equalsIgnoreCase("adopt") || userAction.equalsIgnoreCase("9")) {
				userPetChoice = chooseAPetToAdopt(input, virtualPetShelter, userPetChoice, userInputSplit);
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);

				virtualPetShelter.tickAll(10);
				virtualPetShelter.adoptVirtualPet(printCapitalizedVersion(userPetChoice));

				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("help")) {
				System.out.println(commands);
			} else if (userAction.equalsIgnoreCase("list") || userAction.equalsIgnoreCase("0")) {
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);
				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("exit")) {
				System.exit(0);
			} else {
				System.out.println(commands);
			}
			virtualPetShelter.updatePrevPropertiesAll();
		}
	}

	private static String createPet(Scanner input, VirtualPetShelter virtualPetShelter, String userInput,
			String userType) {
		while (true) {
			if (userType.equalsIgnoreCase("Organic")) {
				virtualPetShelter.addVirtualPet(new Organic(userInput));
				break;
			} else if (userType.equalsIgnoreCase("Robotic")) {
				virtualPetShelter.addVirtualPet(new Robotic(userInput));
				break;
			} else {
				System.out.println("Please try again. Is your pet Organic or Robotic?");
				userType = input.nextLine();
			}
		}
		return userType;
	}

	private static String chooseAPet(Scanner input, VirtualPetShelter virtualPetShelter, String userPetChoice,
			String[] userInputSplit) {
		if (userInputSplit.length == 1) {
			System.out.println("Which pet?");
			virtualPetShelter.nameAll();
			System.out.println("");
			userPetChoice = input.nextLine();
		}
		
		while (!(virtualPetShelter.getVirtualPets().containsKey(printCapitalizedVersion(userPetChoice))
				|| userPetChoice.equalsIgnoreCase("all"))) {
			System.out.println("Hey! Type a name from the list! Which pet?");
			virtualPetShelter.nameAll();
			System.out.println("");
			userPetChoice = input.nextLine();
		}
		return userPetChoice;
	}

	private static String chooseAPetToAdopt(Scanner input, VirtualPetShelter virtualPetShelter, String userPetChoice,
			String[] userInputSplit) {
		if (userInputSplit.length == 1) {
			System.out.println("Which pet?");
			virtualPetShelter.nameAll();
			System.out.println("");
			userPetChoice = input.nextLine();
		}
		
		while (!(virtualPetShelter.getVirtualPets().containsKey(printCapitalizedVersion(userPetChoice)))) {
			System.out.println("Hey! Type a name from the list! Which pet?");
			virtualPetShelter.nameAll();
			System.out.println("");
			userPetChoice = input.nextLine();
		}
		return userPetChoice;
	}
	private static String chooseAOrganicPet(Scanner input, VirtualPetShelter virtualPetShelter, String userPetChoice,
			String[] userInputSplit) {
		if (userInputSplit.length == 1) {
			System.out.println("Which pet?");
			virtualPetShelter.nameAllOrganic();
			System.out.println("");
			userPetChoice = input.nextLine();
		}

		while (!(virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)) instanceof Organic
				|| userPetChoice.equalsIgnoreCase("all"))) {
			System.out.println("The pet must be Organic. Which pet?");
			virtualPetShelter.nameAllOrganic();
			System.out.println("");
			userPetChoice = input.nextLine();
		}

		return userPetChoice;
	}

	private static String chooseARoboticPet(Scanner input, VirtualPetShelter virtualPetShelter, String userPetChoice,
			String[] userInputSplit) {
		if (userInputSplit.length == 1) {
			System.out.println("Which pet?");
			virtualPetShelter.nameAllRobotic();
			System.out.println("");
			userPetChoice = input.nextLine();
		}

		while (!(virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)) instanceof Robotic
				|| userPetChoice.equalsIgnoreCase("all"))) {
			System.out.println("The pet must be Robotic. Which pet?");
			virtualPetShelter.nameAllRobotic();
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
