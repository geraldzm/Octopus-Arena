package views;

import Controllers.GameWindowController;
import model.ContextNode;
import model.Updatable;

import java.awt.*;

public class GameWindow extends AppWindow implements Updatable {

    public Canvas canvas;

    public GameWindow(ContextNode contextNode) {
        super(contextNode, "Game", new Dimension(1000, 1000));
    }

    @Override
    public void initComponents() {

        canvas = new Canvas();
        canvas.setBounds(0,0, getWidth(), getHeight());
        addComponent(canvas, 0);

        new GameWindowController(this);
    }

    @Override
    public Graphics getUpdatableGraphics() {
        return canvas.getGraphics();
    }

}
