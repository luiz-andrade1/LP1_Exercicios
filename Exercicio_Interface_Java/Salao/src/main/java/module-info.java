module org.salao {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.salao to javafx.fxml;
    exports org.salao;
    exports org.salao.Model;
    opens org.salao.Model to javafx.fxml;
    exports org.salao.DataBaseConnection;
    opens org.salao.DataBaseConnection to javafx.fxml;
    exports org.salao.Controller;
    opens org.salao.Controller to javafx.fxml;
}
