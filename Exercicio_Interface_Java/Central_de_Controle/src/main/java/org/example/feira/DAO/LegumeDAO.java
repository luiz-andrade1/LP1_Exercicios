package org.example.feira.DAO;

import org.example.config.ConexaoBD;
import org.example.feira.model.Legume;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Legume> buscarLegume(String nomeLegume){
        String sql = "SELECT * FROM legume WHERE nome ILIKE ?";
        List<Legume> encontrados = new ArrayList<>();
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%"+nomeLegume+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Legume l = new Legume(
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

    public void editarLegume(Legume legume){
        String sql = "UPDATE legume SET nome = ?, peso = ?, valor = ? WHERE id = ?";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, legume.getNome());
            stmt.setInt(2, legume.getQuantidade());
            stmt.setDouble(3, legume.getValor());
            stmt.setInt(4, legume.getId());
            stmt.executeUpdate();
            System.out.println("Banco de dados atualizado!");
        } catch (Exception e) {
            System.err.println("Erro ao editar o banco: " + e.getMessage());
        }
    }

    public void removerLegume(int id){
        ConexaoBD cnx = new ConexaoBD();
        String sql = "DELETE FROM legume WHERE id = ?";
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
