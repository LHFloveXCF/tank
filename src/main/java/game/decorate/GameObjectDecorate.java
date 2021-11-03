package game.decorate;

import game.facade.GameObject;

import java.awt.*;

/**
 * tank
 */
public abstract class GameObjectDecorate extends GameObject {
    protected GameObject gameObject;

    public GameObjectDecorate(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public abstract void paint(Graphics graphics);
}
