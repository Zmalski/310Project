import java.util.ArrayList;
import java.util.HashMap;

public class determineOutput {
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
	 * @param data, personality
	 * @return response contained within the input string
	 */	
	 public String respond(String data, Personality personality) {
		 HashMap<String, Object> hash_map = new HashMap<String, Object>();	 
		 String responseBack = "";
		 /*
		 * Create two ArrayLists to store the arraylists received from two different methods.
		 * With the help of these two different list, we can call the method(converting arraylist to string) as per user input.
		 */
		 ArrayList<String> list1 = personality.getLikes();
		 ArrayList<String> list2 = personality.getDislikes();
		 String likesReturn="";
		 String dislikesReturn2="";
		 String qdoing="";
		 String swearing = "";
		 String greeting = "";
		 String endDate = "";
		 String insult = "";
		 String howru = "";
		 /**Greeting*/
		 if(data.equals("greeting")) {
			greeting = returnGreeting();
			hash_map.put("gretting", greeting);
		 }
		 /**bye*/
		 if(data.equals("bye")) {
				endDate = returnEndDate();
				hash_map.put("bye", endDate);
			 }
		 /**insult*/
		 if(data.equals("insult")) {
				insult = returnInsult(data);
				hash_map.put("insult", insult);
			 }
		 /**swearing*/
		 if(data.equals("swearing")) {
			 swearing = returnSwearing(data); 
			 hash_map.put("swearing", swearing);
		 }
		 /**qdoing*/
		 if(data.equals("qdoing")) {
			 qdoing = returnQdoing(); 
			 hash_map.put("qdoing", qdoing);
		 }
		 /**age */
		 hash_map.put("qage", "I am 22 year old.");
		 /**invalid*/
		 hash_map.put("invalid", "Ask more question");
		 /**qlikes */
		 if(data.equals("qlikes")) {
			 likesReturn = returnArrayList(list1);
			 hash_map.put("qlikes", likesReturn);
		 }
		 /**qdislikes*/
		 if(data.equals("qdislikes")) {
			 dislikesReturn2 = returnArrayList(list2);
			 hash_map.put("qlikes", dislikesReturn2);
		 }
		 /**qjob*/
		 hash_map.put("qjob", personality.getOccupation());
		 /**qzosign*/
		 hash_map.put("qzosign", personality.getZodiacSign());
		 /**howru*/
		 if(data.equals("howru")) {
			 howru = returnHouwru(); 
			 hash_map.put("qdoing", howru);
		 }
		 /**student */
		 hash_map.put("student", "I am a Computer Science student at UBC-Okanagan.");
		 /**qsports*/
		 hash_map.put("qsports", personality.getLikesSports());
		 /**qmusic*/
		 hash_map.put("qmusic", personality.getLikesMusic());
		 /**qanimals*/
		 hash_map.put("qanimals", personality.getLikesAnimals());
		 /**qcountries*/
		 hash_map.put("qcountries", personality.getLikesCountries());
		 /**qmovies*/
		 hash_map.put("qmovies", personality.getLikesMovies());
		 
		if(hash_map.containsKey(data)) {
			responseBack = (String) hash_map.get(data);
		 }else
			 responseBack = "I am sorry, I don't get it what do you mean?";
		 return responseBack;
	 }
	 	 
	 	 /** 
		 * Covert ArrayList to String
		 * @return string with respect to getDisLikes() and getLikes() methods
		 */
	 public String returnArrayList(ArrayList<String> list) {
	   String listString = "";
	   for(String s : list) {
		   listString += s + "\n";
	   }
		 return listString;
	 }
	 	 
	  	 /**
		 * Returns a random response for "greeting" keyword
		 * 
		 * "greeting" keyword is for when a user say hi or greet.
		 * @return string 
		 */
	 private String returnGreeting() {
		String greeting = "";
		ArrayList<String> greetingList = new ArrayList<String>();
		greetingList.add("Hey!!!");
		greetingList.add("Hello!!!");
		greetingList.add("Hi!!!");
		
		int random = (int)(Math.random()*3);

		greeting = greetingList.get(random);
		return greeting;
		}	 
	 	 /**
		 * Returns a random responses for "bye" keyword
		 * 
		 * @return string 
		 */
	 public String returnEndDate() {
		String bye = "";
		ArrayList<String> byeList = new ArrayList<String>();
		byeList.add("Goodbye!!!");
		byeList.add("Bye!!!");
		byeList.add("See you later!!!");
		
		int random = (int)(Math.random()*3);	
		
		bye = byeList.get(random);
		return bye;
	 }
	 	 /**
		 * Returns a random response for "qdoing" keyword
		 * 
		 * "qdoing" keyword is for when a user will ask what are you doing?
		 * @return string 
		 */
	 public String returnQdoing() {
		String qdoing = "";
		ArrayList<String> qdoingList = new ArrayList<String>();
		qdoingList.add("I am eating pasta.");
		qdoingList.add("I am doing homework.");
		qdoingList.add("I am basically talking to you.");
		
		int j = (int)(Math.random()*3);
	
		qdoing = qdoingList.get(j);
		return qdoing; 
	 }
	 	 /**
		 * Returns a random response for "swearing" keyword
		 * 
		 * "swearing" keyword is received when a user swear or unappropriated words.
		 * @return string 
		 */
	 public String returnSwearing(String data) {
		 String swearing = "";
		 ArrayList<String> swearingList = new ArrayList<String>();
		 swearingList.add(data + " ? " +"I do not know that you are swearing.");
		 swearingList.add(data + " ? " + "It is not appropriate.");
		 swearingList.add("Did you just actually say " + data + " ?");
		 
		 int random = (int)(Math.random()*3);
			
		 swearing = swearingList.get(random);
		 return swearing;
	 }
	 	 /**
		 * Returns a random response for "insult" keyword
		 * 
		 * "insult" keyword is received when user use unappropriated words.
		 * @return string 
		 */
	 public String returnInsult(String data) {
		 String insult = "";
		 ArrayList<String> insultList = new ArrayList<String>();
		 insultList.add("Don't call me " + data);
		 insultList.add("Why are you calling me "+ data);
		 insultList.add("You cannot call me " + data);
		 
		 int random = (int)(Math.random()*3);
		 
		 insult = insultList.get(random);
		 return insult;
	 }
	 	/**
		 * Returns a random response for "howru" keyword
		 * 
		 * "howru" keyword is received when user ask how are you?.
		 * @return string 
		 */
	 public String returnHouwru(){
		 String howru = "";
		 ArrayList<String> howruList = new ArrayList<String>();
		 howruList.add("I am doing well.");
		 howruList.add("I am great.");
		 howruList.add("I am fine.");
		 
		 int random = (int)(Math.random()*3);
		 
		 howruList.get(random);
		 return howru;
	 }
}

	/*
		/**
		 * Returns the response to gender
		 * 
		 * @param gender
		 * @return username contained within the input string
	 
		public String gender(String sex, Personality personality) {
			String ChatbotName="";
			if(sex.equals("woman")) {
				 personality = new Personality("woman");
				 ChatbotName = personality.getName();
			}
			else if(sex.equals("man"))
				personality = new Personality("man");
				ChatbotName = personality.getName();
			return ChatbotName;
		}
	}

/*
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
