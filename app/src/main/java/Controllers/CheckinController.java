package Controllers;

import Util.KeyFactory;
import model.*;
import views.CheckIn;
import views.WindowBuilder;
import views.WindowID;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.security.Key;
import java.security.PublicKey;

public class CheckinController extends WindowAdapter {

    private CheckIn checkin;
    private Arena arena;
    private Observer<ArenaInformation> closeListener;
    private boolean isRegistered;
    private Session session;

    public CheckinController(CheckIn checkin) {
        this.checkin = checkin;
        this.checkin.checkIn.addActionListener(this::onCheckInButtonDo);
        this.checkin.exit.addActionListener(this::onExitInButtonDo);

        closeListener = this::checkArenaStatus;
        arena = checkin.getContextNode().arena;
        checkin.getContextNode().arena.register(checkin.arenaPreviewInformation);
        checkin.getContextNode().arena.register(closeListener);

        checkin.addWindowListener(this);
    }

    private void checkArenaStatus(ArenaInformation arenaInformation) {

        if(arenaInformation.getIsStarted()) {
            finishCheckin();

            if(isRegistered && arena.isReady())
                checkin.dispose();

        }

    }

    private void onCheckInButtonDo(ActionEvent event) {

        if(isArenaAvailable()) {

            if(validateParameters()) {
                System.out.println("Available: ");

                ContextNode cntx = checkin.getContextNode();

                Session session = arena.generateSession();

                if(session != null) {

                    session.setUser(cntx.user);

                    UserPlayer userPlayer = new UserPlayer();

                    byte[] energy = KeyFactory.do_RSAEncryption(checkin.sliderEnergy.getValue()+"", session.getPublicKey());
                    byte[] money = KeyFactory.do_RSAEncryption(checkin.spinnerMoney.getValue().toString(), session.getPublicKey());

                    userPlayer.setHealthEncoded(energy);
                    userPlayer.setBetEncoded(money);

                    arena.setUserData(session, userPlayer);finishCheckin();

                    isRegistered = true;
                } else {
                    JOptionPane.showMessageDialog(checkin, "Arena no available", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(checkin, "Parameters error", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            System.out.println("NOT Available");
            finishCheckin();
        }

    }

    private void onExitInButtonDo(ActionEvent event) {
        checkin.dispose();
        WindowBuilder.buildWindowAndShow(checkin.getContextNode(), WindowID.HOME);
    }

    private boolean isArenaAvailable() {
        return !arena.isStarted() && !arena.isFull();
    }

    private boolean validateParameters() {
        return validateEnergy() && validateMoney();
    }

    private boolean validateEnergy() {
        return checkin.sliderEnergy.getValue() > 0 && checkin.sliderEnergy.getValue() < 101;
    }

    private boolean validateMoney() {
        int i = Integer.parseInt(checkin.spinnerMoney.getValue().toString());
        return  i >= arena.getMinimumBet() && i <= arena.getMaximumBet();
    }

    private void finishCheckin() {
        checkin.checkIn.setEnabled(false);
        checkin.sliderEnergy.setEnabled(false);
        checkin.spinnerMoney.setEnabled(false);
    }

    private void encryptData() {

    }

}