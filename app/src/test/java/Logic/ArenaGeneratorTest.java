package Logic;

import model.Arena;
import model.ArenaBuilder;
import model.TimeZones;
import model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ArenaGeneratorTest {


    @Test
    void initialUser() {

        ArenaBuilder builder = new ArenaGenerator();

        User user = new User("Gerald", 3, 1000.0, 100.0, 10, TimeZones.EST, "des", new ArrayList<>());

        Arena arena = builder.arenaBuilder(user);


    }


}