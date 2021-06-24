package GA.model;


@FunctionalInterface
public interface Fitness {

    double fitOf(GAContext c);

}
