package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCParent {

    public static Connection baglanti;
    public static Statement sorguEkrani;

    public static void DBConnectionOpen()
    {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/employees";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            baglanti = DriverManager.getConnection(url, username, password);
            sorguEkrani = baglanti.createStatement();
        }
        catch(Exception ex)
        {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    public static void DBConnectionClose()
    {
        try {
            baglanti.close();
        } catch (SQLException e) {
            System.out.println("ex.getMessage() = " + e.getMessage());
        }
    }
}
