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
			System.out.println("What do you do for living " + name + "?");
			String profession = reader.nextLine();
		        String professionResponse;
		        switch (profession) {
		            case "I am software developer.":
		            		 System.out.println("Wow! thats great.");
		                     break;
		            case "I am a musician.":
	            		 System.out.println("Wow! thats great.");
	                     break;
		            case "I am a sports player.":
	            		 System.out.println("Wow! thats great.");
	                     break;
		            default: professionResponse = "Invalid entry";
		                     System.out.println("This input is not allowed. ");
		                     break;
		        }
		    }	
		/*
		handleInput inputHandler = new handleInput(name);
		inputHandler.getName();
		inputHandler.getUserInput();	
	*/

		}	System.out.println("Have a good day!!! ");
	}
}