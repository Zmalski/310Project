import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Personality {
	// James Boonstra

	private String gender;
	private String zodiacSign;
	private String occupation;

	private ArrayList<String> likesSports;
	private ArrayList<String> dislikes;
	
	/**
	 * 
	 * @param gender
	 */
	public Personality(String gender) {
		setGender(gender);
		setZodiacSign(setString(txtToArray("occupations.txt")));
		setOccupation(setString(txtToArray("occupations.txt")));
		setLikesSports(setArray(txtToArray("occupations.txt"), 3));
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

	public ArrayList<String> getLikesSports() {
		return likesSports;
	}

	private void setLikesSports(ArrayList<String> likesSports) {
		this.likesSports = likesSports;
	}

	public ArrayList<String> getDislikes() {
		return dislikes;
	}

	private void setDislikes(ArrayList<String> dislikes) {
		this.dislikes = dislikes;
	}

}
