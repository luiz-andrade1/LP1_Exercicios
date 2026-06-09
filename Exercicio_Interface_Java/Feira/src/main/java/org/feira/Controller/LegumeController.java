package org.feira.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.feira.App;
import org.feira.DAO.FrutaDAO;
import org.feira.DAO.LegumeDAO;
import org.feira.DataBaseConnection.ConexaoBD;
import org.feira.Model.Fruta;
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
        LegumeDAO dao = new LegumeDAO();
        legume = new Legume(txtNome.getText(),Integer.parseInt(txtQuantidade.getText()),Double.parseDouble(txtValor.getText()));
        dao.cadastrarLegume(legume);
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
