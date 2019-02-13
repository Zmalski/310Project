import java.util.ArrayList;
import java.util.HashMap;

public class determineOutput {
	/*
	 * Pardeep
	 */
	handleInput hInput = new handleInput();
	Personality personality = new Personality(); 
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
			professionResponse = "Sounds cool, but I never heard about this before.";
			break;
		default:
			professionResponse = "You are a " + response + ". Sounds cool.";
			break;
		}
		return professionResponse;
	}
	
	/**
	 * Returns the response for given String
	 * 
	 * @param data
	 * @return response contained within the input string
	 */	
	 public String respond(String data) {
		 HashMap<String, Object> hash_map = new HashMap<String, Object>();	 
		 String responseBack = "";
		 ArrayList<String> list1 = personality.getLikes();
		 ArrayList<String> list2 = personality.getDislikes();
		 hash_map.put("greeting", "Hi! How are you?");
		 hash_map.put("bye", "Goodbye");
		 hash_map.put("insult", "It is not appropriate.");
		 hash_map.put("swearing", "You cannot swear.");
		 hash_map.put("qdoing", "I am talking to you.");
		 hash_map.put("qage", "I am 22 year old.");
		 hash_map.put("Invalid", "Ask more question");
		 hash_map.put("qlikes", returnArrayList(list1));
		 hash_map.put("qdislikes", returnArrayList(list2));
		 hash_map.put("qjob", personality.getOccupation());
		 hash_map.put("qzosign", personality.getZodiacSign());
		 hash_map.put("qname", personality.getName());

		 if(!hash_map.isEmpty()) {
			responseBack = (String) hash_map.get(data);
		 }else
			 responseBack = "I am sorry, I don't get it what do you mean?";
		 return responseBack;
	 }
	 /**
		 * Returns the response for given String
		 * 
		 * Covert ArrayList to String
		 * @return string with respect to getDisLikes() method
		 */
	 public String returnArrayList(ArrayList<String> list) {
	   String listString = "";
	   for(String s : list) {
		   listString += s + "\n";
	   }
		 return listString;
	 }

		/**
		 * Returns the response to gender
		 * 
		 * @param gender
		 * @return username contained within the input string
		 */
		public String gender(String sex) {
			String ChatbotName="";
			if(sex.equals("woman"))
				ChatbotName = "Jane";
			else if(sex.equals("man"))
				ChatbotName = "John";
			return ChatbotName;
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
