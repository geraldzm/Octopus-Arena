package Logic;

import lombok.Getter;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public class ArenaManager {

    private final HashMap<ArenaTableComponent, ArrayList<Arena>> currentArenas;
    private static ArenaManager arenaManager;

    private ArenaManager() {
        currentArenas = new HashMap<>();
    }

    public static ArenaManager getInstance() {
        if(arenaManager != null)
            return arenaManager;

        arenaManager = new ArenaManager();
        return arenaManager;
    }

    //per day
    public void createDistribution(ArrayList<User> arrayUsers) {

       ArenaTable table = ArenaTable.getInstance();
       table.cleanTable();
       currentArenas.clear();

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



}