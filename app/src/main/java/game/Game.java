package game;

import Util.Utility;
import game.model.ActionGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Game extends Canvas implements Runnable {

    private Thread thread;
    private boolean running = false;
    private final Image background;

    // temp
    Octopus octopus;

    public Game() {

        background = Utility.getScaledImage("/images/Arena_Mat.jpg").getImage();

        // temp
        AtomicInteger tImEr = new AtomicInteger();
        ActionGenerator generator = o -> {

            if(tImEr.getAndIncrement() > 300) { // every 300 movements will "guard"
                tImEr.set(0);
                return new GuardAction();
            }

            return new MoveAction();
        };

        octopus = new Octopus(generator, 100);

    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        running = false;
    }

    public synchronized void stopFromOutSide(){
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
    }

    private void render() {

        BufferStrategy bs = getBufferStrategy();

        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.drawImage(background, 0, 0, null);

        // render everything else
        render(g);

        g.dispose();
        bs.show();
    }

    private void render(Graphics g) {
        octopus.render(g);
    }

    private void tick() {
        octopus.tick();
    }

}
