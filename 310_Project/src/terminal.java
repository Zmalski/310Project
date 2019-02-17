import java.util.Arrays;

public class terminal {

	public static void main(String[] args) {
		// Initialize required attributes and objects
		// Used for processing input
		handleInput inputHandler = new handleInput();
		// Used to determine output based on processed input
		determineOutput outputDeterminer = new determineOutput();
		Personality p = new Personality();
		questionAsker questionAsker = new questionAsker();
		// Initialize booleans for determining steps in conversation
		boolean genderchosen = false;
		boolean turn = false;
		boolean nameknown = false;
		// Initialize names for identifying speakers
		String username = "Human";
		String chatbotname = "CHATBOTNAME";
		String botoutput = "";
		String data = "";
		String qdata = "";
		String qresponse[] = new String[50];
		String question[] = new String[2];
		System.out.println("You are on a blind date. Would you like to date a man or a woman?");
		while (true) {
			System.out.print("\n" + username + ":");
			String userinput = inputHandler.getUserInput();
			// Loop is called after desired gender and name are chosen, and begins to loop
			// through response/questions
			if (genderchosen == true && nameknown == true) {
				data = inputHandler.parseInput(userinput);
				if (data.equals("nothing")) {
					question = questionAsker.ask();
					System.out.println(chatbotname + ": " + question[0]);
					qdata = question[1];
					userinput = inputHandler.getUserInput();
					qresponse = inputHandler.parseQResponse(userinput, qdata, p);
					if (userinput.endsWith("?"))
						botoutput = outputDeterminer.respond(inputHandler.keywordConvert(qdata), p);
					else
						botoutput = questionAsker.afterAsk(userinput, question[1], p);
				} else {
					botoutput = outputDeterminer.respond(data, p);

				}
				System.out.print(chatbotname + ": " + botoutput);
			}
			// Determine desired gender from user
			if (genderchosen == false) {
				String gender = inputHandler.checkGender(userinput);
				p = new Personality(gender);
				chatbotname = p.getName();
				System.out.println(chatbotname);
				System.out.println("You are now on a date with a " + gender + " named " + chatbotname + ".");
				genderchosen = true;
			}
			// Determining users name, occupation from user
			if (nameknown == false) {
				System.out.println(chatbotname + ": Hi! What's your name?");
				System.out.println(username + ":");
				userinput = inputHandler.getUserInput();
				username = inputHandler.parseName(userinput).substring(0, 1).toUpperCase()
						+ inputHandler.parseName(userinput).substring(1);
				nameknown = true;
				int random = (int) (Math.random() * 2 + 1);
				if (random == 1)
					System.out.println(
							chatbotname + ": It's nice to meet you, " + username + ". What do you do for a living?");
				else
					System.out.println(
							chatbotname + ": That's a lovely name, " + username + ". So, what do you do for a living?");
				System.out.println(username + ":");
				userinput = inputHandler.getUserInput();
				System.out.println(
						chatbotname + ": " + outputDeterminer.occupation(inputHandler.checkOccupation(userinput)));

			}
			// End conversation if user types "bye"
			if (inputHandler.parseInput(userinput).equals("bye"))
				break;
			turn = !turn;
		}
	}

}
