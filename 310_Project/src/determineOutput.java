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
	 String professionResponse = null;
	 while(exit) {
		String bye = reader.nextLine();
		if(bye.equals("bye")) {
			exit = false;
		}else {
			System.out.println("What do you do for living " + name + "?");
			String profession = reader.nextLine();
			int responseback = response(profession);
			//Switch statement returns the output according to the response.
		        switch (responseback) {
		            case 1:  professionResponse = "Software Developer"; 
		            		 System.out.println("Software developer. Wow! thats great.");
		            		 exit = false;
		                     break;
		            case 2:  professionResponse = "Musician";
		            		 System.out.println("Musician. I love music.");
		                     exit = false;
                    		 break;
		            case 3:  professionResponse = "Sports Player";
		            		 System.out.println("Player!!! Are you a soccer player. I love soccer");
		            		 exit = false;
		            		 break;
		            default: professionResponse = "Invalid entry";
		                     System.out.println("This input is not allowed. ");
		                     exit = false;
		                     break;
		        }
		    }	
		/*
		handleInput inputHandler = new handleInput(name);
		inputHandler.getName();
		inputHandler.getUserInput();	
	*/
		} 
	 System.out.println("\n" + "Good to know that you are a " + professionResponse +  "\n" + "Sorry!! I gotta go. Got a call from work. I will talk to you soon ");
	}
	
	/*
	 * I have created a method that parse the whole string, and if in the given string by the user has the profession matches to our scope, 
	 * the bot will response accordingly. 
	 */
	public static int response(String profession) {
		String Str = new String(profession);
		if(Str.matches("(.*)developer(.*)")) {
			return 1;
		}if(Str.matches("(.*)musician(.*)")) {
			return 2;
		}if(Str.matches("(.*)player(.*)")) {
			return 3;	
		}else 
			return -1;
	 }
}