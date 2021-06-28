package Logic;

import Util.Utility;
import model.*;

import java.util.ArrayList;
import java.util.Optional;

import static Util.Utility.clamp;
import static Util.Utility.randomPoissonDistribution;

/**
 * Probabilistic algorithm
 * */
public class ArenaGenerator implements ArenaBuilder {


    private static int count = 0;
    private ArenaManager arenaManager;

    public ArenaGenerator() {
        arenaManager = ArenaManager.getInstance();
    }

    @Override
    public Arena arenaBuilder(User user) {

        ArenaTableComponent atc = generateUserComponent(user);
        ArenaTableComponent selectedComponent = probabilisticNextArenaConfig(atc);

        ArrayList<Arena> arenaRow = arenaManager.getCurrentArenas().get(selectedComponent);

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
        double minimumBet =  clamp(preferredBet - 100, 0 , Double.MAX_VALUE);
        double maximumBet = preferredBet + 100;
        double experienceArena = randomPoissonDistribution(selectedComponent.getExperience());
        int timeZoneArena = (int) clamp(TimeZones.values().length * randomPoissonDistribution(selectedComponent.getArenas()), 0, TimeZones.values().length-1);

        double fee = Utility.random(1,16);
        fee = fee/100;

        amountOctopi = Utility.clamp(amountOctopi, 2, 18);
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

        int index = 0;
        for (Double d: distribution) {

            rand -= d;
            if(rand <= 0)
                return arenaManager.getArenaTable(userComponent).getRows().get(index);

            index++;
        }

        return null;
    }

    private double generateDistribution(ArenaTableComponent userComponent, ArrayList<Double> distribution) {
        double total = 0;

        ClusterPoint userPoint = new ClusterPoint(userComponent.getValues());

        for (ArenaTableComponent a: arenaManager.getArenaTable(userComponent).getRows()) {

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
