package com.learning.ay.spring.qualifier;

import org.springframework.stereotype.Component;

@Component("barFormater")
public class BarFormater implements Formater{
    @Override
    public String format() {
        return "Bar";
    }
}
