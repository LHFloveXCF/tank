package game;

import game.facade.GameModel;
import game.facade.GameObject;

import java.awt.*;

/**
 * tank
 * 爆炸
 */
public class Explode extends GameObject {
    /** 爆炸当前帧 */
    private int step;
    private GameModel gm;

    public void paint(Graphics g) {
        if (step >= ResourceManager.explodes.length) {
            live = false;
            return;
        }
        g.drawImage(ResourceManager.explodes[step++], x, y, null);
    }

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
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
}
