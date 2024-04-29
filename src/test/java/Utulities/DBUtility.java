package Utulities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    public static Connection baglanti;
    public static Statement sorguEkrani;

    public static List<List<String>> getListData(String sorgu)
    {
        List<List<String>> tablo=new ArrayList<>();

        try {
            DBConnectionOpen();
            ResultSet rs = sorguEkrani.executeQuery(sorgu);
            ResultSetMetaData rsmd = rs.getMetaData(); // kolon sayısı

            // kolon isimleri tablonun ilk satırına eklendi

            ArrayList<String> kolonSatiri = new ArrayList<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                kolonSatiri.add(rsmd.getColumnName(i));
            tablo.add(kolonSatiri);



            while (rs.next()) {

                ArrayList<String> satir = new ArrayList<>();
                // bu satırdaki elemanları satır listine ekle
                // rs.getString(1); // 1
                // rs.getString(2); // English
                for (int i = 1; i <= rsmd.getColumnCount(); i++)
                    satir.add(rs.getString(i));

                // satıra ekleme bitince tablo ya ekle
                tablo.add(satir);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            DBConnectionClose();  // hata olsa d aolmasa da çalış
        }

        return tablo;
    }

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
