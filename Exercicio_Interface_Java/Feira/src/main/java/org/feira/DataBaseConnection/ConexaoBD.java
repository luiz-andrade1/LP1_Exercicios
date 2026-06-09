package org.feira.DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    public static Connection conectar() {
        try {String url = "jdbc:postgresql://localhost:5432/postgres";
            return DriverManager.getConnection(url, "postgres", "senhaGenerica");
        } catch (SQLException e) {
            System.err.println("Erro de conexão: " + e.getMessage());
            return null;
        }
    }
}
