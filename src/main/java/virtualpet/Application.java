package virtualpet;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
// This section determines pet;
//chooses a pet name; allows user to choose help to find a list of commands
		String commands = "Commands\n Adopt - adopt a pet\n" + " Organic - choosing an animal pet\n"
				+ " Robotic - choosing a robot pet\n" + " Feed <petname> - feeds your pet\n"
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

		VirtualPet pet1 = new VirtualPet(initPrompt);
		System.out.println("Your pet's name is " + pet1.getName());
		System.out.println("What would you like to do?");

		String userAction = input.nextLine();

		if (userAction.trim().split("\\s+")[0].equalsIgnoreCase("feed")) {
			pet1.feed();
			pet1.getStatus();
		} else if (userAction.trim().split("\\s+")[0].equalsIgnoreCase("clean")) {
			pet1.clean();
			pet1.getStatus();
		} else if (userAction.trim().split("\\s+")[0].equalsIgnoreCase("checkup")) {
			pet1.checkup();
			pet1.getStatus();
		} else if (userAction.trim().split("\\s+")[0].equalsIgnoreCase("play")) {
			pet1.play();
			pet1.getStatus();
		}

	}

}
