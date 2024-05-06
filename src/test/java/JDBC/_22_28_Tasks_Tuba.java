package JDBC;

import org.testng.annotations.Test;

import java.util.List;

import static Utulities.DBUtility.getListData;

public class _22_28_Tasks_Tuba extends JDBCParent {
    @Test
    public void Task22a() {
        List<List<String>> dbList = getListData("SELECT COUNT(DISTINCT first_name) AS Unique_Names FROM employees;");

        System.out.println("**** Find out how many employees have unique first names (1275) ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    @Test
    public void Task22b() {
        List<List<String>> dbList = getListData("SELECT COUNT(DISTINCT dept_name) AS Unique_Departments FROM departments;");

        System.out.println("**** Identify the number of distinct department names (9) ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    @Test
    public void Task23() {
        List<List<String>> dbList = getListData("SELECT de.dept_no, COUNT(*) AS employee_count FROM dept_emp de GROUP BY de.dept_no;");

        System.out.println("**** List the number of employees in each department ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    @Test
    public void Task24() {
        List<List<String>> dbList = getListData("SELECT * FROM employees WHERE hire_date <= DATE_SUB('1990-02-20', INTERVAL 5 YEAR);");

        System.out.println("****List all employees hired within the last 5 years from February 20, 1990 ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    @Test
    public void Task25() {
        List<List<String>> dbList = getListData("SELECT * FROM employees WHERE first_name = 'Annemarie' AND last_name = 'Redmiles';");

        System.out.println("****List the information (employee number, date of birth, first name, last name, gender, hire date)\n" +
                "\tof the employee named \"Annemarie Redmiles\". ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    @Test
    public void Task26() {
        List<List<String>> dbList = getListData("SELECT * FROM employees e INNER JOIN salaries s ON e.emp_no = s.emp_no INNER JOIN titles t ON e.emp_no = t.emp_no WHERE e.first_name = 'Annemarie' AND e.last_name = 'Redmiles';");

        System.out.println("****List all information (employee number, date of birth, first name, last name, gender, hire date, salary, department, and title)\n" +
                "\tfor the employee named \"Annemarie Redmiles\". ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    @Test
    public void Task27() {
        List<List<String>> dbList = getListData("SELECT e.emp_no, e.first_name, e.last_name, e.birth_date, e.gender, e.hire_date, d.dept_name AS department_name, t.title, s.salary\n" +
                "FROM employees e\n" +
                "JOIN dept_manager dm ON e.emp_no = dm.emp_no\n" +
                "JOIN departments d ON dm.dept_no = d.dept_no\n" +
                "JOIN titles t ON e.emp_no = t.emp_no\n" +
                "JOIN salaries s ON e.emp_no = s.emp_no\n" +
                "WHERE d.dept_no = 'D005';");

        System.out.println("****List all employees and managers in the D005 department ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    @Test
    public void Task28() {
        List<List<String>> dbList = getListData("SELECT e.emp_no, e.first_name, e.last_name, e.birth_date, e.gender, e.hire_date, t.title, s.salary\n" +
                "FROM employees e\n" +
                "JOIN titles t ON e.emp_no = t.emp_no\n" +
                "JOIN salaries s ON e.emp_no = s.emp_no\n" +
                "WHERE e.hire_date > '1994-02-24' AND s.salary > 50000;\n");

        System.out.println("****List all employees hired after '1994-02-24' and earning more than 50,000 ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
