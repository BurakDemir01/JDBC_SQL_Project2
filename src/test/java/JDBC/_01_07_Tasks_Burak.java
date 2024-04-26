package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _01_07_Tasks_Burak extends JDBCParent {

    @Test
    public void Test1() throws SQLException {
        DBConnectionOpen();

        ResultSet rs=sorguEkrani.executeQuery("SELECT * FROM employees INNER JOIN dept_emp ON employees.emp_no = dept_emp.emp_no WHERE dept_no = 'D001'");

        ResultSetMetaData rsmd= rs.getMetaData();

     // System.out.println("rsmd = " + rsmd.getColumnName(1)+" "+rsmd.getColumnCount() );
     // for (int i = 1; i <= rsmd.getColumnCount(); i++)
     //     System.out.print(rsmd.getColumnName(i)+"\t");

     // System.out.println();
       while (rs.next()){

           for (int i = 1; i <= rsmd.getColumnCount() ; i++)
               System.out.print(rs.getString(i)+"\t");
           System.out.println();
       }

        DBConnectionClose();
    }


}
