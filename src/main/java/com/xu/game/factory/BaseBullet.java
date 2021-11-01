package com.xu.game.factory;

import java.awt.*;

/**
 * tank
 */
public class BaseBullet {

    protected boolean live = true;


    public void paint(Graphics graphics){}

    public void collisionDetection(BaseTank baseTank) {
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
