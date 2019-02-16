
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
	 * Returns an array containing a question to ask user and a keyword for data processing
	 * 
	 * @param void
	 * @return Array containing question and question keyword
	 */
	public String[] ask() {
		// TODO Add some randomization to the questions so there is variety.
		String outputArray[] = new String[1];
		if (movies == false) {
			outputArray[0] = "What movies do you like?";
			outputArray[1] = "movies";
			movies = true;
		} else if (music == false) {
			outputArray[0] = "What music do you like?";
			outputArray[1] = "music";
			music = true;
		} else if (countries == false) {
			outputArray[0] = "What music do you like?";
			outputArray[1] = "music";
			music = true;
		} else if (likes == false) {
			outputArray[0] = "What music do you like?";
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
		}
		else {
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
