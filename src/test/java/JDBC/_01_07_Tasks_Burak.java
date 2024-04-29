package _JBDC;

import JDBC.JDBCParent;
import Utulities.DBUtility;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _01_07_Tasks_Burak extends DBUtility {
    @Test
    public void Task1() {
        List<List<String>> dbList = getListData("SELECT * FROM employees INNER JOIN dept_emp ON employees.emp_no = dept_emp.emp_no WHERE dept_no = 'D001';");

        System.out.println("**** List all employees in department D001 ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task2() {
        List<List<String>> dbList = getListData("SELECT employees.* FROM employees INNER JOIN dept_emp ON employees.emp_no = dept_emp.emp_no INNER JOIN departments ON dept_emp.dept_no = departments.dept_no WHERE departments.dept_name = 'Human Resources';;");

        System.out.println("**** List all employees in 'Human Resources' department ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Test3() throws SQLException {
        DBConnectionOpen();

        ResultSet rs=sorguEkrani.executeQuery("SELECT AVG(salary) AS average_salary FROM salaries;");

        rs.next();

        System.out.println(rs.getString("average_salary"));

        DBConnectionClose();
    }

    @Test
    public void Test4() throws SQLException {
        DBConnectionOpen();

        ResultSet rs=sorguEkrani.executeQuery("SELECT AVG(s.salary) AS average_salary FROM employees e INNER JOIN salaries s ON e.emp_no = s.emp_no WHERE e.gender = 'M'");

        rs.next();

        System.out.println(rs.getString(1));

        DBConnectionClose();
    }

    @Test
    public  void  Test5() throws SQLException {
        DBConnectionOpen();

        ResultSet rs= sorguEkrani.executeQuery("SELECT AVG(s.salary) AS average_salary FROM employees e INNER JOIN salaries s ON e.emp_no = s.emp_no WHERE e.gender = 'F'");

        rs.next();

        System.out.println(rs.getString("average_salary"));

        DBConnectionClose();
    }

    @Test
    public void Test6() throws SQLException {
        DBConnectionOpen();

        String sorgu="SELECT e.*, s.salary FROM employees e JOIN dept_emp de ON e.emp_no = de.emp_no JOIN departments d ON de.dept_no = d.dept_no JOIN salaries s ON e.emp_no = s.emp_no WHERE d.dept_name = 'Sales' AND s.salary > 70000";
       // ResultSet rs= sorguEkrani.executeQuery("SELECT e.*, s.salary FROM employees e JOIN dept_emp de ON e.emp_no = de.emp_no JOIN departments d ON de.dept_no = d.dept_no JOIN salaries s ON e.emp_no = s.emp_no WHERE d.dept_name = 'Sales' AND s.salary > 70000;");
        //rs.next();
        //System.out.println(rs.getString(1));

        List<List<String>>  donenTablo=getListData(sorgu);
        for(List<String> satir : donenTablo) {
            for (String kolon : satir)
                System.out.print(kolon+"\t");

            System.out.println();
        }

        DBConnectionClose();
    }

    @Test
    public  void  Test7(){
        DBConnectionOpen();

        String sorgu="SELECT e.*\n" +
                "FROM employees e\n" +
                "INNER JOIN salaries s ON e.emp_no = s.emp_no\n" +
                "WHERE s.salary BETWEEN 50000 AND 100000";

        List<List<String>>  donenTablo=getListData(sorgu);
        for(List<String> satir : donenTablo) {
            for (String kolon : satir)
                System.out.print(kolon+"\t");

            System.out.println();
        }
    }
}
