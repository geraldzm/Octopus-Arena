package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Observable <T> {

    public final List<T> observers;
    public final List<T> observersToRemove;

    public Observable() {
        observers = new ArrayList<>(5);
        observersToRemove = new ArrayList<>(5);
    }

    public void register(T observable) {
        observers.add(observable);
    }

    public void unRegister(T observable) {

        observersToRemove.add(observable);

    }

    public void notifyAll(Consumer<T> consumer) {

        observers.stream()
                .parallel()
                .forEach(consumer);

        observers.removeAll(observersToRemove);
    }

}
