package model;

import java.util.ArrayList;

@FunctionalInterface
public interface ArenaBuilder {
    Arena arenaBuilder(ArrayList<Arena> alreadyVisitedArenas);
}
