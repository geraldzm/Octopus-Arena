package views;

import Util.Utility;
import model.ContextNode;

import javax.swing.*;
import java.awt.*;

public class Signin extends AppWindow {

    JTextArea textArea;
    JLabel nickName;
    JButton next, cancel;

    public Signin(ContextNode contextNode) {
        super(contextNode, "Signin", new Dimension(500, 500));
    }

    @Override
    public void initComponents() {

        int totalY;

        //
        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setFont(new Font("Arial", Font.ITALIC, 40));

        Dimension descripD = Utility.stringDimensions(descriptionLabel.getText(), descriptionLabel.getFont());
        totalY = 10;

        descriptionLabel.setBounds((getWidth() - descripD.width ) / 2 , totalY, descripD.width, descripD.height);
        totalY += descripD.height;
        addComponent(descriptionLabel, 0);

        //
        textArea = new JTextArea();
        textArea.setBounds(100, totalY, 300, 200);
        totalY += 200;
        textArea.setLineWrap(true);
        addComponent(textArea, 0);

        //
        JLabel nickLabel = new JLabel("Nick name:");
        nickLabel.setFont(new Font("Arial", Font.BOLD, 18));

        Dimension nicknameD = Utility.stringDimensions(nickLabel.getText(), nickLabel.getFont());
        totalY += 10;

        nickLabel.setBounds(20, totalY, nicknameD.width, nicknameD.height);

        nickName = new JLabel();
        nickName.setFont(new Font("Arial", Font.PLAIN, 15));
        nickName.setBounds(nickLabel.getX() + nickLabel.getWidth() + 10, totalY, 300, nicknameD.height);
        totalY += nicknameD.height;
        nickName.setBackground(Color.RED);
        nickName.setOpaque(true);

        addComponent(nickName, 0);
        addComponent(nickLabel, 0);

        //
        next = new JButton("Continue");
        next.setBounds(30, totalY, 100, 25);

        cancel = new JButton("Cancel");
        cancel.setBounds(300, totalY, 100, 25);

        addComponent(nickName, 0);


        //setBackgroundColor(Color.RED);
    }
}
