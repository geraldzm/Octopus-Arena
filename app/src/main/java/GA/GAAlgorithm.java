package GA;

import GA.model.Chromosome;
import GA.model.FitnessWithVectors;
import GA.model.GAContext;
import GA.model.Population;
import game.*;
import game.model.Action;
import game.model.ActionGenerator;
import game.model.Helmet;
import game.model.HelmetEnum;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;

import static Util.Utility.choiceRandom;

/**
 * Interface with the rest of the world
 * */
@AllArgsConstructor
public class GAAlgorithm implements ActionGenerator {

    private final ArrayList<Octopus> octopusEnemies;
    private final Population population;
    private final Helmet helmet;


    public GAAlgorithm(ArrayList<Octopus> octopusEnemies) {

        this.octopusEnemies = octopusEnemies;
        this.population = new Population(20, 5, new FitnessWithVectors());
        helmet = new Helmet(choiceRandom(HelmetEnum.values()));

    }

    @Override
    public Action getAction(Octopus octopus) {

        Octopus nearestEnemy = getNearest(octopus);
        if(nearestEnemy != null) {
            GAContext c = new GAContext();

            c.energy = octopus.getEnergy();
            c.energyNE = nearestEnemy.getEnergy();
            c.position = octopus.getPosition();
            c.positionNE = nearestEnemy.getPosition();

            Chromosome mostFit = population.run(c);

            return chromosomeToAction(mostFit, nearestEnemy);
        }

        return new NoAction(); // Everyone is dead
    }

    private Action chromosomeToAction(Chromosome mostFit, Octopus nearestEnemy) {

        switch (mostFit.getType()) {
            case ATTACK: return new AttackAction(octopusEnemies);
            case CHASE: return new ChaseAction(nearestEnemy);
            case EVADE: return new EscapeAction(nearestEnemy);
            case GUARD: return new GuardAction(helmet);
        }

        return null;
    }


    /**
     * @return null if there is no enemies
     * */
    private Octopus getNearest(Octopus octopus) {

        return octopusEnemies.stream()
                .filter(c -> !c.isDead())
                .min(Comparator.comparingDouble(o0 -> o0.getPosition().dist(octopus.getPosition())))
                .orElse(null);

    }

}
