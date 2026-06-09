package org.feira.DataBaseConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoBD {
    public static Connection conectar() throws SQLException {
        Properties props = new Properties();

        try (InputStream input = ConexaoBD.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new IOException("Arquivo db.properties não encontrado!");
            }
            props.load(input);

            return DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.userName"),
                    props.getProperty("db.password")
            );
        } catch (Exception e) {
            throw new SQLException("Falha ao conectar com o banco de dados: " + e.getMessage(), e);
        }
    }
}
