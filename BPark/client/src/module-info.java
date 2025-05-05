module client {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires server;
	requires java.sql; // ← this is crucial
	
    opens client to javafx.fxml;
    exports client;
}
