package game;

import Util.Utility;
import game.model.ActionGenerator;
import game.model.Helmet;
import game.model.HelmetEnum;
import lombok.Getter;
import model.Observable;
import model.Updatable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Game extends Observable<Updatable> implements Runnable {

    private boolean running = false;
    private final Image background;

    private final BufferedImage bufferedImage;

    // temp
    Octopus octopus;

    public Game() {

        bufferedImage = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        background = Utility.getScaledImage("/images/Arena_Mat.jpg").getImage();

        // temp
        AtomicInteger tImEr = new AtomicInteger();
        Helmet helmet = new Helmet(HelmetEnum.HELMET_GLADIATOR);
        ActionGenerator generator = o -> {

            if(tImEr.getAndIncrement() > 100) { // every 300 movements will "guard"
                tImEr.set(0);
                return new AttackAction();
            }

            return new MoveAction();
        };

        octopus = new Octopus(generator, 40);

    }

    public synchronized void start(){
        Thread thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
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
        System.out.println("Game stopped");
    }

    private void render() {

        Graphics g = bufferedImage.getGraphics();
        g.drawImage(background, 0, 0, null);
        octopus.render(g);

        // update
        notifyAll(this::update);
    }


    private void tick() {
        octopus.tick();
    }

    private void update(Updatable updatable) {

        Graphics updatableGraphics = updatable.getUpdatableGraphics();
        if(updatableGraphics != null)
            updatableGraphics.drawImage(bufferedImage, 0, 0, null);
        else {
            unRegister(updatable);
            if(observers.size() == 0) stop();
        }

    }

}
