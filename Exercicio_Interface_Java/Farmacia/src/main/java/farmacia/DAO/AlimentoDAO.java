package farmacia.DAO;

import farmacia.ClassModel.Alimento;
import farmacia.DataBaseConnection.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AlimentoDAO {

    Alimento alimento;

    public void cadastrarAlimento(Alimento alimento) {
        String sql = "INSERT INTO alimento (nome, peso, valor) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, alimento.getNome());
            stmt.setInt(2, alimento.getPeso());
            stmt.setDouble(3, alimento.getValor());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }
}