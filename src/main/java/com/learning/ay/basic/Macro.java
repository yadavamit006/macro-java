package com.learning.ay.basic;

import jakarta.persistence.criteria.CriteriaBuilder;

public class Macro {

    public static void main(String[] args) {

        Integer i = Integer.valueOf(128);
        Integer j = Integer.valueOf(128);
        System.out.println(i == j);
        System.out.println(i.equals(j));
        int primitiveInt = i.intValue();
    }
}
