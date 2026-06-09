package farmacia.DAO;

import farmacia.ClassModel.Cosmetico;
import farmacia.ClassModel.Remedio;
import farmacia.DataBaseConnection.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RemedioDAO {
    public void cadastrarRemedio(Remedio remedio) {
        String sql = "INSERT INTO remedio (nome, peso, valor) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, remedio.getNome());
            stmt.setInt(2, remedio.getPeso());
            stmt.setDouble(3, remedio.getValor());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }
}
