package virtualpet;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

import virtualpet.extras.Levenshtein;
import virtualpet.organic.Cat;
import virtualpet.organic.Dog;
import virtualpet.organic.Dolphin;
import virtualpet.organic.Duck;
import virtualpet.organic.Hawk;
import virtualpet.organic.Lion;
import virtualpet.organic.Organic;
import virtualpet.organic.Pig;
import virtualpet.organic.Wolf;
import virtualpet.robotic.Bulbasaur;
import virtualpet.robotic.Caterpie;
import virtualpet.robotic.Charmander;
import virtualpet.robotic.Pikachu;
import virtualpet.robotic.Robotic;
import virtualpet.robotic.Squirtle;
import virtualpet.robotic.Weedle;

public class Application {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter virtualPetShelter = new VirtualPetShelter();
		long startTime;
		long endTime;
		long timeElapsed;
		String userPetCreate = "";
		String userAction;
		String userPetChoice;
		String[] userInputSplit;
		String longPetname;

		// This section determines your first pet
		// Help display
		String intro = "Pet types \n" + " Organic - choosing an animal pet\n" + " Robotic - choosing a robot pet\n\n"
				+ "WARNING" + " If you let any of the pet's properties go to zero, it will be adopted by Mr. Reaper.";

		String commands = "Commands\n"
				+ " 1. Clean <petname><all><cages>\t- Clean your pet, all pets, or their cages. This will keep your pets clean and healthy.\n"
				+ " 2. Play <petname><all>\t\t- Plays with all of your pets\n"
				+ " 3. Checkup <petname><all>\t- Takes your Organic pet to the vet to improve health\n"
				+ " 4. Feed <petname><all>\t\t- Feeds your Organic pet\n"
				+ " 5. Water <petname><all>\t- Give your Organic pet water\n"
				+ " 6. Plugin <petname><all>\t- Charge Robotic pet\n"
				+ " 7. Defrag <petname><all>\t- Defrag Robotic pet\n" + " 8. Add <petname>\t\t- Admit a new pet\n"
				+ " 9. Adopt <petname>\t\t- This removes your pet from the shelter. THIS WILL BE PERMANENT.\n"
				+ " 0. List \t\t\t- Displays all pets and their stats.\n" + " Exit \t\t\t\t- Exits VPet";
		// Chooses a pet name. Choose if your pet is Organic or Robotic. Also allows
		// user to choose help to find a list of commands
		System.out.println("Please type in your first pet's name. Type \"help\" for list of commands.");
		String userInput = exitChecker(input.nextLine());

		if (userInput.toLowerCase().equals("help")) {
			System.out.println(intro);
			System.out.println(commands);
			System.out.println("Please type in your pet's name");
			userInput = exitChecker(input.nextLine());
		}
		System.out.println("Is your pet Organic or Robotic?");
		String userType = exitChecker(input.nextLine());
		userType = typeGuesser(userType, input);

		userPetCreate = choosePetSubclass(input, userPetCreate, userType);

		createPet(input, virtualPetShelter, userInput, userPetCreate);
		// Displays initial pet's name
		System.out.println(
				"Your pet's name is " + virtualPetShelter.getPet(printCapitalizedVersion(userInput)).getName());

		// Action 'while' loop
		while (true) {
			System.out.println("What would you like to do?");
			startTime = System.nanoTime();
			userAction = "";
			userPetChoice = "";
			userInput = exitChecker(input.nextLine());
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

			if (userAction.equalsIgnoreCase("clean") || userAction.equalsIgnoreCase("1")) {
				userPetChoice = chooseAPetCage(input, virtualPetShelter, userPetChoice, userInputSplit);
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);

				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(20);
					virtualPetShelter.cleanAll();
				} else if (userPetChoice.equalsIgnoreCase("cages")) {
					virtualPetShelter.tickAll(20);
					virtualPetShelter.cleanCage();
				} else {
					virtualPetShelter.tickAll(10);
					virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)).clean();

				}
				virtualPetShelter.removeDeadPets();
				userPetCreate = addPetPrompt(input, virtualPetShelter, userPetCreate);
				virtualPetShelter.endTurn();
			} else if (userAction.equalsIgnoreCase("play") || userAction.equalsIgnoreCase("2")) {
				userPetChoice = chooseAPet(input, virtualPetShelter, userPetChoice, userInputSplit);
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);

				if (userPetChoice.equalsIgnoreCase("all")) {
					virtualPetShelter.tickAll(20);
					virtualPetShelter.playAll();
				} else {
					virtualPetShelter.tickAll(10);
					virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)).play();
				}
				virtualPetShelter.removeDeadPets();
				userPetCreate = addPetPrompt(input, virtualPetShelter, userPetCreate);
				virtualPetShelter.endTurn();
			} else if (userAction.equalsIgnoreCase("checkup") || userAction.equalsIgnoreCase("3")) {
				if (virtualPetShelter.organicChecker()) {
					userPetChoice = chooseAOrganicPet(input, virtualPetShelter, userPetChoice, userInputSplit);
					endTime = System.nanoTime();
					timeElapsed = (endTime - startTime) / 1000000000;
					virtualPetShelter.tickAll((int) timeElapsed);

					if (userPetChoice.equalsIgnoreCase("all")) {
						virtualPetShelter.tickAll(20);
						virtualPetShelter.checkupAll();
					} else {
						virtualPetShelter.tickAll(10);
						((Organic) virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice))).checkup();
					}
					virtualPetShelter.removeDeadPets();
					userPetCreate = addPetPrompt(input, virtualPetShelter, userPetCreate);
					virtualPetShelter.endTurn();
				} else {
					System.out.println("You do not have any Organic pets.");
				}
			} else if (userAction.equalsIgnoreCase("feed") || userAction.equalsIgnoreCase("4")) {
				if (virtualPetShelter.organicChecker()) {
					userPetChoice = chooseAOrganicPet(input, virtualPetShelter, userPetChoice, userInputSplit);
					endTime = System.nanoTime();
					timeElapsed = (endTime - startTime) / 1000000000;
					virtualPetShelter.tickAll((int) timeElapsed);

					if (userPetChoice.equalsIgnoreCase("all")) {
						virtualPetShelter.tickAll(20);
						virtualPetShelter.feedAll();
					} else {
						virtualPetShelter.tickAll(10);
						((Organic) virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice))).feed();
					}
					virtualPetShelter.removeDeadPets();
					userPetCreate = addPetPrompt(input, virtualPetShelter, userPetCreate);
					virtualPetShelter.endTurn();
				} else {
					System.out.println("You do not have any Organic pets.");
				}
			} else if (userAction.equalsIgnoreCase("water") || userAction.equalsIgnoreCase("5")) {
				if (virtualPetShelter.organicChecker()) {
					userPetChoice = chooseAOrganicPet(input, virtualPetShelter, userPetChoice, userInputSplit);
					endTime = System.nanoTime();
					timeElapsed = (endTime - startTime) / 1000000000;
					virtualPetShelter.tickAll((int) timeElapsed);

					if (userPetChoice.equalsIgnoreCase("all")) {
						virtualPetShelter.tickAll(20);
						virtualPetShelter.waterAll();
					} else {
						virtualPetShelter.tickAll(10);
						((Organic) virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice))).water();
					}
					virtualPetShelter.removeDeadPets();
					userPetCreate = addPetPrompt(input, virtualPetShelter, userPetCreate);
					virtualPetShelter.endTurn();
				} else {
					System.out.println("You do not have any Organic pets.");
				}
			} else if (userAction.equalsIgnoreCase("plugin") || userAction.equalsIgnoreCase("6")) {
				if (virtualPetShelter.roboticChecker()) {
					userPetChoice = chooseARoboticPet(input, virtualPetShelter, userPetChoice, userInputSplit);
					endTime = System.nanoTime();
					timeElapsed = (endTime - startTime) / 1000000000;
					virtualPetShelter.tickAll((int) timeElapsed);

					if (userPetChoice.equalsIgnoreCase("all")) {
						virtualPetShelter.tickAll(20);
						virtualPetShelter.pluginAll();
					} else {
						virtualPetShelter.tickAll(10);
						((Robotic) virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice))).plugin();
					}
					virtualPetShelter.removeDeadPets();
					userPetCreate = addPetPrompt(input, virtualPetShelter, userPetCreate);
					virtualPetShelter.endTurn();
				} else {
					System.out.println("You do not have any Robotic pets.");
				}
			} else if (userAction.equalsIgnoreCase("defrag") || userAction.equalsIgnoreCase("7")) {
				if (virtualPetShelter.roboticChecker()) {
					userPetChoice = chooseARoboticPet(input, virtualPetShelter, userPetChoice, userInputSplit);
					endTime = System.nanoTime();
					timeElapsed = (endTime - startTime) / 1000000000;
					virtualPetShelter.tickAll((int) timeElapsed);

					if (userPetChoice.equalsIgnoreCase("all")) {
						virtualPetShelter.tickAll(20);
						virtualPetShelter.defragAll();
					} else {
						virtualPetShelter.tickAll(10);
						((Robotic) virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice))).defrag();
					}
					virtualPetShelter.removeDeadPets();
					userPetCreate = addPetPrompt(input, virtualPetShelter, userPetCreate);
					virtualPetShelter.endTurn();
				} else {
					System.out.println("You do not have any Robotic pets.");
				}
			} else if (userAction.equalsIgnoreCase("add") || userAction.equalsIgnoreCase("8")) {
				System.out.println("What is your new pet's name?");
				userInput = exitChecker(input.nextLine());
				System.out.println("Is your pet Organic or Robotic?");
				userType = exitChecker(input.nextLine());
				userType = typeGuesser(userType, input);
				userPetCreate = choosePetSubclass(input, userPetCreate, userType);

				createPet(input, virtualPetShelter, userInput, userPetCreate);

				virtualPetShelter.removeDeadPets();
				userPetCreate = addPetPrompt(input, virtualPetShelter, userPetCreate);
				virtualPetShelter.endTurn();
			} else if (userAction.equalsIgnoreCase("adopt") || userAction.equalsIgnoreCase("9")) {
				userPetChoice = chooseAPetToAdopt(input, virtualPetShelter, userPetChoice, userInputSplit);
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);

				virtualPetShelter.tickAll(10);
				virtualPetShelter.adoptVirtualPet(printCapitalizedVersion(userPetChoice));

				virtualPetShelter.removeDeadPets();
				userPetCreate = addPetPrompt(input, virtualPetShelter, userPetCreate);
				virtualPetShelter.endTurn();
			} else if (userAction.equalsIgnoreCase("help")) {
				System.out.println(commands);
			} else if (userAction.equalsIgnoreCase("list") || userAction.equalsIgnoreCase("0")) {
				endTime = System.nanoTime();
				timeElapsed = (endTime - startTime) / 1000000000;
				virtualPetShelter.tickAll((int) timeElapsed);

				virtualPetShelter.removeDeadPets();
				userPetCreate = addPetPrompt(input, virtualPetShelter, userPetCreate);
				virtualPetShelter.endTurn();
			} else if (userAction.equalsIgnoreCase("exit")) {
				System.exit(0);
			} else {
				System.out.println(commands);
			}
			virtualPetShelter.updatePrevPropertiesAll();
		}
	}

	private static String addPetPrompt(Scanner input, VirtualPetShelter virtualPetShelter, String userPetCreate) {
		String userInput;
		String userType;
		if (virtualPetShelter.getVirtualPetCount() <= 0) {
			System.out.println("All of your pets have been adopted. You need a new pet!");
			System.out.println("What is your new pet's name?");
			userInput = exitChecker(input.nextLine());
			System.out.println("Is your pet Organic or Robotic?");
			userType = exitChecker(input.nextLine());
			userType = typeGuesser(userType, input);
			userPetCreate = choosePetSubclass(input, userPetCreate, userType);

			createPet(input, virtualPetShelter, userInput, userPetCreate);

		}
		return userPetCreate;
	}

	private static String choosePetSubclass(Scanner input, String userPetCreate, String userType) {
		if (userType.equalsIgnoreCase("Robotic")) {
			System.out.println("Which Robotic pet would you like?");
			System.out.println("1. Bulbasaur");
			System.out.println("2. Charmander");
			System.out.println("3. Squirtle");
			System.out.println("4. Caterpie");
			System.out.println("5. Weedle");
			System.out.println("6. Pikachu");
			userPetCreate = printCapitalizedVersion(exitChecker(input.nextLine()));
			userPetCreate = roboticChoiceChecker(userPetCreate, input);
		} else {
			System.out.println("Which Organic pet would you like?");
			System.out.println("1. Cat");
			System.out.println("2. Dog");
			System.out.println("3. Dolphin");
			System.out.println("4. Duck");
			System.out.println("5. Hawk");
			System.out.println("6. Lion");
			System.out.println("7. Pig");
			System.out.println("8. Wolf");
			userPetCreate = printCapitalizedVersion(exitChecker(input.nextLine()));
			userPetCreate = organicChoiceChecker(userPetCreate, input);

		}
		return userPetCreate;
	}

	private static String roboticChoiceChecker(String userPetCreate, Scanner input) {
		Set<String> roboticList = new HashSet<String>(
				Arrays.asList("Bulbasaur", "Charmander", "Squirtle", "Caterpie", "Weedle", "Pikachu"));

		while (!roboticList.contains(userPetCreate)) {
			switch (userPetCreate) {
			case "1":
				userPetCreate = "Bulbasaur";
				break;
			case "2":
				userPetCreate = "Charmander";
				break;
			case "3":
				userPetCreate = "Squirtle";
				break;
			case "4":
				userPetCreate = "Caterpie";
				break;
			case "5":
				userPetCreate = "Weedle";
				break;
			case "6":
				userPetCreate = "Pikachu";
				break;
			}

			if (!roboticList.contains(userPetCreate)) {
				System.out.println("Please choose from list:");
				System.out.println("1. Bulbasaur");
				System.out.println("2. Charmander");
				System.out.println("3. Squirtle");
				System.out.println("4. Caterpie");
				System.out.println("5. Weedle");
				System.out.println("6. Pikachu");
				userPetCreate = printCapitalizedVersion(exitChecker(input.nextLine()));
			}
		}
		return userPetCreate;
	}

	private static String organicChoiceChecker(String userPetCreate, Scanner input) {
		Set<String> organicList = new HashSet<String>(
				Arrays.asList("Cat", "Dog", "Dolphin", "Duck", "Hawk", "Lion", "Pig", "Wolf"));

		while (!organicList.contains(userPetCreate)) {
			switch (userPetCreate) {
			case "1":
				userPetCreate = "Cat";
				break;
			case "2":
				userPetCreate = "Dog";
				break;
			case "3":
				userPetCreate = "Dolphin";
				break;
			case "4":
				userPetCreate = "Duck";
				break;
			case "5":
				userPetCreate = "Hawk";
				break;
			case "6":
				userPetCreate = "Lion";
				break;
			case "7":
				userPetCreate = "Pig";
				break;
			case "8":
				userPetCreate = "Wolf";
				break;

			}

			if (!organicList.contains(userPetCreate)) {
				System.out.println("Please choose from list:");
				System.out.println("1. Cat");
				System.out.println("2. Dog");
				System.out.println("3. Dolphin");
				System.out.println("4. Duck");
				System.out.println("5. Hawk");
				System.out.println("6. Lion");
				System.out.println("7.Pig");
				System.out.println("8. Wolf");
				userPetCreate = printCapitalizedVersion(exitChecker(input.nextLine()));
			}
		}
		return userPetCreate;
	}

	private static void createPet(Scanner input, VirtualPetShelter virtualPetShelter, String userInput,
			String userPetCreate) {
		if (userPetCreate.equalsIgnoreCase("Bulbasaur")) {
			virtualPetShelter.addVirtualPet(new Bulbasaur(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Charmander")) {
			virtualPetShelter.addVirtualPet(new Charmander(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Squirtle")) {
			virtualPetShelter.addVirtualPet(new Squirtle(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Caterpie")) {
			virtualPetShelter.addVirtualPet(new Caterpie(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Weedle")) {
			virtualPetShelter.addVirtualPet(new Weedle(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Pikachu")) {
			virtualPetShelter.addVirtualPet(new Pikachu(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Cat")) {
			virtualPetShelter.addVirtualPet(new Cat(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Dog")) {
			virtualPetShelter.addVirtualPet(new Dog(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Dolphin")) {
			virtualPetShelter.addVirtualPet(new Dolphin(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Duck")) {
			virtualPetShelter.addVirtualPet(new Duck(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Hawk")) {
			virtualPetShelter.addVirtualPet(new Hawk(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Lion")) {
			virtualPetShelter.addVirtualPet(new Lion(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Pig")) {
			virtualPetShelter.addVirtualPet(new Pig(userInput));
		} else if (userPetCreate.equalsIgnoreCase("Wolf")) {
			virtualPetShelter.addVirtualPet(new Wolf(userInput));
		}
	}

	private static String chooseAPet(Scanner input, VirtualPetShelter virtualPetShelter, String userPetChoice,
			String[] userInputSplit) {
		if (userInputSplit.length == 1) {
			System.out.println("Which pet?");
			userPetChoice = virtualPetShelter.nameAll(input);
		}

		while (!(virtualPetShelter.getVirtualPets().containsKey(printCapitalizedVersion(userPetChoice))
				|| userPetChoice.equalsIgnoreCase("all"))) {
			System.out.println("Hey! Please choose from the list! Which pet?");
			userPetChoice = virtualPetShelter.nameAll(input);
		}
		return userPetChoice;
	}

	private static String chooseAPetCage(Scanner input, VirtualPetShelter virtualPetShelter, String userPetChoice,
			String[] userInputSplit) {
		if (userInputSplit.length == 1) {
			System.out.println("Which pet? Or cages.");
			userPetChoice = virtualPetShelter.nameAllCage(input);
		}

		while (!(virtualPetShelter.getVirtualPets().containsKey(printCapitalizedVersion(userPetChoice))
				|| userPetChoice.equalsIgnoreCase("all") || userPetChoice.equalsIgnoreCase("cages"))) {
			userPetChoice = virtualPetShelter.nameAllCage(input);
		}
		return userPetChoice;
	}

	private static String chooseAPetToAdopt(Scanner input, VirtualPetShelter virtualPetShelter, String userPetChoice,
			String[] userInputSplit) {
		if (userInputSplit.length == 1) {
			System.out.println("Which pet?");
			userPetChoice = virtualPetShelter.nameAllAdopt(input);
		}

		while (!(virtualPetShelter.getVirtualPets().containsKey(printCapitalizedVersion(userPetChoice)))) {
			System.out.println("Hey! Type a name from the list! Which pet?");
			userPetChoice = virtualPetShelter.nameAllAdopt(input);
		}
		return userPetChoice;
	}

	private static String chooseAOrganicPet(Scanner input, VirtualPetShelter virtualPetShelter, String userPetChoice,
			String[] userInputSplit) {
		if (userInputSplit.length == 1) {
			System.out.println("Which pet?");
			userPetChoice = virtualPetShelter.nameAllOrganic(input);
		}

		while (!(virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)) instanceof Organic
				|| userPetChoice.equalsIgnoreCase("all"))) {
			System.out.println("The pet must be Organic. Which pet?");
			userPetChoice = virtualPetShelter.nameAllOrganic(input);
		}

		return userPetChoice;
	}

	private static String chooseARoboticPet(Scanner input, VirtualPetShelter virtualPetShelter, String userPetChoice,
			String[] userInputSplit) {
		if (userInputSplit.length == 1) {
			System.out.println("Which pet?");
			userPetChoice = virtualPetShelter.nameAllRobotic(input);
		}

		while (!(virtualPetShelter.getPet(printCapitalizedVersion(userPetChoice)) instanceof Robotic
				|| userPetChoice.equalsIgnoreCase("all"))) {
			System.out.println("The pet must be Robotic. Which pet?");
			userPetChoice = virtualPetShelter.nameAllRobotic(input);
		}

		return userPetChoice;
	}

	private static String printCapitalizedVersion(String message) {
		String[] messageSplit = message.trim().split("\\s+");
		if (messageSplit.length == 1) {
			return message.substring(0, 1).toUpperCase() + message.substring(1).toLowerCase();
		} else {
			String longName = messageSplit[0].substring(0, 1).toUpperCase()
					+ messageSplit[0].substring(1).toLowerCase();
			for (int i = 1; i < messageSplit.length; i++) {
				longName = longName + " " + messageSplit[i].substring(0, 1).toUpperCase()
						+ messageSplit[i].substring(1).toLowerCase();
			}
			return longName;
		}
	}

	public static String typeGuesser(String userType, Scanner input) {
		int organicGuess = Levenshtein.calculate(printCapitalizedVersion(userType), "Organic");
		int roboticGuess = Levenshtein.calculate(printCapitalizedVersion(userType), "Robotic");
		String guess;
		while (true) {

			if (organicGuess < roboticGuess) {
				guess = "Organic";
				break;
			} else if (organicGuess > roboticGuess) {
				guess = "Robotic";
				break;
			} else {
				System.out.println("Please try again. Is your pet Organic or Robotic?");
				userType = exitChecker(input.nextLine());
			}
			organicGuess = Levenshtein.calculate(printCapitalizedVersion(userType), "Organic");
			roboticGuess = Levenshtein.calculate(printCapitalizedVersion(userType), "Robotic");
		}
		return guess;
	}
	
	public static String exitChecker(String userWord) {
		if (userWord.equalsIgnoreCase("exit")) {
			System.exit(0);
		} 
		
		return userWord;
	}
}
