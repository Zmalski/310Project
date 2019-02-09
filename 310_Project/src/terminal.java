import java.util.Scanner;


public class terminal {

	public static void main(String[] args) {
		handleInput inputHandler = new handleInput();
		//determineOutput outputDeterminer = new determineOutput();
		
		Scanner reader = new Scanner(System.in);
		System.out.println("You are on a blind date. Would you like to date a man or a woman?");
		while(true) {
			String response = reader.nextLine();
			String occ = inputHandler.checkOccupation(response);
			String output = determineOutput.responseBack(occ);
			output.toString();
		}
	}

}
