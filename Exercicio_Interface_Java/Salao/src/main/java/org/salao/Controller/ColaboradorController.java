package org.salao.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.salao.App;
import org.salao.DataBaseConnection.ConexaoBD;
import org.salao.Model.Colaborador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ColaboradorController {

    Colaborador colaborador;

    @FXML
    private Button btCadastro;

    @FXML
    private Button btPromocao;

    @FXML
    private Button btTrabalhar;

    @FXML
    private Button btDemicao;

    @FXML
    private Button btVoltar;

    @FXML
    private Label lbTexto;

    @FXML
    private TextField txtFuncao;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSalario;

    @FXML
    void cadColaborador(ActionEvent event) {
        colaborador = new Colaborador(txtNome.getText(),txtFuncao.getText(),Double.parseDouble(txtSalario.getText()));
        String sql = "INSERT INTO colaborador (nome, funcao, salario) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, colaborador.getNome());
            stmt.setString(2, colaborador.getFuncao());
            stmt.setDouble(3, colaborador.getSalario());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
        txtNome.clear();
        txtFuncao.clear();
        txtSalario.clear();
    }

    @FXML
    void demitir(ActionEvent event) {
        lbTexto.setText(colaborador.demitir());
    }

    @FXML
    void promocao(ActionEvent event) {
        lbTexto.setText(colaborador.promocao());
    }

    @FXML
    void switchToSalao(ActionEvent event) throws IOException {
        App.setRoot("salao");
    }

    @FXML
    void trabalhar(ActionEvent event) {
        lbTexto.setText(colaborador.trabalhar());
    }

}

