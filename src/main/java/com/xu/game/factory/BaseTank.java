package com.xu.game.factory;

import com.xu.game.Dir;
import com.xu.game.Group;
import com.xu.game.TankFrame;
import com.xu.game.strategy.IFireStrategy;

import java.awt.*;

/**
 * tank
 * 这里只抽象了一个方法
 */
public abstract class BaseTank {
    protected boolean live = true;
    protected boolean moving = true;
    protected Dir dir;
    protected int x, y;
    protected Group group;
    protected Rectangle rectangle;
    protected TankFrame tankFrame;

    public abstract void paint(Graphics graphics);

    /**
     * 根据策略发射子弹
     * version 1.0.1
     *
     * @param fireStrategy
     */
    public void fire(IFireStrategy fireStrategy) {
        fireStrategy.fire(this);
    }

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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public TankFrame getTankFrame() {
        return tankFrame;
    }

    public void setTankFrame(TankFrame tankFrame) {
        this.tankFrame = tankFrame;
    }
}
