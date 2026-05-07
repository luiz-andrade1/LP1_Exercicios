package farmacia.ClassController;

import farmacia.App;
import farmacia.ClassModel.Cosmetico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CosmeticoController {

    Cosmetico cosmetico;

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
    void cadCosmetico(ActionEvent event) {
       /* cosmetico = new Cosmetico(txtNome.getText(), Integer.parseInt(txtPeso.getText()), Double.parseDouble(txtValor.getText()));
        String sql = "INSERT INTO cosmetico (nome, peso, valor) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cosmetico.getNome());
            stmt.setInt(2, cosmetico.getPeso());
            stmt.setDouble(3, cosmetico.getValor());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
        txtNome.clear();
        txtPeso.clear();
        txtValor.clear();*/
    }

    @FXML
    void mostrarPeso(ActionEvent event) {
        lbTexto.setText(cosmetico.mostrarPeso());
    }

    @FXML
    void mostrarValor(ActionEvent event) {
        lbTexto.setText(cosmetico.mostrarValor());
    }

    @FXML
    void mostrarVenceu(ActionEvent event) {
        lbTexto.setText(cosmetico.mostrarVenceu());
    }
    @FXML
    private void switchToFarmacia() throws IOException {
        App.setRoot("farmacia");}


}
