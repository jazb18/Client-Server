package uni.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {

    public AccesoDB() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection cn;
        //cargar el driver en memoria
        Class.forName("oracle.jdbc.OracleDriver");
        // obtener objto conecion
        String url = "jdbc:oracle:thin:@172.17.2.101:1521:XE";
        cn = DriverManager.getConnection(url, "ventas", "admin");
        return cn;
    }
}
