package model;

@FunctionalInterface
public interface Observer <T> {

    void update(T t);

}
