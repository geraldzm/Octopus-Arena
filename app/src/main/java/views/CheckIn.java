package views;

import model.ContextNode;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;

public class CheckIn extends AppWindow {

    JSlider sliderEnergy;
    JSpinner spinnerMoney;
    ArenaPreviewInformation arenaPreviewInformation;
    JButton checkIn, exit;
    JList<String> readyPlayers;

    public CheckIn(ContextNode contextNode) {
        super(contextNode, "CheckIn", new Dimension(600, 600));
    }

    @Override
    public void initComponents() {

        // Slider for energy

        sliderEnergy = new JSlider(0, 100);
        sliderEnergy.setBounds(200,10,200,40);
        sliderEnergy.setMajorTickSpacing(20);
        sliderEnergy.setMinorTickSpacing(10);
        sliderEnergy.setForeground(Color.WHITE);
        sliderEnergy.setPaintLabels(true);
        sliderEnergy.setPaintTicks(true);

        JLabel energy = new JLabel("Energy:");
        energy.setForeground(Color.WHITE);
        energy.setBounds(150, 10, 50, 25);

        addComponent(energy, 0);
        addComponent(sliderEnergy, 0);

        // money

        spinnerMoney = new JSpinner();
        spinnerMoney.setBounds(200, 100, 100, 25);

        JFormattedTextField txt = ((JSpinner.NumberEditor) spinnerMoney.getEditor()).getTextField();
        ((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);

        JLabel money = new JLabel("Money:");
        money.setForeground(Color.WHITE);
        money.setBounds(150, 100, 50, 25);

        addComponent(money, 0);
        addComponent(spinnerMoney, 0);


        // Arena Info
        arenaPreviewInformation = new ArenaPreviewInformation();
        arenaPreviewInformation.setBackground(Color.RED);
        arenaPreviewInformation.setBounds(30, 150, 200, 200);

        addComponent(arenaPreviewInformation, 0);

        //
        readyPlayers = new JList<>();
        readyPlayers.setBounds(330, 150, 200, 200);

        addComponent(readyPlayers, 0);

        //
        checkIn = new JButton("Check in");
        checkIn.setBounds(100, 400, 100, 25);

        exit = new JButton("Exit");
        exit.setBounds(300, 400, 100, 25);

        addComponent(checkIn, 0);
        addComponent(exit, 0);

        setBackgroundColor(new Color(52,58,64));

    }

}