public class determineOutput {
	handleInput hInput = new handleInput();
	/*
	 * Pardeep
	 */
	String professionResponse = "";
	/**
	 * Returns the response to occupations
	 * @param output
	 * @return occupation contained within the input string
	 */
	public String occupation(String response) {
		// Switch statement returns the output according to the response.
		switch (response) {
		case "developer":
			professionResponse = "Software developer. Wow! thats great.";
			break;
		case "musician":
			professionResponse = "Musician. I love music.";
			break;
		case "player":
			professionResponse = "Player!!! Are you a soccer player. I love soccer";
			break;
		case "butcher":
			professionResponse = "Butcher!!! thats a good job.";
			break;
		case "cook":
			professionResponse = "Cook!!! I love cooking.";
			break;
		case "farmer":
			professionResponse = "Farmer!!! I love fields.";
			break;
		case "firefighter":
			professionResponse = "Firefighter!!! that's cool.";
			break;
		case "hairdresser":
			professionResponse = "Hairdresser, wow!!! thats a cool job.";
			break;
		case "journalist":
			professionResponse = "Journalist!!! it must be a hectic job.";
			break;
		case "lawyer":
			professionResponse = "Lawyer!!! great.";
			break;
		case "mechanic":
			professionResponse = "Mechanic!!! great.";
			break;
		case "painter":
			professionResponse = "Painter!!! You are an artist.";
			break;
		case "notfound":
			professionResponse = "WOW!!";
			System.out.println("Sounds cool, but I never heard about this before.");
			break;
		default:
			professionResponse = response;
			System.out.println("You are a " + response + ". Sounds cool.");
			break;
		}
		return professionResponse;
	}

	/**
	 * Returns the response to greeting
	 * 
	 * @param output
	 * @return greeting contained within the input string
	 */
	public String respond(String data) {
		String Response = "";
		switch (data) {
		case "greeting":
			Response = "Hi! How are you?";
			break;
		case "bye":
			Response = "Goodbye!";
			break;
		case "insult":
			Response = "It is not appropriate.";
			break;
		case "Swearing":
			Response = "You cannot swear.";
			break;
		/*
		 * This case for testing.	
		 */
		case "i am a software developer":
			String receiveInput = hInput.checkOccupation("I am a software developer.");
			Response = occupation(receiveInput);
		default:
			Response = data;
			break;
		}
		return Response;
	}
	/**
	 * Returns the response to username
	 * 
	 * @param output
	 * @return username contained within the input string
	 */
	public String name(String name) {
		String nameReturn = "Nice to meet you " + name + ". What do you do for living?";
		System.out.println(nameReturn);
		return nameReturn;
	}
}
	/*
	 * I have created a method that parse the whole string, and if in the given
	 * string by the user has the profession matches to our scope, the bot will
	 * response accordingly. 
	 * 
	 * public static int response(String profession) { 
	 * 		String Str = new String(profession); 
	 * 		if(Str.matches("(.*)developer(.*)")) {
	 *  	return 1; 
	 *  	}
	 *  	if(Str.matches("(.*)musician(.*)")) { 
	 *  	return 2;
	 * 		}
	 * 		if(Str.matches("(.*)player(.*)")) { 
	 * 		return 3; }
	 * 		else 
	 * 		return -1; 
	 * }
	 */
