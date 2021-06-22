package game.model;

import Util.Utility;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

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

    public static void loadHelmets() {
        HelmetEnum[] allHelmets = HelmetEnum.values();

        helmetArray = new ArrayList<>(allHelmets.length);

        Arrays.stream(allHelmets)
                .forEach(helmetEnum -> helmetArray.add(Utility.getScaledImage(helmetEnum.getImagePath()).getImage()));

    }

    @Override
    public void tick() {
        setPositionRelativeToOctopus();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    public void setOctopusPosition(PVector octopusPosition) {
        this.octopusPosition = octopusPosition;
        setPositionRelativeToOctopus();
    }

    private void setPositionRelativeToOctopus() {
        this.position.x = (float) (octopusPosition.x - helmetEnum.getXOffset());
        this.position.y = (float) (octopusPosition.y - helmetEnum.getYOffset());
    }

}
