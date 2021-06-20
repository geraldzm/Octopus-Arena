package model;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Observable <T> {

    public final ArrayList<T> observers;

    public Observable() {
        observers = new ArrayList<>(5);
    }

    public void register(T observable) {
        observers.add(observable);
    }

    public void unRegister(T observable) {

        observers.remove(observable);

    }

    public void notifyAll(Consumer<T> consumer) {

        for (int i = 0; i < observers.size(); i++) {
            consumer.accept(observers.get(i));
        }

    }

}
