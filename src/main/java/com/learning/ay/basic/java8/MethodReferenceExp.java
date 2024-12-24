package com.learning.ay.basic.java8;

public class MethodReferenceExp {

    public static void saySomething() {
        System.out.println("This is static method");
    }

    public void instanceMethod() {
        System.out.println("This is instance method");
    }

    MethodReferenceExp() {
    }

    MethodReferenceExp(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        Sayable say = MethodReferenceExp::saySomething; //saySomething binds the static method saySomething to the functional internal method say()
        say.say();// it internally calls saySomething() because the method reference is used as the implementation.
        //This works because Sayable is FI, and the say() method's signature matches the signature of saySomething().a

        MethodReferenceExp m1 = new MethodReferenceExp();
        Sayable ask = m1::instanceMethod;//Instance method call
        ask.say();

        Messageable msg = MethodReferenceExp::new; //You can refer a constructor by using the new keyword. Here, we are referring constructor with the help of functional interface.
        msg.getMessage("Hello user");
    }
}

@FunctionalInterface
interface Sayable {
    void say();
}

@FunctionalInterface
interface Messageable {
    MethodReferenceExp getMessage(String str);
}