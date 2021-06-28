package Logic;

import Util.Utility;
import model.*;
import java.util.ArrayList;
import java.util.Optional;

import static Util.Utility.*;

/**
 * Probabilistic algorithm
 * */
public class ArenaGenerator implements ArenaBuilder {


    public static int count = 0;

    @Override
    public Arena arenaBuilder(User user) {

        ArenaTableComponent atc = generateUserComponent(user);
        ArenaTableComponent selectedComponent = probabilisticNextArenaConfig(atc);

        ArrayList<Arena> arenaRow = ArenaManager.getInstance().getCurrentArenas().get(selectedComponent);
        Optional<Arena> foundArena = user.getArenas()
                .stream()
                .filter(a -> !arenaRow.contains(a))
                .findAny();

        if(foundArena.isPresent())
            return foundArena.get();

        if(selectedComponent.getArenas() == 0)
            return arenaRow.get(0);

        Arena arena = generateNewArena(selectedComponent);

        return arena;
    }

    private Arena generateNewArena(ArenaTableComponent selectedComponent) {
        double amountOctopi = randomPoissonDistribution(selectedComponent.getAmountOctopi());
        double preferredBet = randomPoissonDistribution(selectedComponent.getPreferredBetAmount());
        double minimumBet = preferredBet - 100;
        double maximumBet = preferredBet + 100;
        double experienceArena = randomPoissonDistribution(selectedComponent.getExperience());
        Integer timeZoneArena = (int)(TimeZones.values().length * randomPoissonDistribution(selectedComponent.getArenas()));
        double fee = Utility.random(1,16);
        fee = fee/100;

        Arena arena = new Arena(count++, (int)amountOctopi);
        arena.setFee(fee);
        arena.setMinimumBet(minimumBet);
        arena.setMaximumBet(maximumBet);
        arena.setExperience((int)experienceArena);
        arena.setTimeZone(TimeZones.values()[timeZoneArena]);
        ArenaManager.getInstance().insertNewArena(selectedComponent, arena);
        System.out.println("New arena!");
        return arena;
    }

    private ArenaTableComponent probabilisticNextArenaConfig(ArenaTableComponent userComponent) {
        ArrayList<Double> distribution = new ArrayList<>();
        double total = generateDistribution(userComponent, distribution);

        double rand = Utility.random(0, total);

        for (int i = 0; i < ArenaTable.getInstance().getTableComponents().size(); i++) {
            rand -= distribution.get(i);
            if(rand <= 0)
                return ArenaTable.getInstance().getTableComponents().get(i);
        }
        return null;
    }

    private double generateDistribution(ArenaTableComponent userComponent, ArrayList<Double> distribution) {
        double total = 0;

        userComponent.getValues();

        ClusterPoint userPoint = new ClusterPoint(userComponent.getValues());

        for (ArenaTableComponent a: ArenaTable.getInstance().getTableComponents()) {

            double cosineVal = userPoint.calculateSimilarity(new ClusterPoint(a.getValues()));
            distribution.add(cosineVal);
            total += cosineVal;
        }
        return total;
    }

    private ArenaTableComponent generateUserComponent(User user) {
        return new ArenaTableComponent(user.getAmountOctopi(), user.getPreferredBetAmount(), user.getExperience(), user.getTimeZone());
    }

}
