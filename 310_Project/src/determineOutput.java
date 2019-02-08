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
    /*
     * While statement to keep the conversation continue or terminate the conversation.
     * I have created a demo of static conversation. we need to implement the object oriented concepts though.
     */
	 boolean exit = true;
	 while(exit) {
		String bye = reader.nextLine();
		if(bye.equals("bye")) {
			exit = false;
		}else {
			System.out.println("What do you do for living " + name);
		}	
		/*
		handleInput inputHandler = new handleInput(name);
		inputHandler.getName();
		inputHandler.getUserInput();	
	*/
		}
	}
}