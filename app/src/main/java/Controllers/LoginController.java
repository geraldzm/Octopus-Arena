package Controllers;

import Logic.SystemFileManager;
import lombok.Getter;
import model.Arena;
import model.ContextNode;
import model.TimeZones;
import model.User;
import views.Login;
import views.WindowBuilder;
import views.WindowID;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Optional;

@Getter
public class LoginController {

    private final Login login;

    public LoginController(Login login) {
        this.login = login;

        login.signup.addActionListener(this::onSignInButtonDo);
        login.login.addActionListener(this::onLoginButtonDo);

    }

    //TEMP
    public static int arenaNumber = 0;
    public static ArrayList<Arena> allArenas = new ArrayList<>();

    public void onLoginButtonDo(ActionEvent event) {

        if(validateLoginButton()) {
            User user = SystemFileManager.getInstance().getUser(login.inputName.getText());

            if(user != null) {
                ContextNode contextNode = new ContextNode();
                contextNode.user = user;

                contextNode.arenaBuilder = u -> {

                    Optional<Arena> any = allArenas.stream()
                            .filter(a -> !a.isStarted())
                            .filter(a -> !u.getArenas().contains(a))
                            .findFirst();

                    if(any.isPresent())
                        return any.get();

                    Arena arena = new Arena(arenaNumber++, 3);
                    arena.setFee(0.1);
                    arena.setMinimumBet(80.0);
                    arena.setMaximumBet(150.0);
                    arena.setTimeZone(TimeZones.EST);
                    u.getArenas().add(arena);

                    System.out.println("New arena");

                    allArenas.add(arena);
                    return arena;
                };

                WindowBuilder.buildWindowAndShow(contextNode, WindowID.HOME);
                return;
            }

        }

        JOptionPane.showMessageDialog(login, "Error", "Login", JOptionPane.ERROR_MESSAGE);
    }

    private boolean validateLoginButton() {
       // return login.inputName.getText().matches("([A-Za-z]*-[A-Za-z]+[0-9]+)\\w+");
        return true;
    }

    public void onSignInButtonDo(ActionEvent event) {

        WindowBuilder.buildWindowAndShow(null, WindowID.SIGNUP);

    }

}
