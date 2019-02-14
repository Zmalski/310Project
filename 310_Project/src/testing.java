import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;

public class testing {
	/*
	 * Pardeep & Swakhar
	 * 
	 */
	/**
	 * The method below tests two methods: 
	 * checkOccupation() from handleInput class and occupation() method from determineOutput class.
	 */
	@Test
	public void testoccupation() {
		determineOutput testresponseBack = new determineOutput();
		handleInput testresponse = new handleInput();
		String input = "i am Software Developer";
		String parseinput = testresponse.checkOccupation(input);
		String occ = testresponseBack.occupation(parseinput);

		String expectedOutput = "Software developer. Wow! thats great.";
		assertTrue(expectedOutput.equals(occ));
	}
	/**
	 * The method below tests two methods: 
	 * parseInput() from handleInput class and respond() method from determineOutput class.
	 * 
	 * This method works fine for only parameter(String) yet. trying to get it work for another parameter (object)
	 */
	@Test
	public void testrespond() {
		determineOutput testresponseBack = new determineOutput();
		handleInput testresponse = new handleInput();
		Personality p = new Personality();

		String input = "What is your age?";
		//The string will be trimmed by parseinput() method and will return a keyword(qage)
		String parseIn = testresponse.parseInput(input);
		//The keyword(qage) will call the response and produce the output
		String output = testresponseBack.respond(parseIn, p);

		String expectedOutput = "I am 22 year old.";
		assertTrue(expectedOutput.equals(output));
	}
	@Test
	public void ArrayListToString() {
		determineOutput testresponseBack = new determineOutput();
		ArrayList<String> ArrayLIST = new ArrayList<>();
		ArrayLIST.add("waterboarding");
		ArrayLIST.add("tennis");
		ArrayLIST.add("curling");
		ArrayLIST.add("skiing");
		
		String returnAsStrings = testresponseBack.returnArrayList(ArrayLIST);
		String expectedOutput = "waterboarding" + "\n" + "tennis" + "\n" + "curling" + "\n" + "skiing" + "\n";
		
		assertTrue(expectedOutput.equals(returnAsStrings));		
	}
}