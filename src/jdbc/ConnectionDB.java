package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection instance;

    private ConnectionDB(){};

    public static Connection getInstance() throws SQLException {
        if(instance == null) {
            String url = MYSQLConnection.url;
            String usr = MYSQLConnection.username;
            String pwd = MYSQLConnection.password;
            instance = DriverManager.getConnection(url, usr, pwd);
        }
        return instance;
    }

    public static void closeConnection() throws SQLException {
        if(instance != null){
            instance.close();
        }
    }
}
