package Logic;

import Util.Utility;
import model.Constants;
import model.User;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class UserManager {

    private final ArrayList<User> onlineUsers;
    private final int maxUsersPerDay;
    private int currentOnlineUsers;

    private static UserManager userManager;

    private UserManager() {

        maxUsersPerDay = 1000;
        currentOnlineUsers = 0;

        onlineUsers = new ArrayList<>();
        Timer dayTimer = new Timer();

        dayTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                currentOnlineUsers = 0;
            }
        }, Constants.DAY);

    }

    public static UserManager getInstance() {

        if(userManager != null)
            return userManager;

        userManager = new UserManager();
        return userManager;
    }

    public boolean connectUser(User user) {

        if(currentOnlineUsers < maxUsersPerDay) {
            onlineUsers.add(user);
            currentOnlineUsers++;
            return true;
        }

        return false;
    }

    public void disconnectUser(User user) {
        if(onlineUsers.remove(user)) {
            currentOnlineUsers--;
        }
    }

    public ArrayList<User> get10PercentOnlineUsers(){

        ArrayList<User> tmpArray = new ArrayList<>();
        for (int i = 0; i < currentOnlineUsers; i++) {
            int rand = Utility.random(0,101);
            if(rand < 10)
                tmpArray.add(onlineUsers.get(i));
        }
        return tmpArray;
    }

}
