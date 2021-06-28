package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Observable <T> {

    public final List<T> observers;

    public Observable() {
        observers = new ArrayList<>(5);
    }

    public void register(T observable) {
        observers.add(observable);
    }

    public synchronized void unRegister(T observable) {
        observers.remove(observable);
    }

    public synchronized void notifyAll(Consumer<T> consumer) {
        observers.stream()
               // .parallel()
                .forEach(consumer);
    }

    public void cleanObservers() {
        observers.clear();
    }

}
