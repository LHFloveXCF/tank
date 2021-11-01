package com.xu.game.component.strange;

import com.xu.game.Audio;
import com.xu.game.ResourceManager;
import com.xu.game.TankFrame;
import com.xu.game.factory.BaseExplode;

import java.awt.*;

/**
 * tank
 * 爆炸
 */
public class StrangeExplode extends BaseExplode {
    private int x;
    private int y;
    /** 爆炸当前帧 */
    private int step;
    private TankFrame tankFrame;


    public void paint(Graphics g) {
        if (step >= ResourceManager.explodes.length) {
            live = false;
            return;
        }
        step++;
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y,50,50);
        g.setColor(color);
    }

    public StrangeExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
        this.step = 0;
        new Thread(() -> new Audio("/audio/explode.wav").play()).start();
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

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
