package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
	//IP 192.168.1.151
public class Main extends Application {
    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        try {
        	System.out.println("connectToServerGUI.fxml");  // Debug print
        	Parent root = FXMLLoader.load(getClass().getResource("connectToServerGUI.fxml"));

            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Connect to Server");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	System.out.println("App Started");//notation line
        launch(args);
    }
}
