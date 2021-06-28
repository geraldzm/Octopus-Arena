package game;

import game.model.UserFinalPosition;
import model.User;

import java.util.ArrayList;
import java.util.Set;

public class MoneyDistributor {

    private ArrayList<UserFinalPosition> leaderboard;
    private double fee;
    private double prizePool;
    private double totalPositionXMoneyPercentage;
    private int worstPosition;

    // se tiene que llamar desde game session y la informacion se le pasa directa a ScoreBoard
    // si
    public MoneyDistributor(ArrayList<UserFinalPosition> leaderboard, double fee) {
        this.leaderboard = leaderboard;
        this.fee = fee;
        prizePool = 0;
        totalPositionXMoneyPercentage = 0;
        worstPosition = 0;
    }

    public ArrayList<UserFinalPosition> distributeMoney(){
        if(leaderboard != null){

            calculatePrizePool();
            calculatePrizePoolPercentages();
            calculatePositionXPercentages();

            return leaderboard;
        }
        leaderboard = null;
        return leaderboard;
    }

    private void calculatePrizePool(){
        for (int i = 0; i < leaderboard.size(); i++){
            UserFinalPosition ufp = leaderboard.get(i);
            if(ufp.getPosition() > worstPosition)
                worstPosition = ufp.getPosition();
            ufp.setMoneyBetWithFee(ufp.getMoneyBet() * (1-fee));
            prizePool += ufp.getMoneyBetWithFee();
        }
    }

    private void calculatePrizePoolPercentages(){
        for (int i = 0; i < leaderboard.size(); i++) {
            UserFinalPosition ufp = leaderboard.get(i);
            ufp.setPercentageOfPrizePool(ufp.getMoneyBetWithFee() / prizePool);
            ufp.setPositionXpercentageOfPrizePool((worstPosition - ufp.getPosition() + 1) * ufp.getPercentageOfPrizePool());
            totalPositionXMoneyPercentage += ufp.getPositionXpercentageOfPrizePool();
        }
    }

    private void calculatePositionXPercentages(){
        for (int i = 0; i < leaderboard.size(); i++) {
            UserFinalPosition ufp = leaderboard.get(i);
            ufp.setPercentageOfpositionXpercentageOfPrizePool(ufp.getPositionXpercentageOfPrizePool() / totalPositionXMoneyPercentage);
            ufp.setMoneyWon(ufp.getPercentageOfpositionXpercentageOfPrizePool() * prizePool);
        }
    }
}
