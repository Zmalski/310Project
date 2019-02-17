import java.util.ArrayList;
import java.util.HashMap;

public class determineOutput {
	/*
	 * Pardeep
	 */
	String professionResponse = "";
	boolean condition = false;
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
			professionResponse = "Player!!! Are you a soccer player? I love sports";
			break;
		case "professor":
			professionResponse = "Professor!!! This would be a though job.";
			break;
		case "studnent":
			professionResponse = "Student!!! that's great.";
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
		 HashMap<String, String> hash_map = new HashMap<String, String>();	 
		 String responseBack = "";
		 /*
		 * Create ArrayLists to store the arraylists received from Personality Class.
		 * With the help of these ArrayLists variables, we can call the method(converting arraylist to string) as per user input.
		 */
		 ArrayList<String> list1 = personality.getLikes();
		 //System.out.println(list1);
		 ArrayList<String> list2 = personality.getDislikes();
		 System.out.println(list2);
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
		 if(data.equals("swearing")) {
			String swearing = returnSwearing(data); 
			 hash_map.put("swearing", swearing);
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
		 hash_map.put("invalid", "Ask more question");
		 }
		 /**qlikes */
		 if(data.equals("qlikes")) {
			String likesReturn = returnArrayList(list1);
			 hash_map.put("qlikes", likesReturn);
		 }
		 /**qdislikes*/
		 if(data.equals("qdislikes")) {
			String dislikesReturn2 = returnArrayList(list2);
			System.out.println(dislikesReturn2);
			hash_map.put("qdislikes", dislikesReturn2);
		 }
		 /**qjob*/
		 if(data.equals("qzosign")) {
			 hash_map.put("qjob", personality.getOccupation());
		}
		 /**qzosign*/
		 if(data.equals("qzosign")) {
			 hash_map.put("qzosign", personality.getZodiacSign());
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
			String likeSports = returnArrayList(likeSportsList);
			 hash_map.put("qsports", likeSports);
		 }
		 /**qmusic*/
		 if(data.equals("qmusic")) {
			String likeMusicString = returnArrayList(likeMusic);
			 hash_map.put("qmusic", likeMusicString);
			 
		 }
		 /**qanimals*/
		 if(data.equals("qanimals")) {
			String likeAnimalString = returnArrayList(likeAnimal);
			 hash_map.put("qanimals", likeAnimalString);
		 }
		 /**qcountries*/
		 if(data.equals("qcountries")) {
			 String likeCountriesString = returnArrayList(likeCountries);
			 hash_map.put("qcountries", likeCountriesString );
		 }
		 /**qmovies*/
		 if(data.equals("qmovies")) {
			String likeMoviesString = returnArrayList(likeMovies);
			hash_map.put("qmovies", likeMoviesString);
		 }
		 /**qfood*/
		 if(data.equals("qfood")) {
			 String food = returnArrayList(likefood);
			 hash_map.put("qfood", food);
		 }
		 

		if(hash_map.containsKey(data)) {
			System.out.println(data);
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
		 * Returns a name
		 * 
		 * "qname" keyword is for when user asks Bot's name.
		 * @return string 
		 */
	 public String returnName(Personality p){
		 String name = "";
		 if(condition == false) {
			 name = "My name is " + p.getName() + ".";
			 condition = true;
		 }else {
			name = "You have already asked my name but still my name is " + p.getName()+"."; 
		 }
		 return name;
	 }
	  	 /**
		 * Returns a random response for "greeting" keyword
		 * 
		 * "greeting" keyword is for when a user say hi or greet.
		 * @return string 
		 */
	 public String returnGreeting() {
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
		 ArrayList<String> howruList = new ArrayList<String>();
		 howruList.add("I am doing well.");
		 howruList.add("I am great.");
		 howruList.add("I am fine.");
		 
		 int random = (int)(Math.random()*3);
		 
		 String howru = howruList.get(random);
		 
		 return howru;
	 }
}

