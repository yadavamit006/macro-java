package com.learning.ay.designpatern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyTopic implements Subject {

    String message = null;
    List<Observer> observers;
    final Object MUTEX = new Object();
    boolean changed;

    public MyTopic() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        Objects.requireNonNull(observer, "Observer can not be null");
        synchronized (MUTEX) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        }
    }

    @Override
    public void unRegister(Observer observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal;
        synchronized (MUTEX) {
            if (!changed) {
                return;
            }
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }
        for (Observer observer : observersLocal) {
            observer.update();
        }
    }

    @Override
    public Object getUpdate() {
        return this.message;
    }

    public void postMessage(String msg) {
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}
