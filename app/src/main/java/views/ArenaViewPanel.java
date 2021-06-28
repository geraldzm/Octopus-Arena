package views;

import Util.Utility;

import javax.swing.*;
import java.awt.*;

public class ArenaViewPanel extends JPanel {

    public JLabel left, right, arena;
    public JButton enter;
    public ArenaPreviewInformation arenaPreviewInformation;

    public ArenaViewPanel() {
        setLayout(null);

        initAllArrows();
        initArenaPreview();
        initEnter();
        arena = initLabelImage("/images/battlearenapulposPreview.png", 200, 50, 400, 400);

    }

    private JLabel initLabelImage(String path, int x, int y, int width, int height) {

        JLabel label = new JLabel(Utility.getScaledImage(path, width, height));

        label.setBounds(x, y, width, height);
        add(label);
        return label;
    }

    private JLabel initLabelImage(String path, int x) {
        return initLabelImage(path, x, 250, 32, 32);
    }

    private void initAllArrows() {
        left = initLabelImage("/images/arrow-left.png", 0);
        right = initLabelImage("/images/arrow-right.png", 734);
    }

    private void initEnter() {
        enter = new JButton("Enter");
        enter.setBounds(350, 500, 100, 25);
        add(enter);
    }

    private void initArenaPreview() {
        arenaPreviewInformation = new ArenaPreviewInformation();
       // arenaPreviewInformation.setOpaque(true);
       // arenaPreviewInformation.setBackground(new Color(0,0,0,0));
        arenaPreviewInformation.setBackground(new Color(255, 225, 148,200));
        arenaPreviewInformation.setBounds(280, 100, 270, 250);
        add(arenaPreviewInformation);
    }

}
