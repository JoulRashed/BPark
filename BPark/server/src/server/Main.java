package server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        try {
        	System.out.println("connectToServerGUI.fxml");  // Debug print
        	Parent root = FXMLLoader.load(getClass().getResource("serverMenu.fxml"));

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
