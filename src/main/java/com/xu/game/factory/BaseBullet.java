package com.xu.game.factory;

import java.awt.*;

/**
 * tank
 */
public abstract class BaseBullet {

    /** 子弹是否存活 */
    protected boolean live = true;

    /**
     * 绘制
     * @param graphics
     */
    public abstract void paint(Graphics graphics);

    /**
     * 碰撞检测
     * @param baseTank
     */
    public abstract void collisionDetection(BaseTank baseTank);

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
