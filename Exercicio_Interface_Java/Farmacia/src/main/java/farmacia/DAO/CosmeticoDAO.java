package farmacia.DAO;

import farmacia.ClassModel.Alimento;
import farmacia.ClassModel.Cosmetico;
import farmacia.DataBaseConnection.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CosmeticoDAO {

    public void cadastrarCosmetico(Cosmetico cosmetico) {
        String sql = "INSERT INTO cosmetico (nome, peso, valor) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cosmetico.getNome());
            stmt.setInt(2, cosmetico.getPeso());
            stmt.setDouble(3, cosmetico.getValor());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }

}
