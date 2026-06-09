package org.feira.DAO;

import org.feira.DataBaseConnection.ConexaoBD;
import org.feira.Model.Fruta;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FrutaDAO {
    public void cadastrarFruta(Fruta fruta){
        String sql = "INSERT INTO fruta (nome, quantidade, valor) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fruta.getNome());
            stmt.setInt(2, fruta.getQuantidade());
            stmt.setDouble(3, fruta.getValor());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }
}
