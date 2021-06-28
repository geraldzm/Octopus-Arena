package Controllers;

import Logic.AlternativeArenaGenerator;
import Logic.DescriptionParser;
import Logic.NicknameGenerator;
import Logic.SystemFileManager;
import Util.Utility;
import model.ContextNode;
import model.TimeZones;
import model.User;
import views.Signup;
import views.WindowBuilder;
import views.WindowID;

import javax.naming.Context;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.TimeZone;

public class SignupController {

    private Signup signup;
    private String nickname;

    public SignupController(Signup signup) {

        this.signup = signup;
        nickname = NicknameGenerator.getInstance().generateNickname();
        signup.nickName.setText(nickname);

        signup.next.addActionListener(this::onNextAction);
    }

    private void onNextAction(ActionEvent actionEvent) {

        DescriptionParser parser = new DescriptionParser();
        ArrayList<Integer> numbers = parser.numberValuesFromString(signup.textArea.getText());

        if(numbers.size() == 3) {
            numbers.sort(Integer::compareTo);

            User newUSer = new User();
            newUSer.setTimeZone(TimeZones.values()[(int) Utility.clamp(numbers.get(0), 0, TimeZones.values().length -1)]);
            newUSer.setMoney(1000.0);
            newUSer.setAmountOctopi((int) Utility.clamp(numbers.get(0), 0, TimeZones.values().length));
            newUSer.setPreferredBetAmount((double)numbers.get(2));
            newUSer.setNickname(nickname);
            newUSer.setDescription(signup.textArea.getText());
            newUSer.setExperience(0);
            newUSer.setArenas(new ArrayList<>(5));

            SystemFileManager.getInstance().insertTree(newUSer);

            signup.dispose();
            ContextNode context = new ContextNode();
            context.user = newUSer;
            context.arenaBuilder = new AlternativeArenaGenerator();
            WindowBuilder.buildWindowAndShow(context, WindowID.HOME);

        }

    }


}
