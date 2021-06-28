package Logic;

import lombok.Getter;
import model.*;

import java.util.*;
import java.util.stream.Collectors;


@Getter
public class ArenaManager {

    private static ArenaManager arenaManager;

    private final HashMap<ArenaTableComponent, ArrayList<Arena>> currentArenas;
    private ArenaTable arenaTable;

    private ArenaManager() {
        currentArenas = new HashMap<>();
        arenaTable = new ArenaTable();

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                createDistribution();
            }
        }, Constants.DAY, Constants.DAY);

    }

    public static ArenaManager getInstance() {
        if(arenaManager != null)
            return arenaManager;

        arenaManager = new ArenaManager();
        return arenaManager;
    }

    //per day
    public void createDistribution() {

        arenaTable = new ArenaTable();

       ArrayList<User> sample = UserManager.getInstance().get10PercentOnlineUsers();

       List<ClusterPoint> points = sample.stream()
               .map(s -> new ClusterPoint(new double[]{s.getAmountOctopi(), s.getPreferredBetAmount(), s.getExperience(), s.getTimeZone().getTimezoneNumber()}))
               .collect(Collectors.toList());

       ClusterBuilder builder = new ClusterBuilder();
       ArrayList<Cluster> clusters = builder.makeClusters(new ArrayList<>(points));
       clusters.stream()
               .map(c -> {

                    ArenaTableComponent a = new ArenaTableComponent();
                    a.setValues(a.getValues(), c.getPoints().size());
                    return a;
               }).forEach(t -> currentArenas.put(t, new ArrayList<>()));

    }

    public void insertNewArena(ArenaTableComponent row, Arena arena) {

        ArrayList<Arena> arenas = currentArenas.get(row);

        if(arenas != null) arenas.add(arena);

    }

    public ArenaTable getArenaTable(ArenaTableComponent user) {
//
//        if(arenaTable.getRows().isEmpty()) {
//            ArenaTableComponent component = new ArenaTableComponent();
//            component.setValues(user.getValues());
//            component.setArenas(1);
//
//            arenaTable.getRows().add(component);
//            currentArenas.put(component, new ArrayList<>());
//        }

        return arenaTable;
    }

}