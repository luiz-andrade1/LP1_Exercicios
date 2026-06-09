package org.salao.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.salao.App;
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
        cliente = new Cliente(txtNome.getText(),txtTipoCliente.getText(),Integer.parseInt(txtIdade.getText()));
        String sql = "INSERT INTO cliente (nome, tipoCliente, idade) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTipoCliente());
            stmt.setInt(3, cliente.getIdade());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
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