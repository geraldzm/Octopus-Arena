package Controllers;

import lombok.Getter;
import views.Login;
import views.WindowBuilder;
import views.WindowID;

import java.awt.event.ActionEvent;

@Getter
public class LoginController {

    private final Login login;

    public LoginController(Login login) {
        this.login = login;

        login.signin.addActionListener(this::onSignInButtonDo);
        login.login.addActionListener(this::onLoginButtonDo);

    }

    public void onLoginButtonDo(ActionEvent event) {

        // insert if to validated user information
        WindowBuilder.buildWindowAndShow(null, WindowID.HOME);

    }

    public void onSignInButtonDo(ActionEvent event) {

        WindowBuilder.buildWindowAndShow(null, WindowID.SINGIN);

    }

}
