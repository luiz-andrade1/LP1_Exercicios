package farmacia.ClassController;

import farmacia.App;
import farmacia.ClassModel.Alimento;
import farmacia.DAO.AlimentoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AlimentoController {

    Alimento alimento;

    @FXML
    private Button btCadastro;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btPeso;

    @FXML
    private Button btValor;

    @FXML
    private Button btVencimento;

    @FXML
    private Label lbTexto;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtValor;

    @FXML
    void cadAlimento(ActionEvent event) {
        AlimentoDAO dao = new AlimentoDAO();
        alimento = new Alimento(txtNome.getText(), Integer.parseInt(txtPeso.getText()), Double.parseDouble(txtValor.getText()));
        dao.cadastrarAlimento(alimento);
        txtNome.clear();
        txtPeso.clear();
        txtValor.clear();
    }

    @FXML
    void mostrarPeso(ActionEvent event) {lbTexto.setText(alimento.mostrarPeso());}

    @FXML
    void mostrarValor(ActionEvent event) {lbTexto.setText(alimento.mostrarValor());}

    @FXML
    void mostrarVenceu(ActionEvent event) {
        lbTexto.setText(alimento.mostrarVenceu());
    }

    @FXML
    private void switchToFarmacia() throws IOException {
        App.setRoot("farmacia");}


}

