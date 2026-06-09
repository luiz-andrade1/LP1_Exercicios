package farmacia.ClassController;

import farmacia.App;
import farmacia.ClassModel.Cosmetico;
import farmacia.ClassModel.Remedio;
import farmacia.DAO.CosmeticoDAO;
import farmacia.DAO.RemedioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RemedioController {

    Remedio remedio;

    @FXML
    private Button btCadastro;

    @FXML
    private Button btPeso;

    @FXML
    private Button btValor;

    @FXML
    private Button btVencimento;

    @FXML
    private Button btVoltar;

    @FXML
    private Label lbTexto;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtValor;

    @FXML
    void cadRemedio(ActionEvent event) {
        RemedioDAO dao = new RemedioDAO();
        remedio = new Remedio(txtNome.getText(), Integer.parseInt(txtPeso.getText()), Double.parseDouble(txtValor.getText()));
        dao.cadastrarRemedio(remedio);
        txtNome.clear();
        txtPeso.clear();
        txtValor.clear();
    }

    @FXML
    void mostrarPeso(ActionEvent event) {
        lbTexto.setText(remedio.mostrarPeso());
    }

    @FXML
    void mostrarValor(ActionEvent event) {
        lbTexto.setText(remedio.mostrarValor());
    }

    @FXML
    void mostrarVenceu(ActionEvent event) {
        lbTexto.setText(remedio.mostrarVenceu());
    }

    @FXML
    private void switchToFarmacia() throws IOException {
        App.setRoot("farmacia");}
}
