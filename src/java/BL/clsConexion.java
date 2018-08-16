package BL;

import java.sql.DriverManager;
import java.sql.Connection;

public class clsConexion {

    Connection conn = null;
    String stServidor, stDatabase, stUsuario, stPassword = "";

    public clsConexion() {
        try {
            stServidor = "localhost";
            stDatabase = "bdCRM";
            stUsuario = "User";
            stPassword = "123456";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String stConexion = 
                    "jdbc:sqlserver://" + stServidor + ":1433;databaseName=" + stDatabase;
            conn = DriverManager.getConnection(stConexion,stUsuario,stPassword);
        } catch (Exception ex) {

        }
    }

    public Connection getConexion() {
        return conn;
    }

    public void cerrarConexion() {
        try {
            conn.close();
        } catch (Exception ex) {

        }
    }
}
