import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class handleInput {
	private String name;
	// Initalizing patterns to check for what user is asking or saying
	Pattern qdoing = Pattern
			.compile("(?i)((.*)(\\bwhat\\b)(.*)(\\bdoing\\b)(.*)(\\?))|((.*)(\\bwhat's\\b)(.*)(\\bup\\b)(.*)(\\?))");
	Pattern qname = Pattern.compile(
			"(?i)((.*)(\\bwhat\\b)(.*)(\\bname\\b)(.*)(\\?))|((.*)(\\bwhat\\b)(.*)(\\bare you called\\b)(.*)(\\?))|((.*)(\\bwho\\b)(.*)(\\byou\\b)(.*)(\\?))");
	Pattern qage = Pattern.compile(
			"(?i)((.*)(\\bhow\\b)(.*)(\\bold\\b)(.*)(\\?))|((.*)(\\bwhat\\b)(.*)(\\bage\\b)(.*)(\\?))|((.*)(\\bwhen\\b)(.*)(\\bborn\\b)(.*)(\\?))");
	Pattern qlikes = Pattern.compile(
			"(?i)((.*)(\\bwhat\\b)(.*)(\\bhobbies\\b)(.*)(\\?))|((\\bwhat\\b)(.*)(\\bdo for fun\\b)(.*)(\\?))|((.*)(\\bwhat\\b)(.*)(\\blikes\\b)(.*)(\\?))");
	Pattern qdislikes = Pattern.compile(
			"(?i)((.*)(\\bwhat\\b)(.*)(\\bdislike(s)?\\b)(.*)(\\?))|((.*)(\\bwhat\\b)(.*)(\\bnot like\\b)(.*)(\\?))|((.*)(\\bdo you\\b)(.*)(\\bnot like\\b)(.*)(\\?))");
	Pattern qjob = Pattern.compile(
			"(?i)((\\bwhat\\b)(.*)(\\bfor living\\b)(.*)(\\?))|((\\bwhat\\b)(.*)(\\bjob\\b)(.*)(\\?))|((\\bwhat\\b)(.*)(\\bwork\\b)(.*)(\\?))");
	Pattern qzosign = Pattern.compile("(?i)(.*)(\\bwhat\\b)(.*)(\\bsign\\b)(.*)(\\?)");
	Pattern howru = Pattern.compile("(?i)(.*)(\\bhow\\b)(.*)(\\byou\\b)(.*)(\\?)");
	Pattern student = Pattern.compile(
			"(?i)((\\bare\\b)(.*)(\\byou\\b)(.*)(\\bstudent\\b)(.*)(\\?))|((\\bwhat\\b)(.*)(\\bstudy\\b)(.*)(\\?))");
	Pattern qsports = Pattern.compile(
			"(?i)((.*)(\\bdo\\b)(.*)(\\bsports\\b)(.*)(\\?))|((.*)(\\bwhat\\b)(.*)(\\bsports\\b)(.*)(\\?))|((.*)(\\bplay\\b)(.*)(\\bsports\\b)(.*)(\\?))");
	Pattern qmusic = Pattern.compile(
			"(?i)((.*)(\\bdo\\b)(.*)(\\bmusic\\b)(.*)(\\?))|((.*)(\\bwhat\\b)(.*)(\\bmusic\\b)(.*)(\\?))|((.*)(\\bwhat\\b)(.*)(\\blisten to\\b)(.*)(\\?))");
	Pattern qmovies = Pattern.compile(
			"(?i)((.*)(\\bdo\\b)(.*)(\\bmovies\\b)(.*)(\\?))|((.*)(\\bwhat\\b)(.*)(\\bmovies\\b)(.*)(\\?))|((.*)(\\bseen\\b)(.*)(\\bmovies\\b)(.*)(\\?))");
	Pattern qanimals = Pattern.compile(
			"(?i)((.*)(\\bwhat\\b)(.*)(\\banimals\\b)(.*)(\\?))|((.*)(\\bdo\\b)(.*)(\\bpets\\b|\\banimals\\b)(.*)(\\?))|((.*)(\\blike\\b)(.*)(\\bcats\\b|\\bdogs\\b)(.*)(\\?))");
	Pattern qcountries = Pattern.compile(
			"(?i)((.*)(\\bwhere\\b)(.*)(\\btravel\\b)(.*)(\\?))|((.*)(\\bdo\\b)(.*)(\\btravel\\b)(.*)(\\?))|((.*)(\\bif\\b)(.*)(\\btravel\\b)(.*)(\\?))");
	Pattern qfood = Pattern.compile(
			"(?i)((.*)(\\bwhat\\b)(.*)(\\bfood\\b)(.*)(\\?))|((.*)(\\bwhat\\b)(.*)(\\beat\\b)(.*)(\\?))|((.*)(\\bdo\\b)(.*)(\\bfood\\b)(.*)(\\?))");

	public handleInput(String name) {
		this.name = name;
	}

	public handleInput() {
	}

	public String getName() {
		return this.name;
	}

	/**
	 * Call this when you want user input. It makes sure a user enters a string.
	 **/
	public String getUserInput() {
		Scanner reader = new Scanner(System.in);
		String input = "";
		try {
			input = reader.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Please enter words I can understand.");
			// Recursive call if they don't enter a string.
			getUserInput();
		}
		return input;
	}

	/**
	 * Returns an output string that is much easier to parse, with all case ignored
	 * and punctuation removed.
	 * 
	 * @param input
	 * @return String converted to lowercase, with all punctuation removed
	 */
	public String processInput(String input) {
		String output = input.replaceAll("[^a-zA-Z ]", "").toLowerCase();
		return output;
	}

	/**
	 * Returns the occupation
	 * 
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
					scanner2.close();
					break;
				}
			}
			if (end == true)
				break;
		}

		return output;
	}

	/**
	 * Returns the gender based on string
	 * 
	 * @param input
	 * @return gender contained within the input string
	 */
	public String checkGender(String input) {
		boolean gender = true;
		input = processInput(input);
		String[] boy = { "girl", "woman", "female", "dudette" };
		String[] girl = { "boy", "man", "male", "guy", "dude" };
		for (String g : girl) {
			if (input.matches("(.*)" + g + "(.*)"))
				gender = false;
		}
		for (String b : boy) {
			if (input.matches("(.*)" + b + "(.*)"))
				gender = true;
		}
		if (gender == false)
			return "man";
		else
			return "woman";
	}

	/**
	 * Extremely brute force method of parsing input, checks every file
	 * 
	 * @param input string
	 * @return basic intention contained within the input string
	 */
	public String parseInput(String input) {
		String pinput = processInput(input);
		String data = "";
		Scanner scanner = null;// REGEX for what followed by doing followed by ? = (?i)(what)(.*)(doing)(.*)(?)
		boolean end = false;
		// Work in Progress
		// Attention Pardeep - The following data values need to be handled in the
		// respond method within the determineOutput Class.
		boolean matchfound = false;
		Matcher m = qdoing.matcher(input);
		while (matchfound == false) {
			// Asks what the bot is doing
			if (m.matches()) {
				data = "qdoing";
				matchfound = true;
				break;
			} else
				m = qname.matcher(input);
			// Asks what the bot's name is
			if (m.matches()) {
				data = "qname";
				matchfound = true;
				break;
			} else
				m = qage.matcher(input);
			// Asks what the bot's age is
			if (m.matches()) {
				data = "qage";
				matchfound = true;
				break;
			} else
				m = qlikes.matcher(input);
			// Asks what the bot's likes are
			if (m.matches()) {
				data = "qlikes";
				matchfound = true;
				break;
			} else
				m = qdislikes.matcher(input);
			// Asks what the bot's dislikes are
			if (m.matches()) {
				data = "qdislikes";
				matchfound = true;
				break;
			} else
				m = qjob.matcher(input);
			// Asks what the bot's job is
			if (m.matches()) {
				data = "qjob";
				matchfound = true;
				break;
			} else
				m = qzosign.matcher(input);
			// Asks what the bot's zodiac sign is
			if (m.matches()) {
				data = "qzosign";
				matchfound = true;
				break;
			} else
				m = howru.matcher(input);
			// Asks how the bot is doing
			if (m.matches()) {
				data = "howru";
				matchfound = true;
				break;
			} else
				m = student.matcher(input);
			// Asks if the bot is a student
			if (m.matches()) {
				data = "student";
				matchfound = true;
				break;
			} else
				m = qsports.matcher(input);
			// Asks what sports the bot likes
			if (m.matches()) {
				data = "qsports";
				matchfound = true;
				break;
			} else
				m = qmusic.matcher(input);
			// Asks what music the bot likes
			if (m.matches()) {
				data = "qmusic";
				matchfound = true;
				break;
			} else
				m = qmovies.matcher(input);
			// Asks what movies the bot likes
			if (m.matches()) {
				data = "qmovies";
				matchfound = true;
				break;
			} else
				m = qanimals.matcher(input);
			// Asks what animals the bot likes or if it has pets
			if (m.matches()) {
				data = "qanimals";
				matchfound = true;
				break;
			} else
				m = qcountries.matcher(input);
			// Asks what countries or travel aspirations the bot likes
			if (m.matches()) {
				data = "qcountries";
				matchfound = true;
				break;
			} else
				m = qfood.matcher(input);
			if (m.matches()) {
				data = "qfood";
				matchfound = true;
				break;
			}
			if (!input.endsWith("?")) {
				data = "nothing";
				matchfound = true;
				break;
			}
			if (matchfound == false) {
				matchfound = true;
				data = "invalid";
			}
		}
		if (!input.endsWith("?")) {
			try {
				scanner = new Scanner(new File("greetings.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while (scanner.hasNextLine()) {
				Scanner scanner2 = new Scanner(scanner.nextLine());
				while (scanner2.hasNext()) {
					String s = scanner2.next();
					if (pinput.matches("(.*)" + s + "(.*)")) {
						data = "greeting";
						end = true;
						scanner2.close();
						break;
					}
				}
				if (end == true)
					break;
			}
		}
		try {
			scanner = new Scanner(new File("insults.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			Scanner scanner2 = new Scanner(scanner.nextLine());
			while (scanner2.hasNext()) {
				String s = scanner2.next();
				if (pinput.matches("(.*)" + s + "(.*)")) {
					data = "insult";
					end = true;
					scanner2.close();
					break;
				}
			}
			if (end == true)
				break;
		}
		// Scan through swears file, check if input matches any words.
		try {
			scanner = new Scanner(new File("swears.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			Scanner scanner2 = new Scanner(scanner.nextLine());
			while (scanner2.hasNext()) {
				String s = scanner2.next();
				if (pinput.matches("(.*)" + s + "(.*)")) {
					data = "swear";
					end = true;
					scanner2.close();
					break;
				}
			}
			if (end == true)
				break;
		}

		return data;
	}

	/**
	 * Does a decent job at guessing what a name from a string after being requested
	 * 
	 * @param input
	 * @return name contained within the input string
	 */
	public String parseName(String input) {
		String[] words = input.split(" ");
		if (words.length < 2)
			return words[words.length - 1];
		int capcount = 0;
		int lastindex = 0;
		int count = 0;
		for (String word : words) {
			if (Character.isUpperCase(word.charAt(0))) {
				capcount++;
				lastindex = count;
			}
			count++;
		}
		if (capcount > 1)
			return words[lastindex];
		else if (words[0].toLowerCase().equals("my") || words[0].toLowerCase().equals("i'm")
				|| words[0].toLowerCase().equals("im"))
			return words[words.length - 1];
		else
			return words[0];
	}

	/**
	 * Determines what a user responded to a question and returns any matches to the
	 * bots likes/dislikes
	 * 
	 * @param input and data and personality
	 * @return string of matches seperated by comma, first array index is likes,
	 *         second is dislikes
	 */
	public String[] parseQResponse(String input, String data, Personality personality) {
		String[] output = new String[2];
		output[0] = "";
		output[1] = "";
		Scanner scanner = null;
		input = processInput(input);
		String arrayString = "";
		String s = "";
		if (data.equals("movies")) {
			arrayString = listToString(personality.getLikesMovies());
			scanner = new Scanner(arrayString);
			while (scanner.hasNextLine()) {
				s = scanner.nextLine();
				if (input.matches("(.*)" + s + "(.*)")) {
					output[0] = output[0] + s + ", ";
				}
			}
			arrayString = listToString(personality.getDislikesMovies());
			scanner = new Scanner(arrayString);
			while (scanner.hasNextLine()) {
				s = scanner.nextLine();
				if (input.matches("(.*)" + s + "(.*)")) {
					output[1] = output[1] + s + ", ";
				}
			}
		}
		if (data.equals("countries")) {
			arrayString = listToString(personality.getLikesCountries());
			scanner = new Scanner(arrayString);
			while (scanner.hasNextLine()) {
				s = scanner.nextLine();
				if (input.matches("(.*)" + s + "(.*)")) {
					output[0] = output[0] + s + ", ";
				}
			}
			arrayString = listToString(personality.getDislikesCountries());
			scanner = new Scanner(arrayString);
			while (scanner.hasNextLine()) {
				s = scanner.nextLine();
				if (input.matches("(.*)" + s + "(.*)")) {
					output[1] = output[1] + s + ", ";
				}
			}
		}
		if (data.equals("howru")) {
			if(input.matches("(?i)(.*)\\bnot good\\b(.*)|(.*)\\bnot great\\b(.*)|(.*)\\bad day\\b(.*)|(.*)\\bsucks\\b(.*)"))
				output[0] = "bad";
			else
				output[0] = "good";

		}
		if (data.equals("music")) {
			arrayString = listToString(personality.getLikesMusic());
			scanner = new Scanner(arrayString);
			while (scanner.hasNextLine()) {
				s = scanner.nextLine();
				if (input.matches("(.*)" + s + "(.*)")) {
					output[0] = output[0] + s + ", ";
				}
			}
			arrayString = listToString(personality.getDislikesMusic());
			scanner = new Scanner(arrayString);
			while (scanner.hasNextLine()) {
				s = scanner.nextLine();
				if (input.matches("(.*)" + s + "(.*)")) {
					output[1] = output[1] + s + ", ";
				}
			}
		}
		if (data.equals("likes")) {
			arrayString = listToString(personality.getLikes());
			scanner = new Scanner(arrayString);
			while (scanner.hasNextLine()) {
				s = scanner.nextLine();
				if (input.matches("(.*)" + s + "(.*)")) {
					output[0] = output[0] + s + ", ";
				}
			}
		}
		if (data.equals("dislikes")) {
			arrayString = listToString(personality.getDislikes());
			scanner = new Scanner(arrayString);
			while (scanner.hasNextLine()) {
				s = scanner.nextLine();
				if (input.matches("(.*)" + s + "(.*)")) {
					output[0] = output[0] + s + ", ";
				}
			}
		}
		if (data.equals("sports")) {
			arrayString = listToString(personality.getLikesSports());
			scanner = new Scanner(arrayString);
			while (scanner.hasNextLine()) {
				s = scanner.nextLine();
				if (input.matches("(.*)" + s + "(.*)")) {
					output[0] = output[0] + s + ", ";
				}
			}
			arrayString = listToString(personality.getDislikesSports());
			scanner = new Scanner(arrayString);
			while (scanner.hasNextLine()) {
				s = scanner.nextLine();
				if (input.matches("(.*)" + s + "(.*)")) {
					output[1] = output[1] + s + ", ";
				}
			}
		}
		if (input.equals("what"))
			output[0] = "what";
		if (output[0].endsWith(", "))
			output[0] = output[0].substring(0, output[0].length() - 2);
		if (output[1].endsWith(", "))
			output[1] = output[1].substring(0, output[1].length() - 2);

		return output;

	}

	public String keywordConvert(String keyword) {
		if (keyword == "music")
			return "qmusic";
		if (keyword == "movies")
			return "qmovies";
		if (keyword == "countries")
			return "qcountries";
		if (keyword == "sports")
			return "qsports";
		if (keyword == "howru")
			return keyword;
		if (keyword == "likes")
			return "qlikes";
		if (keyword == "dislikes")
			return "qdislikes";
		if (keyword == "food")
			return "qfood";
		else
			return "invalid";
	}

	/**
	 * Covert ArrayList to String
	 * 
	 * @return string with respect to getDisLikes() and getLikes() methods
	 */
	public String listToString(ArrayList<String> list) {
		String listString = "";
		for (String s : list) {
			listString += s + "\n";
		}
		return listString;
	}
}