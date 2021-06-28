package model;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ArenaTable {

    private static ArenaTable arenaTable;
    private ArrayList<ArenaTableComponent> tableComponents;


    private ArenaTable(){
        tableComponents = new ArrayList<>();
    }

    public static ArenaTable getInstance(){
        if(arenaTable != null)
            return arenaTable;

        arenaTable = new ArenaTable();
        return arenaTable;
    }

    public void insertComponent(ArenaTableComponent component){
        tableComponents.add(component);
    }

    public void cleanTable() {
        tableComponents.clear();
    }


}
