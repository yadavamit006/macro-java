package com.learning.ay.basic;

import java.util.ArrayList;
import java.util.List;

public class GenericsSample {
    public static void main(String[] args) {

        List<?> list = new ArrayList<>(); //Wildcard, A list of elements are unknown. Designed for read-only access
        list.add(null);//
        //list.add("sdr") cannot add any element because the actual type is unknown.

        List<Object> objectList = new ArrayList<>(); // Obj is superclass of all classes in java
        objectList.add("asd");

        Object object = new Object();
        List<? extends Object> extendsObject = new ArrayList<>(); //wildcard with upperbound
        //extendsObject.add(object); all types in java extend Object, this is effectively equivalent to List<?>

        List<? super Number> numberList = new ArrayList<>(); // Allows a list whose type is Number or any of its supertypes ex Object
        numberList.add(Integer.valueOf(10));// valid because Java guarantees that any element you add will match the Number type or its subtypes
        numberList.add(Double.valueOf(12));
        Object obj = numberList.get(0);// compiler treats the elements as Object because the exact type is unknown

        List<Integer> integerList = List.of(1, 2, 3);
        List<Double> doubleList = List.of(1.1, 2.1, 3.1);

        printNumbers(integerList);
        printNumbers(doubleList);
        addNumbers(integerList);
    }

    private static void addNumbers(List<Integer> integers) {
        //integers.add(Integer.valueOf(3)); //java.lang.UnsupportedOperationException because List.of is ImmutableCollections
        System.out.println(integers.size());
    }

    private static void printNumbers(List<? extends Number> numbers) {
        for (Number number : numbers)
            System.out.println(number);
    }
}
