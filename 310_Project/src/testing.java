import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class testing {
	/*Pardeep & Swakhar
	 * 
	 */
	@Test
	public void testoccupation() {
	determineOutput testocc = new determineOutput();
	handleInput testocc2 = new handleInput();
	
		//Scanner scanner = new Scanner(System.in);
		String input = "i am Software Developer";
		String parseinput = testocc2.checkOccupation(input);
		String occ =  testocc.occupation(parseinput);
		String s = "Software developer. Wow! thats great.";
		String s2 = "developer";
		assertTrue(s.equals(occ));
	}	
}
