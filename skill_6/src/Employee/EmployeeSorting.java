package Employee;

import java.util.*;

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Sunny", 3, 70000));
        employees.add(new Employee("Rithik", 1, 50000));
        employees.add(new Employee("Rahul", 2, 60000));

        System.out.println("Original list:");
        printEmployees(employees);

        Collections.sort(employees);
        System.out.println("\nSorted by name:");
        printEmployees(employees);

        Collections.sort(employees, Employee.salaryComparator);
        System.out.println("\nSorted by salary:");
        printEmployees(employees);

        Collections.sort(employees, Employee.idComparator);
        System.out.println("\nSorted by ID:");
        printEmployees(employees);

        try {
            Employee clonedEmployee = employees.get(0).clone();
            System.out.println("\nCloned Employee:");
            System.out.println(clonedEmployee);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
