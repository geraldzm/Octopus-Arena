package views;

import Controllers.SignupController;
import Util.Utility;
import model.ContextNode;

import javax.swing.*;
import java.awt.*;

public class Signup extends AppWindow {

    public JTextArea textArea;
    public JLabel nickName;
    public JButton next, cancel;

    public Signup(ContextNode contextNode) {
        super(contextNode, "Sign up", new Dimension(500, 500));
    }

    @Override
    public void initComponents() {

        int totalY = 10;
        Dimension descripD = initAndAddDescription(totalY);
        totalY += descripD.height;
        initAndAddTextarea(totalY);
        totalY += 200;

        JLabel nickLabel = initNicknameLabel();
        Dimension nicknameD = Utility.stringDimensions(nickLabel.getText(), nickLabel.getFont());
        totalY += 10;
        nickLabel.setBounds(20, totalY, nicknameD.width, nicknameD.height);

        nickName = new JLabel();
        nickName.setForeground(Color.WHITE);
        nickName.setFont(new Font("Arial", Font.PLAIN, 15));
        nickName.setBounds(nickLabel.getX() + nickLabel.getWidth() + 10, totalY, 300, nicknameD.height);
        totalY += nicknameD.height;

        addComponent(nickName, 0);
        addComponent(nickLabel, 0);

        totalY += 20;
        initAndAddNextAndCancelButtons(totalY);
        setBackgroundColor(new Color(52,58,64));

        new SignupController(this);
    }

    private Dimension initAndAddDescription(int totalY){
        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setFont(new Font("Arial", Font.ITALIC, 40));
        Dimension descripD = Utility.stringDimensions(descriptionLabel.getText(), descriptionLabel.getFont());
        descriptionLabel.setBounds((getWidth() - descripD.width ) / 2 , totalY, descripD.width, descripD.height);
        addComponent(descriptionLabel, 0);
        return descripD;
    }

    private void initAndAddTextarea(int totalY){
        textArea = new JTextArea();
        textArea.setBounds(100, totalY, 300, 200);
        textArea.setLineWrap(true);
        addComponent(textArea, 0);
    }

    private JLabel initNicknameLabel(){
        JLabel nickLabel = new JLabel("Nick name:");
        nickLabel.setForeground(Color.WHITE);
        nickLabel.setFont(new Font("Arial", Font.BOLD, 18));
        return nickLabel;
    }

    private void initAndAddNextAndCancelButtons(int totalY){
        next = new JButton("Continue");
        next.setBounds(150, totalY, 100, 25);
        cancel = new JButton("Cancel");
        cancel.setBounds(260, totalY, 100, 25);
        addComponent(next, 0);
        addComponent(cancel, 0);
    }


}
