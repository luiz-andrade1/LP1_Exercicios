package org.salao.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.salao.App;
import org.salao.DAO.ClienteDAO;
import org.salao.DataBaseConnection.ConexaoBD;
import org.salao.Model.Cliente;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteController {

    Cliente cliente;

    @FXML
    private Button btAniversario;

    @FXML
    private Button btCadastro;

    @FXML
    private Button btChegar;

    @FXML
    private Button btTipoCliente;

    @FXML
    private Button btVoltar;

    @FXML
    private Label lbTexto;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTipoCliente;

    @FXML
    void cadCliente(ActionEvent event) {
        ClienteDAO dao = new ClienteDAO();
        cliente = new Cliente(txtNome.getText(),txtTipoCliente.getText(),Integer.parseInt(txtIdade.getText()));
        dao.cadastrarCliente(cliente);
        txtNome.clear();
        txtTipoCliente.clear();
        txtIdade.clear();
    }

    @FXML
    void clienteChegou(ActionEvent event) {
        lbTexto.setText(cliente.clienteChegou());
    }

    @FXML
    void fazerAniversario(ActionEvent event) {
        lbTexto.setText(cliente.fazerAniversario());
    }

    @FXML
    void mostrarTipoCliente(ActionEvent event) {
        lbTexto.setText(cliente.mostrarTipoCliente());
    }

    @FXML
    void switchToSalao(ActionEvent event) throws IOException {
        App.setRoot("salao");
    }

}