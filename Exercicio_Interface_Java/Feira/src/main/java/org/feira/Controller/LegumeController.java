package org.feira.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.feira.App;
import org.feira.DataBaseConnection.ConexaoBD;
import org.feira.Model.Legume;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LegumeController {

    Legume legume;

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
    void cadLegume(ActionEvent event) {
        legume = new Legume (txtNome.getText(),Integer.parseInt(txtQuantidade.getText()),Double.parseDouble(txtValor.getText()));
        String sql = "INSERT INTO legume (nome, quantidade, valor) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, legume.getNome());
            stmt.setInt(2, legume.getQuantidade());
            stmt.setDouble(3, legume.getValor());
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
        lbTexto.setText(legume.mostrarQuantidade());
    }

    @FXML
    void mostrarValor(ActionEvent event) {
        lbTexto.setText(legume.mostrarValor());
    }

    @FXML
    void vendeu(ActionEvent event) {
        lbTexto.setText(legume.vendeu());
    }

    @FXML
    void switchToFeira(ActionEvent event) throws IOException {
        App.setRoot("feira");
    }


}
