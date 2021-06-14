package views;

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

        int totalY = 0;

        // title
        String sTitle = "Octopus Arena";
        JLabel title = new JLabel(sTitle);
        Font arial = new Font("Arial", Font.ITALIC, 50);
        title.setFont(arial);
        title.setForeground(Color.WHITE);
        FontMetrics fontMetrics = title.getFontMetrics(arial);
        int stringWidth = fontMetrics.stringWidth(sTitle);
        totalY = 10;
        title.setBounds((getWidth() - stringWidth) / 2, totalY, stringWidth, fontMetrics.getHeight());
        addComponent(title, 0);

        //
        inputName = new JTextField();
        int inputWidth = 200;
        totalY += fontMetrics.getHeight() + 200 + 10;
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
