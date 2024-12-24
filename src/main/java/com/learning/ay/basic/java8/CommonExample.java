package com.learning.ay.basic.java8;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int numberOfStudents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Course(String name, String category, int reviewScore, int numberOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public String toString() {
        return "course{" + "name='" + name + '\'' + ", category='" + category + '\'' + ", reviewScore=" + reviewScore + ", numberOfStudents=" + numberOfStudents + '}';
    }
}

public class CommonExample {
    public static void main(String[] args) {
        List<Course> courseList = List.of(new Course("Java Basics", "Programming", 4, 100), new Course("Data Structures and Algorithms", "Computer Science", 4, 200), new Course("Machine Learning Fundamentals", "Artificial Intelligence", 5, 300), new Course("Web Development Bootcamp", "Web Development", 4, 150), new Course("Introduction to Python", "Programming", 4, 120), new Course("Database Management Essentials", "Database Management", 4, 80), new Course("JavaScript for Beginners", "Web Development", 3, 250), new Course("Artificial Intelligence Ethics", "Ethics", 4, 90), new Course("Advanced Java Concepts", "Programming", 5, 80), new Course("Software Testing and QA", "Quality Assurance", 4, 70));

        Predicate<Course> reviewScoreGreaterThanOne = new Predicate<Course>() {
            @Override
            public boolean test(Course course) {
                return course.getReviewScore() > 1;

            }
        };
        Predicate<Course> reviewScoreGreaterThanNinty = new Predicate<Course>() {
            @Override
            public boolean test(Course course) {
                return course.getReviewScore() > 90;

            }
        };
        Predicate<Course> reviewScoreLessThanFour = new Predicate<Course>() {
            @Override
            public boolean test(Course course) {
                return course.getReviewScore() < 4;

            }
        };
        //allMatch ,noneMatch,anyMatch
        System.out.println(courseList.stream().allMatch(reviewScoreGreaterThanOne));
        System.out.println(courseList.stream().noneMatch(reviewScoreGreaterThanNinty));
        System.out.println(courseList.stream().anyMatch(reviewScoreLessThanFour));
        //whenever we are using primitive type to compare we can use comapringInt/comapringLong/comparingDouble methods as they much effiencet because of no autoboxing, normal comparing method performs autoboxing before comparing but these primitive comparing method is free from autoboxing and hence is much efficient.
        Comparator<Course> comparingByNumberOfStudentsIncreasing = Comparator.comparingInt(Course::getNumberOfStudents);
        Comparator<Course> comparingByNumberOfStudentsDecreasing = comparingByNumberOfStudentsIncreasing.reversed();// .reversed() will reverse the comparator logic of a given comparator.
        System.out.println(courseList.stream().sorted(comparingByNumberOfStudentsIncreasing).collect(Collectors.toList()));
        System.out.println(courseList.stream().sorted(comparingByNumberOfStudentsDecreasing).collect(Collectors.toList()));

        System.out.println("comparingByNoOfStudentsAndReviewScore ------->");
        Comparator<Course> comparingByNoOfStudentsAndReviewScore = Comparator.comparing(Course::getNumberOfStudents).thenComparing(Course::getReviewScore);
        System.out.println(courseList.stream().sorted(comparingByNoOfStudentsAndReviewScore).toList());

        //skip , limit, takeWhile,dropWhile

        //limit allows u limit the number of elements from the stream
        System.out.println("get top 2 element after sorting by number of students");
        System.out.println(courseList.stream().sorted(comparingByNumberOfStudentsIncreasing).limit(2).collect(Collectors.toList()));

        //skip is like db skip keyword , allows u to skip the number of records mentioned from stream.
        System.out.println("sort the list and skip first 2 elements and get the remaining result");
        System.out.println(courseList.stream().sorted(comparingByNumberOfStudentsIncreasing).skip(2).collect(Collectors.toList()));

        System.out.println("takeWhile will keep elements from the stream as long as the predicate is true. Once the predicate becomes false, takeWhile stops and returns the elements it has collected so far");
        System.out.println(courseList.stream().takeWhile(course -> course.getNumberOfStudents() <= 100).collect(Collectors.toList()));

        System.out.println("dropWhile operates on a Stream and removes elements from it as long as a given predicate is true. Once the predicate becomes false for an element, dropWhile stops removing elements and returns the rest of the Stream.");
        System.out.println(courseList.stream().dropWhile(course -> course.getNumberOfStudents() <= 200).collect(Collectors.toList()));

        System.out.println("returns the last item from a list based on the comparator");
        System.out.println(courseList.stream().max(comparingByNumberOfStudentsIncreasing).get());

        System.out.println("returns min fist from list based on comparator");
        System.out.println(courseList.stream().min(comparingByNumberOfStudentsIncreasing).get());

        //mapping is used to map the list into another list based a given function that converts here  our method refference method is converting stream of courses to stream of integer containing only the number of students from each course if ur variable is of primitive type u can use mapToInt/mapToLong/mapToDouble to map which will skip the autoboxing and is efficient and will give u a primitive stream which u can then use to do some operations like sum average max etc
        System.out.println(courseList.stream().mapToInt(Course::getNumberOfStudents).sum());// we cannot to collectors in it as its a list of primitve
        System.out.println(courseList.stream().mapToInt(Course::getNumberOfStudents).average());
        System.out.println(courseList.stream().mapToInt(Course::getNumberOfStudents).count());
        System.out.println(courseList.stream().mapToInt(Course::getNumberOfStudents).boxed().toList());//after we do boxed it converts the list of primitive into list of Integer which we can then collect

        System.out.println("grouping");
        System.out.println(courseList.stream().collect(Collectors.groupingBy(Course::getCategory)));
        //group courses , count the number of courses for each category
        System.out.println(courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
        //group courses based on category but in each group keep that course which have the highest review
        System.out.println(courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        //group the courses but show only the names in each group
        System.out.println(courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));//collectors.mapping takes two input ,first the parameter or attribute with which u want to map and second is the collection in which you want to store those mapped value
    }
}