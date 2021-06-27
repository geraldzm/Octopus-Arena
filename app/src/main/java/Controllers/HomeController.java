package Controllers;

import lombok.NonNull;
import model.*;
import views.Home;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeController {

    Home home;
    int arenaIndex;
    ArenaBuilder arenaBuilder;
    Arena currentArena;
    User user;
    Observer<ArenaInformation> arenaInformationObserver;
    Observer<ArenaInformation> arenaInformationConsume;


    public HomeController(Home home) {
        this.home = home;

        home.arenaPreviewPane.left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickedLeftButton(e);
            }
        });

        home.arenaPreviewPane.right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickedRightButton(e);
            }
        });

        arenaIndex = 0;
        home.arenaPreviewPane.left.setVisible(false);

        arenaBuilder = home.getContextNode().arenaBuilder;
        user = home.getContextNode().user;
        arenaInformationObserver = home.arenaPreviewPane.arenaPreviewInformation;
        arenaInformationConsume = this::buttonUpdate;

        setCurrentArena(arenaBuilder.arenaBuilder(user.getArenas()));
    }

    public synchronized void mouseClickedLeftButton(MouseEvent e) {

        int i = user.getArenas().indexOf(currentArena);
        if(i == 1)
            home.arenaPreviewPane.left.setVisible(false);

        setCurrentArena(user.getArenas().get(i-1));
    }

    public synchronized void mouseClickedRightButton(MouseEvent e) {
        home.arenaPreviewPane.left.setVisible(true);

        int i = user.getArenas().indexOf(currentArena);

        if(i != -1 && 1+i != user.getArenas().size() && currentArena != null)
            setCurrentArena(user.getArenas().get(i+1));
        else
            setCurrentArena(arenaBuilder.arenaBuilder(user.getArenas()));
    }

    public void setCurrentArena(@NonNull Arena arena) {

        if(currentArena != null) {
            currentArena.unRegister(arenaInformationObserver);
            currentArena.unRegister(arenaInformationConsume);
        }

        currentArena = arena;

        currentArena.register(arenaInformationObserver);
        registerButton(currentArena);
    }

    private void buttonUpdate(ArenaInformation arenaInformation) {
        home.arenaPreviewPane.enter.setEnabled(!arenaInformation.getIsStarted());
    }

    private void registerButton(Arena arena) {

        home.arenaPreviewPane.enter.setEnabled(!arena.isStarted());

        if(!arena.isStarted())
            currentArena.register(arenaInformationConsume);

    }

}
