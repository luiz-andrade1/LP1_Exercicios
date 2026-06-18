module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example to javafx.fxml;
    exports org.example;

    opens org.example.farmacia.controller to javafx.fxml;
    opens org.example.feira.controller to javafx.fxml;
    opens org.example.salao.controller to javafx.fxml;
    opens org.example.config to javafx.fxml;
    opens org.example.farmacia.model to javafx.base;
    opens org.example.feira.model to javafx.base;
    opens org.example.salao.model to javafx.base;
}
