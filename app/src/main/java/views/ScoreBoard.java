package views;

import model.ContextNode;

import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends AppWindow {

    JList<String> positionRank, moneyRank;
    JButton ok;

    public ScoreBoard(ContextNode contextNode) {
        super(contextNode, "Score Board", new Dimension(500, 550));
    }

    @Override
    public void initComponents() {
        initAndAddMoneyRank();
        initAndAddPositionRank();
        initAndAddOkButton();
        setBackgroundColor(new Color(52,58,64));
    }

    private void initAndAddPositionRank(){
        positionRank = new JList<>();
        positionRank.setBounds(30, 30, 200, 400);
        addComponent(positionRank, 0);
    }

    private void initAndAddMoneyRank(){
        moneyRank = new JList<>();
        moneyRank.setBounds(260, 30, 200, 400);
        addComponent(moneyRank, 0);
    }

    private void initAndAddOkButton(){
        ok = new JButton("Ok");
        ok.setBounds(50, 450, 100, 25);
        addComponent(ok, 0);
    }
}
