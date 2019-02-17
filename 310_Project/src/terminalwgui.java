
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
	public String botoutput = "";
	public String data = "";
	public String qdata = "";
	public String qresponse[] = new String[50];
	public String question[] = new String[2];
	public questionAsker questionAsker = new questionAsker();
	String userinput = "";
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
	    outField.setPrefWidth(500);
	    outField.setPrefHeight(75);
	    
	    TextField inField = new TextField ("");
	    inField.setPrefWidth(200);
	    inField.setPrefHeight(50);
	   
	    hb.getChildren().add(outField);
	    hb.setAlignment(Pos.TOP_CENTER);
	    hb.setPadding(new Insets(100, 20, 20, 20));
	    hb2.getChildren().addAll(inField, actionBtn);
	    hb2.setAlignment(Pos.BOTTOM_CENTER);
	    hb2.setPadding(new Insets(20, 20, 20, 20));
	    
		StackPane layout = new StackPane();
		layout.getChildren().addAll(hb, hb2);
		Scene scene = new Scene(layout, 900, 500);	
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		layout.setStyle("-fx-background-image: url('https://wallpaperstock.net/wallpapers/thumbs1/34464wide.png');");
		
		userinput = inField.getText().toString();
		
		actionBtn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				// Loop is called after desired gender and name are chosen, and begins to loop
				// through response/questions
				if (genderchosen == true && nameknown == true) {
					data = inputHandler.parseInput(userinput);
					if (data.equals("nothing")) {
						question = questionAsker.ask();
						outField.setText(chatbotname + ": " + question[0]);
						qdata = question[1];
						userinput = inField.getText();
						qresponse = inputHandler.parseQResponse(userinput, qdata, p);
						botoutput = questionAsker.afterAsk(userinput, question[1], p);
					} else {
						botoutput = outputDeterminer.respond(data, p);

					}
					outField.setText(chatbotname + ": " + botoutput);
				}
				// Determine desired gender from user
				if (genderchosen == false) {
					String gender = inputHandler.checkGender(userinput);
					p = new Personality(gender);
					chatbotname = p.getName();
					//System.out.println(chatbotname);
					outField.setText("You are now on a date with a " + gender + " named " + chatbotname + ".");
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
			if (inputHandler.parseInput(userinput).equals("bye"))
				System.exit(0);
			turn = !turn;
		    }
		 });

	}
}

