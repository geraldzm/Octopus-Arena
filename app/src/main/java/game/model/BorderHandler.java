package game.model;

import lombok.AllArgsConstructor;

import java.awt.geom.Rectangle2D;


public class BorderHandler {

    private final PVector center;
    private final double radium;
    // 370


    public BorderHandler(PVector center, double radium) {
        this.center = center;
    //    this.radium = radium;
        this.radium = 370;
    }

    public void clampMovement(PVector position, Rectangle2D box) {

        position.x += box.getWidth()/2;
        position.y += box.getHeight()/2;

        if(position.dist(center) > radium ) {

            position.sub(center);
            position.normalize();
            position.mult((float) radium);
            position.add(center);

        }

        position.x -= box.getWidth()/2;
        position.y -= box.getHeight()/2;

    }

}
