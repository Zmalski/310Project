import static org.junit.Assert.assertTrue;

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
		String parseIn = testresponse.parseInput(input);
		String output = testresponseBack.respond(parseIn, p);

		String expectedOutput = "I am 22 year old.";
		assertTrue(expectedOutput.equals(output));
	}
	@Test
	public void test() {
		
	}
}