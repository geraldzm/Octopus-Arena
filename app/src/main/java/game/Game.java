package game;

import Util.Utility;
import game.model.GameObjectHandler;
import lombok.Getter;
import lombok.Setter;
import model.GameSession;
import model.Observable;
import model.Updatable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class Game extends Observable<Updatable> implements Runnable {

    private boolean running = false;
    private final Image background;

    private final BufferedImage bufferedImage;
    private final GameObjectHandler handler;
    private final GameSession gameSession;
    @Setter
    private LinkedHashMap<String, Color> nameTable;

    public Game(GameSession gameSession) {
        bufferedImage = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        background = Utility.getScaledImage("/images/Arena_Mat.jpg").getImage();
        handler = new GameObjectHandler();
        this.gameSession = gameSession;
    }

    public void setOctopus(ArrayList<Octopus> octopusArrayList) {
        handler.addObjectsList(octopusArrayList);
    }

    public synchronized void start() {
        Thread thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        running = false;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 30.0D;
        double ns = 1000000000D / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            boolean shouldRender = false;
            while(delta >=1) {
                tick();
                delta--;
                shouldRender = true;
            }

            if(shouldRender) {
                render();
                frames++;
            }

            if(System.currentTimeMillis() - timer >= 1000) {
                timer += 1000;
                System.out.println(frames);
                frames = 0;
            }
        }
        stop();
        gameSession.onGameFinished();
    }

    private void render() {

        Graphics g = bufferedImage.getGraphics();
        g.drawImage(background, 0, 0, null);
        handler.render(g);

        renderNames(g);

        // update
        notifyAll(this::update);
    }

    private void renderNames(Graphics g) {
        int y = 20;
        for(Map.Entry<String, Color> row: nameTable.entrySet()) {
            g.setColor(row.getValue());
            g.drawString(row.getKey(), 10, y);
            y += 20;
        }
    }


    private void tick() {
        handler.tick();
    }

    private void update(Updatable updatable) {

        Graphics updatableGraphics = updatable.getUpdatableGraphics();
        if(updatableGraphics != null){
            updatableGraphics.drawImage(bufferedImage, 0, 0, null);
            updatable.update();
        }

    }

}
