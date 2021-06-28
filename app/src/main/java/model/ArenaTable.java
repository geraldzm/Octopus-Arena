package model;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ArenaTable {

    private ArrayList<ArenaTableComponent> rows;

    public ArenaTable(){
        rows = new ArrayList<>();
    }

    public void insertComponent(ArenaTableComponent component){
        rows.add(component);
    }

}
