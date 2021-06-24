package GA;

import GA.model.Chromosome;
import GA.model.FitnessNoRadiumNoMoney;
import GA.model.GAContext;
import GA.model.Population;
import game.Octopus;
import game.model.Action;
import game.model.ActionGenerator;
import lombok.AllArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Interface with the rest of the world
 * */
@AllArgsConstructor
public class GAAlgorithm implements ActionGenerator {

    private ArrayList<Octopus> arrayOctopi;
    private Population population;

    public GAAlgorithm(ArrayList<Octopus> arrayOctopi) {
        this.arrayOctopi = new ArrayList<>(arrayOctopi);
        this.population = new Population(20, 5, new FitnessNoRadiumNoMoney());
    }

    @Override
    public Action getAction(Octopus octopus) {
        Octopus nearestOctopus = getNearest(octopus);
        GAContext c = new GAContext();
        setContext(c, octopus, nearestOctopus);
        Chromosome mostFit = population.run(c);
        return null;
    }

    private void setContext(GAContext c, Octopus octopus, Octopus nearestOctopus){
        c.energy = octopus.getEnergy();
        c.energyNE = nearestOctopus.getEnergy();
        c.position = octopus.getPosition();
        c.positionNE = nearestOctopus.getPosition();
    }


    private Octopus getNearest(Octopus octopus) {
        Octopus shortestOctopus = arrayOctopi.get(0);
        double shortestDistance = 800;
        for (int i = 0; i < arrayOctopi.size(); i++) {
            double tmpDistance = arrayOctopi.get(i).getPosition().dist(octopus.getPosition());
            if(tmpDistance < shortestDistance && arrayOctopi.get(i) != octopus) {
                shortestOctopus = arrayOctopi.get(i);
                shortestDistance = tmpDistance;
            }
        }
        return shortestOctopus;
    }

}
