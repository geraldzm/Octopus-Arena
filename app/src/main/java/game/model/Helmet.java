package game.model;

import Util.Utility;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
public class Helmet extends GameObject {

    private static ArrayList<Image> helmetArray;
    private PVector octopusPosition;
    private HelmetEnum helmetEnum;

    public Helmet(HelmetEnum helmetEnum) {
        super(100, 100);
        this.helmetEnum = helmetEnum;
        if(helmetArray == null)
            loadHelmets();
        setImg(helmetArray.get(helmetEnum.getHelmetIndex()));
    }

    public static void loadHelmets(){
        helmetArray = new ArrayList<>(5);
        helmetArray.add(Utility.getScaledImage("/images/helment0.png").getImage());
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        this.position.x = (float) (octopusPosition.x - helmetEnum.getXOffset());
        this.position.y = (float) (octopusPosition.y - helmetEnum.getYOffset());
        super.render(g);
    }
}
