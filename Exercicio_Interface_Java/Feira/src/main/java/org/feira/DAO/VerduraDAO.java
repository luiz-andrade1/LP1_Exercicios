package org.feira.DAO;

import org.feira.DataBaseConnection.ConexaoBD;
import org.feira.Model.Legume;
import org.feira.Model.Verdura;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VerduraDAO {
    public void cadastrarVerdura(Verdura verdura){
        String sql = "INSERT INTO verdura (nome, quantidade, valor) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, verdura.getNome());
            stmt.setInt(2, verdura.getQuantidade());
            stmt.setDouble(3, verdura.getValor());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }
}
