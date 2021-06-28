package Controllers;

import Logic.AlternativeArenaGenerator;
import Logic.ArenaGenerator;
import Logic.SystemFileManager;
import Logic.UserManager;
import lombok.Getter;
import model.ContextNode;
import model.User;
import views.Login;
import views.WindowBuilder;
import views.WindowID;

import javax.swing.*;
import java.awt.event.ActionEvent;

@Getter
public class LoginController {

    private final Login login;

    public LoginController(Login login) {
        this.login = login;

        login.signup.addActionListener(this::onSignInButtonDo);
        login.login.addActionListener(this::onLoginButtonDo);

    }

    public void onLoginButtonDo(ActionEvent event) {

        if(validateLoginButton()) {
            User user = SystemFileManager.getInstance().getUser(login.inputName.getText());

            if(user != null) {
                ContextNode contextNode = new ContextNode();
                contextNode.user = user;
                contextNode.arenaIndex = 0;

                contextNode.arenaBuilder = new AlternativeArenaGenerator();


                WindowBuilder.buildWindowAndShow(contextNode, WindowID.HOME);
                return;
            }

        }

        JOptionPane.showMessageDialog(login, "Error", "Login", JOptionPane.ERROR_MESSAGE);
    }

    private boolean validateLoginButton() {
        return login.inputName.getText().matches("([A-Za-z]*-[A-Za-z]+[0-9]+)\\w+");
    }

    public void onSignInButtonDo(ActionEvent event) {

        WindowBuilder.buildWindowAndShow(null, WindowID.SIGNUP);

    }

}
