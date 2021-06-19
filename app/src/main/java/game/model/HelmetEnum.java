package game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HelmetEnum {

    HELMET_GLADIATOR("/images/helment0.png", 0, 5, 20 );

    private String imagePath;
    private int helmetIndex;
    private double xOffset;
    private double yOffset;

}
