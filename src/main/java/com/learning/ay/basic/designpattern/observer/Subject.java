package com.learning.ay.basic.designpattern.observer;

public interface Subject {

    void register(Observer observer);

    void unRegister(Observer observer);

    void notifyObservers();

    Object getUpdate();
}
