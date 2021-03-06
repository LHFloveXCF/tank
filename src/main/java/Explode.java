import java.awt.*;

/**
 * tank
 * 爆炸
 */
public class Explode {
    private int x;
    private int y;
    /** 爆炸当前帧 */
    private int step;
    private TankFrame tankFrame;
    private boolean live = true;

    public void paint(Graphics g) {
        if (step >= ResourceManager.explodes.length) {
            live = false;
            return;
        }
        g.drawImage(ResourceManager.explodes[step++], x, y, null);
    }

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
        this.step = 0;
        new Thread(() -> new Audio("audio/explode.wav").play()).start();
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
