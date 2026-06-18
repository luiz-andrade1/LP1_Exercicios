package org.example.salao.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.App;
import org.example.salao.DAO.ClienteDAO;
import org.example.salao.DAO.ColaboradorDAO;
import org.example.salao.DAO.ServicoDAO;
import org.example.salao.model.*;
import java.io.IOException;
import java.util.List;

public class SalaoController {

    @FXML
    private TextField barraPesquisaCliente;

    @FXML
    private TextField barraPesquisaColaborador;

    @FXML
    private TextField barraPesquisaServico;

    @FXML
    private Button btBuscarCliente;

    @FXML
    private Button btBuscarColaborador;

    @FXML
    private Button btBuscarServico;

    @FXML
    private Button btCadastroCliente;

    @FXML
    private Button btCadastroColaborador;

    @FXML
    private Button btCadastroServico;

    @FXML
    private Button btEditarCliente;

    @FXML
    private Button btEditarColaborador;

    @FXML
    private Button btEditarServico;

    @FXML
    private Button btRemoverCliente;

    @FXML
    private Button btRemoverColaborador;

    @FXML
    private Button btRemoverServico;

    @FXML
    private Button btVoltarCentral;

    @FXML
    private TableColumn<Colaborador, String> colunaFuncaoColaborador;

    @FXML
    private TableColumn<Cliente, Integer> colunaIDCliente;

    @FXML
    private TableColumn<Colaborador, Integer> colunaIDColaborador;

    @FXML
    private TableColumn<Servico, Integer> colunaIDServico;

    @FXML
    private TableColumn<Cliente, Integer> colunaIdadeCliente;

    @FXML
    private TableColumn<Cliente, String> colunaNomeCliente;

    @FXML
    private TableColumn<Colaborador, String> colunaNomeColaborador;

    @FXML
    private TableColumn<Servico, String> colunaNomeServico;

    @FXML
    private TableColumn<Servico, String> colunaResponsavelServico;

    @FXML
    private TableColumn<Colaborador, Double> colunaSalarioColaborador;

    @FXML
    private TableColumn<Cliente, String> colunaTipoCliente;

    @FXML
    private TableColumn<Servico, Double> colunaValorServico;

    @FXML
    private Tab opcaoCliente;

    @FXML
    private Tab opcaoColaborador;

    @FXML
    private Tab opcaoServico;

    @FXML
    private TabPane painelOpcoes;

    @FXML
    private TableView<Cliente> tabelaBuscaCliente;

    @FXML
    private TableView<Colaborador> tabelaBuscaLColaborador;

    @FXML
    private TableView<Servico> tabelaBuscaServico;

    @FXML
    private TextField txtFuncaoColaborador;

    @FXML
    private TextField txtIDCliente;

    @FXML
    private TextField txtIDColaborador;

    @FXML
    private TextField txtIDServico;

    @FXML
    private TextField txtIdadeCliente;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    private TextField txtNomeColaborador;

    @FXML
    private TextField txtNomeServico;

    @FXML
    private TextField txtResponsavelServico;

    @FXML
    private TextField txtSalarioColaborador;

    @FXML
    private TextField txtTipoCliente;

    @FXML
    private TextField txtValorServico;

    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    private ObservableList<Colaborador> listaColaboradores = FXCollections.observableArrayList();
    private ObservableList<Servico> listaServicos = FXCollections.observableArrayList();

    Cliente cliente;
    Colaborador colaborador;
    Servico servico;

    @FXML
    public void initialize() {
        configurarTabelaCliente();
        configurarTabelaColaborador();
        configurarTabelaServico();
    }

    private void configurarTabelaCliente() {
        colunaIDCliente.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNomeCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaTipoCliente.setCellValueFactory(new PropertyValueFactory<>("tipoCliente"));
        colunaIdadeCliente.setCellValueFactory(new PropertyValueFactory<>("idade"));

        tabelaBuscaCliente.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) {
                txtIDCliente.setText(String.valueOf(novo.getId()));
                txtNomeCliente.setText(novo.getNome());
                txtTipoCliente.setText(novo.getTipoCliente());
                txtIdadeCliente.setText(String.valueOf(novo.getIdade()));
            }
        });
    }

    private void configurarTabelaColaborador() {
        colunaIDColaborador.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNomeColaborador.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaFuncaoColaborador.setCellValueFactory(new PropertyValueFactory<>("funcao"));
        colunaSalarioColaborador.setCellValueFactory(new PropertyValueFactory<>("salario"));

        tabelaBuscaLColaborador.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) {
                txtIDColaborador.setText(String.valueOf(novo.getId()));
                txtNomeColaborador.setText(novo.getNome());
                txtFuncaoColaborador.setText(novo.getFuncao());
                txtSalarioColaborador.setText(String.valueOf(novo.getSalario()));
            }
        });
    }

    private void configurarTabelaServico() {
        colunaIDServico.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNomeServico.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaValorServico.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colunaResponsavelServico.setCellValueFactory(new PropertyValueFactory<>("responsavel"));

        tabelaBuscaServico.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) {
                txtIDServico.setText(String.valueOf(novo.getId()));
                txtNomeServico.setText(novo.getNome());
                txtValorServico.setText(String.valueOf(novo.getValor()));
                txtResponsavelServico.setText(novo.getResponsavel());
            }
        });
    }

    @FXML
    void cadastrarCliente(ActionEvent event) {
        ClienteDAO dao = new ClienteDAO();
        cliente = new Cliente(txtNomeCliente.getText(),txtTipoCliente.getText(),Integer.parseInt(txtIdadeCliente.getText()));
        dao.cadastrarCliente(cliente);
        txtNomeCliente.clear();
        txtTipoCliente.clear();
        txtIdadeCliente.clear();
    }

    @FXML
    void cadastrarColaborador(ActionEvent event) {
        ColaboradorDAO dao = new ColaboradorDAO();
        colaborador = new Colaborador(txtNomeColaborador.getText(),txtFuncaoColaborador.getText(),Double.parseDouble(txtSalarioColaborador.getText()));
        dao.cadastrarColaborador(colaborador);
        txtNomeColaborador.clear();
        txtFuncaoColaborador.clear();
        txtSalarioColaborador.clear();
    }

    @FXML
    void cadastrarServico(ActionEvent event) {
        ServicoDAO dao = new ServicoDAO();
        servico = new Servico(txtNomeServico.getText(),Double.parseDouble(txtValorServico.getText()),txtResponsavelServico.getText());
        dao.cadastrarServico(servico);
        txtNomeServico.clear();
        txtValorServico.clear();
        txtResponsavelServico.clear();
    }

    @FXML
    void buscarCliente(ActionEvent event) {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> banco = dao.buscarCliente(barraPesquisaCliente.getText());
        listaClientes.clear();
        listaClientes.addAll(banco);
        tabelaBuscaCliente.setItems(listaClientes);
    }

    @FXML
    void buscarColaborador(ActionEvent event) {
        ColaboradorDAO dao = new ColaboradorDAO();
        List<Colaborador> banco = dao.buscarColaborador(barraPesquisaColaborador.getText());
        listaColaboradores.clear();
        listaColaboradores.addAll(banco);
        tabelaBuscaLColaborador.setItems(listaColaboradores);
    }

    @FXML
    void buscarServico(ActionEvent event) {
        ServicoDAO dao = new ServicoDAO();
        List<Servico> banco = dao.buscarServico(barraPesquisaServico.getText());
        listaServicos.clear();
        listaServicos.addAll(banco);
        tabelaBuscaServico.setItems(listaServicos);
    }

    @FXML
    void editarCliente(ActionEvent event) {
        ClienteDAO dao = new ClienteDAO();
        int id = Integer.parseInt(txtIDCliente.getText());
        String nome = txtNomeCliente.getText();
        String tipo = txtTipoCliente.getText();
        int idade = Integer.parseInt(txtIdadeCliente.getText());
        Cliente clienteEditado = new Cliente(id, nome, tipo, idade);
        dao.editarCliente(clienteEditado);
        buscarCliente(event);
        txtIDCliente.clear();
        txtNomeCliente.clear();
        txtTipoCliente.clear();
        txtIdadeCliente.clear();
    }

    @FXML
    void editarColaborador(ActionEvent event) {
        ColaboradorDAO dao = new ColaboradorDAO();
        int id = Integer.parseInt(txtIDColaborador.getText());
        String nome = txtNomeColaborador.getText();
        String funcao = txtFuncaoColaborador.getText();
        Double salario = Double.parseDouble(txtSalarioColaborador.getText());
        Colaborador colaboradorEditado = new Colaborador(id, nome, funcao, salario);
        dao.editarColaborador(colaboradorEditado);
        buscarColaborador(event);
        txtIDColaborador.clear();
        txtNomeColaborador.clear();
        txtFuncaoColaborador.clear();
        txtSalarioColaborador.clear();
    }

    @FXML
    void editarServico(ActionEvent event) {
        ServicoDAO dao = new ServicoDAO();
        int id = Integer.parseInt(txtIDServico.getText());
        String nome = txtNomeServico.getText();
        Double valor = Double.parseDouble(txtValorServico.getText());
        String responsavel = txtResponsavelServico.getText();
        Servico servicoEditado = new Servico(id, nome, valor, responsavel);
        dao.editarServico(servicoEditado);
        buscarServico(event);
        txtIDServico.clear();
        txtNomeServico.clear();
        txtValorServico.clear();
        txtResponsavelServico.clear();
    }

    @FXML
    void removerCliente(ActionEvent event) {
        int id = Integer.parseInt(txtIDCliente.getText());
        ClienteDAO dao = new ClienteDAO();
        dao.removerCliente(id);
        buscarCliente(event);
        txtIDCliente.clear();
        txtNomeCliente.clear();
        txtTipoCliente.clear();
        txtIdadeCliente.clear();
    }

    @FXML
    void removerColaborador(ActionEvent event) {
        int id = Integer.parseInt(txtIDColaborador.getText());
        ColaboradorDAO dao = new ColaboradorDAO();
        dao.removerColaborador(id);
        buscarColaborador(event);
        txtIDColaborador.clear();
        txtNomeColaborador.clear();
        txtFuncaoColaborador.clear();
        txtSalarioColaborador.clear();
    }

    @FXML
    void removerServico(ActionEvent event) {
        int id = Integer.parseInt(txtIDServico.getText());
        ServicoDAO dao = new ServicoDAO();
        dao.removerServico(id);
        buscarServico(event);
        txtIDServico.clear();
        txtNomeServico.clear();
        txtValorServico.clear();
        txtResponsavelServico.clear();
    }

    @FXML
    void switchToCentral(ActionEvent event) throws IOException {
        App.setRoot("centralControle");
    }

}
