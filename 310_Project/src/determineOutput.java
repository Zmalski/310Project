public class determineOutput {
	handleInput hInput = new handleInput();
	/*
	 * Pardeep
	 */
	String inputReceive = hInput.getUserInput();
	String responseback = hInput.checkOccupation(inputReceive);
	static String professionResponse = null;
	/**
	 * Returns the response to occupations
	 * @param output
	 * @return occupation contained within the input string
	 */
	public static String occupation(String response) {
		// Switch statement returns the output according to the response.
		switch (response) {
		case "developer":
			professionResponse = "Software Developer";
			System.out.println("CHATBOTNAME: Software developer. Wow! thats great.");
			break;
		case "musician":
			professionResponse = "Musician";
			System.out.println("CHATBOTNAME: Musician. I love music.");
			break;
		case "player":
			professionResponse = "Sports Player";
			System.out.println("CHATBOTNAME: Player!!! Are you a soccer player. I love soccer");
			break;
		case "butcher":
			professionResponse = "butcher";
			System.out.println("CHATBOTNAME: Butcher!!! thats a good job.");
			break;
		case "cook":
			professionResponse = "cook";
			System.out.println("CHATBOTNAME: Cook!!! I love cooking.");
			break;
		case "farmer":
			professionResponse = "farmer";
			System.out.println("CHATBOTNAME: Farmer!!! I love fields");
			break;
		case "firefighter":
			professionResponse = "firefighter";
			System.out.println("CHATBOTNAME: Firefighter!!! that's cool.");
			break;
		case "hairdresser":
			professionResponse = "hairdresser";
			System.out.println("CHATBOTNAME: Hairdresser, wow!!! thats a cool job.");
			break;
		case "journalist":
			professionResponse = "journalist";
			System.out.println("CHATBOTNAME: Journalist!!! it must be a hectic job.");
			break;
		case "lawyer":
			professionResponse = "lawyer";
			System.out.println("CHATBOTNAME: Lawyer!!! great.");
			break;
		case "mechanic":
			professionResponse = "mechanic";
			System.out.println("CHATBOTNAME: Mechanic!!! great.");
			break;
		case "painter":
			professionResponse = "painter";
			System.out.println("CHATBOTNAME: Painter!!! You are an artist.");
			break;
		case "notfound":
			professionResponse = "WOW!!";
			System.out.println("CHATBOTNAME: Sounds cool, but I never heard about this before.");
			break;
		default:
			professionResponse = response;
			System.out.println("CHATBOTNAME: You are a " + response + ". Sounds cool.");
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
	public static String respond(String data) {
		String Response = null;
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
		default:
			Response = data;
			break;
		}
		return Response;
	}

	public static String name(String name) {
		String nameReturn = "CHATBOTNAME: Nice to meet you " + name + ". What do you do for living?";
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
