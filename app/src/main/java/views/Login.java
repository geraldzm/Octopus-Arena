package views;

import Util.Utility;
import model.ContextNode;

import javax.swing.*;
import java.awt.*;


public class Login extends AppWindow {

    public JTextField inputName;
    public JButton login, signup;

    public Login(ContextNode contextNode) {
        super(contextNode, "Login", new Dimension(500, 600));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void initComponents() {
        int totalY = 10;
        int buttonsWidth = 100;
        Dimension sDimension = initAndAddTitle(totalY);
        totalY += sDimension.height + 200 + 10;
        initAndAddInputName(totalY);
        totalY += 75;
        initAndAddLogin(totalY, buttonsWidth);
        totalY += 35;
        initAndAddSignup(totalY, buttonsWidth);
        setBackgroundColor(new Color(52,58,64));
    }

    private Dimension initAndAddTitle(int totalY){
        JLabel title = new JLabel("Octopus Arena");
        title.setFont(new Font("Arial", Font.ITALIC, 50));
        title.setForeground(Color.WHITE);
        Dimension sDimension = Utility.stringDimensions(title.getText(), title.getFont());
        title.setBounds((getWidth() - sDimension.width) / 2, totalY, sDimension.width, sDimension.height);
        addComponent(title, 0);
        return sDimension;
    }

    private void initAndAddInputName(int totalY){
        inputName = new JTextField();
        int inputWidth = 200;
        inputName.setBounds((getWidth() - inputWidth) / 2,  totalY, inputWidth, 25);
        addComponent(inputName, 0);
    }

    public void initAndAddLogin(int totalY, int buttonsWidth){
        login = new JButton("Login");
        login.setBounds((getWidth() - buttonsWidth) / 2, totalY, buttonsWidth, 25);
        addComponent(login, 0);
    }

    public void initAndAddSignup(int totalY, int buttonsWidth){
        signup = new JButton("Sign up");
        signup.setBounds((getWidth() - buttonsWidth) / 2, totalY, buttonsWidth, 25);
        addComponent(signup, 0);
    }

}
