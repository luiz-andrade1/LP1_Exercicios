package org.example.farmacia.DAO;

import org.example.farmacia.model.Cosmetico;
import org.example.farmacia.model.Remedio;
import org.example.config.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RemedioDAO {
    public void cadastrarRemedio(Remedio remedio) {
        String sql = "INSERT INTO remedio (nome, peso, valor) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, remedio.getNome());
            stmt.setInt(2, remedio.getPeso());
            stmt.setDouble(3, remedio.getValor());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }

    public List<Remedio> buscarRemedio(String nomeRemedio){
        String sql = "SELECT * FROM remedio WHERE nome ILIKE ?";
        List<Remedio> encontrados = new ArrayList<>();
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%"+nomeRemedio+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Remedio r = new Remedio(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("peso"),
                        rs.getDouble("valor")
                );
                encontrados.add(r);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar no banco: " + e.getMessage());
        }
        return encontrados;
    }

    public void editarRemedio(Remedio remedio){
        String sql = "UPDATE remedio SET nome = ?, peso = ?, valor = ? WHERE id = ?";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, remedio.getNome());
            stmt.setInt(2, remedio.getPeso());
            stmt.setDouble(3, remedio.getValor());
            stmt.setInt(4, remedio.getId());
            stmt.executeUpdate();
            System.out.println("Banco de dados atualizado!");
        } catch (Exception e) {
            System.err.println("Erro ao editar o banco: " + e.getMessage());
        }
    }

    public void removerRemedio(int id){
        ConexaoBD cnx = new ConexaoBD();
        String sql = "DELETE FROM remedio WHERE id = ?";
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
