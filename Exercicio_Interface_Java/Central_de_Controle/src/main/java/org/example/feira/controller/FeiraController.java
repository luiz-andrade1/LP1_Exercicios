package org.example.feira.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.App;
import org.example.farmacia.DAO.AlimentoDAO;
import org.example.farmacia.model.Alimento;
import org.example.farmacia.model.Cosmetico;
import org.example.farmacia.model.Remedio;
import org.example.feira.DAO.FrutaDAO;
import org.example.feira.DAO.LegumeDAO;
import org.example.feira.DAO.VerduraDAO;
import org.example.feira.model.*;
import java.io.IOException;
import java.util.List;

public class FeiraController {

    @FXML
    private TextField barraPesquisaFruta;

    @FXML
    private TextField barraPesquisaLegume;

    @FXML
    private TextField barraPesquisaVerdura;

    @FXML
    private Button btBuscarFruta;

    @FXML
    private Button btBuscarLegume;

    @FXML
    private Button btBuscarVerdura;

    @FXML
    private Button btCadastroFruta;

    @FXML
    private Button btCadastroLegume;

    @FXML
    private Button btCadastroVerdura;

    @FXML
    private Button btEditarFruta;

    @FXML
    private Button btEditarLegume;

    @FXML
    private Button btEditarVerdura;

    @FXML
    private Button btRemoverFruta;

    @FXML
    private Button btRemoverLegume;

    @FXML
    private Button btRemoverVerdura;

    @FXML
    private Button btVoltarCentral;

    @FXML
    private TableColumn<Fruta, Integer> colunaIDFruta;

    @FXML
    private TableColumn<Legume, Integer> colunaIDLegume;

    @FXML
    private TableColumn<Verdura, Integer> colunaIDVerdura;

    @FXML
    private TableColumn<Fruta, String> colunaNomeFruta;

    @FXML
    private TableColumn<Legume, String> colunaNomeLegume;

    @FXML
    private TableColumn<Verdura, String> colunaNomeVerdura;

    @FXML
    private TableColumn<Fruta, Integer> colunaQuantidadeFruta;

    @FXML
    private TableColumn<Legume, Integer> colunaQuantidadeLegume;

    @FXML
    private TableColumn<Verdura, Integer> colunaQuantidadeVerdura;

    @FXML
    private TableColumn<Fruta, Double> colunaValorFruta;

    @FXML
    private TableColumn<Legume, Double> colunaValorLegume;

    @FXML
    private TableColumn<Verdura, Double> colunaValorVerdura;

    @FXML
    private Tab opcaoFruta;

    @FXML
    private Tab opcaoLegume;

    @FXML
    private Tab opcaoVerdura;

    @FXML
    private TabPane painelOpcoes;

    @FXML
    private TableView<Fruta> tabelaBuscaFruta;

    @FXML
    private TableView<Legume> tabelaBuscaLegume;

    @FXML
    private TableView<Verdura> tabelaBuscaVerdura;

    @FXML
    private TextField txtIDFruta;

    @FXML
    private TextField txtIDLegume;

    @FXML
    private TextField txtIDVerdura;

    @FXML
    private TextField txtNomeFruta;

    @FXML
    private TextField txtNomeLegume;

    @FXML
    private TextField txtNomeVerdura;

    @FXML
    private TextField txtQuantidadeFruta;

    @FXML
    private TextField txtQuantidadeLegume;

    @FXML
    private TextField txtQuantidadeVerdura;

    @FXML
    private TextField txtValorFruta;

    @FXML
    private TextField txtValorLegume;

    @FXML
    private TextField txtValorVerdura;

    Fruta fruta;
    Legume legume;
    Verdura verdura;

    private ObservableList<Fruta> listaFrutas = FXCollections.observableArrayList();
    private ObservableList<Legume> listaLegumes = FXCollections.observableArrayList();
    private ObservableList<Verdura> listaVerduras = FXCollections.observableArrayList();

    public void initialize() {

        configurarTabelaGenerica(tabelaBuscaFruta, colunaIDFruta, colunaNomeFruta, colunaQuantidadeFruta, colunaValorFruta,
                txtIDFruta, txtNomeFruta, txtQuantidadeFruta, txtValorFruta);

        configurarTabelaGenerica(tabelaBuscaLegume, colunaIDLegume, colunaNomeLegume, colunaQuantidadeLegume, colunaValorLegume,
                txtIDLegume, txtNomeLegume, txtQuantidadeLegume, txtValorLegume);

        configurarTabelaGenerica(tabelaBuscaVerdura, colunaIDVerdura, colunaNomeVerdura, colunaQuantidadeVerdura, colunaValorVerdura,
                txtIDVerdura, txtNomeVerdura, txtQuantidadeVerdura, txtValorVerdura);
    }

    private <T> void configurarTabelaGenerica(
            TableView<T> tabela,
            TableColumn<T, Integer> colId,
            TableColumn<T, String> colNome,
            TableColumn<T, Integer> colQuantidade,
            TableColumn<T, Double> colValor,
            TextField campoId,
            TextField campoNome,
            TextField campoQuantidade,
            TextField campoValor) {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        tabela.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    int id = (int) newValue.getClass().getMethod("getId").invoke(newValue);
                    String nome = (String) newValue.getClass().getMethod("getNome").invoke(newValue);
                    Integer quantidade = (Integer) newValue.getClass().getMethod("getQuantidade").invoke(newValue);
                    Double valor = (Double) newValue.getClass().getMethod("getValor").invoke(newValue);

                    campoId.setText(String.valueOf(id));
                    campoNome.setText(nome);
                    campoQuantidade.setText(String.valueOf(quantidade));
                    campoValor.setText(String.valueOf(valor));

                } catch (Exception e) {
                    System.err.println("Erro ao extrair dados da linha selecionada: " + e.getMessage());
                }
            }
        });
    }

    @FXML
    void cadastrarFruta(ActionEvent event) {
        FrutaDAO dao = new FrutaDAO();
        fruta = new Fruta(txtNomeFruta.getText(),Integer.parseInt(txtQuantidadeFruta.getText()),Double.parseDouble(txtValorFruta.getText()));
        dao.cadastrarFruta(fruta);
        txtNomeFruta.clear();
        txtQuantidadeFruta.clear();
        txtValorFruta.clear();
    }

    @FXML
    void cadastrarLegume(ActionEvent event) {
        LegumeDAO dao = new LegumeDAO();
        legume = new Legume(txtNomeLegume.getText(),Integer.parseInt(txtQuantidadeLegume.getText()),Double.parseDouble(txtValorLegume.getText()));
        dao.cadastrarLegume(legume);
        txtNomeLegume.clear();
        txtQuantidadeLegume.clear();
        txtValorLegume.clear();
    }

    @FXML
    void cadastrarVerdura(ActionEvent event) {
        VerduraDAO dao = new VerduraDAO();
        verdura = new Verdura(txtNomeVerdura.getText(),Integer.parseInt(txtQuantidadeVerdura.getText()),Double.parseDouble(txtValorVerdura.getText()));
        dao.cadastrarVerdura(verdura);
        txtNomeVerdura.clear();
        txtQuantidadeVerdura.clear();
        txtValorVerdura.clear();
    }

    @FXML
    void buscarFruta(ActionEvent event) {
        FrutaDAO dao = new FrutaDAO();
        List<Fruta> banco = dao.buscarFruta(barraPesquisaFruta.getText());
        listaFrutas.clear();
        listaFrutas.addAll(banco);
        tabelaBuscaFruta.setItems(listaFrutas);
    }

    @FXML
    void buscarLegume(ActionEvent event) {
        LegumeDAO dao = new LegumeDAO();
        List<Legume> banco = dao.buscarLegume(barraPesquisaLegume.getText());
        listaLegumes.clear();
        listaLegumes.addAll(banco);
        tabelaBuscaLegume.setItems(listaLegumes);
    }

    @FXML
    void buscarVerdura(ActionEvent event) {
        VerduraDAO dao = new VerduraDAO();
        List<Verdura> banco = dao.buscarVerdura(barraPesquisaVerdura.getText());
        listaVerduras.clear();
        listaVerduras.addAll(banco);
        tabelaBuscaVerdura.setItems(listaVerduras);
    }

    @FXML
    void editarFruta(ActionEvent event) {
        FrutaDAO dao = new FrutaDAO();
        int id = Integer.parseInt(txtIDFruta.getText());
        String nome = txtNomeFruta.getText();
        int quantidade = Integer.parseInt(txtQuantidadeFruta.getText());
        double valor = Double.parseDouble(txtValorFruta.getText());
        Fruta frutaEditado = new Fruta(id, nome, quantidade, valor);
        dao.editarFruta(frutaEditado);
        buscarFruta(event);
        txtIDFruta.clear();
        txtNomeFruta.clear();
        txtQuantidadeFruta.clear();
        txtValorFruta.clear();
    }

    @FXML
    void editarLegume(ActionEvent event) {
        LegumeDAO dao = new LegumeDAO();
        int id = Integer.parseInt(txtIDLegume.getText());
        String nome = txtNomeLegume.getText();
        int quantidade = Integer.parseInt(txtQuantidadeLegume.getText());
        double valor = Double.parseDouble(txtValorLegume.getText());
        Legume legumeEditado = new Legume(id, nome, quantidade, valor);
        dao.editarLegume(legumeEditado);
        buscarLegume(event);
        txtIDLegume.clear();
        txtNomeLegume.clear();
        txtQuantidadeLegume.clear();
        txtValorLegume.clear();
    }

    @FXML
    void editarVerdura(ActionEvent event) {
        VerduraDAO dao = new VerduraDAO();
        int id = Integer.parseInt(txtIDVerdura.getText());
        String nome = txtNomeVerdura.getText();
        int quantidade = Integer.parseInt(txtQuantidadeVerdura.getText());
        double valor = Double.parseDouble(txtValorVerdura.getText());
        Verdura verduraEditado = new Verdura(id, nome, quantidade, valor);
        dao.editarVerdura(verduraEditado);
        buscarVerdura(event);
        txtIDVerdura.clear();
        txtNomeVerdura.clear();
        txtQuantidadeVerdura.clear();
        txtValorVerdura.clear();
    }

    @FXML
    void removerFruta(ActionEvent event) {
        int id = Integer.parseInt(txtIDFruta.getText());
        FrutaDAO dao = new FrutaDAO();
        dao.removerFruta(id);
        buscarFruta(event);
        txtIDFruta.clear();
        txtNomeFruta.clear();
        txtQuantidadeFruta.clear();
        txtValorFruta.clear();
    }

    @FXML
    void removerLegume(ActionEvent event) {
        int id = Integer.parseInt(txtIDLegume.getText());
        LegumeDAO dao = new LegumeDAO();
        dao.removerLegume(id);
        buscarLegume(event);
        txtIDLegume.clear();
        txtNomeLegume.clear();
        txtQuantidadeLegume.clear();
        txtValorLegume.clear();
    }

    @FXML
    void removerVerdura(ActionEvent event) {
        int id = Integer.parseInt(txtIDVerdura.getText());
        VerduraDAO dao = new VerduraDAO();
        dao.removerVerdura(id);
        buscarVerdura(event);
        txtIDVerdura.clear();
        txtNomeVerdura.clear();
        txtQuantidadeVerdura.clear();
        txtValorVerdura.clear();
    }

    @FXML
    void switchToCentral(ActionEvent event) throws IOException {
        App.setRoot("centralControle");
    }

}
