import java.util.Scanner;

public class terminal {

	public static void main(String[] args) {
		handleInput inputHandler = new handleInput();
		// determineOutput outputDeterminer = new determineOutput();
		boolean genderchosen = false;
		boolean turn = false;
		boolean nameknown = false;
		String username = "";
		Scanner reader = new Scanner(System.in);
		System.out.println("You are on a blind date. Would you like to date a man or a woman?");
		while (true) {
			if (nameknown)
				System.out.print(username + ":");
			else
				System.out.println("\nHuman:");
			String userinput = reader.nextLine();
			if (genderchosen == true && nameknown == true) {
				String data = inputHandler.parseInput(userinput);
				String botoutput = determineOutput.respond(data);
				System.out.print("CHATBOTNAME: " + botoutput);
			}
			// Determine desired gender
			if (genderchosen == false) {
				String gender = inputHandler.checkGender(userinput);
				System.out.println("You are now on a date with a " + gender + ".");
				genderchosen = true;
			}
			// Determining users name
			if (nameknown == false) {
				System.out.println("CHATBOTNAME: Hi! What's your name?");
				System.out.println("Human: ");
				userinput = reader.nextLine();
				username = inputHandler.parseName(userinput);
				nameknown = true;
				int random = (int) (Math.random() * 2 + 1);
				if (random == 1)
					System.out.println(
							"CHATBOTNAME: It's nice to meet you, " + username + ". What do you do for a living?");
				else
					System.out.println(
							"CHATBOTNAME: That's a lovely name, " + username + ". So, what do you do for a living?");
				System.out.println("Human: ");
				userinput = reader.nextLine();
				System.out.println("CHATBOTNAME:" + determineOutput.occupation(inputHandler.checkOccupation(userinput)).toString());

			}
			if (userinput.equals("bye"))
				break;
			turn = !turn;

		}
	}

}
