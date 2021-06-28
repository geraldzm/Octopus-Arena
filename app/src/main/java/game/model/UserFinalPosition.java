package game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.User;

@Setter
@Getter
public class UserFinalPosition {

    private User user;
    private double moneyBet;
    private int position;

    private double moneyBetWithFee;
    private double percentageOfPrizePool;
    private double positionXpercentageOfPrizePool;
    private double percentageOfpositionXpercentageOfPrizePool;
    private double moneyWon;

    public UserFinalPosition(User user, double moneyBet, int position) {
        this.user = user;
        this.moneyBet = moneyBet;
        this.position = position;
    }
}
