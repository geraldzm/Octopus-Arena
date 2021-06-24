package game.model;

import Util.Utility;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

@Data
public abstract class GameObject implements IRenderable, ITickable {

    protected PVector velocity;
    protected PVector maxVelocity;
    protected PVector acceleration;
    protected PVector position;

    protected Rectangle2D hitBox;
    private Image img;

    public GameObject(int width, int height) {

        velocity = new PVector(0, 0);
        maxVelocity = new PVector(1, 1);
        acceleration = new PVector(0, 0);
        position = new PVector(0, 0);

        hitBox = new Rectangle2D.Double(0, 0, width, height);

    }

    @Override
    public void render(Graphics g) {

        if(img != null)
            g.drawImage(img, (int)position.x, (int)position.y, null);

    }

    @Override
    public abstract void tick();

    public void setImage(String imgPath) {

        ImageIcon scaledImage = Utility.getScaledImage(imgPath, (int) hitBox.getWidth(), (int) hitBox.getHeight());
        setImg(scaledImage.getImage());

    }

    public void move() {
        velocity.add(acceleration);
        velocity.limit(maxVelocity.mag());
        position.add(velocity);
    }

    public boolean isTouching(GameObject g) {

        hitBox = new Rectangle2D.Double((int)position.x, (int)position.y, hitBox.getWidth(), hitBox.getHeight());
        g.hitBox = new Rectangle2D.Double((int)g.position.x, (int)g.position.y, g.hitBox.getWidth(), g.hitBox.getHeight());

        return hitBox.intersects(g.getHitBox());
    }

}
