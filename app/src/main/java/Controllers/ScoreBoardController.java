package Controllers;

import game.model.UserFinalPosition;
import model.UserPlayer;
import views.ScoreBoard;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreBoardController {

    ScoreBoard scoreBoard;

    public ScoreBoardController(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;

        ArrayList<UserFinalPosition> finalPositions = scoreBoard.getContextNode().finalPositions;

        for (int i = 0; i < finalPositions.size(); i++) {
            System.out.println("Nickname: " + finalPositions.get(i).getUser().getNickname() + "  Position: " + finalPositions.get(i).getPosition() +
                    "  OriginalMoney: " + finalPositions.get(i).getMoneyBet() + "  MoneyWon: " + finalPositions.get(i).getMoneyWon());
        }
    }


}
