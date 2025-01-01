package com.learning.ay.basic.designpattern.observer;

public class CallingMethod {
    public static void main(String[] args) {
        //Create Subject
        MyTopic topic = new MyTopic();

        Observer obs1 = new MyTopicSubscriber("Observer 1");
        Observer obs2 = new MyTopicSubscriber("Observer 2");
        Observer obs3 = new MyTopicSubscriber("Observer 3");

        //register observers to the subject
        topic.register(obs1);
        topic.register(obs2);
        topic.register(obs3);

        //attach observer to subject
        obs1.setSubject(topic);
        obs2.setSubject(topic);
        obs3.setSubject(topic);

        obs1.update();
        topic.postMessage("Hello");
        topic.unRegister(obs2);
        topic.postMessage("Hello world");
    }
}
