package client;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import server.MySqlConnection;

public class DisplaySubscriberOrdersController {

	@FXML
	private TextField searchField;

	@FXML
	private VBox dataContainer;

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
			System.out.println("moved from Display Subscriber Orders GUI to main GUI");// notation line
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error loading Connect Page: " + e.getMessage());
		}
	}

	@FXML
	void SearchBtn(ActionEvent event) throws SQLException {
		String searchInput = searchField.getText();
		System.out.println("Subscriber Number Entered is " + searchInput); // Debug line

		ResultSet rs = MySqlConnection.searchOrdersOfSubscriber(searchInput);
		dataContainer.getChildren().clear(); // clear old results

		try {
			while (rs != null && rs.next()) {
				GridPane row = new GridPane();
				row.setHgap(5);

				Label parkingSpace = new Label(rs.getString("parking_space"));
				Label orderNumber = new Label(rs.getString("order_number"));
				Label orderDate = new Label(rs.getString("order_date"));
				Label confirmationCode = new Label(rs.getString("confirmation_code"));
				Label subscriberId = new Label(rs.getString("subscriberNumber"));
				Label placingDate = new Label(rs.getString("date_of_placing_an_order"));

				parkingSpace.setPrefWidth(115);
				parkingSpace.setPadding(new Insets(5));
				parkingSpace.setAlignment(Pos.CENTER);
				orderNumber.setPrefWidth(111);
				orderNumber.setPadding(new Insets(5));
				orderNumber.setAlignment(Pos.CENTER);
				orderDate.setPrefWidth(92);
				orderDate.setPadding(new Insets(5));
				orderDate.setAlignment(Pos.CENTER);
				confirmationCode.setPrefWidth(131);
				confirmationCode.setPadding(new Insets(5));
				confirmationCode.setAlignment(Pos.CENTER);
				subscriberId.setPrefWidth(93);
				subscriberId.setPadding(new Insets(5));
				subscriberId.setAlignment(Pos.CENTER);
				placingDate.setPrefWidth(169);
				placingDate.setPadding(new Insets(5));
				placingDate.setAlignment(Pos.CENTER);
				// Optional: style your labels here if you want uniform padding, etc.
				for (Label label : new Label[] { parkingSpace, orderNumber, orderDate, confirmationCode, subscriberId,
						placingDate }) {
					label.setStyle("-fx-padding: 5;");
				}

				row.add(parkingSpace, 0, 0);
				row.add(orderNumber, 1, 0);
				row.add(orderDate, 2, 0);
				row.add(confirmationCode, 3, 0);
				row.add(subscriberId, 4, 0);
				row.add(placingDate, 5, 0);

				dataContainer.getChildren().add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error displaying subscriber orders: " + e.getMessage());
		}
	}

}
