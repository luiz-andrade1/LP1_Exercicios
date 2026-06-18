package org.example.farmacia.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import java.io.IOException;
import java.util.List;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.App;
import org.example.farmacia.DAO.AlimentoDAO;
import org.example.farmacia.DAO.CosmeticoDAO;
import org.example.farmacia.DAO.RemedioDAO;
import org.example.farmacia.model.*;

public class FarmaciaController {

    @FXML
    private TextField barraPesquisaAlimento;

    @FXML
    private TextField barraPesquisaCosmetico;

    @FXML
    private TextField barraPesquisaRemedio;

    @FXML
    private Button btBuscarAlimento;

    @FXML
    private Button btBuscarCosmetico;

    @FXML
    private Button btBuscarRemedio;

    @FXML
    private Button btCadastroAlimento;

    @FXML
    private Button btCadastroCosmetico;

    @FXML
    private Button btCadastroRemedio;

    @FXML
    private Button btEditarAlimento;

    @FXML
    private Button btEditarCosmetico;

    @FXML
    private Button btEditarRemedio;

    @FXML
    private Button btRemoverAlimento;

    @FXML
    private Button btRemoverCosmetico;

    @FXML
    private Button btRemoverRemedio;

    @FXML
    private Button btVoltarCentral;

    @FXML
    private Tab opcaoAlimento;

    @FXML
    private Tab opcaoCosmetico;

    @FXML
    private Tab opcaoRemedio;

    @FXML
    private TabPane painelOpcoes;

    @FXML
    private TableColumn<Alimento, Integer> colunaIDAlimento;

    @FXML
    private TableColumn<Cosmetico, Integer> colunaIDCosmetico;

    @FXML
    private TableColumn<Remedio, Integer> colunaIDRemedio;

    @FXML
    private TableColumn<Alimento, String> colunaNomeAlimento;

    @FXML
    private TableColumn<Cosmetico, String> colunaNomeCosmetico;

    @FXML
    private TableColumn<Remedio, String> colunaNomeRemedio;

    @FXML
    private TableColumn<Alimento, Integer> colunaPesoAlimento;

    @FXML
    private TableColumn<Cosmetico, Integer> colunaPesoCosmetico;

    @FXML
    private TableColumn<Remedio, Integer> colunaPesoRemedio;

    @FXML
    private TableColumn<Alimento, Double> colunaValorAlimento;

    @FXML
    private TableColumn<Remedio, Double> colunaValorRemedio;

    @FXML
    private TableColumn<Cosmetico, Double> colunaValorCosmetico;

    @FXML
    private TableView<Alimento> tabelaBuscaAlimento;

    @FXML
    private TableView<Cosmetico> tabelaBuscaCosmetico;

    @FXML
    private TableView<Remedio> tabelaBuscaRemedio;

    @FXML
    private TextField txtIDAlimento;

    @FXML
    private TextField txtIDCosmetico;

    @FXML
    private TextField txtIDRemedio;

    @FXML
    private TextField txtNomeAlimento;

    @FXML
    private TextField txtNomeCosmetico;

    @FXML
    private TextField txtNomeRemedio;

    @FXML
    private TextField txtPesoAlimento;

    @FXML
    private TextField txtPesoCosmetico;

    @FXML
    private TextField txtPesoRemedio;

    @FXML
    private TextField txtValorAlimento;

    @FXML
    private TextField txtValorCosmetico;

    @FXML
    private TextField txtValorRemedio;

    Remedio remedio;
    Cosmetico cosmetico;
    Alimento alimento;

    private ObservableList<Remedio> listaRemedios = FXCollections.observableArrayList();
    private ObservableList<Cosmetico> listaCosmeticos = FXCollections.observableArrayList();
    private ObservableList<Alimento> listaAlimentos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        configurarTabelaGenerica(tabelaBuscaRemedio, colunaIDRemedio, colunaNomeRemedio, colunaPesoRemedio, colunaValorRemedio,
                txtIDRemedio, txtNomeRemedio, txtPesoRemedio, txtValorRemedio);

        configurarTabelaGenerica(tabelaBuscaCosmetico, colunaIDCosmetico, colunaNomeCosmetico, colunaPesoCosmetico, colunaValorCosmetico,
                txtIDCosmetico, txtNomeCosmetico, txtPesoCosmetico, txtValorCosmetico);

        configurarTabelaGenerica(tabelaBuscaAlimento, colunaIDAlimento, colunaNomeAlimento, colunaPesoAlimento, colunaValorAlimento,
                txtIDAlimento, txtNomeAlimento, txtPesoAlimento, txtValorAlimento);
    }

    private <T> void configurarTabelaGenerica(
            TableView<T> tabela,
            TableColumn<T, Integer> colId,
            TableColumn<T, String> colNome,
            TableColumn<T, Integer> colPeso,
            TableColumn<T, Double> colValor,
            TextField campoId,
            TextField campoNome,
            TextField campoPeso,
            TextField campoValor) {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        tabela.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    int id = (int) newValue.getClass().getMethod("getId").invoke(newValue);
                    String nome = (String) newValue.getClass().getMethod("getNome").invoke(newValue);
                    Integer peso = (Integer) newValue.getClass().getMethod("getPeso").invoke(newValue);
                    Double valor = (Double) newValue.getClass().getMethod("getValor").invoke(newValue);

                    campoId.setText(String.valueOf(id));
                    campoNome.setText(nome);
                    campoPeso.setText(String.valueOf(peso));
                    campoValor.setText(String.valueOf(valor));

                } catch (Exception e) {
                    System.err.println("Erro ao extrair dados da linha selecionada: " + e.getMessage());
                }
            }
        });
    }

    @FXML
    void cadastrarAlimento(ActionEvent event) {
        AlimentoDAO dao = new AlimentoDAO();
        alimento = new Alimento(txtNomeAlimento.getText(), Integer.parseInt(txtPesoAlimento.getText()), Double.parseDouble(txtValorAlimento.getText()));
        dao.cadastrarAlimento(alimento);
        txtNomeAlimento.clear();
        txtPesoAlimento.clear();
        txtValorAlimento.clear();
    }

    @FXML
    void cadastrarCosmetico(ActionEvent event) {
        CosmeticoDAO dao = new CosmeticoDAO();
        cosmetico = new Cosmetico(txtNomeCosmetico.getText(), Integer.parseInt(txtPesoCosmetico.getText()), Double.parseDouble(txtValorCosmetico.getText()));
        dao.cadastrarCosmetico(cosmetico);
        txtNomeCosmetico.clear();
        txtPesoCosmetico.clear();
        txtValorCosmetico.clear();
    }

    @FXML
    void cadastrarRemedio(ActionEvent event) {
        RemedioDAO dao = new RemedioDAO();
        remedio = new Remedio(txtNomeRemedio.getText(), Integer.parseInt(txtPesoRemedio.getText()), Double.parseDouble(txtValorRemedio.getText()));
        dao.cadastrarRemedio(remedio);
        txtNomeRemedio.clear();
        txtPesoRemedio.clear();
        txtValorRemedio.clear();
    }

    @FXML
    void buscarAlimento(ActionEvent event) {
        AlimentoDAO dao = new AlimentoDAO();
        List<Alimento> banco = dao.buscarAlimento(barraPesquisaAlimento.getText());
        listaAlimentos.clear();
        listaAlimentos.addAll(banco);
        tabelaBuscaAlimento.setItems(listaAlimentos);
    }

    @FXML
    void buscarCosmetico(ActionEvent event) {
        CosmeticoDAO dao = new CosmeticoDAO();
        List<Cosmetico> banco = dao.buscarCosmetico(barraPesquisaCosmetico.getText());
        listaCosmeticos.clear();
        listaCosmeticos.addAll(banco);
        tabelaBuscaCosmetico.setItems(listaCosmeticos);
    }

    @FXML
    void buscarRemedio(ActionEvent event) {
        RemedioDAO dao = new RemedioDAO();
        List<Remedio> banco = dao.buscarRemedio(barraPesquisaRemedio.getText());
        listaRemedios.clear();
        listaRemedios.addAll(banco);
        tabelaBuscaRemedio.setItems(listaRemedios);
    }

    @FXML
    void editarAlimento(ActionEvent event) {
        AlimentoDAO dao = new AlimentoDAO();
        int id = Integer.parseInt(txtIDAlimento.getText());
        String nome = txtNomeAlimento.getText();
        int peso = Integer.parseInt(txtPesoAlimento.getText());
        double valor = Double.parseDouble(txtValorAlimento.getText());
        Alimento alimentoEditado = new Alimento(id, nome, peso, valor);
        dao.editarAlimento(alimentoEditado);
        buscarAlimento(event);
        txtIDAlimento.clear();
        txtNomeAlimento.clear();
        txtPesoAlimento.clear();
        txtValorAlimento.clear();
    }

    @FXML
    void editarCosmetico(ActionEvent event) {
        CosmeticoDAO dao = new CosmeticoDAO();
        int id = Integer.parseInt(txtIDCosmetico.getText());
        String nome = txtNomeCosmetico.getText();
        int peso = Integer.parseInt(txtPesoCosmetico.getText());
        double valor = Double.parseDouble(txtValorCosmetico.getText());
        Cosmetico cosmeticoEditado = new Cosmetico(id, nome, peso, valor);
        dao.editarCosmetico(cosmeticoEditado);
        buscarCosmetico(event);
        txtIDCosmetico.clear();
        txtNomeCosmetico.clear();
        txtPesoCosmetico.clear();
        txtValorCosmetico.clear();
    }

    @FXML
    void editarRemedio(ActionEvent event) {
        RemedioDAO dao = new RemedioDAO();
        int id = Integer.parseInt(txtIDRemedio.getText());
        String nome = txtNomeRemedio.getText();
        int peso = Integer.parseInt(txtPesoRemedio.getText());
        double valor = Double.parseDouble(txtValorRemedio.getText());
        Remedio remedioEditado = new Remedio(id, nome, peso, valor);
        dao.editarRemedio(remedioEditado);
        buscarRemedio(event);
        txtIDRemedio.clear();
        txtNomeRemedio.clear();
        txtPesoRemedio.clear();
        txtValorRemedio.clear();
    }

    @FXML
    void removerAlimento(ActionEvent event) {
        int id = Integer.parseInt(txtIDAlimento.getText());
        AlimentoDAO dao = new AlimentoDAO();
        dao.removerAlimento(id);
        buscarAlimento(event);
        txtIDAlimento.clear();
        txtNomeAlimento.clear();
        txtPesoAlimento.clear();
        txtValorAlimento.clear();
    }

    @FXML
    void removerCosmetico(ActionEvent event) {
        int id = Integer.parseInt(txtIDCosmetico.getText());
        CosmeticoDAO dao = new CosmeticoDAO();
        dao.removerCosmetico(id);
        buscarCosmetico(event);
        txtIDCosmetico.clear();
        txtNomeCosmetico.clear();
        txtPesoCosmetico.clear();
        txtValorCosmetico.clear();
    }

    @FXML
    void removerRemedio(ActionEvent event) {
        int id = Integer.parseInt(txtIDRemedio.getText());
        RemedioDAO dao = new RemedioDAO();
        dao.removerRemedio(id);
        buscarRemedio(event);
        txtIDRemedio.clear();
        txtNomeRemedio.clear();
        txtPesoRemedio.clear();
        txtValorRemedio.clear();
    }

    @FXML
    void switchToCentral(ActionEvent event) throws IOException {
        App.setRoot("centralControle");
    }

}
