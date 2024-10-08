package APImethods;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 70000));
        employees.add(new Employee("Bob", 50000));
        employees.add(new Employee("Charlie", 60000));
        employees.add(new Employee("Diana", 80000));
        employees.add(new Employee("Ethan", 45000));
        employees.add(new Employee("Fiona", 90000));
        employees.add(new Employee("George", 120000));
        employees.add(new Employee("Hannah", 55000));
        employees.add(new Employee("Ian", 72000));
        employees.add(new Employee("Jack", 65000));

        EmployeeManager employeeManager = new EmployeeManager(employees);

        System.out.println("All Employees:");
        employeeManager.displayEmployees();

        employeeManager.filterEmployeesBySalary(60000);

        employeeManager.sortEmployeesBySalary();

        employeeManager.findHighestSalary();

        employeeManager.calculateAverageSalary();
    }
}
