package virtualpet;

import java.util.Scanner;

public class ManualTesting {

	public static void main(String[] args) {
		MakeSound.playSound("C:\\Users\\WeCanCodeIT\\wcci\\default-workspace\\virtual-pet\\soundfiles\\bulbasaur.wav");
		String directory = System.getProperty("user.dir").replace("\\", "\\\\");
		MakeSound.playSound(directory + "\\soundfiles\\" + "bulbasaur" + ".wav");
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		
		Scanner input = new Scanner(System.in);
		//dog 
		System.out.println("           __\r\n" + 
				"      (___()'`;\r\n" + 
				"      /,    /`\r\n" + 
				"      \\\\\"--\\\\");
		System.out.println();
		System.out.println("  __      _\r\n" + 
				"o'')}____//\r\n" + 
				" `_/      )\r\n" + 
				" (_(_/-(_/");
		
		//cat
		System.out.println();
		System.out.println("   |\\---/|\r\n" + 
				"   | ,_, |\r\n" + 
				"    \\_`_/-..----.\r\n" + 
				" ___/ `   ' ,\"\"+ \\  \r\n" + 
				"(__...'   __\\    |`.___.';\r\n" + 
				"  (_,...'(_,.`__)/'.....+");
		System.out.println();
		System.out.println("        ,-\"\"\"\"\"\"-.\r\n" + 
				"     /\\j__/\\  (  \\`--.\r\n" + 
				"     \\`@_@'/  _)  >--.`.\r\n" + 
				"    _{.:Y:_}_{{_,'    ) )\r\n" + 
				"   {_}`-^{_} ```     (_/");
		System.out.println();
		System.out.println("                ;'-. \r\n" + 
				"    `;-._        )  '---.._\r\n" + 
				"      >  `-.__.-'          `'.__\r\n" + 
				"     /_.-'-._         _,   ^ ---)\r\n" + 
				"     `       `'------/_.'----```");
		System.out.println();
		System.out.println("   /\\                 /\\\r\n" + 
				"  / \\'._   (\\_/)   _.'/ \\\r\n" + 
				" /_.''._'--('.')--'_.''._\\\r\n" + 
				" | \\_ / `;=/ \" \\=;` \\ _/ |\r\n" + 
				"  \\/ `\\__|`\\___/`|__/`  \\/\r\n" + 
				"   `      \\(/|\\)/       `\r\n" + 
				"           \" ` \"");
		System.out.println();
		System.out.println("              __\r\n" + 
				"             /'{>\r\n" + 
				"         ____) (____\r\n" + 
				"       //'--;   ;--'\\\\\r\n" + 
				"      ///////\\_/\\\\\\\\\\\\\\\r\n" + 
				"            m m");
		
		System.out.println();
		System.out.println("      (_V__V_)\r\n" + 
				"        (oo)\r\n" + 
				" /-------\\/\r\n" + 
				"\"| _____||\r\n" + 
				" ||     || \r\n" + 
				"  ^^     ^^");
		System.out.println();
		System.out.println(" ___    ___\r\n" + 
				"( _<    >_ )\r\n" + 
				"//        \\\\\r\n" + 
				"\\\\___..___//\r\n" + 
				" `-(    )-'\r\n" + 
				"   _|__|_\r\n" + 
				"  /_|__|_\\\r\n" + 
				"  /_|__|_\\\r\n" + 
				"  /_\\__/_\\\r\n" + 
				"   \\ || /  _)\r\n" + 
				"     ||   ( )\r\n" + 
				"      \\\\___//\r\n" + 
				"      `---'");
		
	}	
	
}
