import java.util.ArrayList;
import java.util.HashMap;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TheGameOfMorra extends Application {
	
	////////FIRST SCENE VARIABLES
	PauseTransition pause = new PauseTransition(Duration.seconds(3));
	Button connectServer = new Button("Connect to Server");	
	HashMap<String, Scene> sceneMap1; 	
	Text txtIP = new Text("IP Address: ");	
	TextField enterIP = new  TextField("");
	Text txtPort= new Text("Port:  ");
	TextField enterPort = new  TextField("");
	

	
	//Utility Varibles for the GUI
	/*
	 * For this port I will incorportate listView
	 * ListView<String> displayQueueItems;
	 */
	Stage clientDisplay;
	Button finger1 = new Button("One finger");
	Button finger2 = new Button("Two fingers");
	Button finger3 = new Button("Three fingers");
	Button finger4 = new Button("Four fingers");
	Button finger5 = new Button("Five fingers");
	
	//Tranitions
	Button submit = new Button("Submit Play and Guess");
	Button quit  = new Button("Quit");
	Button playAgain = new Button("Play Again");
	
	//Setting the TextFields
	Text txt1 = new Text("Choose Your Play:                ");
	Text txt2 = new Text("Make YourGuess:");
	Text txt3 = new Text("Your Points: ");
	Text txt4 = new Text("Opponent's points: ");
	Text txt5 = new Text("Opponent's Play: ");
	Text txt6 = new Text("Opponent's Guess: ");
	
	
	TextField field1 = new TextField(""); // userInput for the guess
	TextField field2 = new TextField(""); //your points
	TextField field5 = new TextField("");  //Opponent's points
	TextField field3 = new TextField(""); // opponent's Play
	TextField field4 = new TextField(""); // oppenent's number of guesses
	

	//Utilities for Framing the Fx Variable Declarations
	//BorderPane pane = new BorderPane();
	GridPane grid1 = new GridPane();
	HBox hbox1 = new HBox();
	HBox hbox2;
	HBox hbox3;
	VBox vbox1 = new VBox();
	VBox vbox2;
	
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		clientDisplay = primaryStage; // In case we want to re-start	
		//First SCENE
		sceneMap1 = new HashMap<String,Scene>();
	


		//MAY USE when entering I
//		addToListBtn.setOnAction(new EventHandler<ActionEvent>(){
//			
//			public void handle(ActionEvent event){
//				myQueue.enqueue(text.getText());;
//				text.clear();
//				
//			}
//		});

		//Utility Varibles for the GUI
		/*
		 * For this port I will incorportate listView
		 * ListView<String> displayQueueItems;
		 */	

	

	//styling buttons
	finger1.setStyle("-fx-font: 15 Times; -fx-base: #b6e7c9;");
	finger2.setStyle("-fx-font: 15 Times; -fx-base: #b6e7c9;");
	finger3.setStyle("-fx-font: 15 Times; -fx-base: #b6e7c9;");
	finger4.setStyle("-fx-font: 15 Times; -fx-base: #b6e7c9;");
	finger5.setStyle("-fx-font: 15 Times; -fx-base: #b6e7c9;");
	playAgain.setStyle("-fx-font: 18 Times; -fx-base: hotpink;");
	quit.setStyle("-fx-font: 18 Times; -fx-base: hotpink;");
	submit.setStyle("-fx-font: 15 Times; -fx-base: hotpink;");
	
	// Setting the sizes and style for each text
	
	txt1.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 20%, red 40%);");
	//txt1.setFontSmoothingType(FontSmoothingType.LCD);
	txt1.setFont(Font.font("Times", FontWeight.BOLD, 40));
	txt2.setFont(Font.font("Times", FontWeight.BOLD, 18));
	txt2.setFill(Color.RED);
	txt3.setFont(Font.font("Times", FontWeight.BOLD, 20));
	//txt3.setFill(Color.RED);
	txt4.setFont(Font.font("Times", FontWeight.BOLD, 20));
	//txt4.setFill(Color.RED);
	txt5.setFont(Font.font("Times", FontWeight.BOLD, 18));
	txt5.setFill(Color.RED);
	txt6.setFont(Font.font("Times", FontWeight.BOLD, 18));
	txt6.setFill(Color.RED);

	
    //Adding to Vbox
    vbox1.getChildren().add(txt1);  //adding text on top of button
    hbox1.getChildren().add(finger1);
    hbox1.getChildren().add(finger2);
    hbox1.getChildren().add(finger3);
    hbox1.getChildren().add(finger4);
    hbox1.getChildren().add(finger5);      
    vbox1.getChildren().add(hbox1);   // putting all buttons in vbox   
    hbox3 = new HBox(15,txt2, field1);      
    vbox1.getChildren().add(hbox3);   // putting text and guess under all buttons
    vbox1.getChildren().add(submit);
    hbox2 = new HBox(20,playAgain, quit ); 
    hbox2.setAlignment(Pos.CENTER);
    
    
    field2.setMaxSize(100, 10);
    field3.setMaxSize(100, 10);
    field4.setMaxSize(100, 10);
    field5.setMaxSize(100, 10);
  
	
	primaryStage.setTitle("(Client) Let's Play Morra!!!");			
	connectServer.setOnAction(e -> primaryStage.setScene(sceneMap1.get("scene2")));
	sceneMap1.put("scene1",createScene1());
	sceneMap1.put("scene2",createScene2());
	
	primaryStage.setScene(sceneMap1.get("scene1"));
	//primaryStage.setScene(sceneMap1.get("scene2"));
	

	primaryStage.show(); 

		
	} // end starter


	//Creating helper function make first Scene
	public Scene createScene1() {
		BorderPane pane1= new BorderPane();
		pane1.setPadding(new Insets(50));
		
//		Button connectServer = new Button("Connect to Server");
//		
//		HashMap<String, Scene> sceneMap1; 
//		
//		Text txtIP = new Text("IP Addrees: ");
//		TextField enterIP = new  TextField("");
//		
//		
//		Text txtPort= new Text("Port: ");
//		TextField enterPort = new  TextField("");
		
		Image pic1 = new Image("PLAY.png");
		ImageView v1 = new ImageView(pic1);
		v1.setOpacity(0.20);
		v1.setFitHeight(200);
		v1.setFitWidth(500);
		HBox hbox_pic = new HBox(v1);
		hbox_pic.setAlignment(Pos.TOP_CENTER);		
		txtIP.setFont(Font.font("Times", FontWeight.BOLD, 40));
		txtPort.setFont(Font.font("Times", FontWeight.BOLD, 30));

		HBox hboxs1 = new HBox( txtIP,enterIP );
		HBox hboxs2 = new HBox( txtPort,enterPort);
		VBox vboxs1 = new VBox(hboxs1,hboxs2);
		vboxs1.setAlignment(Pos.CENTER);
		
		pane1.setTop(hbox_pic);
		pane1.setCenter(vboxs1);
		connectServer.setStyle("-fx-background-color: lightgreen;");
		pane1.setBottom(connectServer);
		
		pane1.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, orange  40%);  ;");
		
		return new Scene(pane1, 700, 550);
	}// end Scene one 
	

	//Creating helper function make Second Scene
		public Scene createScene2() {
			
			BorderPane pane = new BorderPane();		
			Image pic = new Image("letsPlay.png");
			ImageView v = new ImageView(pic);
			v.setOpacity(0.20);
			v.setFitHeight(200);
			v.setFitWidth(700);
			
		    VBox vboxpic = new VBox(v);
		    vboxpic.setAlignment(Pos.TOP_CENTER);
		    VBox vbox3 = new VBox(10, txt3,field2, txt4, field5 ,vboxpic);
		  
		    vbox3.setAlignment(Pos.TOP_LEFT);
		    VBox vbox4 = new VBox(txt5,field3, txt6,field4 );
		    vbox4.setAlignment(Pos.CENTER);
		    vbox1.setAlignment(Pos.CENTER);
		   
		    // Adding things to borderpane
		    pane.setTop(vbox3);
		    pane.setLeft(vbox4);
		    pane.setRight(vbox1);    
		    pane.setBottom(hbox2); 		
		    pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, indigo  40%);  ");
		
			return new Scene(pane, 700, 550);
		}// end scene two 
	
	
}// end of TheGameOfMorra Application 


























