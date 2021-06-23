package game;

import Util.Utility;
import game.model.*;
import lombok.Getter;
import model.GameSession;
import model.Observable;
import model.Updatable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

@Getter
public class Game extends Observable<Updatable> implements Runnable {

    private boolean running = false;
    private final Image background;

    private final BufferedImage bufferedImage;
    private final GameObjectHandler handler;
    private final GameSession gameSession;

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

        // update
        notifyAll(this::update);
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
