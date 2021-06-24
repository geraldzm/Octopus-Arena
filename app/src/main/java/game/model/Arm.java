package game.model;

import game.Octopus;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Arm extends GameObject {

    PVector center, startPosition;
    float maxLength; // max distance from the center
    boolean contracting;
    float angel;
    private ArrayList<Octopus> enemies;

    public Arm(PVector center, PVector acceleration, ArrayList<Octopus> enemies) {
        super(51, 28);

        setImage("/images/fist.png");

        this.enemies = enemies;
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
        g2d.drawRect( (int)position.x, (int)position.y, (int)hitBox.getWidth(), (int)hitBox.getHeight());

        g2d.setTransform(backup);

    }

    @Override
    public void tick() {
        move();

        for (int i = 0; i < enemies.size(); i++) {
            Octopus enemy = enemies.get(i);

            if(isTouching(enemy)) {
                System.out.println("Hitting");
            }

        }

        if(!contracting && PApplet.dist(position.x, position.y, startPosition.x, startPosition.y) >= maxLength) {
            acceleration.mult(-1);
            contracting = true;
        }

    }

}
