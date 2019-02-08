
public class Personality {
	// James Boonstra
	
	public Personality(String gender) {
		setGender(gender);
		setZodiacSign(setString(PersonalityGenerator.zodiacSigns));
		setOccupation(setString(PersonalityGenerator.occupations));
	}
	
	private String gender;
	private String zodiacSign;
	private String occupation;
	
	
	private String[] likes;
	private String[] dislikes;
	
	
	
	public static String setString(String[] string) {
		int random = random(string.length-1);
		return string[random];
	}
	
	/**
	 * 
	 * @param array
	 * @return An array of randomized strings from the given list
	 */
	private String[] setArray(String[] array, int choose) {
		for(int i = 0; i < choose; i++) {
			int random = random(array.length-1);
			
			}
		return array;
	}
	
	/**
	* A random number generator
	*@param upperBound 
	*@return A number between 0 and upperBound
	*/
	static int random(int upperBound) {
		return (int)(Math.random() * upperBound +1);
	}
	
	
	
	public String isGender() {
		return gender;
	}
	private void setGender(String gender) {
		this.gender = gender;
	}
	public String getZodiacSign() {
		return zodiacSign;
	}
	private void setZodiacSign(String zodiacSign) {
		this.zodiacSign = zodiacSign;
	}
	public String getOccupation() {
		return occupation;
	}
	private void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String[] getLikes() {
		return likes;
	}
	private void setLikes(String[] likes) {
		this.likes = likes;
	}
	public String[] getDislikes() {
		return dislikes;
	}
	private void setDislikes(String[] dislikes) {
		this.dislikes = dislikes;
	}
	
	

	
		
	
}
