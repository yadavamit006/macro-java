package com.learning.ay.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {

    String value();
    String type() default "amazon";
    int priority() default 1;

}
/*
@Interface : It can include elements, which are essentially methods with optional default values.

@Retention : determines at what point annotation information is discarded.
There are three retention policies:
    SOURCE: Annotations are retained only in the source code and discarded during compilation.
    CLASS: Annotations are recorded in the class file but discarded by the JVM during runtime.
    RUNTIME: Annotations are retained at runtime, allowing them to be accessed through reflection.

@Target defines the kinds of program elements to which an annotation can be applied.
Possible values include:
    TYPE: Class, interface, or enum declaration
    FIELD: Field (including enum constants).
    METHOD: Method declaration.
    PARAMETER: Parameter of a method or constructor.
    CONSTRUCTOR: Constructor declaration.
    LOCAL_VARIABLE: Local variable declaration.
    ANNOTATION_TYPE: Another annotation.

 */
