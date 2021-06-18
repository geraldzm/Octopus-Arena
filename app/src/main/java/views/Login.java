package views;

import Util.Utility;
import model.ContextNode;

import javax.swing.*;
import java.awt.*;


public class Login extends AppWindow {

    public JTextField inputName;
    public JButton login, signin;

    public Login(ContextNode contextNode) {
        super(contextNode, "Login", new Dimension(500, 600));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void initComponents() {

        int totalY;

        // title
        JLabel title = new JLabel("Octopus Arena");
        title.setFont(new Font("Arial", Font.ITALIC, 50));
        title.setForeground(Color.WHITE);
        Dimension sDimension = Utility.stringDimensions(title.getText(), title.getFont());
        totalY = 10;
        title.setBounds((getWidth() - sDimension.width) / 2, totalY, sDimension.width, sDimension.height);
        addComponent(title, 0);

        //
        inputName = new JTextField();
        int inputWidth = 200;
        totalY += sDimension.height + 200 + 10;
        inputName.setBounds((getWidth() - inputWidth) / 2,  totalY, inputWidth, 25);
        totalY += 25;
        addComponent(inputName, 0);

        //
        login = new JButton("Login");
        int buttonsWidth = 100;
        totalY += 50;
        login.setBounds((getWidth() - buttonsWidth) / 2, totalY, buttonsWidth, 25);
        totalY += 25;
        addComponent(login, 0);

        //
        signin = new JButton("Signin");
        totalY += 10;
        signin.setBounds((getWidth() - buttonsWidth) / 2, totalY, buttonsWidth, 25);
        totalY += 25;
        addComponent(signin, 0);

        setBackgroundColor(new Color(52,58,64));
    }

}
