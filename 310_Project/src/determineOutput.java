public class determineOutput {
	handleInput hInput = new handleInput();
	/*
	 * Pardeep
	 */
	String inputReceive = hInput.getUserInput();
	String responseback = hInput.checkOccupation(inputReceive);
	static String professionResponse = null;

	public static String responseBack(String responseback) {
		// Switch statement returns the output according to the response.
		switch (responseback) {
		case "developer":
			professionResponse = "Software Developer";
			System.out.println("Software developer. Wow! thats great.");
			break;
		case "musician":
			professionResponse = "Musician";
			System.out.println("Musician. I love music.");
			break;
		case "player":
			professionResponse = "Sports Player";
			System.out.println("Player!!! Are you a soccer player. I love soccer");
			break;
		case "butcher":
			professionResponse = "butcher";
			System.out.println("Butcher!!! thats a good job.");
			break;
		case "cook":
			professionResponse = "cook";
			System.out.println("Cook!!! I love cooking.");
			break;
		case "farmer":
			professionResponse = "farmer";
			System.out.println("Farmer!!! I love fields");
			break;
		case "firefighter":
			professionResponse = "firefighter";
			System.out.println("Firefighter!!! that's cool.");
			break;
		case "hairdresser":
			professionResponse = "hairdresser";
			System.out.println("Hairdresser, wow!!! thats a cool job.");
			break;
		case "journalist":
			professionResponse = "journalist";
			System.out.println("Journalist!!! it must be a hectic job.");
			break;
		case "lawyer":
			professionResponse = "lawyer";
			System.out.println("Lawyer!!! great.");
			break;
		case "mechanic":
			professionResponse = "mechanic";
			System.out.println("Mechanic!!! great.");
			break;
		case "painter":
			professionResponse = "painter";
			System.out.println("Painter!!! You are an artist.");
			break;
		case "notfound":
			professionResponse = "WOW!!";
			System.out.println("Sounds cool, but I never heard about this before.");
			break;	
		default:
			professionResponse = responseback;
			System.out.println("You are a "+ responseback+". Sounds cool.");
			break;
		}
		return professionResponse;
	}

	public static String respond(String data) {
		String response = "";
		if(data.equals("greeting")) {
			response = "Hi! How are you?";
		}
		else
			response = "Hello?";
		return response;
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
