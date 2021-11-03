package game.facade;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * tank
 */
public abstract class GameObject {

    protected boolean live = true;

    protected int x, y;

    public abstract void paint(Graphics g);

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void keyPressEvent(KeyEvent event){}

    public void keyReleasedEvent(KeyEvent event) {}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract int getWidth();

    public abstract int getHeight();
}
