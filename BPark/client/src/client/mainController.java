package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainController {
	
	@FXML
	void UpdateDetailsBtn(ActionEvent event) {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/client/updatewindow.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Connect Page");
            stage.centerOnScreen();
            stage.show();
            System.out.println("moved from main GUI to Update Window GUI");//notation line
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading Connect Page: " + e.getMessage());
        }
	}
	
	@FXML
	void ExitBtn(ActionEvent event) {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/client/connectToServerGUI.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Connect Page");
            stage.centerOnScreen();
            stage.show();
            System.out.println("moved from main GUI to Connect To Server GUI");//notation line
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading Connect Page: " + e.getMessage());
        }
	}
	
	@FXML
	void DisplayDetailsBtn(ActionEvent event) {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/client/displaySubscriberOrders.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Connect Page");
            stage.centerOnScreen();
            stage.show();
            System.out.println("moved from main GUI to Display Subscriber's Orders GUI");//notation line
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading Connect Page: " + e.getMessage());
        }
	}
}
