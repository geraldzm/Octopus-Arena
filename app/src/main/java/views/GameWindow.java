package views;

import Util.Utility;
import model.ContextNode;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GameWindow extends AppWindow {

    public GameWindow(ContextNode contextNode) {
        super(contextNode, "Game", new Dimension(1000, 1000));
    }

    @Override
    public void initComponents() {

        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/Arena_Mat.jpg")));
        JLabel label = new JLabel(new ImageIcon(Utility.getScaledImage(imageIcon.getImage(), getWidth(), getHeight())));

        label.setBounds(0, 0, getWidth(), getHeight());

        add(label);

    }

}
