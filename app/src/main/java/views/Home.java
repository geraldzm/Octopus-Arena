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
        JPanel stacksPane = new JPanel();
        BoxLayout boxLayout = new BoxLayout(stacksPane, BoxLayout.PAGE_AXIS);
        stacksPane.setLayout(boxLayout);
        stacksPane.setBounds(0, totalY, 200,  80);

        addComponent(stacksPane, 1);

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
        arenaPreviewPane.setBounds(0, totalY, getWidth(), 540);
        addComponent(arenaPreviewPane, 0);
        totalY += 540;

        // Statistics
        JPanel statisticsPane = new JPanel();
        BoxLayout boxLayout1 = new BoxLayout(statisticsPane, BoxLayout.PAGE_AXIS);
        statisticsPane.setLayout(boxLayout1);

        statisticsPane.setBounds(0, totalY, 200,  80);

        addComponent(statisticsPane, 1);

        wines = initAndAdd("Wines", statisticsPane);
        moneyWon = initAndAdd("Money won", statisticsPane);
        loses = initAndAdd("Loses", statisticsPane);
        moneyLost = initAndAdd("Money lost", statisticsPane);

        // Tickets
        JPanel ticketsPane = new JPanel();
        BoxLayout boxLayout2 = new BoxLayout(ticketsPane, BoxLayout.PAGE_AXIS);
        ticketsPane.setLayout(boxLayout2);

        ticketsPane.setBounds(600, totalY, 200,  90);

        addComponent(ticketsPane, 1);

        tickets = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            wines = initAndAdd("Ticket" + i, ticketsPane);
        }

        setBackgroundColor(new Color(246, 239, 211));
    }

}
