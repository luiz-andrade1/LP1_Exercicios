package org.salao.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.salao.App;

import java.io.IOException;

public class SalaoController {

    @FXML
    private Button btCliente;

    @FXML
    private Button btColaborador;

    @FXML
    private Button btServico;

    @FXML
    void switchToCliente(ActionEvent event) throws IOException {
        App.setRoot("cliente");
    }

    @FXML
    void switchToColaborador(ActionEvent event) throws IOException {
        App.setRoot("colaborador");
    }

    @FXML
    void switchToServico(ActionEvent event) throws IOException {
        App.setRoot("servico");
    }

}
