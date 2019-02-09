public class Personality {
	// James Boonstra
	
	public Personality(String gender) {
		setGender(gender);
		setZodiacSign(setString(Attributes.zodiacSigns));
		setOccupation(setString(Attributes.occupations));
		setLikesSports(setArray(Attributes.sports,3));
		for(String n : this.getLikesSports()) {
			System.out.println(n);
			
		}
	}
	
	
	private String gender;
	private String zodiacSign;
	private String occupation;
	
	
	private String[] likesSports;
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
		
		String[] newArray = new String[choose];
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = "";
		}
		
		for(int i = 0; i < choose; i++) {
			int random = random(array.length-1);
			if(i>0 && contains(newArray,array[random])) {
				i--;
			}
			else {
				newArray[i] = array[random];
			}
		}
		return newArray;
	}
	
	public static boolean contains(String[] arr, String item) {
	      for (String n : arr) {
	         if (n.equals(item)) {
	            return true;
	         }
	      }
	      return false;
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
	public String[] getLikesSports() {
		return likesSports;
	}
	private void setLikesSports(String[] likesSports) {
		this.likesSports = likesSports;
	}
	public String[] getDislikes() {
		return dislikes;
	}
	private void setDislikes(String[] dislikes) {
		this.dislikes = dislikes;
	}
	
	

	
		
	
}

