import java.io.*;
import java.util.Scanner;
public class handleInput {
	private String name;
	public handleInput(String name) {
		this.name = name;
	}
	public handleInput() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return this.name;
	}
	public String getUserInput() {
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		return input;
		//call method for parsing input, pass input string
	}
	/**
	 * Returns an output string that is much easier to parse, with all case ignored and punctuation removed.
	 * @param input
	 * @return String converted to lowercase, with all punctuation removed
	 */
	public String processInput(String input) {
		String output = input.toLowerCase();
		output = output.replaceAll("(?:--|[\\[\\]{}()+/\\\\]).,", "");
		return output;
	}
	
	/**
	 * Returns the occupation
	 * @param input
	 * @return occupation contained within the input string
	 */
	public String checkOccupation(String input) {
		input = processInput(input);
		String output = "Unemployed";
	    Scanner scanner = null;
	    boolean end = false;
	    try {
	        scanner = new Scanner(new File("occupations.txt"));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();  
	    }
	    while (scanner.hasNextLine()) {
	            Scanner scanner2 = new Scanner(scanner.nextLine());
	        while (scanner2.hasNext()) {
	            String s = scanner2.next();
	            if (input.matches("(.*)" + s + "(.*)")) {
	            	output = s;
	            	end = true;
	            	break;
	            }
	        }
	        if(end == true)
	        	break;
	    }
	    return output;
	}
	
	
	

	
	
	//method for parsing input and returning relvenat values / semantics / meaing of the string.
}
