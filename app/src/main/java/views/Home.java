package views;

import model.ContextNode;

import javax.swing.*;
import java.awt.*;

public class Home extends AppWindow {

    JLabel name, pot, experience, time; // info
    JLabel wines, loses, moneyWon, moneyLost; // stacks
    JLabel tickets[]; // 6 tickets
    JTextArea description;
    JButton update, enter;
    ArenaViewPanel arenaPreviewPane;

    public Home(ContextNode contextNode) {
        super(contextNode, "Home", new Dimension(800, 750));
    }

    private JLabel initAndAdd(String text, JPanel panel) {

        JLabel label = new JLabel(text);
        panel.add(label);

        return label;
    }

    @Override
    public void initComponents() {

        int totalY = 0;

        // Stacks
        JPanel stacksPane = createPanelStack(0, totalY, 200, 80);

        name = initAndAdd("Nick", stacksPane);
        pot = initAndAdd("Pot", stacksPane);
        experience = initAndAdd("Experience", stacksPane);
        time = initAndAdd("Time", stacksPane);

        // Description
        description = new JTextArea();
        description.setBounds(250 , totalY, 300, 80);
        description.setLineWrap(true);
        addComponent(description, 1);

        update = new JButton("Update");
        update.setBounds(580, totalY + 30, 100, 25);
        addComponent(update, 1);
        totalY += 80;

        //
        arenaPreviewPane = new ArenaViewPanel();
        arenaPreviewPane.setBackground(new Color(246, 239, 211));

        arenaPreviewPane.setBounds(0, totalY, getWidth(), 540);
        addComponent(arenaPreviewPane, 0);
        totalY += 540;

        // Statistics
        JPanel statisticsPane = createPanelStack(0, totalY, 200, 80);

        wines = initAndAdd("Wines", statisticsPane);
        moneyWon = initAndAdd("Money won", statisticsPane);
        loses = initAndAdd("Loses", statisticsPane);
        moneyLost = initAndAdd("Money lost", statisticsPane);

        // Tickets
        JPanel ticketsPane = createPanelStack(600, totalY, 200, 90);

        tickets = new JLabel[6];

        for (int i = 0; i < 6; i++) {
            wines = initAndAdd("Ticket" + i, ticketsPane);
        }

        setBackgroundColor(new Color(246, 239, 211));
    }

    private JPanel createPanelStack(int x, int totalY, int width, int height) {
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(new Color(0,0,0,0));
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(boxLayout);

        panel.setBounds(x, totalY, width ,  height);

        addComponent(panel, 1);

        return panel;
    }

}
