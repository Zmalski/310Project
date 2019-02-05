import java.io.*;
import java.util.Scanner;
public class main {
	public static void main(String [] args) {
		//Initial input to get the name of the user and introduce them to the program.
		Scanner reader = new Scanner(System.in);
		System.out.println("Hello, nice to meet you! I'm BerthaBot, what's your name?");
		String name = reader.nextLine(); 
		System.out.println("Alright " + name + " lets start out blind date!");	
		handleInput inputHandler = new handleInput(name);
	}
}

