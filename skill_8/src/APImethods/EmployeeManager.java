package APImethods;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager(List<Employee> employees) {
        this.employees = employees;
    }

    public void displayEmployees() {
        employees.forEach(System.out::println);
    }

    public void filterEmployeesBySalary(double threshold) {
        System.out.println("Employees with salary greater than " + threshold + ":");
        employees.stream()
                .filter(e -> e.getSalary() > threshold)
                .forEach(System.out::println);
    }

    public void sortEmployeesBySalary() {
        System.out.println("Employees sorted by salary:");
        employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .forEach(System.out::println);
    }

    public void findHighestSalary() {
        OptionalDouble highestSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max();

        highestSalary.ifPresent(salary -> 
                System.out.println("Highest salary: " + salary));
    }

    public void calculateAverageSalary() {
        OptionalDouble averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average();

        averageSalary.ifPresent(avg -> 
                System.out.println("Average salary: " + avg));
    }
}

