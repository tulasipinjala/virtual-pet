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

		String commands = "Commands\n" + " 1. Feed <petname><all>\t- feeds your pet\n"
				+ " 2. Play <petname><all>\t- plays with your pet\n"
				+ " 3. Checkup <petname><all>\t- Takes your pet to the vet to improve health\n"
				+ " 4. Clean <petname><all>\t- Cleans your pet\n" + " 5. Water <petname><all>\t- Give your pet water\n"

				+ " 8. Add <petname>\t- Give your pet water\n"
				+ " 9. Adopt <petname>\t- This removes your pet from the shelter. THIS WILL BE PERMANENT.\n"
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
		System.out.println("Your pet's name is " + virtualPetShelter.get(printCapitalizedVersion(userInput)).getName());

		System.out.println("What would you like to do?");

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
			if (userAction.equalsIgnoreCase("feed") || userAction.equalsIgnoreCase("1")) {
				if (userInputSplit.length == 1) {
					System.out.println("Which pet?");
					virtualPetShelter.nameAll();
					System.out.println("");
					userPetChoice = input.nextLine();
				}
				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.feedAll();
				} else {
				virtualPetShelter.get(printCapitalizedVersion(userPetChoice)).feed();
				}
				virtualPetShelter.statusChangeAll();
			} else if (userAction.equalsIgnoreCase("clean") || userAction.equalsIgnoreCase("2")) {
				if (userInputSplit.length == 1) {
					System.out.println("Which pet?");
					virtualPetShelter.nameAll();
					System.out.println("");
					userPetChoice = input.nextLine();
				}
				virtualPetShelter.get(printCapitalizedVersion(userPetChoice)).clean();
				virtualPetShelter.get(printCapitalizedVersion(userPetChoice)).getStatusChange();
			} else if (userAction.equalsIgnoreCase("checkup") || userAction.equalsIgnoreCase("3")) {
				if (userInputSplit.length == 1) {
					System.out.println("Which pet?");
					virtualPetShelter.nameAll();
					System.out.println("");
					userPetChoice = input.nextLine();
				}
				virtualPetShelter.get(printCapitalizedVersion(userPetChoice)).checkup();
				virtualPetShelter.get(printCapitalizedVersion(userPetChoice)).getStatusChange();
			} else if (userAction.equalsIgnoreCase("play") || userAction.equalsIgnoreCase("4")) {
				if (userInputSplit.length == 1) {
					System.out.println("Which pet?");
					virtualPetShelter.nameAll();
					System.out.println("");
					userPetChoice = input.nextLine();
				}
				virtualPetShelter.get(printCapitalizedVersion(userPetChoice)).play();
				virtualPetShelter.get(printCapitalizedVersion(userPetChoice)).getStatusChange();
			} else if (userAction.equalsIgnoreCase("water") || userAction.equalsIgnoreCase("5")) {
				if (userInputSplit.length == 1) {
					System.out.println("Which pet?");
					virtualPetShelter.nameAll();
					System.out.println("");
					userPetChoice = input.nextLine();
				}
				virtualPetShelter.get(printCapitalizedVersion(userPetChoice)).water();
				virtualPetShelter.get(printCapitalizedVersion(userPetChoice)).getStatusChange();
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
			System.out.println("What would you like to do?");
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

	private static String printCapitalizedVersion(String message) {
		String[] messageSplit = message.trim().split("\\s+");
		if (messageSplit.length == 1) {
			return message.substring(0, 1).toUpperCase() + message.substring(1).toLowerCase();
		} else {
			String longName = "";
			for (int i = 0; i < message.trim().split("\\s+").length; i++) {
				longName = longName + " " + messageSplit[i].substring(0, 1).toUpperCase() + messageSplit[i].substring(1).toLowerCase();
			}
			return longName;
		}
	}
}
