package Controllers;

import model.Arena;
import views.CheckIn;
import views.WindowBuilder;
import views.WindowID;

import java.awt.event.ActionEvent;

public class CheckinController {

    private CheckIn checkin;
    private Arena arena;

    public CheckinController(CheckIn checkin) {
        this.checkin = checkin;
        this.checkin.checkIn.addActionListener(this::onCheckInButtonDo);
        this.checkin.exit.addActionListener(this::onExitInButtonDo);

        arena = checkin.getContextNode().arena;
        checkin.getContextNode().arena.register(checkin.arenaPreviewInformation);
    }

    private void onCheckInButtonDo(ActionEvent event) {

        if(!validateParameters() || isArenaAvailable())
            return;

        finishCheckin();
    }

    private void onExitInButtonDo(ActionEvent event) {
        checkin.dispose();

        WindowBuilder.buildWindowAndShow(checkin.getContextNode(), WindowID.HOME);
    }

    private boolean isArenaAvailable() {
        return true;
    }

    private boolean validateParameters(){
        return validateEnergy() && validateMoney();
    }

    private boolean validateEnergy() {
        return checkin.sliderEnergy.getValue() > 0 && checkin.sliderEnergy.getValue() < 101;
    }

    private  boolean validateMoney() {
        return Integer.parseInt(checkin.spinnerMoney.getValue().toString()) > 0;
    }

    private void finishCheckin() {
        checkin.checkIn.setEnabled(false);
        checkin.exit.setEnabled(false);
        checkin.sliderEnergy.setEnabled(false);
        checkin.spinnerMoney.setEnabled(false);
    }

    private void encryptData() {

    }

}
