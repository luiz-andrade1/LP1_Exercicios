package org.salao.DAO;

import org.salao.DataBaseConnection.ConexaoBD;
import org.salao.Model.Colaborador;
import org.salao.Model.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ServicoDAO {
    public void cadastrarServico(Servico servico){
        String sql = "INSERT INTO servico (nome, valor, responsavel) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, servico.getNome());
            stmt.setDouble(2, servico.getValor());
            stmt.setString(3, servico.getResponsavel());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }
}
