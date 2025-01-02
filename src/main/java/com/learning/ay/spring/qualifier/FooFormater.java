package com.learning.ay.spring.qualifier;

import org.springframework.stereotype.Component;

@Component("fooFormater")
public class FooFormater implements Formater{
    @Override
    public String format() {
        return "Foo";
    }
}
