package com.xu.game.factory;

import java.awt.*;

/**
 * tank
 */
public abstract class BaseExplode {

    protected boolean live = true;

    public abstract void paint(Graphics g);

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
