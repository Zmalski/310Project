import java.io.*;
import java.util.Scanner;
public class handleInput {
	private String name;
	public handleInput(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void getUserInput() {
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		//call method for parsing input, pass input string
	}
	//method for parsing input and returning relvenat values / semantics / meaing of the string.
}
