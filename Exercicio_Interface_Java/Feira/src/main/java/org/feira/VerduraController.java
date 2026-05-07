package org.feira;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class VerduraController {

    Verdura verdura;

    @FXML
    private Button btCadastro;

    @FXML
    private Button btQuantidade;

    @FXML
    private Button btValor;

    @FXML
    private Button btVenda;

    @FXML
    private Button btVoltar;

    @FXML
    private Label lbTexto;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtValor;

    @FXML
    void cadVerdura(ActionEvent event) {
        verdura = new Verdura(txtNome.getText(),Integer.parseInt(txtQuantidade.getText()),Double.parseDouble(txtValor.getText()));
        String sql = "INSERT INTO verdura (nome, quantidade, valor) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, verdura.getNome());
            stmt.setInt(2, verdura.getQuantidade());
            stmt.setDouble(3, verdura.getValor());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
        txtNome.clear();
        txtQuantidade.clear();
        txtValor.clear();
    }

    @FXML
    void mostrarQuantidade(ActionEvent event) {
        lbTexto.setText(verdura.mostrarQuantidade());
    }

    @FXML
    void mostrarValor(ActionEvent event) {
        lbTexto.setText(verdura.mostrarValor());
    }

    @FXML
    void vendeu(ActionEvent event) {
        lbTexto.setText(verdura.vendeu());
    }

    @FXML
    void switchToFeira(ActionEvent event) throws IOException {
        App.setRoot("feira");
    }

}
