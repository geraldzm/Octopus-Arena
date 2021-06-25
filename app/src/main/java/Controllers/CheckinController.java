package Controllers;

import views.CheckIn;
import views.WindowBuilder;
import views.WindowID;

import javax.crypto.Cipher;
import java.awt.event.ActionEvent;
import java.security.PrivateKey;
import java.security.PublicKey;

public class CheckinController {

    private CheckIn checkin;

    public CheckinController(CheckIn checkin) {
        this.checkin = checkin;
    }

    public void onCheckInButtonDo(ActionEvent event) {

        if(validateParameters())
            return;


        finishCheckin();
    }

    private boolean validateParameters(){
        return  validateEnergy() && validateMoney();
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
