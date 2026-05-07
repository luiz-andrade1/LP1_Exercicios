module Farmacia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports farmacia;
    opens farmacia to javafx.fxml;
    exports farmacia.ClassModel;
    opens farmacia.ClassModel to javafx.fxml;
    exports farmacia.ClassController;
    opens farmacia.ClassController to javafx.fxml;
    exports farmacia.DataBaseConnection;
    opens farmacia.DataBaseConnection to javafx.fxml;
}
