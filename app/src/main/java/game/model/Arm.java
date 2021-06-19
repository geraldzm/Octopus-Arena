package game.model;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Arm extends GameObject {

    PVector center;

    public Arm(PVector center, PVector acceleration) {
        super(52, 29);
        setImage("/images/fist.png");

        this.center = center;

        this.position.x = (float) (center.x + getHitBox().getWidth()/2);
        this.position.y = (float) (center.y + getHitBox().getHeight());

        this.acceleration.x = acceleration.x;
        this.acceleration.y = acceleration.y;

    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        AffineTransform backup = g2d.getTransform();
        //rx is the x coordinate for rotation, ry is the y coordinate for rotation, and angle
        //is the angle to rotate the image. If you want to rotate around the center of an image,
        //use the image's center x and y coordinates for rx and ry.
        AffineTransform a = AffineTransform.getRotateInstance(acceleration.heading(), position.x, position.y);
        //Set our Graphics2D object to the transform
        g2d.setTransform(a);
        //Draw our image like normal
        g2d.drawImage(getImg(), (int)position.x, (int)position.y, null);
        //Reset our graphics object so we can draw with it again.
        g2d.setTransform(backup);
    }

    @Override
    public void tick() {
        move();
    }

}
