package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDAO {
    public static Connection ConnectDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/revisi", "root", "210703");
            return connect;
        } catch (Exception e) {
        }
        return null;
    }
}
