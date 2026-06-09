module org.salao {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.feira to javafx.fxml;
    exports org.feira;
    exports org.feira.DataBaseConnection;
    opens org.feira.DataBaseConnection to javafx.fxml;
    exports org.feira.Controller;
    opens org.feira.Controller to javafx.fxml;
    exports org.feira.Model;
    opens org.feira.Model to javafx.fxml;
}
