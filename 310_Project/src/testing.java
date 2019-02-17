import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;

public class testing {
	determineOutput determineOutput = new determineOutput();
	handleInput handleInput = new handleInput();
	Personality p = new Personality();
	/*
	 * Pardeep Rathore 
	 * 
	 */
	/**
	 * The method below tests two methods: 
	 * checkOccupation() from handleInput class and occupation() method from determineOutput class.
	 */
	@Test
	public void testoccupation() {
		String input = "i am Software Developer";
		String parseinput = handleInput.checkOccupation(input);
		String occ = determineOutput.occupation(parseinput);

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
	public void testParseInput() {
		String input = "What are your likes?";
		String parseIn = handleInput.parseInput(input);
		String expectedOutput = "qlikes";
		
		assertTrue(expectedOutput.equals(parseIn));
	}
	@Test
	public void testrespond() {
		String input = "What is your age?";
		//The string will be trimmed by parseinput() method and will return a keyword(qage)
		String parseIn = handleInput.parseInput(input);
		//The keyword(qage) will call the response and produce the output
		String output = determineOutput.respond(parseIn, p);

		String expectedOutput = "I am 22 year old.";
		assertTrue(expectedOutput.equals(output));
	}
	@Test
	public void ArrayListToString() {
		ArrayList<String> ArrayLIST = new ArrayList<>();
		ArrayLIST.add("waterboarding");
		ArrayLIST.add("tennis");
		ArrayLIST.add("curling");
		ArrayLIST.add("skiing");
		
		String returnAsStrings = determineOutput.returnArrayList(ArrayLIST);
		String expectedOutput = "waterboarding" + "\n" + "tennis" + "\n" + "curling" + "\n" + "skiing" + "\n";
		
		assertTrue(expectedOutput.equals(returnAsStrings));		
	}
	/**
	 * The following method tests the getName method of handleInput Class.  
	 */
	@Test
	public void hadleInputGetName() {
		String name = "Adrian";
		handleInput j = new handleInput(name);
		String outputname = j.getName();
		assertTrue(name.equals(outputname));
	}
	@Test
	public void testReturnGreeting() {
		String s1 = "Hey!!!",s2 = "Hello!!!", s3 = "Hi!!!";
		String methodOutput = determineOutput.returnGreeting();
		
		assertTrue(s1.equals(methodOutput)||s2.equals(methodOutput)||s3.equals(methodOutput));
	}
	@Test
	public void testEndDate() {
		String s1 = "Goodbye!!!",s2 ="Bye!!!",s3 ="See you later!!!";
		String methodOutput = determineOutput.returnEndDate();
		
		assertTrue(s1.equals(methodOutput)||s2.equals(methodOutput)||s3.equals(methodOutput));
	}
	@Test
	public void testQdoing() {
		String s1 = "I am eating pasta.",s2 = "I am doing homework.",s3 = "I am basically talking to you.";
		String methodOutput = determineOutput.returnQdoing();
		
		assertTrue(s1.equals(methodOutput)||s2.equals(methodOutput)||s3.equals(methodOutput));
	}
	@Test
	public void testSwearing() {
		 String data = "hell";
		 String s1 = data + " ? " +"I do not know that you are swearing.", s2= data + " ? " + "It is not appropriate.", s3 = "Did you just actually say " + data + " ?";
		 
		 String methodOutput = determineOutput.returnSwearing(data);
		 assertTrue(s1.equals(methodOutput)||s2.equals(methodOutput)||s3.equals(methodOutput));
	}
	@Test
	public void testHowru() {
		String s1 = "I am doing well.";
		String s2 = "I am great.";
		String s3 = "I am fine.";
		String methodOutput = determineOutput.returnHouwru();	
		
		assertTrue(s1.equals(methodOutput)||s2.equals(methodOutput)||s3.equals(methodOutput));
	}
	@Test
	public void testInsult() {
		String data = "idiot";
		String s1 = "Don't call me " + data, s2= "Why are you calling me "+ data, s3 = "You cannot call me " + data;
		 
		String methodOutput = determineOutput.returnInsult(data);
		assertTrue(s1.equals(methodOutput)||s2.equals(methodOutput)||s3.equals(methodOutput));
	}
	
}
	
