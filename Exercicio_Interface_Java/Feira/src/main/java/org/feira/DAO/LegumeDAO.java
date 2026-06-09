package org.feira.DAO;

import org.feira.DataBaseConnection.ConexaoBD;
import org.feira.Model.Fruta;
import org.feira.Model.Legume;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LegumeDAO {
    public void cadastrarLegume(Legume legume){
        String sql = "INSERT INTO legume (nome, quantidade, valor) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, legume.getNome());
            stmt.setInt(2, legume.getQuantidade());
            stmt.setDouble(3, legume.getValor());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }
}
