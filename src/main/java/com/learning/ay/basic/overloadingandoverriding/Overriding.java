package com.learning.ay.basic.overloadingandoverriding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Overriding {
    public static void main(String[] args) throws Exception {
        Animal a = new Horse();
        a.eat();
        System.out.println(a.getCount());
        //a.bulk(); cant resolve bulk() Animal class don't have bulk;
        System.out.println("Speed is "+a.speed);// Animal speed. Member variable are not overridden

        Animal animal = new Horse();
        Horse horse = (Horse) animal;//Valid DownCasting
        horse.bulk();

        //Horse b = (Horse) new Animal();// Invalid DownCasting
    }
}

class Animal {

    public int speed = 100;

    public void eat() throws NullPointerException {
        System.out.println("Animal eating");
    }

    public Number getCount() throws IOException {
        return Integer.valueOf(1);
    }

    public String getName() {
        return "Animal";
    }

    private void defineBreed() {
        System.out.println("Animal bread");
    }
}

class Horse extends Animal {
    public int speed = 200;

    public void eat() throws RuntimeException {
        System.out.println("Horse eating");
    }

    public void bulk() {
        System.out.println("bulk horse");
    }

    public Integer getCount() throws FileNotFoundException { //a subclass of that object is allowed as the return type
        return Integer.valueOf(2);
    }

    public String getName() throws NullPointerException { //Overridden method does not throws exception then overriding method can only throw Unchecked Exception
        return "Horse";
    }
}

/*
The parameter list must not change: the overriding method must take the same number and type of parameters as the overridden method – otherwise, you would just be overloading the method.
The return type must not change (Note: if the method returns an object, a subclass of that object is allowed as the return type).
The access modifier must be either the same or a less restrictive one (for example, if the overridden method is protected, you can declare the overriding method as public, but not private).
Thrown checked exceptions, if any, can be removed or reduced by the overriding method. This means that the overriding method can throw the same checked exception as the overridden method, or a subclass of that checked exception, but not a broader exception. This restriction does not apply to unchecked exceptions.

Checked Exp is free to throw any unchecked exception. Overriding method can not throw higher exception. Exception
If Overridden method does not throws an exception then overriding method can throw unchecked exception else compile time error
 */