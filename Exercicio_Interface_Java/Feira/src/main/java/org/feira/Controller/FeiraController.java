package org.feira.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.feira.App;

import java.io.IOException;

public class FeiraController {


    @FXML
    private Button btFruta;

    @FXML
    private Button btLegume;

    @FXML
    private Button btVerdura;

    @FXML
    void switchToFruta(ActionEvent event) throws IOException {
        App.setRoot("fruta");
    }

    @FXML
    void switchToLegume(ActionEvent event) throws IOException {
        App.setRoot("legume");
    }

    @FXML
    void switchToVerdura(ActionEvent event) throws IOException {
        App.setRoot("verdura");
    }

}
