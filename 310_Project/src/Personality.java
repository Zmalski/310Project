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
	
	private ArrayList<String> likes;
	private ArrayList<String> dislikes;

	private ArrayList<String> likesSports;
	private ArrayList<String> likesMusic;
	private ArrayList<String> likesMovies;
	private ArrayList<String> likesAnimals;
	private ArrayList<String> likesCountries;
	private ArrayList<String> likesHobbies;
	private ArrayList<String> likesFoods;
	private ArrayList<String> dislikesSports;
	private ArrayList<String> dislikesMusic;
	private ArrayList<String> dislikesMovies;
	private ArrayList<String> dislikesAnimals;
	private ArrayList<String> dislikesCountries;
	private ArrayList<String> dislikesHobbies;
	private ArrayList<String> dislikesFoods;
	
	/**
	 * 
	 * 
	 */
	public Personality() {
		this("man");
	}
	
	/**
	 * 
	 * @param gender
	 */
	public Personality(String gender) {
		
		setGender(gender);
		setDislikes();
		setLikes();
		setZodiacSign(setString(txtToArray("zodiac_signs.txt")));
		setOccupation(setString(txtToArray("occupations.txt")));
		setLikesSports(setArray(txtToArray("sports.txt"), random(5)+3));
		setLikesMusic(setArray(txtToArray("music.txt"), random(5)+3));
		setLikesMovies(setArray(txtToArray("movies.txt"), random(5)+3));
		setLikesAnimals(setArray(txtToArray("animals.txt"), random(5)+3));
		setLikesCountries(setArray(txtToArray("countries.txt"), random(5)+3));
		setLikesHobbies(setArray(txtToArray("hobbies.txt"), random(5)+3));
		setLikesFoods(setArray(txtToArray("food.txt"), random(5)+3));
		setDislikesFoods(setArray(txtToArray("food.txt"),this.getLikesFoods(), 3));
		setDislikesSports(setArray(txtToArray("sports.txt"),this.getLikesSports(), 3));
		setDislikesMusic(setArray(txtToArray("music.txt"),this.getLikesMusic(), 3));
		setDislikesMovies(setArray(txtToArray("movies.txt"),this.getLikesMovies(), 3));
		setDislikesAnimals(setArray(txtToArray("animals.txt"),this.getLikesAnimals(), 3));
		setDislikesCountries(setArray(txtToArray("countries.txt"),this.getLikesCountries(), 3));
		setDislikesHobbies(setArray(txtToArray("hobbies.txt"),this.getLikesHobbies(), 3));
		
		if(gender.equals("man"))
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
			result.add("Error File Not Found");
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
	
	private ArrayList<String> setArray(ArrayList<String> array,  ArrayList<String> array2, int choose) {

		ArrayList<String> result = new ArrayList<>();

		for (int i = 0; i < choose; i++) {
			int random = random(array.size() - 1);
			if (i > 0 && contains(result, array2, array.get(random))) {
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
	
	public static boolean contains(ArrayList<String> arr, ArrayList<String> arr1, String item) {
		for (String n : arr) {
			if (n.equals(item)) 
				return true;
			}
		for (String n : arr1) {
			if (n.equals(item)) 
				return true;
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
	
	public ArrayList<String> getLikesFoods() {
		return likesFoods;
	}
	
	public void setLikesFoods(ArrayList<String> likesFoods) {
		this.likesFoods = likesFoods;
	}
	
	public ArrayList<String> getDislikesFoods() {
		return dislikesFoods;
	}
	
	public void setDislikesFoods(ArrayList<String> dislikesFoods) {
		this.dislikesFoods = dislikesFoods;
	}

	public ArrayList<String> getLikes() {
		return likes;
	}
	
	public ArrayList<String> getDislikesSports() {
		return dislikesSports;
	}



	public void setDislikesSports(ArrayList<String> dislikesSports) {
		this.dislikesSports = dislikesSports;
	}



	public ArrayList<String> getDislikesMusic() {
		return dislikesMusic;
	}



	public void setDislikesMusic(ArrayList<String> dislikesMusic) {
		this.dislikesMusic = dislikesMusic;
	}



	public ArrayList<String> getDislikesMovies() {
		return dislikesMovies;
	}



	public void setDislikesMovies(ArrayList<String> dislikesMovies) {
		this.dislikesMovies = dislikesMovies;
	}



	public ArrayList<String> getDislikesAnimals() {
		return dislikesAnimals;
	}



	public void setDislikesAnimals(ArrayList<String> dislikesAnimals) {
		this.dislikesAnimals = dislikesAnimals;
	}



	public ArrayList<String> getDislikesCountries() {
		return dislikesCountries;
	}



	public void setDislikesCountries(ArrayList<String> dislikesCountries) {
		this.dislikesCountries = dislikesCountries;
	}



	public ArrayList<String> getDislikesHobbies() {
		return dislikesHobbies;
	}



	public void setDislikesHobbies(ArrayList<String> dislikesHobbies) {
		this.dislikesHobbies = dislikesHobbies;
	}

	public void setLikes() {
		ArrayList<String> likes = new ArrayList<String>();
		likes.addAll(this.getLikesAnimals());
		likes.addAll(this.getLikesCountries());
		likes.addAll(this.getLikesFoods());
		likes.addAll(this.getLikesHobbies());
		likes.addAll(this.getLikesMovies());
		likes.addAll(this.getLikesMusic());
		likes.addAll(this.getLikesSports());
		
		this.likes = likes;
	}

	public ArrayList<String> getDislikes() {
		return dislikes;
	}

	public void setDislikes() {
		ArrayList<String> dislikes = new ArrayList<String>();
		dislikes.addAll(this.getDislikesAnimals());
		dislikes.addAll(this.getDislikesCountries());
		dislikes.addAll(this.getDislikesFoods());
		dislikes.addAll(this.getDislikesHobbies());
		dislikes.addAll(this.getDislikesMovies());
		dislikes.addAll(this.getDislikesMusic());
		dislikes.addAll(this.getDislikesSports());
		
		this.dislikes = dislikes;
	}

}
