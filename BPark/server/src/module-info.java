
module server {
	requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;

    opens server to javafx.fxml;
    exports server;
}