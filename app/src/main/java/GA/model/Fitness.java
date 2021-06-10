package GA.model;

@FunctionalInterface
public interface Fitness {
    double fitOf(double energy, double energyNE, double distanceNE);
}
