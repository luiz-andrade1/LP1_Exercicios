package org.example.salao.DAO;

import org.example.config.ConexaoBD;
import org.example.salao.model.Colaborador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Colaborador> buscarColaborador(String nomeColaborador){
        String sql = "SELECT * FROM colaborador WHERE nome ILIKE ?";
        List<Colaborador> encontrados = new ArrayList<>();
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nomeColaborador + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Colaborador col = new Colaborador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("funcao"),
                        rs.getDouble("salario")
                );
                encontrados.add(col);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar colaborador no banco: " + e.getMessage());
        }
        return encontrados;
    }

    public void editarColaborador(Colaborador colaborador){
        String sql = "UPDATE colaborador SET nome = ?, funcao = ?, salario = ? WHERE id = ?";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, colaborador.getNome());
            stmt.setString(2, colaborador.getFuncao());
            stmt.setDouble(3, colaborador.getSalario());
            stmt.setInt(4, colaborador.getId());
            stmt.executeUpdate();
            System.out.println("Banco de dados atualizado!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar colaborador no banco: " + e.getMessage());
        }
    }

    public void removerColaborador(int id){
        ConexaoBD cnx = new ConexaoBD();
        String sql = "DELETE FROM colaborador WHERE id = ?";
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Colaborador removido do banco de dados!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover colaborador do banco: " + e.getMessage());
        }
    }
}
