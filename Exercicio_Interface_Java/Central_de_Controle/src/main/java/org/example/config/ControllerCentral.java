package org.example.config;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.App;
import java.io.IOException;

public class ControllerCentral {

    @FXML
    private Button botaoFarmacia;

    @FXML
    private Button botaoFeira;

    @FXML
    private Button botaoSalao;

    @FXML
    void switchToFarmacia(ActionEvent event) throws IOException {
        App.setRoot("farmacia");
    }

    @FXML
    void switchToFeira(ActionEvent event) throws IOException {
        App.setRoot("feira");
    }

    @FXML
    void switchToSalao(ActionEvent event) throws IOException {
        App.setRoot("salao");
    }

}

