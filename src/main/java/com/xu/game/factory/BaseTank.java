package com.xu.game.factory;

import com.xu.game.Dir;
import com.xu.game.IFireStrategy;

import java.awt.*;

/**
 * tank
 * 这里只抽象了一个方法
 */
public class BaseTank {
    protected boolean live = true;
    protected boolean moving = true;
    protected Dir dir;

    public void paint(Graphics graphics){}

    public void fire(IFireStrategy strategy){}

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
