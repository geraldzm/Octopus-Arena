package views;

import Controllers.GameWindowController;
import lombok.Getter;
import model.ContextNode;

import java.awt.*;

@Getter
public class GameWindow extends AppWindow {

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


}
