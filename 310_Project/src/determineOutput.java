import java.util.Scanner;

public class determineOutput {
	/*
	 * Pardeep
	 */
	public static void main(String[] arg) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Hello, nice to meet you! I'm BerthaBot, what's your name?");
		String name = reader.nextLine(); 
		System.out.println("Alright " + name + " lets start out blind date!");	
		
		handleInput inputHandler = new handleInput(name);
		inputHandler.getName();
		inputHandler.getUserInput();
	
	}
}
