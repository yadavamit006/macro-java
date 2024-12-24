package com.learning.ay.basic.java8.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise {

    public static List<Employee> employees() {
        var rahul = new Employee("Rahul", 23, 90000, "IT");
        var janeDone = new Employee("Jane Doe", 28, 60000, "Sales");
        var michelJhonson = new Employee("Michael Johnson", 42, 75000, "HR");
        var emilyWilliams = new Employee("Emily Williams", 31, 55000, "Marketing");
        var DavidBrown = new Employee("David Brown", 45, 80000, "Engineering");
        var sarahAnderson = new Employee("Sarah Anderson", 33, 65000, "IT");
        var robertDavis = new Employee("Robert Davis", 29, 60000, "Finance");
        var jessicaTaylor = new Employee("Jessica Taylor", 38, 70000, "HR");
        Employee christopherWilson = new Employee("Christopher Wilson", 27, 55000, "Marketing");
        Employee ashleyThomson = new Employee("Ashley Thompson", 41, 75000, "Sales");
        Employee danielClark = new Employee("Daniel Clark", 34, 65000, "Engineering");
        Employee oliviaMartinez = new Employee("Olivia Martinez", 30, 60000, "IT");
        Employee williamLee = new Employee("William Lee", 39, 70000, "Finance");
        Employee sophiaRodriguez = new Employee("Sophia Rodriguez", 32, 60000, "HR");
        return List.of(rahul, janeDone, michelJhonson, emilyWilliams, DavidBrown, sarahAnderson, robertDavis, jessicaTaylor, christopherWilson, ashleyThomson, danielClark, oliviaMartinez, williamLee, sophiaRodriguez);
    }

    public static void main(String[] args) {
        System.out.println("Sort employees by their salary in descending order. ----->");
        employees().stream().sorted(Collections.reverseOrder(Comparator.comparingDouble(Employee::getSalary))).forEach(System.out::println);

        System.out.println("Find the employee with the highest age. ----->");
        Optional<Employee> maxSalary = employees().stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println(maxSalary.get());

        System.out.println("Check if there are any employees with a salary above 100,000.");
        Optional<Employee> status = employees().stream().filter(emp -> emp.getSalary() > 100000).findAny();
        System.out.println("Any Employee : " + status.isPresent());

        System.out.println("Get a list of employees' names only.");
        employees().stream().map(emp -> emp.getName()).forEach(System.out::println);

        System.out.println("Find the employee with the lowest salary.");
        employees().stream().sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName, Comparator.reverseOrder())).forEach(System.out::println);

        System.out.println("Check if all employees are from the same department.");
        long distinctDepartment = employees().stream().map(Employee::getDepartment).distinct().count();
        if (distinctDepartment == 1) {
            System.out.println("They are in same department");
        } else {
            System.out.println("different department");
        }
        boolean sameDepartment = employees().stream().allMatch(emp -> emp.getDepartment().equals(employees().get(0).getDepartment()));
        System.out.println("allMatch to same department : " + sameDepartment);

        System.out.println("Get the department with the most employees.------->");
        System.out.println(employees().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey));

        System.out.println("Find the youngest employee.------->");
        System.out.println(employees().stream().min(Comparator.comparingInt(Employee::getAge)));

        System.out.println("Calculate the sum of salaries for employees in the IT department ------->");
        System.out.println(employees().stream().filter(e -> e.getDepartment().equalsIgnoreCase("IT")).mapToDouble(Employee::getSalary).sum());

        System.out.println("Check if there is any employee with an age below 25------->");
        System.out.println(employees().stream().anyMatch(employee -> employee.getAge() < 25));

        System.out.println("Find the employee with the longest name.------->");
        Optional<Employee> longestName = employees().stream().max(Comparator.comparing(emp -> emp.getName().length()));
        System.out.println(longestName.get());

        System.out.println("Group employees by their age.-------->");
        System.out.println(employees().stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getName, Collectors.toList()))));

        System.out.println("Get a list of employees' ages only.--------->");
        System.out.println(employees().stream().map(Employee::getAge).distinct().sorted().collect(Collectors.toSet()));


    }
}

