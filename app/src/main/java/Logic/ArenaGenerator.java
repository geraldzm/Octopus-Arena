package Logic;

import model.Arena;
import model.ArenaBuilder;

import java.util.ArrayList;

/**
 * Probabilistic algorithm
 * */
public class ArenaGenerator implements ArenaBuilder {


    public static int count = 0;

    @Override
    public Arena arenaBuilder(ArrayList<Arena> alreadyVisitedArenas) {

        // Toma el 10% de la población
        // si el 10% es 0 entonces se valida que haya almenos un usuario en la lista de online users
        // y se crea la vara con los gustos de ese mae

        Arena arena = new Arena(count++);
        arena.setFee(0.1);
        arena.setOctopusAmount(10);
        alreadyVisitedArenas.add(arena);

        System.out.println("New arena");
        return arena;
    }


}
