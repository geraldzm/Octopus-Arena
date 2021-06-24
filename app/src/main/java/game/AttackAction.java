package game;

import game.model.Action;

import java.util.ArrayList;

public class AttackAction extends Action {
    
    private final ArrayList<Octopus> octopusArrayList;

    public AttackAction(ArrayList<Octopus> octopusArrayList) {
        this.octopusArrayList = octopusArrayList;
    }

    @Override
    public void execute(Octopus octopus) {
        octopus.setOctopusAction(new OctopusAttack(octopus, octopusArrayList));
    }
}
