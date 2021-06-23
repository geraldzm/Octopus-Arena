package game.model;

import java.awt.*;

public class GameObjectHandler extends Handler<GameObject> implements ITickable, IRenderable {

    public GameObjectHandler() {
        super();
    }

    @Override
    public void tick(){
        for (int i = 0; i < getList().size(); i++)
            getList().get(i).tick();
    }

    @Override
    public void render(Graphics g){
        for (int i = 0; i < getList().size(); i++)
            getList().get(i).render(g);

    }

}