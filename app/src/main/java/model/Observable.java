package model;

import java.util.ArrayList;

public class Observable <T> {

    private ArrayList<Observer<T>> observers;

    public Observable() {
        observers = new ArrayList<>(5);
    }

    public void register(Observer<T> observable) {
        observers.add(observable);
    }

    public void unRegister(Observer<T> observable) {
        observers.remove(observable);
    }

    public void notifyAll(T t) {
        observers.forEach(observer -> observer.update(t));
    }

}
