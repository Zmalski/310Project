import java.io.*;
import java.util.InputMismatchException;
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
	/**
	 Call this when you want user input.  
	 It makes sure a user enters a string.
	 **/
	public String getUserInput() {
		Scanner reader = new Scanner(System.in);
		String input = "";
		try {
			input = reader.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("Please enter words I can understand.");
			//Recursive call if they don't enter a string.
			getUserInput();
		}
		return input;
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
		String output = "notfound";
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
	
	/**
	 * Returns the gender based on string
	 * @param input
	 * @return gender contained within the input string
	 */
	public String checkGender(String input) {
		boolean gender = true;
		input = processInput(input);
		String[] boy = {"girl","woman","female","dudette"};
		String[] girl = {"boy","man","male","guy","dude"};
		for(String g : girl) {
			if(input.matches("(.*)" + g + "(.*)"))
			gender = false;
		}
		for(String b : boy) {
			if(input.matches("(.*)" + b + "(.*)"))
			gender = true;
		}
		if(gender == false)
			return "man";
		else
			return "woman";
	}
	
	/**
	 * Returns the gender based on string
	 * @param input
	 * @return gender contained within the input string
	 */
	public String parseInput(String input) {
	input = processInput(input);
	String data = "";
    Scanner scanner = null;
    boolean end = false;
    try {
        scanner = new Scanner(new File("greetings.txt"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();  
    }
    while (scanner.hasNextLine()) {
            Scanner scanner2 = new Scanner(scanner.nextLine());
        while (scanner2.hasNext()) {
            String s = scanner2.next();
            if (input.matches("(.*)" + s + "(.*)")) {
            	data = "greeting";
            	end = true;
            	break;
            }
        }
        if(end == true)
        	break;
    }
    return data;
	}	
	 /**
	 * Does a decent job at guessing what a name from a string after being requested
	 * @param input
	 * @return name contained within the input string
	 */
	public String parseName(String input) {
		String [] words = input.split(" ");
		if(words.length < 2)
			return words[words.length-1];
		int capcount = 0;
		int lastindex = 0;
		int count = 0;
		for(String word : words) {
			if(Character.isUpperCase(word.charAt(0))) {
				capcount++;
				lastindex = count;
			}
			count++;
		}
		if(capcount > 1)
			return words[lastindex];
		else if (words[0].toLowerCase().equals("my") || words[0].toLowerCase().equals("i'm") || words[0].toLowerCase().equals("im"))
			return words[words.length-1];
		else
			return words[0];
	}
	//method for parsing input and returning relvenat values / semantics / meaning of the string.
	}