
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class terminalwgui extends Application{
	public String username = "Human";
	public String chatbotname = "CHATBOTNAME";
	public boolean genderchosen = false;
	public boolean turn = false;
	public boolean nameknown = false;
	public Personality p = new Personality("man");
	public static void main(String[] args) {
		// Initialize required attributes and objects
		// Used for processing input
		launch(args);
	}		
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button;
		handleInput inputHandler = new handleInput();
		// Used to determine output based on processed input
		determineOutput outputDeterminer = new determineOutput();
		
		// Initialize booleans for determining steps in conversation
		
		// Initialize names for identifying speakers
		
		//System.out.println();
		//*************************************************************************************
		primaryStage.setTitle("Dating Bot");		
		HBox hb = new HBox();
		HBox hb2 = new HBox();
		
	    Button actionBtn = new Button("Respond");
	    actionBtn.setPrefWidth(100);
	    actionBtn.setPrefHeight(50);
	    
	    TextField outField = new TextField ("You are on a blind date. Would you like to date a man or a woman?");
	    outField.setPrefWidth(200);
	    outField.setPrefHeight(75);
	    
	    TextField inField = new TextField ("");
	    inField.setPrefWidth(200);
	    inField.setPrefHeight(50);
	   
	    hb.getChildren().add(outField);
	    hb.setAlignment(Pos.TOP_CENTER);
	    hb.setPadding(new Insets(20, 20, 20, 20));
	    hb2.getChildren().addAll(inField, actionBtn);
	    hb2.setAlignment(Pos.BOTTOM_RIGHT);
	    hb2.setPadding(new Insets(20, 20, 20, 20));
	    
		StackPane layout = new StackPane();
		layout.getChildren().addAll(hb, hb2);
		Scene scene = new Scene(layout, 680, 440);	
		
		//if female ->
		layout.setStyle("-fx-background-image: url('https://cdn1.thr.com/sites/default/files/imagecache/scale_crop_768_433/2018/03/jessica_alba.jpg');");
		//if male - >
		//layout.setStyle("-fx-background-image: url('https://ca.hellomagazine.com/imagenes/celebrities/2018012945862/david-beckham-miami-major-league-soccer-team-news/0-230-943/david-beckham-t.jpg');");
		actionBtn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
			//System.out.print("\n" + username + ":");
			String userinput = inputHandler.getUserInput();
			// Loop is called after desired gender and name are chosen, and begins to loop through response/questions
			if (genderchosen == true && nameknown == true) {
				String data = inField.getText();
				String botoutput = outputDeterminer.respond(data, p);
				outField.setText(chatbotname + ": " + botoutput);
			}
			// Determine desired gender from user
			if (genderchosen == false) {
				String gender = inputHandler.checkGender(userinput);
				//This is just an example of setting the chatbotname, will be changed
				outField.setText("You are now on a date with a " + gender + " named " + chatbotname + ".");
				p = new Personality(gender);
				chatbotname = p.getName();
				genderchosen = true;
			}
			// Determining users name, occupation from user
			if (nameknown == false) {
				outField.setText(chatbotname + ": Hi! What's your name?");
				//System.out.println(username + ":");
				userinput = inField.getText();
				username = inputHandler.parseName(userinput).substring(0, 1).toUpperCase()
						+ inputHandler.parseName(userinput).substring(1);
				nameknown = true;
				int random = (int) (Math.random() * 2 + 1);
				if (random == 1)
					outField.setText(chatbotname + ": It's nice to meet you, " + username + ". What do you do for a living?");							
				else
					outField.setText(chatbotname + ": That's a lovely name, " + username + ". So, what do you do for a living?");
				//System.out.println(username + ":");
				userinput = inField.getText();
				outField.setText(chatbotname + ": " + outputDeterminer.occupation(inputHandler.checkOccupation(userinput)));
			}
			//End conversation if user types "bye"
			if (inputHandler.parseInput(userinput).equals("bye"))
				System.exit(0);
			turn = !turn;
		    }
		 });
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

