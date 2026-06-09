package org.feira.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.feira.App;
import org.feira.DAO.FrutaDAO;
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
        FrutaDAO dao = new FrutaDAO();
        Fruta fruta = new Fruta(txtNome.getText(),Integer.parseInt(txtQuantidade.getText()),Double.parseDouble(txtValor.getText()));
        dao.cadastrarFruta(fruta);
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
