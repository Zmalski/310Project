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
			professionResponse = "Player!!! Are you a soccer player. I love soccer";
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
		 * Create two ArrayLists to store the arraylists received from two different methods.
		 * With the help of these two different list, we can call the method(converting arraylist to string) as per user input.
		 * Create ArrayLists to store the arraylists received from Personality Class.
		 * With the help of these ArrayLists variables, we can call the method(converting arraylist to string) as per user input.
		 */
		 ArrayList<String> list1 = personality.getLikes();
		 //System.out.println(list1);
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
		 hash_map.put("invalid", "I am sorry, I don't understand the question.");
		 }
		 /**qlikes */
		 if(data.equals("qlikes")) {
			String likesReturn = returnArrayList(list1);
			 hash_map.put("qlikes", likesReturn);
		 }
		 /**qdislikes*/
		 if(data.equals("qdislikes")) {
			String dislikesReturn2 = returnArrayList(list2);
			hash_map.put("qdislikes", dislikesReturn2);
		 }
		 /**qjob*/
		 hash_map.put("qjob", personality.getOccupation());
		 if(data.equals("qzosign")) {
			 hash_map.put("qjob", personality.getOccupation());
		}
		 /**qzosign*/
		 hash_map.put("qzosign", personality.getZodiacSign());
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
}