import java.util.Scanner;

public class terminal {

	public static void main(String[] args) {
		handleInput inputHandler = new handleInput();
		determineOutput outputDeterminer = new determineOutput();
		boolean genderchosen = false;
		boolean turn = false;
		boolean nameknown = false;
		String username = "";
		Scanner reader = new Scanner(System.in);
		System.out.println("You are on a blind date. Would you like to date a man or a woman?");
		while (true) {
			if (turn == true)
				System.out.println("CHATBOTNAME:");
			else if (nameknown)
				System.out.println(username + ":");
			else
				System.out.println("Human:");
			String userinput = reader.nextLine();
			if (genderchosen == true) {
				String data = inputHandler.parseInput(userinput);
				String botoutput = outputDeterminer.respond(data);
				System.out.println(botoutput);
			}
			if (genderchosen == false) {
				String gender = inputHandler.checkGender(userinput);
				System.out.println("You are now on a date with a " + gender + ".  Say Hi!");
				genderchosen = true;
			}
			if (userinput.equals("bye"))
				break;
			turn = !turn;

		}
	}

}
