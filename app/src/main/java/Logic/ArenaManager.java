package Logic;

import model.Arena;
import model.ArenaTableComponent;
import model.Constants;

import java.util.ArrayList;
import java.util.HashMap;

public class ArenaManager {

    private final HashMap<ArenaTableComponent,ArrayList<Arena>> currentArenas;
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


    /*

    actualizar por dia el table (limpiar completamente)

    10%
    crea clusters
    mete componentes a arenatable  ... insertcomponents



        // Toma el 10% de la población
        // si el 10% es 0 entonces se valida que haya almenos un usuario en la lista de online users
        // y se crea la vara con los gustos de ese mae

     */



}
