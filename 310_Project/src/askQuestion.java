/*Swakhar
 * 
 */
public class askQuestion {
//	boolean movies = false;
//	boolean countries = false;
//	boolean music = false;
//	boolean likes = false;
//	boolean dislikes = false;
//	boolean food = false;
//	boolean howru = false;
//	boolean sports = false;

	boolean[] keys = new boolean[8]; //keys represents as question number
		
	String [] questions = {"What movies do you like?",
						   "Where would you travel to?",
						   "What music do you like?",
						   "What do you like?",
						   "What do you dislike?",
						   "What food do you like?",
						   "How are you?",
						   "What sports do you like?"};
	public askQuestion() {
		for(int i=0;i<keys.length;i++) {
			keys[i] = false;
		}
	}
	
	public String[] askQ() {
		String [] a = new String[2];
		int j = (int)(Math.random()*8);
		if(keys[j]==false) {
		switch(j) {
		case(0): keys[0] = true;a[1] = "movies";break;
		case(1): keys[1] = true;a[1] = "countries";break;
		case(2): keys[2] = true;a[1] = "music";break;
		case(3): keys[3] = true;a[1] = "likes";break;
		case(4): keys[4] = true;a[1] = "dislikes";break;
		case(5): keys[5] = true;a[1] = "food";break;
		case(6): keys[6] = true;a[1] = "howru";break;
		case(7): keys[7] = true;a[1] = "sports";break;
		}
		a[0] = questions[j];
		}
		return a;
	}

}
