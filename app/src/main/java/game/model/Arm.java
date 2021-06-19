package game.model;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Arm extends GameObject {

    PVector center, startPosition;
    float maxLength; // max distance from the center
    boolean contracting;
    float angel;

    public Arm(PVector center, PVector acceleration) {
        super(51, 28);

        setImage("/images/fist.png");

        this.center = center;

        this.position.x = center.x + 50;
        this.position.y = center.y + 45;

        this.maxVelocity.x = 4;
        this.maxVelocity.y = 4;
        this.acceleration = acceleration.copy();
        angel = this.acceleration.heading();

        // Hide arms behind octopus
        PVector direction = acceleration.copy().normalize();
        position.sub(direction.x * 20, direction.y * 20);
        startPosition = this.position.copy();

        // Contract
        maxLength = (float) (getHitBox().getWidth()*0.35);
        contracting = false;

    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        AffineTransform backup = g2d.getTransform();
        AffineTransform a = AffineTransform.getRotateInstance(angel, position.x, position.y);

        g2d.setTransform(a);

        g2d.drawImage(getImg(), (int)position.x, (int)position.y, null);

        g2d.setTransform(backup);

    }

    @Override
    public void tick() {
        move();

        if(!contracting && PApplet.dist(position.x, position.y, startPosition.x, startPosition.y) >= maxLength) {
            acceleration.mult(-1);
            contracting = true;
        }

    }

}
