package JDBC;

import Utulities.DBUtility;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _36_41_Tasks_Gulmira extends DBUtility {
    @Test
    public void Task36() {
        //Find the duration of employment for each employee:
        String query = "select e.emp_no, e.first_name, e.last_name, (datediff(Max(t.to_date), min(t.from_date)))/365 as work_duration_in_years from employees e join titles t on e.emp_no=t.emp_no group by e.emp_no, e.first_name, e.last_name LIMIT 1000";
        System.out.println("----------------Task 36: Find the duration of employment for each employee:---------------");
        List<List<String>> table = getListData(query);
                for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                System.out.print(table.get(i).get(j) + "        ");
            }
            System.out.println();
            }
    }

    @Test
    public void Task37() {
        //Find the latest title information for each employee:
        String query = "SELECT employees.emp_no, employees.first_name, employees.last_name, titles.title FROM employees JOIN titles ON employees.emp_no = titles.emp_no WHERE titles.to_date = (SELECT MAX(to_date) FROM titles WHERE titles.emp_no = employees.emp_no) LIMIT 1000;";
        System.out.println("-----------Task37: Find the latest title information for each employee:");
        List<List<String>> table = getListData(query);
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                System.out.print(table.get(i).get(j) + "    ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task38() {
        //Find the first and last names of managers in department 'D005':
        String query = "SELECT employees.first_name, employees.last_name FROM employees JOIN dept_manager ON employees.emp_no = dept_manager.emp_no WHERE dept_manager.dept_no = 'D005' LIMIT 1000;";
        System.out.println("-----------Task 38: Find the first and last names of managers in department 'D005':---------");
        List<List<String>> table = getListData(query);
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                System.out.print(table.get(i).get(j) + "    ");
            }
            System.out.println();
        }
    }
    @Test
    public void Task39() {
        //Sort employees by their birthdate:
        String query = "SELECT *  FROM employees ORDER BY birth_date LIMIT 1000;";
        System.out.println("----------------Task 39: Sort employees by their birthdate:----------------------");
        List<List<String>> table = getListData(query);
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                System.out.print(table.get(i).get(j) + "    ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task40() {
        //List employees hired in April 1992:
        String query = "SELECT * FROM employees WHERE hire_date BETWEEN '1992-04-01' AND '1992-04-30' LIMIT 1000;";
        System.out.println("-------------------Task 40:List employees hired in April 1992:---------------------- ");
        List<List<String>> table = getListData(query);
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                System.out.print(table.get(i).get(j) + "    ");
            }
            System.out.println();
        }
    }
    @Test
    public void Task41() {
        //Find all departments that employee '10102' has worked in:
        String query = "SELECT DISTINCT dept_no FROM dept_emp WHERE emp_no = '10102' LIMIT 1000;";
        System.out.println("---------------------Task 41: Find all departments that employee '10102' has worked in:-----------------------");
        List<List<String>> table = getListData(query);
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                System.out.print(table.get(i).get(j) + "    ");
            }
            System.out.println();
        }
    }



    public static List<List<String>> getListData(String query) {
        List<List<String>> dataTable = new ArrayList<>();

        try {
            DBConnectionOpen();
            ResultSet rs = sorguEkrani.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            ArrayList<String> colomnRow = new ArrayList<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                colomnRow.add(rsmd.getColumnName(i));
            dataTable.add(colomnRow);

            while (rs.next()) {
                ArrayList<String> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++)
                    row.add(rs.getString(i));
                dataTable.add(row);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnectionClose();
        }
        return dataTable;
    }
}


