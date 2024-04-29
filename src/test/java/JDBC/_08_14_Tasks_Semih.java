package JDBC;

import Utulities.DBUtility;
import org.testng.annotations.Test;

import java.util.List;

public class _08_14_Tasks_Semih extends DBUtility {

    @Test
    public void Task8() {
        List<List<String>> dbList = getListData("SELECT de.dept_no, AVG(s.salary) AS average_salary FROM dept_emp de JOIN salaries s ON de.emp_no = s.emp_no GROUP BY de.dept_no;");

        System.out.println("**** Calculate the average salary for each department (by department number or department name) ****");
        System.out.println("By Department No");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println("-------------------------------------------------------------");

        List<List<String>> dbList1 = getListData("SELECT dept_name, AVG(salary) AS avg_salary FROM departments JOIN dept_emp ON departments.dept_no = dept_emp.dept_no JOIN salaries ON dept_emp.emp_no = salaries.emp_no GROUP BY departments.dept_no;");

        System.out.println("By Department Name");
        System.out.println();

        for (int i = 0; i < dbList1.size(); i++) {
            for (int j = 0; j < dbList1.get(i).size(); j++) {
                System.out.print(dbList1.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task9() {
        List<List<String>> dbList = getListData("SELECT d.dept_no, d.dept_name, AVG(s.salary) AS average_salary FROM employees e JOIN dept_emp de ON e.emp_no = de.emp_no JOIN salaries s ON e.emp_no = s.emp_no JOIN departments d ON de.dept_no = d.dept_no GROUP BY d.dept_no, d.dept_name;");

        System.out.println("**** Calculate the average salary for each department, including department names ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task10() {
        List<List<String>> dbList = getListData("SELECT emp_no, salary, from_date, to_date FROM salaries WHERE emp_no = '10102' ORDER BY from_date;");

        System.out.println("**** Calculate the average salary for each department, including department names ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task11() {
        List<List<String>> dbList = getListData("SELECT emp_no, salary, to_date FROM salaries WHERE emp_no = '10102' ORDER BY to_date;");

        System.out.println("**** Find the salary increases for employee with employee number '10102' (using the to_date column in salaries) ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task12() {
        List<List<String>> dbList = getListData("SELECT * FROM employees JOIN salaries ON employees.emp_no = salaries.emp_no ORDER BY salary DESC LIMIT 1;");

        System.out.println("**** Find the employee with the highest salary ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task13() {
        List<List<String>> dbList = getListData("SELECT emp_no, salary, to_date FROM salaries WHERE (emp_no, to_date) IN (SELECT emp_no, MAX(to_date) FROM salaries GROUP BY emp_no);");

        System.out.println("**** Find the latest salaries for each employee ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Task14() {
        List<List<String>> dbList = getListData("SELECT e.first_name, e.last_name, MAX(s.salary) AS highest_salary FROM employees e INNER JOIN dept_emp de ON e.emp_no = de.emp_no INNER JOIN departments d ON de.dept_no = d.dept_no INNER JOIN salaries s ON e.emp_no = s.emp_no WHERE d.dept_name = 'Sales' GROUP BY e.first_name, e.last_name ORDER BY highest_salary DESC LIMIT 1;");

        System.out.println("**** List the first name, last name, and highest salary of employees in the 'Sales' department ****");
        System.out.println("**** Order the list by highest salary descending and only show the employee with the highest salary ****");
        System.out.println();

        for (int i = 0; i < dbList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                System.out.print(dbList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
