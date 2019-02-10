import java.util.Scanner;

public class terminal {

	public static void main(String[] args) {
		handleInput inputHandler = new handleInput();
		//determineOutput outputDeterminer = new determineOutput();
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
			//Determine desired gender
			if (genderchosen == false) {
				String gender = inputHandler.checkGender(userinput);
				System.out.println("You are now on a date with a " + gender + ".");
				genderchosen = true;
			}
			//Determining users name
			if(nameknown == false) {
				System.out.println("CHATBOTNAME: Hi! What's your name?");
				username = reader.nextLine();
				nameknown = true;
				
			}
			if (userinput.equals("bye"))
				break;
			turn = !turn;

		}
	}

}
