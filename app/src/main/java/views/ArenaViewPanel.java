package views;

import Util.Utility;

import javax.swing.*;
import java.awt.*;

public class ArenaViewPanel extends JPanel {

    JLabel left, right, up, down, arena;
    JButton enter;
    ArenaPreviewInformation arenaPreviewInformation;

    public ArenaViewPanel() {
        initAllArrows();
        initArenaPreview();
        initEnter();
        arena = initArrow("/images/battlearenapulposPreview.png", 200, 50, 400, 400);
        setLayout(null);
    }

    private JLabel initArrow(String path, int x, int y, int width, int height) {

        JLabel label = new JLabel(Utility.getScaledImage(path, width, height));

        label.setBounds(x, y, width, height);
        add(label);
        return label;
    }

    private JLabel initArrow(String path, int x, int y) {
        return initArrow(path, x, y, 32, 32);
    }

    private void initAllArrows(){
        up = initArrow("/images/arrow-up.png", (800-64) / 2, 0);
        down = initArrow("/images/arrow-down.png", (800-64) / 2, 476);
        left = initArrow("/images/arrow-left.png", 0, (564-64) / 2);
        right = initArrow("/images/arrow-right.png", 734, (564-64) / 2);
    }

    private void initEnter(){
        enter = new JButton("Enter");
        enter.setSize(100, 25);
    }

    private void initArenaPreview(){
        arenaPreviewInformation = new ArenaPreviewInformation();
        arenaPreviewInformation.setOpaque(true);
        arenaPreviewInformation.setBackground(new Color(0,0,0,0));
        arenaPreviewInformation.setBounds(250, 100, 300, 250);
        add(arenaPreviewInformation);
    }
}
