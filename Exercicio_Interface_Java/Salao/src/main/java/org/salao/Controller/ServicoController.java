package org.salao.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.salao.App;
import org.salao.DAO.ServicoDAO;
import org.salao.DataBaseConnection.ConexaoBD;
import org.salao.Model.Servico;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ServicoController {

    Servico servico;

    @FXML
    private Button btAumentarValor;

    @FXML
    private Button btCadastro;

    @FXML
    private Button btCobrar;

    @FXML
    private Button btExecServico;

    @FXML
    private Button btVoltar;

    @FXML
    private Label lbTexto;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtResponsavel;

    @FXML
    private TextField txtValor;

    @FXML
    void cadServico(ActionEvent event) {
        ServicoDAO dao = new ServicoDAO();
        servico = new Servico(txtNome.getText(),Double.parseDouble(txtValor.getText()),txtResponsavel.getText());
        dao.cadastrarServico(servico);
        txtNome.clear();
        txtValor.clear();
        txtResponsavel.clear();
    }

    @FXML
    void cobrarServico(ActionEvent event) {
        lbTexto.setText(servico.cobrarServico());
    }

    @FXML
    void servicoExecutando(ActionEvent event) {
        lbTexto.setText(servico.servicoExecutando());
    }

    @FXML
    void aumentarValorServico(ActionEvent event) {
        lbTexto.setText(servico.aumentarValorServico());
    }

    @FXML
    void switchToSalao(ActionEvent event) throws IOException {
        App.setRoot("salao");
    }

}
