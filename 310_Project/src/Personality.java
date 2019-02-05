
public class Personality {
	// James Boonstra
	
	public Personality() {
		
	}
	
	boolean gender;
	int age;
	String zodiacSign;
	String occupation;
	
	
	String[] likes;
	String[] dislikes;
	
	private void setPersonality() {}
	
	public boolean isGender() {
		return gender;
	}
	private void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	private void setAge(int age) {
		this.age = age;
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
