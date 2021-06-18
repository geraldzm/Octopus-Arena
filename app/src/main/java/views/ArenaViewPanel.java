package views;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ArenaViewPanel extends JPanel {

    JLabel left, right, up, down;
    JButton enter;
    ArenaPreviewInformation arenaPreviewInformation;

    public ArenaViewPanel() {
        initAllArrows();
        initArenaPreview();
        initEnter();
        right = initArrow("/images/battlearenapulpos.png", 0, 0, 800, 540);
        setLayout(null);
    }

    private JLabel initArrow(String path, int x, int y, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(x, y, width, height);
        add(label);
        return label;
    }

    private JLabel initArrow(String path, int x, int y) {
        return initArrow(path, x, y, 64, 64);
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
        arenaPreviewInformation.setBackground(Color.RED);
        arenaPreviewInformation.setBounds(250, 100, 300, 250);
        add(arenaPreviewInformation);
    }
}
