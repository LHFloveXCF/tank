package game.decorate;

import game.facade.GameObject;

import java.awt.*;

/**
 * tank
 */
public class RectangleBulletDecorate extends GameObjectDecorate {

    public RectangleBulletDecorate(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.RED);
        graphics.fillRect(gameObject.getX(), gameObject.getY(), getWidth() + 2, getHeight() + 2);
        graphics.setColor(color);
    }

    @Override
    public int getWidth() {
        return gameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return gameObject.getHeight();
    }
}
