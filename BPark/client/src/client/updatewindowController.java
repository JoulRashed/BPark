package client;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import server.MySqlConnection;

public class updatewindowController {

	@FXML
    private TextField parkingSpaceInput;

	@FXML
    private TextField subscriberNumberInput;
	@FXML
    private TextField subscriberNumberInput1;
	
    @FXML
    private DatePicker newOrderDateInput;
    
    @FXML
    private TextField orderDateOrderNumberInput;
	
    @FXML
    private TextField parkingSpaceOrderNumberInput;
    
	@FXML
	void ExitBtn(ActionEvent event) {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/client/main.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Connect Page");
            stage.centerOnScreen();
            stage.show();
            System.out.println("moved from Update Window GUI to main GUI");//notation line
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading Connect Page: " + e.getMessage());
        }
	}
	
	@FXML 
	 void ParkingSpaceBtn(ActionEvent event) {
		String subscriberNumber = subscriberNumberInput.getText();
		String parkingSpace = parkingSpaceInput.getText();
		String OrderNumber = parkingSpaceOrderNumberInput.getText();
        System.out.println("Parking Space Entered: " + parkingSpace + "\nSubscriber Number Entered:" + subscriberNumber + 
        		"\nOrder Number Input: " + OrderNumber);//debug line
        MySqlConnection.updateParkingSpace(parkingSpace, subscriberNumber, OrderNumber);

    }

    // Handle the second "Confirm" (order date)
    @FXML
    void NewOrderDateInputBtn(ActionEvent event) {
    	try {
    		String subscriberNumber1 = subscriberNumberInput1.getText();
            LocalDate selectedDate = newOrderDateInput.getValue();
    		String OrderNumber = orderDateOrderNumberInput.getText();

            if (selectedDate == null || subscriberNumber1 == null) {
                System.out.println("Invalid or no date selected.");
                return;
            }
            System.out.println("Order Date Selected: " + selectedDate + "\nSusbcriberNumber: " + subscriberNumber1 + 
            		"\nOrder Number Input: " + OrderNumber);
            MySqlConnection.updateDate(selectedDate, subscriberNumber1, OrderNumber);
        } catch (Exception e) {
            System.out.println("Error parsing date: " + e.getMessage());
        } 
    }
    
    
}
