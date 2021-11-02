package game.facade;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * tank
 */
public class GameObject {

    protected boolean live = true;

    public void paint(Graphics g) {}

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void keyPressEvent(KeyEvent event){}

    public void keyReleasedEvent(KeyEvent event) {}
}
