package com.learning.ay.basic.designpattern.observer;

import java.util.Objects;

public class MyTopicSubscriber implements Observer {


    private final String subscriberName;
    private Subject subject;

    public MyTopicSubscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void update() {
        String msg = (String) subject.getUpdate();
        if (Objects.isNull(msg)) {
            System.out.println("No new message");
        } else {
            System.out.println(subscriberName + " is consuming message " + msg);
        }
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
