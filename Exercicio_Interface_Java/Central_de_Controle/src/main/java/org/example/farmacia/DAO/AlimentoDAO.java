package org.example.farmacia.DAO;

import org.example.farmacia.model.Alimento;
import org.example.config.ConexaoBD;
import org.example.farmacia.model.Cosmetico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlimentoDAO {

    Alimento alimento;

    public void cadastrarAlimento(Alimento alimento) {
        String sql = "INSERT INTO alimento (nome, peso, valor) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, alimento.getNome());
            stmt.setInt(2, alimento.getPeso());
            stmt.setDouble(3, alimento.getValor());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }

    public List<Alimento> buscarAlimento(String nomeAlimento){
        String sql = "SELECT * FROM alimento WHERE nome ILIKE ?";
        List<Alimento> encontrados = new ArrayList<>();
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%"+nomeAlimento+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Alimento a = new Alimento(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("peso"),
                        rs.getDouble("valor")
                );
                encontrados.add(a);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar no banco: " + e.getMessage());
        }
        return encontrados;
    }

    public void editarAlimento(Alimento alimento){
        String sql = "UPDATE alimento SET nome = ?, peso = ?, valor = ? WHERE id = ?";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, alimento.getNome());
            stmt.setInt(2, alimento.getPeso());
            stmt.setDouble(3, alimento.getValor());
            stmt.setInt(4, alimento.getId());
            stmt.executeUpdate();
            System.out.println("Banco de dados atualizado!");
        } catch (Exception e) {
            System.err.println("Erro ao editar o banco: " + e.getMessage());
        }
    }

    public void removerAlimento(int id){
        ConexaoBD cnx = new ConexaoBD();
        String sql = "DELETE FROM alimento WHERE id = ?";
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