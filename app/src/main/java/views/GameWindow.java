package views;

import game.Game;
import model.ContextNode;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends AppWindow {

    public Game game;

    public GameWindow(ContextNode contextNode) {
        super(contextNode, "Game", new Dimension(1000, 1000));
    }

    @Override
    public void initComponents() {

        game = new Game();
        game.setBounds(0,0,getWidth(), getHeight());

        addComponent(game, 0);


        //  SDFGSDFGSDFGSDFGSDFGSDF
        game.start();

        addWindowListener(new WindowAdapter() { // THIS MUST BE MOVED TO A CONTROLLER
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("closed");
                game.stop();
            }
        });
        //  SDFGSDFGSDFGSDFGSDFGSDF

    }

}
