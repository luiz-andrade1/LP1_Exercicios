package farmacia.DataBaseConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoBD {

    private String url;
    private String userName;
    private String password;

    public ConexaoBD() {
        loadProperties();
    }

    public void loadProperties() {

        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new RuntimeException("Arquivo db.properties nao encontrado.");

            }
            Properties properties = new Properties();
            properties.load(input);

            url = properties.getProperty("db.url");
            userName = properties.getProperty("db.userName");
            password = properties.getProperty("db.password");

        } catch (Exception e) {e.printStackTrace();}
    }

    public String getUrl(){
        return url;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }

    public Connection conectar () {
        try {return DriverManager.getConnection(getUrl(),getUserName(),getPassword());
        } catch (SQLException e) {
            System.err.println("Erro de conexão: " + e.getMessage());
            return null;
        }
    }

        public static Connection conectar2() {
            try {
                String url = "jdbc:postgresql://localhost:5432/postgres";
                return DriverManager.getConnection(url, "postgres", "senhaGenerica");
            } catch (SQLException e) {
                System.err.println("Erro de conexão: " + e.getMessage());
                return null;
            }
        }

    public static void main(String[] args){
        ConexaoBD con = new ConexaoBD();
        System.out.println(con.getUrl()+con.getUserName()+con.getPassword());
        System.out.println(con.conectar2());
    }

}
