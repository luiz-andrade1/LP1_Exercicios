package org.feira.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.feira.App;
import org.feira.DataBaseConnection.ConexaoBD;
import org.feira.Model.Fruta;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FrutaController {

    Fruta fruta;

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
    void cadFruta(ActionEvent event) {
        Fruta fruta = new Fruta(txtNome.getText(),Integer.parseInt(txtQuantidade.getText()),Double.parseDouble(txtValor.getText()));
        String sql = "INSERT INTO fruta (nome, quantidade, valor) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fruta.getNome());
            stmt.setInt(2, fruta.getQuantidade());
            stmt.setDouble(3, fruta.getValor());
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
    void mostrarValor(ActionEvent event) {
        lbTexto.setText(fruta.mostrarValor());
    }

    @FXML
    void quantidadeSobrando(ActionEvent event) {
        lbTexto.setText(fruta.quantidadeSobrando());
    }

    @FXML
    void vendeu(ActionEvent event) {
        lbTexto.setText(fruta.vendeu());
    }

    @FXML
    void switchToFeira(ActionEvent event) throws IOException {
        App.setRoot("feira");
    }

}
