package views;

import model.ArenaInformation;
import model.Observer;

import javax.swing.*;
import java.awt.*;

public class ArenaPreviewInformation extends JPanel implements Observer<ArenaInformation> {

    JLabel arenaNumber;
    JLabel fee;
    JLabel octopus;
    JLabel timer;
    JLabel minBet;
    JLabel maxBet;

    public ArenaPreviewInformation() {
        fee = new JLabel();
        octopus = new JLabel();
        timer = new JLabel();
        minBet = new JLabel();
        maxBet = new JLabel();

        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(boxLayout);

        init();
    }

    private void init() {
        Font font = new Font("Arial", Font.BOLD, 30);

        fee = createJLabel(font);
        octopus = createJLabel(font);
        minBet = createJLabel(font);
        maxBet = createJLabel(font);

        timer = createJLabel(font);
        timer.setOpaque(true);
        timer.setBackground(Color.GREEN);

        arenaNumber = createJLabel(font);
        arenaNumber.setOpaque(true);
        arenaNumber.setBackground(Color.LIGHT_GRAY);

        add(arenaNumber);
        add(fee);
        add(octopus);
        add(timer);
        add(minBet);
        add(maxBet);
    }

    private JLabel createJLabel(Font font) {
        JLabel label = new JLabel();
        label.setFont(font);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentY(Component.CENTER_ALIGNMENT);

        return label;
    }

    @Override
    public void update(ArenaInformation arenaInformation) {


        arenaNumber.setText("Arena: " + arenaInformation.getArenaNumber());
        fee.setText((arenaInformation.getFee() * 100) + "%");
        octopus.setText(arenaInformation.getOctopusAmount() + "#");
        timer.setText(arenaInformation.getStartTime());
        minBet.setText("Min $"+arenaInformation.getMinBet());
        maxBet.setText("Max $"+arenaInformation.getMaxBet());

        if(arenaInformation.getStartTime().equals("00:00:00"))
            timer.setBackground(Color.RED);
        else
            timer.setBackground(Color.GREEN);

    }

}
