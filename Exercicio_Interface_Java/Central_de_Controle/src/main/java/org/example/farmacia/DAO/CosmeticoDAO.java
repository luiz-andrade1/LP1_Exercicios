package org.example.farmacia.DAO;

import org.example.farmacia.model.Alimento;
import org.example.farmacia.model.Cosmetico;
import org.example.config.ConexaoBD;
import org.example.farmacia.model.Remedio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CosmeticoDAO {

    public void cadastrarCosmetico(Cosmetico cosmetico) {
        String sql = "INSERT INTO cosmetico (nome, peso, valor) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cosmetico.getNome());
            stmt.setInt(2, cosmetico.getPeso());
            stmt.setDouble(3, cosmetico.getValor());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }

    public List<Cosmetico> buscarCosmetico(String nomeCosmetico){
        String sql = "SELECT * FROM cosmetico WHERE nome ILIKE ?";
        List<Cosmetico> encontrados = new ArrayList<>();
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%"+nomeCosmetico+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Cosmetico c = new Cosmetico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("peso"),
                        rs.getDouble("valor")
                );
                encontrados.add(c);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar no banco: " + e.getMessage());
        }
        return encontrados;
    }

    public void editarCosmetico(Cosmetico cosmetico){
        String sql = "UPDATE cosmetico SET nome = ?, peso = ?, valor = ? WHERE id = ?";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cosmetico.getNome());
            stmt.setInt(2, cosmetico.getPeso());
            stmt.setDouble(3, cosmetico.getValor());
            stmt.setInt(4, cosmetico.getId());
            stmt.executeUpdate();
            System.out.println("Banco de dados atualizado!");
        } catch (Exception e) {
            System.err.println("Erro ao editar o banco: " + e.getMessage());
        }
    }

    public void removerCosmetico(int id){
        ConexaoBD cnx = new ConexaoBD();
        String sql = "DELETE FROM cosmetico WHERE id = ?";
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
