package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class connectToServerGUIController {

    // Called when "connect" button is pressed
    @FXML
    void ConnectBtn(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/client/main.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Connect Page");
            stage.centerOnScreen();
            stage.show();
            System.out.println("moved from Connect To Server GUI to main GUI");//notation line
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading Connect Page: " + e.getMessage());
        }
    }

    @FXML
    private void ExitBtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        System.out.println("App Closed");//notation line
    }

}
