package Controllers;

import lombok.NonNull;
import model.*;
import views.ArenaViewPanel;
import views.Home;
import views.WindowBuilder;
import views.WindowID;

import java.awt.event.ActionEvent;
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

        ArenaViewPanel arenaPreviewPane = home.arenaPreviewPane;

        arenaPreviewPane.left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickedLeftButton(e);
            }
        });

        arenaPreviewPane.right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickedRightButton(e);
            }
        });

        arenaPreviewPane.enter.addActionListener(this::onEnterAction);

        arenaPreviewPane.left.setVisible(false);

        ContextNode context = home.getContextNode();

        arenaBuilder = context.arenaBuilder;
        user = context.user;
        arenaInformationObserver = arenaPreviewPane.arenaPreviewInformation;
        arenaInformationConsume = this::buttonUpdate;

        if(user.getArenas().size() > 0) {
            setCurrentArena(user.getArenas().get(0));
            arenaIndex = context.arenaIndex;
        }else {
            arenaIndex = 0;
            setCurrentArena(arenaBuilder.arenaBuilder(user.getArenas()));
        }

    }

    public void setCurrentArena(@NonNull Arena arena) {

        if(currentArena != null)
            unRegisterAll();

        currentArena = arena;

        currentArena.register(arenaInformationObserver);
        registerButton(currentArena);
    }

    private void unRegisterAll() {
        currentArena.unRegister(arenaInformationObserver);
        currentArena.unRegister(arenaInformationConsume);
    }

    private void buttonUpdate(ArenaInformation arenaInformation) {
        home.arenaPreviewPane.enter.setEnabled(!arenaInformation.getIsStarted());
    }

    private void registerButton(Arena arena) {

        home.arenaPreviewPane.enter.setEnabled(!arena.isStarted());

        if(!arena.isStarted())
            currentArena.register(arenaInformationConsume);

    }

    public void onEnterAction(ActionEvent event) {

        if(currentArena != null && !currentArena.isStarted()) {

            ContextNode contextNode = new ContextNode();
            contextNode.arena = currentArena;
            contextNode.arenaBuilder = arenaBuilder;
            contextNode.user = user;
            contextNode.arenaIndex = arenaIndex;

            closeWindows();

            WindowBuilder.buildWindowAndShow(contextNode, WindowID.CHECK_IN);

        }

    }

    private void closeWindows() {
        unRegisterAll();
        arenaInformationObserver = null;
        arenaInformationConsume = null;
        home.dispose();
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

}
