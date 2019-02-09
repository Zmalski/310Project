import java.util.Scanner;


public class terminal {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		handleInput inputHandler = new handleInput();
		determineOutput outputDeterminer = new determineOutput();
		System.out.println("You are on a blind date. Would you like to date a man or a woman?");
		while(true) {
			String response = reader.nextLine();
			String occ = inputHandler.checkOccupation(response);
			System.out.println(occ);
		}

	}

}
