import java.util.ArrayList;

public class questionAsker {
	// Attributes to track which questions have already been asked
	public boolean movies = false;
	public boolean music = false;
	public boolean howru = false;
	public boolean countries = false;
	public boolean likes = false;
	public boolean dislikes = false;
	public boolean sports = false;

	/**
	 * Returns an array containing a question to ask user and a keyword for data
	 * processing
	 * 
	 * @param void
	 * @return Array containing question and question keyword
	 */
	public String[] ask() {
		String outputArray[] = new String[2];
		int random = (int) (Math.random() * 2 + 1);
		if (movies == false) {
			// Picks one of three questions, randomly.
			if (random == 1)
				outputArray[0] = "What movies do you like?";
			else if (random == 2)
				outputArray[0] = "Seen any good movies lately?";
			else
				outputArray[0] = "What are some of your favourite movies?";
			outputArray[1] = "movies";
			movies = true;
		} else if (music == false) {
			// Picks one of three questions, randomly.
			if (random == 1)
				outputArray[0] = "What music do you like?";
			else if (random == 2)
				outputArray[0] = "What genres of music do you listen to?";
			else
				outputArray[0] = "Heard any good music lately?";
			outputArray[1] = "music";
			music = true;
		} else if (countries == false) {
			// Picks one of three questions, randomly.
			if (random == 1)
				outputArray[0] = "What countries do you like?";
			else if (random == 2)
				outputArray[0] = "What countries would you like to travel to?";
			else
				outputArray[0] = "Where would you travel if you could travel anywhere?";
			outputArray[1] = "countries";
			countries = true;
		} else if (likes == false) {
			// Picks one of three questions, randomly.
			if (random == 1)
				outputArray[0] = "What are your hobbies?";
			else if (random == 2)
				outputArray[0] = "What do you like to do in your spare time?";
			else
				outputArray[0] = "What are some things you like?";
			outputArray[1] = "likes";
			likes = true;
		} else if (dislikes == false) {
			// Picks one of three questions, randomly.
			if (random == 1)
				outputArray[0] = "What do you hate?";
			else if (random == 2)
				outputArray[0] = "What do you dislike?";
			else
				outputArray[0] = "What are some things you try to avoid in life?";
			outputArray[1] = "dislikes";
			dislikes = true;
		} else if (sports == false) {
			// Picks one of three questions, randomly.
			if (random == 1)
				outputArray[0] = "Do you play any sports?";
			else if (random == 2)
				outputArray[0] = "What are some of your favourite sports?";
			else
				outputArray[0] = "See any good sports games lately?";
			outputArray[1] = "sports";
			sports = true;
		} else {
			outputArray[0] = "Sorry, I'm out of things to talk about! This has been fun though.";
			outputArray[1] = "invalid";
		}
		return outputArray;
	}

	public String afterAsk(String input, String qdata, Personality personality) {
		String output = "Sorry?";
		if(input.endsWith("?")) {
			if(qdata.equals("music")) {
				output = "Some music I like is: " + listToString(personality.getLikesMusic());
			}
			if(qdata.equals("movies")) {
				output = "Some movies I like are: " + listToString(personality.getLikesMovies());
			}
			if(qdata.equals("sports")) {
				output = "Some sports I like are: " + listToString(personality.getLikesSports());
			}
			if(qdata.equals("countries")) {
				output = "Some countries I like are: " + listToString(personality.getLikesCountries());
			}
			if(qdata.equals("howru")) {
				output = "I'm good, thanks for asking!";
			}
			if(qdata.equals("likes")) {
				output = "Some things I like are: " + listToString(personality.getLikes());
			}
			if(qdata.equals("dislikes")) {
				output = "Some Things I dislike are: " + listToString(personality.getDislikes());
			}
		}

		return output;
	}

	/**
	 * Covert ArrayList to String
	 * 
	 * @return string with respect to getDisLikes() and getLikes() methods
	 */
	public String listToString(ArrayList<String> list) {
		String listString = "";
		for (String s : list) {
			listString += s + "\n";
		}
		return listString;
	}

}
