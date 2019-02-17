
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
		// TODO Add some randomization to the questions so there is variety.
		String outputArray[] = new String[1];
		int random = (int) (Math.random() * 2 + 1);
		if (movies == false) {
			//Picks one of three questions, randomly.
			if (random == 1)
				outputArray[0] = "What movies do you like?";
			else if (random == 2)
				outputArray[0] = "Seen any good movies lately?";
			else
				outputArray[0] = "What are some of your favourite movies?";
			outputArray[1] = "movies";
			movies = true;
		} else if (music == false) {
			//Picks one of three questions, randomly.
			if (random == 1)
				outputArray[0] = "What music do you like?";
			else if (random == 2)
				outputArray[0] = "What genres of music do you listen to?";
			else
				outputArray[0] = "Heard any good music lately?";
			outputArray[1] = "music";
			music = true;
		} else if (countries == false) {
			//Picks one of three questions, randomly.
			if (random == 1)
				outputArray[0] = "What countries do you like?";
			else if (random == 2)
				outputArray[0] = "What countries would you like to travel to?";
			else
				outputArray[0] = "Where would you travel if you could travel anywhere?";
			outputArray[1] = "music";
			music = true;
		} else if (likes == false) {
			//Picks one of three questions, randomly.
			if (random == 1)
				outputArray[0] = "What are your hobbies?";
			else if (random == 2)
				outputArray[0] = "What do you like to do in your spare time?";
			else
				outputArray[0] = "What are some of your favourite movies?";
			outputArray[1] = "music";
			music = true;
		} else if (dislikes == false) {
			outputArray[0] = "What music do you like?";
			outputArray[1] = "music";
			music = true;
		} else if (sports == false) {
			outputArray[0] = "What music do you like?";
			outputArray[1] = "music";
			music = true;
		} else {
			outputArray[0] = "Sorry, I'm out of things to talk about!";
			outputArray[1] = "invalid";
		}
		return outputArray;
	}

	public String afterAsk(String input, String qdata) {
		// TODO implement

		return "";
	}

}
