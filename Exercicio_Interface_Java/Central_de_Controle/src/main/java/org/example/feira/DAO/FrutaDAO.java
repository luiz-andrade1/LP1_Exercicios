package org.example.feira.DAO;

import org.example.config.ConexaoBD;
import org.example.feira.model.Fruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FrutaDAO {
    public void cadastrarFruta(Fruta fruta){
        String sql = "INSERT INTO fruta (nome, quantidade, valor) VALUES (?, ?, ?)";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fruta.getNome());
            stmt.setInt(2, fruta.getQuantidade());
            stmt.setDouble(3, fruta.getValor());
            stmt.executeUpdate();
            System.out.println("Salvo no banco com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }

    public List<Fruta> buscarFruta(String nomeFruta){
        String sql = "SELECT * FROM fruta WHERE nome ILIKE ?";
        List<Fruta> encontrados = new ArrayList<>();
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%"+nomeFruta+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Fruta f = new Fruta(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getDouble("valor")
                );
                encontrados.add(f);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar no banco: " + e.getMessage());
        }
        return encontrados;
    }

    public void editarFruta(Fruta fruta){
        String sql = "UPDATE fruta SET nome = ?, quantidade = ?, valor = ? WHERE id = ?";
        ConexaoBD cnx = new ConexaoBD();
        try (
                Connection conn = cnx.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fruta.getNome());
            stmt.setInt(2, fruta.getQuantidade());
            stmt.setDouble(3, fruta.getValor());
            stmt.setInt(4, fruta.getId());
            stmt.executeUpdate();
            System.out.println("Banco de dados atualizado!");
        } catch (Exception e) {
            System.err.println("Erro ao editar o banco: " + e.getMessage());
        }
    }

    public void removerFruta(int id){
        ConexaoBD cnx = new ConexaoBD();
        String sql = "DELETE FROM fruta WHERE id = ?";
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
