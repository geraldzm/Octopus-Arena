package Logic;

import Util.Utility;
import jdk.jshell.execution.Util;
import model.TimeZones;
import model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArenaManagerTest {

    @Test
    void run() {

        ArrayList<User> tmpArray = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            User user = new User();
            user.setAmountOctopi(Utility.random(0,19));
            user.setPreferredBetAmount(Utility.random(10.0,1000.0));
            user.setExperience(Utility.random(0, 51));
            user.setTimeZone(TimeZones.values()[Utility.random(0,4)]);
            tmpArray.add(user);
        }

        ArenaManager.getInstance().createDistribution(tmpArray);

    }
}