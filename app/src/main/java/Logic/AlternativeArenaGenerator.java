package Logic;

import model.Arena;
import model.ArenaBuilder;
import model.TimeZones;
import model.User;

import java.util.ArrayList;
import java.util.Optional;

import static Util.Utility.choiceRandom;
import static Util.Utility.random;

public class AlternativeArenaGenerator implements ArenaBuilder {

    private static int arenaNumber = 0;
    private static final ArrayList<Arena> allArenas = new ArrayList<>();

    @Override
    public Arena arenaBuilder(User user) {

        Optional<Arena> any = allArenas.stream()
                .filter(a -> !a.isStarted() && !user.getArenas().contains(a))
                .findFirst();

        if(any.isPresent()) {
            user.getArenas().add(any.get());
            return any.get();
        }

        Arena arena = new Arena(arenaNumber++, random(2, 16));
        arena.setFee(0.1);
        arena.setMinimumBet(random(20.0, 100.0));
        arena.setMaximumBet(random(150, 300.0));
        arena.setTimeZone(choiceRandom(TimeZones.values()));
        user.getArenas().add(arena);

        System.out.println("New arena");

        allArenas.add(arena);
        return arena;
    }

}
