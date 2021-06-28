package Controllers;

import model.UserPlayer;
import views.ScoreBoard;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreBoardController {

    ScoreBoard scoreBoard;

    public ScoreBoardController(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;

        ArrayList<UserPlayer> scoreUsers = scoreBoard.getContextNode().scoreUsers;

        System.out.println(Collections.unmodifiableList(scoreUsers));
    }


}
