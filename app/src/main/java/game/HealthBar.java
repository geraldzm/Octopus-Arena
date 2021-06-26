package game;

import Util.Utility;
import game.model.IRenderable;
import game.model.PVector;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
public class HealthBar implements IRenderable {

    private double health;
    private int width, height;
    private PVector octopusPosition;
    @Setter
    private Color color;

    public HealthBar(double health, PVector octopusPosition) {
        this.health = health;
        this.octopusPosition = octopusPosition;
        this.width = 50;
        this.height = 5;
        color = Color.GREEN;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        int x = (int)octopusPosition.x + 22;
        int y = (int)octopusPosition.y - 10;
        g.drawRect(x, y, width, height);
        g.fillRect(x, y, (int)((health/100)*width), height);
    }

    public void reduceHealth(double toReduce) {
        health = Utility.clamp(health - toReduce, 0, health);
    }

}
