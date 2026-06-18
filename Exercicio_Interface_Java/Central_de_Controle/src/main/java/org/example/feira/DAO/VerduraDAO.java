package org.example.feira.DAO;

import org.example.config.ConexaoBD;
import org.example.feira.model.Verdura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Verdura> buscarVerdura(String nomeVerdura){
        String sql = "SELECT * FROM verdura WHERE nome ILIKE ?";
        List<Verdura> encontrados = new ArrayList<>();
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%"+nomeVerdura+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Verdura l = new Verdura(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getDouble("valor")
                );
                encontrados.add(l);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar no banco: " + e.getMessage());
        }
        return encontrados;
    }

    public void editarVerdura(Verdura verdura){
        String sql = "UPDATE verdura SET nome = ?, peso = ?, valor = ? WHERE id = ?";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, verdura.getNome());
            stmt.setInt(2, verdura.getQuantidade());
            stmt.setDouble(3, verdura.getValor());
            stmt.setInt(4, verdura.getId());
            stmt.executeUpdate();
            System.out.println("Banco de dados atualizado!");
        } catch (Exception e) {
            System.err.println("Erro ao editar o banco: " + e.getMessage());
        }
    }

    public void removerVerdura(int id){
        ConexaoBD cnx = new ConexaoBD();
        String sql = "DELETE FROM verdura WHERE id = ?";
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Item removido do banco de dados!");
        } catch (Exception e) {
            System.err.println("Erro ao remover do banco: " + e.getMessage());
        }
    }
}
