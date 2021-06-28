package Controllers;

import game.model.UserFinalPosition;
import model.ContextNode;
import views.ScoreBoard;
import views.WindowBuilder;
import views.WindowID;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ScoreBoardController {

    ScoreBoard scoreBoard;

    public ScoreBoardController(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;

        ArrayList<UserFinalPosition> finalPositions = scoreBoard.getContextNode().finalPositions;

        String [] ranking = new String[finalPositions.size()];
        String [] rankingMoney = new String[finalPositions.size()];

        for (int i = 0; i < finalPositions.size(); i++) {
            rankingMoney[i] = String.format("bet %.2f earned %.2f", finalPositions.get(i).getMoneyBet(), finalPositions.get(i).getMoneyWon());
            ranking[i] = String.format("%s  #%d", finalPositions.get(i).getUser().getNickname() , finalPositions.get(i).getPosition());
        }

        scoreBoard.positionRank.setListData(ranking);
        scoreBoard.moneyRank.setListData(rankingMoney);

        scoreBoard.ok.addActionListener(this::onOkButton);


    }

    private void onOkButton(ActionEvent event) {
        System.out.println("OK button");

        ContextNode contextNode = new ContextNode();
        contextNode.user = scoreBoard.getContextNode().user;

     //   scoreBoard.dispose();
        WindowBuilder.buildWindowAndShow(contextNode, WindowID.HOME);
    }


}
