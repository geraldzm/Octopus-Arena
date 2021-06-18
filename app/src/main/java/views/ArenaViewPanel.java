package views;

import Util.Utility;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ArenaViewPanel extends JPanel {

    JLabel left, right, up, down, arena;
    JButton enter;
    ArenaPreviewInformation arenaPreviewInformation;

    public ArenaViewPanel() {

        // init
        up = initArrow("/images/arrow-up.png", (800-32) / 2, 0);
        down = initArrow("/images/arrow-down.png", (800-32) / 2, 476);
        left = initArrow("/images/arrow-left.png", 0, (564-32) / 2);
        right = initArrow("/images/arrow-right.png", 734, (564-32) / 2);

        enter = new JButton("Enter");
        enter.setSize(100, 25);

        arenaPreviewInformation = new ArenaPreviewInformation();
        arenaPreviewInformation.setOpaque(true);
        arenaPreviewInformation.setBackground(new Color(0,0,0,0));
     //   arenaPreviewInformation.setBackground(Color.RED);

        arenaPreviewInformation.setBounds(250, 100, 300, 300);

        add(arenaPreviewInformation);

        arena = initArrow("/images/battlearenapulposPreview.png", 200, 50, 400, 400);

        setLayout(null);
    }

    private JLabel initArrow(String path, int x, int y, int width, int height) {

        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(path)));
        JLabel label = new JLabel(new ImageIcon(Utility.getScaledImage(imageIcon.getImage(), width, height)));

        label.setBounds(x, y, width, height);
        add(label);

        return label;
    }

    private JLabel initArrow(String path, int x, int y) {
        return initArrow(path, x, y, 32, 32);
    }

}
