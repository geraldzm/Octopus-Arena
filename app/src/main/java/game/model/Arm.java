package game.model;

import game.Octopus;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Arm extends GameObject {

    PVector center, startPosition;
    float maxLength; // max distance from the center
    boolean contracting, hit;
    float angle;
    PVector fistHeading;
    private ArrayList<Octopus> enemies;
    Double damage;

    public Arm(PVector center, PVector acceleration, ArrayList<Octopus> enemies, Double damage) {
        super(51, 28);

        setImage("/images/fist.png");

        this.enemies = enemies;
        this.center = center;

        this.damage = damage;

        this.position.x = center.x + 50;
        this.position.y = center.y + 45;

        this.maxVelocity.x = 4;
        this.maxVelocity.y = 4;
        this.acceleration = acceleration.copy();
        angle = this.acceleration.heading();

        fistHeading = PVector.fromAngle(angle);
        fistHeading.mult((float) hitBox.getWidth());

        // Hide arms behind octopus
        PVector direction = acceleration.copy().normalize();
        position.sub(direction.x * 20, direction.y * 20);
        startPosition = this.position.copy();

        // Contract
        maxLength = (float) (getHitBox().getWidth()*0.35);
        contracting = false;
        hit = false;

    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        AffineTransform backup = g2d.getTransform();
        AffineTransform a = AffineTransform.getRotateInstance(angle, position.x, position.y);

        g2d.setTransform(a);

        g2d.drawImage(getImg(), (int)position.x, (int)position.y, null);

        if(hit) {
            g2d.setColor(Color.RED);
            g2d.drawRect((int)position.x, (int)position.y, (int)hitBox.getWidth(), (int)hitBox.getHeight());
        }
        //g2d.setColor(Color.GREEN);

        g2d.setTransform(backup);

    }

    @Override
    public void tick() {
        move();

        if(!hit) {

            PVector copy = fistHeading.copy();
            copy.add(position);

            for (int i = 0; i < enemies.size(); i++) {
                Octopus enemy = enemies.get(i);

                if(!enemy.isDead() && enemy.isTouching(copy)) {
                    enemy.takeDamage(damage); //
                    hit = true;
                }

            }

        }

        if(!contracting && PApplet.dist(position.x, position.y, startPosition.x, startPosition.y) >= maxLength) {
            acceleration.mult(-1);
            contracting = true;
        }

    }

}