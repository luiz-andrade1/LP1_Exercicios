package org.example.salao.DAO;

import org.example.config.ConexaoBD;
import org.example.salao.model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Servico> buscarServico(String nomeServico){
        String sql = "SELECT * FROM servico WHERE nome ILIKE ?";
        List<Servico> encontrados = new ArrayList<>();
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nomeServico + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Servico s = new Servico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("valor"),
                        rs.getString("responsavel")
                );
                encontrados.add(s);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar serviço no banco: " + e.getMessage());
        }
        return encontrados;
    }

    public void editarServico(Servico servico){
        String sql = "UPDATE servico SET nome = ?, valor = ?, responsavel = ? WHERE id = ?";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, servico.getNome());
            stmt.setDouble(2, servico.getValor());
            stmt.setString(3, servico.getResponsavel());
            stmt.setInt(4, servico.getId());
            stmt.executeUpdate();
            System.out.println("Banco de dados atualizado!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar serviço no banco: " + e.getMessage());
        }
    }

    public void removerServico(int id){
        ConexaoBD cnx = new ConexaoBD();
        String sql = "DELETE FROM servico WHERE id = ?";
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Serviço removido do banco de dados!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover serviço do banco: " + e.getMessage());
        }
    }
}
