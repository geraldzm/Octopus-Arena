package Controllers;

import model.Arena;
import Logic.GameSession;
import views.CheckIn;
import java.awt.event.ActionEvent;

public class CheckinController {

    private CheckIn checkin;
    private GameSession gameSession;
    private Arena arena;

    public CheckinController(CheckIn checkin) {
        this.checkin = checkin;
        this.checkin.checkIn.addActionListener(this::onCheckInButtonDo);

        gameSession = checkin.getContextNode().gameSession;
        arena = checkin.getContextNode().arena;
    }

    public void onCheckInButtonDo(ActionEvent event) {

        if(!validateParameters() || isArenaAvailable())
            return;



        finishCheckin();
    }

    private boolean isArenaAvailable() {
        return true;
    }

    private boolean validateParameters(){
        return validateEnergy() && validateMoney();
    }

    private boolean validateEnergy(){
        return checkin.sliderEnergy.getValue() > 0 && checkin.sliderEnergy.getValue() < 101;
    }

    private  boolean validateMoney(){
        return Integer.parseInt(checkin.spinnerMoney.getValue().toString()) > 0;
    }

    private void finishCheckin(){
        checkin.checkIn.setEnabled(false);
        checkin.exit.setEnabled(false);
        checkin.sliderEnergy.setEnabled(false);
        checkin.spinnerMoney.setEnabled(false);
    }

    private void encryptData(){

    }

}
