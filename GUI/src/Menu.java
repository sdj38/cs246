import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class Menu extends Application {
	String item;
	Thread thread;
	public void start(final Stage primaryStage) throws InterruptedException{
		primaryStage.setTitle("Threads of Glory");
	        
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		Label userName = new Label ("Runnable:");
		grid.add(userName, 0, 0);
		
		Label ready = new Label ("Ready to start");
		grid.add(ready,0,3);
		
		Label thread = new Label ("Threads in Progress");
		grid.add(thread, 1, 3);
		
		
		
		final TextField userTextField = new TextField();
		userTextField.setPromptText("Enter Runnable");
		grid.add(userTextField, 0, 1);;
		
		final ListView<String> start = new ListView<String>();
		final ObservableList<String> items =FXCollections.observableArrayList();
		grid.add(start, 0, 4);
		final ListView<Thread> running = new ListView<Thread>();
		final ObservableList<Thread> viewThread = FXCollections.observableArrayList();
		grid.add(running, 1, 4);

		Button btn = new Button ("Add");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.CENTER_LEFT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 1);
		
		Button endbtn = new Button ("Remove");
		HBox ehbBtn = new HBox(10);
		ehbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		ehbBtn.getChildren().add(endbtn);
		grid.add(ehbBtn, 1, 5);
		
		Button startbtn = new Button ("Start");
		HBox sBtn = new HBox(10);
		sBtn.setAlignment(Pos.BOTTOM_RIGHT);
		sBtn.getChildren().add(startbtn);
		grid.add(sBtn, 0, 5);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				item = userTextField.getText();
				if (!item.equals("")){
				
					items.add(item);
				start.setItems(items);
			}
			}
		});
		
		startbtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				String name = start.getSelectionModel().getSelectedItem();
				Thread thread;
				Runnable run = getThread(name);
				thread = new Thread(run);
				viewThread.add(thread);
				running.setItems(viewThread);
				thread.start();
			}
		});
		
		endbtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				Thread stop =  running.getSelectionModel().getSelectedItem();
				viewThread.remove(running.getSelectionModel().getSelectedItem());
				running.setItems(viewThread);
					threadStop(stop);
			}
		}); 
		
		Scene scene = new Scene (grid, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	//	Platform.runLater(new Runnable(){
		//	public void run(){
				//primaryStage.setScene(null);
		//	}
		//});
		
	}

	protected void threadStop(Thread stop)  {
	//	System.out.println(stop);
		stop.interrupt();
		
	}

	public Runnable getThread(String item){
		Runnable t = null;
		switch (item) {
		case "Count":
			t = new Count();
			//thread = new Thread(Count);
			break;
		case "Rain":
			//thread = new Thread(Rain);
			break;
		case "Sound":
			t = new Sound();
		// threadname = sound.getClass() + "" + t.getId();
			break;
		default:
			break;
		}
		return t;
		
	}
}