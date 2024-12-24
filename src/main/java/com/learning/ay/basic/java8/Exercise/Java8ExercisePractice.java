package com.learning.ay.basic.java8.Exercise;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8ExercisePractice {
    public static void findSumOfAllIntegers() {
        /*
         * Find the sum of all integers in a list.
         * */

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Integer sum = integers.stream().reduce(Integer::sum).get();
        System.out.println(sum);
    }

    public static void productOfAllIntegerList() {
        //Find the product of all integers in a list.
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        Integer product = integers.stream().reduce((integer, integer2) -> integer * integer2).get();
        System.out.println(product);
    }

    public static void findAverageOfAllIntegers() {
        //Find the average of all integers in a list.
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(integers.stream().reduce(Integer::sum).get() / Integer.valueOf(integers.size()).doubleValue());
    }

    public static void findMaxIntegerInList() {
        //Find the maximum integer in a list.
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(integers.stream().max(Integer::compare).get());
    }

    public static void filerEmployeeWhoseAgeIsGraterThan30(List<Employee> employees) {
        //Filter employees whose age is above 30.
        System.out.println(employees.stream().filter(employee -> employee.getAge() > 30).map(Employee::toString).collect(Collectors.toList()));
    }

    //Find the average salary of all employees.
    public static void findAverageSalaryOfEmployees(List<Employee> employees) {
        System.out.println(employees.stream().map(Employee::getSalary).collect(Collectors.averagingInt(Double::intValue)));
    }

    //Sort employees by their name.
    public static void sortEmployeesByName(List<Employee> employees) {
        System.out.println(employees.stream().sorted(Comparator.comparing(Employee::getName)).map(Employee::toString).collect(Collectors.toList()));
    }

    //Group employees by department.
    public static void groupEmployeesByDepartment(List<Employee> employees) {
        System.out.println("//Group employees by department. ----->");
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect);
    }

    //Find the employee with the highest salary.
    public static void findEmployeeWithHighestSalary(List<Employee> employees) {
        System.out.println(employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).get().toString());
    }

    //Find all employees whose name starts with "J".
    public static void getEmployeesStartingWithJ(List<Employee> employees) {
        System.out.println(employees.stream().filter(employee -> employee.getName().startsWith("J")).map(Employee::toString).collect(Collectors.toList()));
    }

    //Calculate the total salary of all employees.
    public static void getTotalSalaryOfAllEmployees(List<Employee> employees) {
        System.out.println(employees.stream().map(Employee::getSalary).reduce(Double::sum).get());
    }

    //Find the employee with the shortest name.
    public static void findShortestEmployeeName(List<Employee> employees) {
        System.out.println("Find the employee with the shortest name.------>");
        System.out.println(employees.stream().min(Comparator.comparing(employee -> employee.getName().length())).get().getName());
    }
    //Get the distinct departments of all employees.
    public static void findDistinctDepartment(List<Employee> employees){
        System.out.println(employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList()));
    }
    //Find the oldest employee.
    public static void findOldestEmployee(List<Employee> employees){
        System.out.println(employees.stream().max(Comparator.comparing(Employee::getAge)).get());
    }

    public static void main(String[] args) {
        //Find the sum of all integers in a list.
        findSumOfAllIntegers();
        //Find the product of all integers in a list.
        productOfAllIntegerList();
        //Find the average of all integers in a list.
        findAverageOfAllIntegers();
        //Find the minimum integer in a list.
        findMaxIntegerInList();
        List<Employee> employees = generateEmployees();
        //Filter employees whose age is above 30.
        filerEmployeeWhoseAgeIsGraterThan30(employees);
        //Find the average salary of all employees.
        findAverageSalaryOfEmployees(employees);
        //Sort employees by their name.
        sortEmployeesByName(employees);
        //Group employees by department.
        groupEmployeesByDepartment(employees);
        //Find the employee with the highest salary.
        findEmployeeWithHighestSalary(employees);
        getEmployeesStartingWithJ(employees);
        //Calculate the total salary of all employees.
        getTotalSalaryOfAllEmployees(employees);
        //Find the employee with the shortest name.
        findShortestEmployeeName(employees);
        //Get the distinct departments of all employees.
        findDistinctDepartment(employees);
        //Find the oldest employee.
        findOldestEmployee(employees);


    }


    public static List<Employee> generateEmployees() {
        Employee rahul = new Employee("Rahul", 23, 90000, "IT");
        Employee janeDone = new Employee("Jane Doe", 28, 60000, "Sales");
        Employee michelJhonson = new Employee("Michael Johnson", 42, 75000, "HR");
        Employee emilyWilliams = new Employee("Emily Williams", 31, 55000, "Marketing");
        Employee DavidBrown = new Employee("David Brown", 45, 80000, "Engineering");
        Employee sarahAnderson = new Employee("Sarah Anderson", 33, 65000, "IT");
        Employee robertDavis = new Employee("Robert Davis", 29, 60000, "Finance");
        Employee jessicaTaylor = new Employee("Jessica Taylor", 38, 70000, "HR");
        Employee christopherWilson = new Employee("Christopher Wilson", 27, 55000, "Marketing");
        Employee ashleyThomson = new Employee("Ashley Thompson", 41, 75000, "Sales");
        Employee danielClark = new Employee("Daniel Clark", 34, 65000, "Engineering");
        Employee oliviaMartinez = new Employee("Olivia Martinez", 30, 60000, "IT");
        Employee williamLee = new Employee("William Lee", 39, 70000, "Finance");
        Employee sophiaRodriguez = new Employee("Sophia Rodriguez", 32, 60000, "HR");


        return List.of(rahul, janeDone, michelJhonson, emilyWilliams, DavidBrown, sarahAnderson, robertDavis, jessicaTaylor, christopherWilson, ashleyThomson, danielClark, oliviaMartinez, williamLee, sophiaRodriguez);


    }


}