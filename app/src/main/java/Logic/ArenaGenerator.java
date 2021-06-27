package Logic;

import Util.Utility;
import model.*;

import java.util.ArrayList;

/**
 * Probabilistic algorithm
 * */
public class ArenaGenerator implements ArenaBuilder {


    public static int count = 0;

    @Override
    public Arena arenaBuilder(User user) {

        ArenaTableComponent atc = generateUserComponent(user);
        ArenaTableComponent selectedComponent = probabilisticNextArenaConfig(atc);

        /*
        randoms con tendencia a los valores del componente
         */

//
////        Arena arena = new Arena(count++);
////        arena.setFee(0.1);
////        arena.setOctopusAmount(10);
////        alreadyVisitedArenas.add(arena);
//        System.out.println("New arena");
//        return arena;
        return null;
    }

        /*
        crear componentes e insert al table (10% y agrupamiento)


        get arenaTableComponent
        crear arena con

     */

    private ArenaTableComponent generateUserComponent(User user){
        return new ArenaTableComponent(user.getMinimumBet(), user.getMaximumBet(), user.getAmountOctopi(), user.getExperience(), user.getTimeZone());
    }

    private ArenaTableComponent probabilisticNextArenaConfig(ArenaTableComponent userComponent){
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
        for (int i = 0; i < ArenaTable.getInstance().getTableComponents().size() ; i++) {
            double cosineVal = calculateCosineSimilarity(userComponent, ArenaTable.getInstance().getTableComponents().get(i));
            total += cosineVal;
            distribution.add(cosineVal);
        }
        return total;
    }

    private double calculateCosineSimilarity(ArenaTableComponent userComponent, ArenaTableComponent tableComponent){
        double quotient = userComponent.calculateQuotient(tableComponent);
        double rs = quotient / (userComponent.getNorm() * tableComponent.getNorm());
        return Math.cos(rs);
    }

}
