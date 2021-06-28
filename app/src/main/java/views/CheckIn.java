package views;

import Controllers.CheckinController;
import model.ContextNode;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;

public class CheckIn extends AppWindow {

    public JSlider sliderEnergy;
    public JSpinner spinnerMoney;
    public ArenaPreviewInformation arenaPreviewInformation;
    public JButton checkIn, exit;
    public JList<String> readyPlayers;

    public CheckIn(ContextNode contextNode) {
        super(contextNode, "CheckIn", new Dimension(600, 600));
    }

    @Override
    public void initComponents() {
        initSliderEnergy();
        setAndAddEnergy();
        initSpinnerMoney();
        setAndAddMoney();
        initAndAddArenaPreview();
        initAndAddReadyPlayers();
        initAndAddCheckinEnterButtons();
        setBackgroundColor(new Color(52,58,64));
        new CheckinController(this);
    }

    private void initSliderEnergy(){
        sliderEnergy = new JSlider(20, 100);
        sliderEnergy.setBounds(200,10,200,40);
        sliderEnergy.setMajorTickSpacing(20);
        sliderEnergy.setMinorTickSpacing(10);
        sliderEnergy.setForeground(Color.WHITE);
        sliderEnergy.setPaintLabels(true);
        sliderEnergy.setPaintTicks(true);
    }

    private void setAndAddEnergy(){
        JLabel energy = new JLabel("Energy:");
        energy.setForeground(Color.WHITE);
        energy.setBounds(150, 10, 50, 25);
        addComponent(energy, 0);
        addComponent(sliderEnergy, 0);
    }

    private void initSpinnerMoney(){
        spinnerMoney = new JSpinner();
        spinnerMoney.setBounds(200, 100, 100, 25);
        JFormattedTextField txt = ((JSpinner.NumberEditor) spinnerMoney.getEditor()).getTextField();
        ((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
    }

    private void setAndAddMoney(){
        JLabel money = new JLabel("Money:");
        money.setForeground(Color.WHITE);
        money.setBounds(150, 100, 50, 25);
        addComponent(money, 0);
        addComponent(spinnerMoney, 0);
    }

    private void initAndAddArenaPreview(){
        arenaPreviewInformation = new ArenaPreviewInformation();
        arenaPreviewInformation.setBackground(Color.WHITE);
        arenaPreviewInformation.setBounds(15, 150, 300, 250);
        addComponent(arenaPreviewInformation, 0);
    }

    private void initAndAddReadyPlayers(){
        readyPlayers = new JList<>();
        readyPlayers.setBounds(325, 150, 250, 250);
        addComponent(readyPlayers, 0);
    }

    private void initAndAddCheckinEnterButtons(){
        checkIn = new JButton("Check in");
        checkIn.setBounds(100, 450, 100, 25);
        exit = new JButton("Exit");
        exit.setBounds(300, 450, 100, 25);
        addComponent(checkIn, 0);
        addComponent(exit, 0);
    }


}