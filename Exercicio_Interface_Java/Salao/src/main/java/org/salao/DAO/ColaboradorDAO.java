package org.salao.DAO;

import org.salao.DataBaseConnection.ConexaoBD;
import org.salao.Model.Cliente;
import org.salao.Model.Colaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ColaboradorDAO {
    public void cadastrarColaborador(Colaborador colaborador){
        String sql = "INSERT INTO colaborador (nome, funcao, salario) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, colaborador.getNome());
            stmt.setString(2, colaborador.getFuncao());
            stmt.setDouble(3, colaborador.getSalario());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }
}
