package org.example.salao.DAO;

import org.example.config.ConexaoBD;
import org.example.salao.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Cliente> buscarCliente(String nomeCliente){
        String sql = "SELECT * FROM cliente WHERE nome ILIKE ?";
        List<Cliente> encontrados = new ArrayList<>();
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nomeCliente + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("tipoCliente"),
                        rs.getInt("idade")
                );
                encontrados.add(c);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar cliente no banco: " + e.getMessage());
        }
        return encontrados;
    }

    public void editarCliente(Cliente cliente){
        String sql = "UPDATE cliente SET nome = ?, tipoCliente = ?, idade = ? WHERE id = ?";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTipoCliente());
            stmt.setInt(3, cliente.getIdade());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();
            System.out.println("Banco de dados atualizado!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar cliente no banco: " + e.getMessage());
        }
    }

    public void removerCliente(int id){
        ConexaoBD cnx = new ConexaoBD();
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Cliente removido do banco de dados!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover cliente do banco: " + e.getMessage());
        }
    }


}
