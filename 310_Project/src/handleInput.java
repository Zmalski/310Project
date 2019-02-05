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
	//method for parsing input and returning relvenat values / semantics / meaing of the string.
}
