package GA;

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
import static Util.Utility.random;

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

  /*      Octopus nearestOctopus = getNearest(octopus);
        GAContext c = new GAContext();
        setContext(c, octopus, nearestOctopus);
        Chromosome mostFit = population.run(c);
*/

        int random = random(0, 300);
        Octopus nearestEnemy = getNearest(octopus);

        if (random < 10) {
            return new AttackAction(octopusEnemies);
        } else if (random < 20) {
            return new GuardAction(helmet);
        }

        return new ChaseAction(nearestEnemy);
      //  return new EscapeAction(nearestEnemy);

    }

    private void setContext(GAContext c, Octopus octopus, Octopus nearestOctopus) {
        c.energy = octopus.getEnergy();
        c.energyNE = nearestOctopus.getEnergy();
        c.position = octopus.getPosition();
        c.positionNE = nearestOctopus.getPosition();
    }


    /**
     * @return null if there is no enemies
     * */
    private Octopus getNearest(Octopus octopus) {

        return octopusEnemies.stream()
                .min(Comparator.comparingDouble(o0 -> o0.getPosition().dist(octopus.getPosition())))
                .orElse(null);

    }

}
