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
	public String getUserInput() {
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		return input;
	}
}
