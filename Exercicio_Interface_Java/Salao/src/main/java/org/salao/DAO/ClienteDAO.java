package org.salao.DAO;

import org.salao.DataBaseConnection.ConexaoBD;
import org.salao.Model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO {
    public void cadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO cliente (nome, tipoCliente, idade) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTipoCliente());
            stmt.setInt(3, cliente.getIdade());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }
}
