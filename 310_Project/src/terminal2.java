import java.util.Scanner;

public class terminal2 {

	public static void main(String[] args) {
		handleInput inputHandler = new handleInput();
		
		boolean genderchosen = false;
		boolean turn = false;
		boolean nameknown = false;
		String username = "";
		String occ = "";
		
		Scanner reader = new Scanner(System.in);
		System.out.println("You are on a blind date. Would you like to date a man or a woman?");
		
		while (true) {
			if (nameknown)
				System.out.print(username + ":");
			else
				System.out.println("\nHuman:");
			String userinput = reader.nextLine();
			if (genderchosen == true && nameknown == true) {
				String botoutput = determineOutput.respond(userinput);
				botoutput.toString();
				//System.out.print("CHATBOTNAME: " + botoutput);
			}
			//Determine desired gender
			if (genderchosen == false) {
				String gender = inputHandler.checkGender(userinput);
				System.out.println("You are now on a date with a " + gender + ".");
				genderchosen = true;
			}
			//Determining users name
			if(nameknown == false) {
				System.out.println("\nCHATBOTNAME: Hi! What's your name?");
				username = reader.nextLine();
				determineOutput.name(username).toString();
				occ = reader.nextLine();
				String responseback = inputHandler.checkOccupation(occ);
				String occupat = determineOutput.occupation(responseback);
				occupat.toString();
				nameknown = true;
			}
			if (userinput.equals("bye"))
				break;
			turn = !turn;

		}
	}

}
