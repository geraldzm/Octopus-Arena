package views;

import Controllers.HomeController;
import model.ContextNode;

import javax.swing.*;
import java.awt.*;

public class Home extends AppWindow {

    public JLabel name, pot, experience, time; // info
    public JLabel wins, losses, moneyWon, moneyLost; // stacks
    public JLabel tickets[]; // 6 tickets
    public JTextArea description;
    public JButton update;
    public ArenaViewPanel arenaPreviewPane;

    public Home(ContextNode contextNode) {
        super(contextNode, "Home", new Dimension(800, 750));
    }

    @Override
    public void initComponents() {
        int totalY = 0;
        JPanel stacksPane = initAndAddStacksPaneComponent(totalY);
        initAndAddInfo(stacksPane);
        initAndAddDescriptionComponent(totalY);
        initAndAddUpdateComponent(totalY);
        totalY += 80;
        initAndAddArenaPreviewComponent(totalY);
        totalY += 540;
        JPanel statisticsPane = initAndAddStatisticsPaneComponent(totalY);
        initAndAddStats(statisticsPane);
        JPanel ticketsPane = initAndAddTicketsPaneComponent(totalY);
        addTickets(ticketsPane);
        setBackgroundColor(new Color(246, 239, 211));

        new HomeController(this);

    }

    private JLabel initAndAdd(String text, JPanel panel) {
        JLabel label = new JLabel(text);
        panel.add(label);
        return label;
    }

    private void initAndAddInfo(JPanel stacksPane){
        name = initAndAdd("Nick", stacksPane);
        pot = initAndAdd("Pot", stacksPane);
        experience = initAndAdd("Experience", stacksPane);
        time = initAndAdd("Time", stacksPane);
    }

    private JPanel initAndAddStacksPaneComponent(int totalY){
        JPanel stacksPane = new JPanel();
        BoxLayout boxLayout = new BoxLayout(stacksPane, BoxLayout.PAGE_AXIS);
        stacksPane.setLayout(boxLayout);
        stacksPane.setBounds(0, totalY, 200,  80);
        addComponent(stacksPane, 1);
        return stacksPane;
    }

    private JPanel initAndAddStatisticsPaneComponent(int totalY){
        JPanel statisticsPane = new JPanel();
        BoxLayout boxLayout1 = new BoxLayout(statisticsPane, BoxLayout.PAGE_AXIS);
        statisticsPane.setLayout(boxLayout1);
        statisticsPane.setBounds(0, totalY, 200,  80);
        addComponent(statisticsPane, 1);
        return statisticsPane;
    }

    private void initAndAddDescriptionComponent(int totalY){
        description = new JTextArea();
        description.setBounds(250 , totalY, 300, 80);
        description.setLineWrap(true);
        addComponent(description, 1);
    }

    private void initAndAddUpdateComponent(int totalY){
        update = new JButton("Update");
        update.setBounds(580, totalY + 30, 100, 25);
        addComponent(update, 1);
    }

    private void initAndAddArenaPreviewComponent(int totalY){
        arenaPreviewPane = new ArenaViewPanel();
        arenaPreviewPane.setBackground(new Color(246, 239, 211));

        arenaPreviewPane.setBounds(0, totalY, getWidth(), 540);
        addComponent(arenaPreviewPane, 0);
    }
    private void initAndAddStats(JPanel statisticsPane){
        wins = initAndAdd("Wins", statisticsPane);
        moneyWon = initAndAdd("Money won", statisticsPane);
        losses = initAndAdd("Losses", statisticsPane);
        moneyLost = initAndAdd("Money lost", statisticsPane);
    }

    private JPanel initAndAddTicketsPaneComponent(int totalY){
        JPanel ticketsPane = new JPanel();
        BoxLayout boxLayout2 = new BoxLayout(ticketsPane, BoxLayout.PAGE_AXIS);
        ticketsPane.setLayout(boxLayout2);
        ticketsPane.setBounds(600, totalY, 200,  90);
        addComponent(ticketsPane, 1);
        return ticketsPane;
    }

    private void addTickets(JPanel ticketsPane){
        tickets = new JLabel[6];

        for (int i = 0; i < 6; i++) {
            wins = initAndAdd("Ticket" + i, ticketsPane);
        }
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
