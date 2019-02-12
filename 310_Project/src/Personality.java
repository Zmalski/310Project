import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Personality {
	// James Boonstra

	private String gender;
	private String name;
	private String zodiacSign;
	private String occupation;

	private ArrayList<String> likesSports;
	private ArrayList<String> likesMusic;
	private ArrayList<String> likesMovies;
	private ArrayList<String> likesAnimals;
	private ArrayList<String> likesCountries;
	private ArrayList<String> likesHobbies;
	
	
	/**
	 * 
	 * @param gender
	 */
	public Personality(String gender) {
		setGender(gender);
		setZodiacSign(setString(txtToArray("zodiac_signs.txt")));
		setOccupation(setString(txtToArray("occupations.txt")));
		setLikesSports(setArray(txtToArray("sports.txt"), 3));
		setLikesMusic(setArray(txtToArray("music.txt"), 3));
		setLikesMovies(setArray(txtToArray("movies.txt"), 3));
		setLikesAnimals(setArray(txtToArray("animals.txt"), 3));
		setLikesCountries(setArray(txtToArray("countries.txt"), 3));
		setLikesHobbies(setArray(txtToArray("hobbies.txt"), 3));
		if(gender.equals("male"))
			setName(setString(txtToArray("names_boys.txt")));
		else
			setName(setString(txtToArray("names_girls.txt")));
	}

	

	/**
	 * 
	 * @param filename
	 * @return
	 */
	public ArrayList<String> txtToArray(String filename) {
		ArrayList<String> result = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));

			while (br.ready()) {
				result.add(br.readLine());
			}
				
			br.close();	
			return result;
			
		} catch (IOException e) {
			System.out.println("Error File Not Found");
			return result;
		}
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public static String setString(ArrayList<String> string) {
		int random = random(string.size()-1);
		return string.get(random);
	}

	/**
	 * 
	 * @param array
	 * @return An array of randomized strings from the given list
	 */
	private ArrayList<String> setArray(ArrayList<String> array, int choose) {

		ArrayList<String> result = new ArrayList<>();

		for (int i = 0; i < choose; i++) {
			int random = random(array.size() - 1);
			if (i > 0 && contains(result, array.get(random))) {
				i--;
			} else {
				result.add(array.get(random));
			}
		}
		return result;
	}

	/**
	 * 
	 * @param arr
	 * @param item
	 * @return
	 */
	public static boolean contains(ArrayList<String> arr, String item) {
		for (String n : arr) {
			if (n.equals(item)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * A random number generator
	 * 
	 * @param upperBound
	 * @return A number between 0 and upperBound
	 */
	static int random(int upperBound) {
		return (int) (Math.random() * upperBound + 1);
	}

	public String getGender() {
		return gender;
	}

	private void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public ArrayList<String> getLikesSports() {
		return likesSports;
	}

	private void setLikesSports(ArrayList<String> likesSports) {
		this.likesSports = likesSports;
	}

	public ArrayList<String> getLikesMusic() {
		return likesMusic;
	}

	public void setLikesMusic(ArrayList<String> likesMusic) {
		this.likesMusic = likesMusic;
	}

	public ArrayList<String> getLikesMovies() {
		return likesMovies;
	}

	public void setLikesMovies(ArrayList<String> likesMovies) {
		this.likesMovies = likesMovies;
	}

	public ArrayList<String> getLikesAnimals() {
		return likesAnimals;
	}

	public void setLikesAnimals(ArrayList<String> likesAnimals) {
		this.likesAnimals = likesAnimals;
	}

	public ArrayList<String> getLikesCountries() {
		return likesCountries;
	}

	public void setLikesCountries(ArrayList<String> likesCountries) {
		this.likesCountries = likesCountries;
	}

	public ArrayList<String> getLikesHobbies() {
		return likesHobbies;
	}

	public void setLikesHobbies(ArrayList<String> likesHobbies) {
		this.likesHobbies = likesHobbies;
	}

}
