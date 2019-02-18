//import test.Stage;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
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
	public handleInput inputHandler = new handleInput();
	public determineOutput outputDeterminer = new determineOutput();
	public Personality p = new Personality();
	public questionAsker questionAsker = new questionAsker();
	public boolean genderchosen = false;
	public boolean turn = false;
	public boolean nameknown = false;
	public String username = "Human";
	public String chatbotname = "CHATBOTNAME";
	public String botoutput = "";
	public String data = "";
	public String qdata = "";
	public String qresponse[] = new String[2];
	public String question[] = new String[2];	
	public String userinput = "";
	public boolean askName = false;
	public String result;
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Set Scene ***********************************************************
		primaryStage.setTitle("Dating Bot");		
		HBox hb = new HBox();
		HBox hb2 = new HBox();
		
	    Button actionBtn = new Button("Respond");
	    actionBtn.setPrefWidth(100);
	    actionBtn.setPrefHeight(50);
	    
	    TextField outField = new TextField ("You are on a blind date. Would you like to date a man or a woman?");
	    outField.setPrefWidth(500);
	    outField.setPrefHeight(75);
	    
	    
	   
	    hb.getChildren().add(outField);
	    hb.setAlignment(Pos.TOP_LEFT);
	    hb.setPadding(new Insets(20, 20, 20, 20));
	    hb2.getChildren().add(actionBtn);
	    hb2.setAlignment(Pos.BOTTOM_LEFT);
	    hb2.setPadding(new Insets(20, 20, 250, 20));
	    
		StackPane layout = new StackPane();
		layout.getChildren().addAll(hb, hb2);
		Scene scene = new Scene(layout, 600, 400);	
		//layout.setStyle("-fx-background-image: url('https://media.giphy.com/media/nr6Uz7bTJo9uE/giphy.gif');");
		primaryStage.setScene(scene);
		primaryStage.show();
		//***********************************************************************
		actionBtn.setOnAction(new EventHandler<ActionEvent>() {			
		    @Override public void handle(ActionEvent e) {	
		    	TextInputDialog inField = new TextInputDialog();	   
			    inField.setWidth(200);
			    inField.setHeight(50);
		    	//System.out.print("\n" + username + ":");
				//String userinput = inputHandler.getUserInput();
				// Loop is called after desired gender and name are chosen, and begins to loop
				// through response/questions
		    	result = inField.showAndWait().toString();
		    	result = result.substring(9, result.length() - 1);		    	
				if (genderchosen == true && nameknown == true) {
					data = inputHandler.parseInput(result);
					if (data.equals("nothing")) {
						question = questionAsker.ask();
						outField.setText(chatbotname + ": " + question[0]);
						qdata = question[1];
						result = inField.showAndWait().toString();	
						result = result.substring(9, result.length() - 1);
						qresponse = inputHandler.parseQResponse(result.toString(), qdata, p);
						if (userinput.endsWith("?")) {
							botoutput = outputDeterminer.respond(inputHandler.keywordConvert(qdata), p);
							outField.setText(chatbotname + botoutput);
						}
						botoutput = questionAsker.afterAsk(qresponse, qdata);
					} else {
						botoutput = outputDeterminer.respond(data, p);
					}
					outField.setText(chatbotname + ": " + botoutput);
				}
				// Determine desired gender from user
				if (genderchosen == false) {
					String gender = inputHandler.checkGender(result);
					p = new Personality(gender);
					chatbotname = p.getName();
					outField.setText("You are now on a date with a " + gender + " named " + chatbotname + ".");
					genderchosen = true;
				}
				// Determining users name, occupation from user
				else if (nameknown == false) {
					outField.setText(chatbotname + ": Hi! What's your name?");
					//System.out.println(username + ":");
					result = inField.showAndWait().toString();
					result = result.substring(9, result.length() - 1);
					username = inputHandler.parseName(result).substring(0, 1).toUpperCase()
							+ inputHandler.parseName(result).substring(1);
					nameknown = true;
					int random = (int) (Math.random() * 2 + 1);
					if (random == 1)
						outField.setText(chatbotname + ": It's nice to meet you, " + username + ". What do you do for a living?");
					else
						outField.setText(chatbotname + ": That's a lovely name, " + username + ". So, what do you do for a living?");
					//System.out.println(username + ":");
					result = inField.showAndWait().toString();
					result = result.substring(9, result.length() - 1);
					outField.setText(chatbotname + ": " + outputDeterminer.occupation(inputHandler.checkOccupation(result)));
				}
				// End conversation if user types "bye"
				if (inputHandler.parseInput(userinput).equals("bye"))				
				turn = !turn;
		}
	});		
}
}