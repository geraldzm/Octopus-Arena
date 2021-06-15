package views;

import javax.swing.*;
import java.net.URL;

public class ArenaViewPanel extends JPanel {

    JLabel left, right, up, down;
    JButton enter;

    public ArenaViewPanel() {

        // init
        up = initArrow("/images/arrow-up.png", (800-64) / 2, 0);
        down = initArrow("/images/arrow-down.png", (800-64) / 2, 476);
        left = initArrow("/images/arrow-left.png", 0, (564-64) / 2);
        right = initArrow("/images/arrow-right.png", 734, (564-64) / 2);

        enter = new JButton("Enter");
        enter.setSize(100, 25);

        setLayout(null);
    }

    private JLabel initArrow(String path, int x, int y) {
        URL resource = ArenaViewPanel.class.getResource(path);
        assert resource != null;

        JLabel label = new JLabel(new ImageIcon(resource.getPath()));
        label.setBounds(x, y, 64, 64);
        add(label);

        return label;
    }

}
