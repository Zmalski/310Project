import java.util.ArrayList;
import java.util.HashMap;
public class determineOutput {
	/*
	 * Pardeep
	 */
	String professionResponse = "";
	boolean condition = false;
	/**
	 * Returns a response for a given String
	 * 
	 * This method stores the responses in a HashMap, and return the output(response) to user as per the given input.
	 * The data is stored as a key value pair. As soon as the method receives a key it provides the output.
	 * 
	 * @param data, personality
	 * @return string
	 */	
	 public String respond(String data, Personality personality) {
		 HashMap<String, String> hash_map = new HashMap<String, String>();	 
		 String responseBack = "";
		 /*
		 * Create ArrayLists to store the arraylists received from Personality class.
		 * Once we receive a arraylist, we can call the method(converting arraylist to string) as per the given user input.
		 */
		 ArrayList<String> list1 = personality.getLikes();
		 ArrayList<String> list2 = personality.getDislikes();
		 ArrayList<String> likeSportsList = personality.getLikesSports();
		 ArrayList<String> likeMusic = personality.getLikesMusic();
		 ArrayList<String> likeAnimal = personality.getLikesAnimals();
		 ArrayList<String> likeCountries = personality.getLikesCountries();
		 ArrayList<String> likeMovies = personality.getLikesMovies();
		 ArrayList<String> likefood = personality.getLikesFoods();

		 /**Greeting*/
		 if(data.equals("greeting")) {
			String greeting = returnGreeting();
			hash_map.put("greeting", greeting);
		 }
		 if(data.equals("qname")) {
			 String name = returnName(personality);
			 hash_map.put("qname", name);
		 }
		 /**bye*/
		 if(data.equals("bye")) {
			String endDate = returnEndDate();
				hash_map.put("bye", endDate);
			 }
		 /**insult*/
		 if(data.equals("insult")) {
			String insult = returnInsult(data);
			hash_map.put("insult", insult);
			 }
		 /**swearing*/
		 if(data.equals("swear")) {
			String swearing = returnSwearing(data); 
			 hash_map.put("swear", swearing);
		 }
		 /**qdoing*/
		 if(data.equals("qdoing")) {
			String qdoing = returnQdoing(); 
			 hash_map.put("qdoing", qdoing);
		 }
		 /**age */
		 if(data.equals("qage")) {
		 hash_map.put("qage", "I am 22 year old.");
		 }
		 /**invalid*/
		 if(data.equals("invalid")) {
		 hash_map.put("invalid", "I am sorry, I don't understand the question.");
		 }
		 /**qlikes */
		 if(data.equals("qlikes")) {
			String likesReturn = returnString(list1);
			 hash_map.put("qlikes", "I like " + likesReturn);
		 }
		 /**qdislikes*/
		 if(data.equals("qdislikes")) {
			String dislikesReturn2 = returnString(list2);
			hash_map.put("qdislikes","I dislike " +  dislikesReturn2);
		 }
		 /**qjob*/
		 hash_map.put("qjob", personality.getOccupation());
		 if(data.equals("qzosign")) {
			 hash_map.put("qjob", "My job is " + personality.getOccupation());
		}
		 /**qzosign*/
		 hash_map.put("qzosign", personality.getZodiacSign());
		 if(data.equals("qzosign")) {
			 hash_map.put("qzosign", "My zodiac sign " + personality.getZodiacSign());
		 }
		 /**howru*/
		 if(data.equals("howru")) {
			String howru = returnHouwru(); 
			 hash_map.put("howru", howru);
		 }
		 /**student */
		 if(data.equals("student")) {
			 hash_map.put("student", "I am a Computer Science student at UBC-Okanagan.");
		 }
		/**qsports*/
		 if(data.equals("qsports")) {
			String likeSports = returnString(likeSportsList);
			 hash_map.put("qsports","The sports I like " + likeSports);
		 }
		 /**qmusic*/
		 if(data.equals("qmusic")) {
			String likeMusicString = returnString(likeMusic);
			 hash_map.put("qmusic","Music!! I really like " + likeMusicString);

		 }
		 /**qanimals*/
		 if(data.equals("qanimals")) {
			String likeAnimalString = returnString(likeAnimal);
			 hash_map.put("qanimals","The animal I like " + likeAnimalString);
		 }
		 /**qcountries*/
		 if(data.equals("qcountries")) {
			 String likeCountriesString = returnString(likeCountries);
			 hash_map.put("qcountries","The countries I would like to travel " +  likeCountriesString );
		 }
		 /**qmovies*/
		 if(data.equals("qmovies")) {
			String likeMoviesString = returnString(likeMovies);
			hash_map.put("qmovies","umm!!! The movies I like " +  likeMoviesString);
		 }
		 /**qfood*/
		 if(data.equals("qfood")) {
			 String food = returnString(likefood);
			 hash_map.put("qfood","food!!! The food I like " +  food);
		 }
		 
		if(hash_map.containsKey(data)) {
			 responseBack = (String) hash_map.get(data);	
		 }else
			 responseBack = "I am sorry, I don't understand the question.";
		 return responseBack;
	 } 
	/**
	 * Returns the response to occupations
	 * @param output
	 * @return occupation in a string
	 */
	public String occupation(String response) {
		// Switch statement returns the output according to the response.
		switch (response) {
		case "developer":
			professionResponse = "Like a programmer? Cool!";
			break;
		case "musician":
			professionResponse = "Oh cool, I love music.";
			break;
		case "player":
			professionResponse = "Wow, that's cool, I always wanted to be a professional sports player.";
			break;
		case "professor":
			professionResponse = "Wow, professors are truly the greatest members of society.";
			break;
		case "studnent":
			professionResponse = "I'm a student too!";
			break;
		case "butcher":
			professionResponse = "Oh. Gross.";
			break;
		case "cook":
			professionResponse = "I love cooking! You must love that job.";
			break;
		case "farmer":
			professionResponse = "Farmer! I love plowing!";
			break;
		case "firefighter":
			professionResponse = "Wow, you must be strong!";
			break;
		case "hairdresser":
			professionResponse = "I could sure use a haircut!";
			break;
		case "journalist":
			professionResponse = "You must chat with some pretty interesting people!";
			break;
		case "lawyer":
			professionResponse = "Oh boy, I'm sure you're good at arguing.";
			break;
		case "mechanic":
			professionResponse = "I bet it's fun to work on cars all day.";
			break;
		case "painter":
			professionResponse = "Wow, you're the next Bob Ross.";
			break;
		case "notfound":
			professionResponse = "Huh, I've never heard of that job before!";
			break;
		default:
			professionResponse = "You are a " + response + "? Sounds neat.";
			break;
		}
		return professionResponse;
	}
	

	 	 /**  
		 * Covert ArrayList to String
		 * @return a string for any given arraylist  
		 */
	 public String returnString(ArrayList<String> list) {
	   String listString = "";
	   for(String s : list) {
		   listString += s + ", ";
	   }
		 return listString;
	 }
	 /**
		 * Returns a name
		 * "qname" keyword is for when user asks Bot's name.
		 * @return string 
		 */
	 public String returnName(Personality p){
		 String name = "";
		 if(condition == false) {
			 name = "My name is " + p.getName() + ".";
			 condition = true;
		 }else {
			name = "My name is still " + p.getName()+"."; 
		 }
		 return name;
	 }
 	 /**
		 * Returns a related random response for "greeting" keyword
		 * 
		 * "greeting" keyword is for when a user say hi or greet.
		 * @return string 
		 */
	 public String returnGreeting() {
		String greeting = "";
		ArrayList<String> greetingList = new ArrayList<String>();
		greetingList.add("Hey!");
		greetingList.add("Hello!");
		greetingList.add("Hi!");
		
		int random = (int)(Math.random()*3);
		greeting = greetingList.get(random);
		return greeting;
		}	 
	 	 /**
		 * Returns a related random responses for "bye" keyword
		 * 
		 * @return string 
		 */
	 public String returnEndDate() {
		String bye = "";
		ArrayList<String> byeList = new ArrayList<String>();
		byeList.add("Goodbye!");
		byeList.add("Bye!");
		byeList.add("See you later!");
		
		int random = (int)(Math.random()*3);	
		
		bye = byeList.get(random);
		return bye;
	 }
	 	 /**
		 * Returns a related random response for "qdoing" keyword
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
		 * Returns a related random response for "swearing" keyword
		 * 
		 * "swearing" keyword is received when a user swear or unappropriated words.
		 * @return string 
		 */
	 public String returnSwearing(String data) {
		 String swearing = "";
		 ArrayList<String> swearingList = new ArrayList<String>();
		 swearingList.add("That's pretty vulgar language.");
		 swearingList.add("Watch your language.");
		 swearingList.add("Woah! You kiss your mother with that mouth?");
		 
		 int random = (int)(Math.random()*3);
			
		 swearing = swearingList.get(random);
		 return swearing;
	 }
	 	 /**
		 * Returns a related random response for "insult" keyword
		 * 
		 * "insult" keyword is received when user use unappropriated words.
		 * @return string 
		 */
	 public String returnInsult(String data) {
		 String insult = "";
		 ArrayList<String> insultList = new ArrayList<String>();
		 insultList.add("Don't call me names!");
		 insultList.add("Why are you calling me names?");
		 insultList.add("Don't be a jerk!");
		 
		 int random = (int)(Math.random()*3);
		 
		 insult = insultList.get(random);
		 return insult;
	 }
	 	/**
		 * Returns a related random response for "howru" keyword
		 * 
		 * "howru" keyword is received when user ask how are you?.
		 * @return string 
		 */
	 public String returnHouwru(){
		 ArrayList<String> howruList = new ArrayList<String>();
		 howruList.add("I am doing well, thanks!");
		 howruList.add("I am great, thanks!");
		 howruList.add("I am fine. Thanks.");

		 int random = (int)(Math.random()*3);

		 String howru = howruList.get(random);
		 return howru;
	 }
}