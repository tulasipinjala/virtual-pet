package virtualpet;

import java.util.Arrays;
import java.util.Scanner;

public class ManualTesting {

	public static void main(String[] args) {
//		MakeSound.playSound("C:\\Users\\WeCanCodeIT\\wcci\\default-workspace\\virtual-pet\\soundfiles\\bulbasaur.wav");
//		String directory = System.getProperty("user.dir").replace("\\", "\\\\");
//		MakeSound.playSound(directory + "\\soundfiles\\" + "bulbasaur" + ".wav");
		
		System.out.println("R & Organic: " + calculate("R","Organic"));
		System.out.println("R & Robotic: " + calculate("R","Robotic"));
		System.out.println("O & Organic: " + calculate("O","Organic"));
		System.out.println("O & Robotic: " + calculate("O","Robotic"));
		
		System.out.println("o & Organic: " + calculate("o","Organic"));
		System.out.println("o & Robotic: " + calculate("o","Robotic"));
		
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
	
	static int calculate(String x, String y) {
	    int[][] dp = new int[x.length() + 1][y.length() + 1];
	 
	    for (int i = 0; i <= x.length(); i++) {
	        for (int j = 0; j <= y.length(); j++) {
	            if (i == 0) {
	                dp[i][j] = j;
	            }
	            else if (j == 0) {
	                dp[i][j] = i;
	            }
	            else {
	                dp[i][j] = min(dp[i - 1][j - 1] 
	                 + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), 
	                  dp[i - 1][j] + 1, 
	                  dp[i][j - 1] + 1);
	            }
	        }
	    }
	 
	    return dp[x.length()][y.length()];
	}
	
	public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
	
    public static int min(int... numbers) {
        return Arrays.stream(numbers)
          .min().orElse(Integer.MAX_VALUE);
    }
}
