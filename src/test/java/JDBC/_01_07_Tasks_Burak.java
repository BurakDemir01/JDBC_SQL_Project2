package _JBDC;

import JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class _01_07_Tasks_Burak extends JDBCParent {
    @Test
    public void Test1() {
        String sorgu="SELECT * FROM employees INNER JOIN dept_emp ON employees.emp_no = dept_emp.emp_no WHERE dept_no = 'D001'";
        List<List<String>>  donenTablo=getListData(sorgu);
        for(List<String> satir : donenTablo) {
            for (String kolon : satir)
                System.out.print(kolon+"\t");

            System.out.println();
        }
    }

    public List<List<String>> getListData(String sorgu) {
        List<List<String>> tablo=new ArrayList<>();

        try {
            DBConnectionOpen();
            ResultSet rs = sorguEkrani.executeQuery(sorgu);
            ResultSetMetaData rsmd = rs.getMetaData();

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

                tablo.add(satir);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            DBConnectionClose();
        }
        return tablo;
    }

    @Test
    public void Test2(){

    }
}
