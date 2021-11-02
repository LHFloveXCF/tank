package game;

import game.facade.GameModel;
import game.facade.GameObject;

import java.awt.*;

/**
 * tank
 * 子弹
 */
public class Bullet extends GameObject {
    private int x, y;
    private static final int SPEED = 20;
    public static final int WIDTH = ResourceManager.explodes[0].getWidth(), HEIGHT = ResourceManager.explodes[0].getHeight();
    private Dir dir;
    private Group group;
    private GameModel gm;
    private Rectangle rectangle;

    public void paint(Graphics g) {
        /*Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH, HEIGHT);
        g.setColor(color);*/

        addBuffImage(g);
        move();

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }

    private void addBuffImage(Graphics g) {
        switch (dir) {
            case UP:
                g.drawImage(ResourceManager.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR, x, y, null);
                break;
            default:
                break;
        }
    }

    private void move() {
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
        rectangle.x = x;
        rectangle.y = y;
    }

    public Bullet(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;
        rectangle = new Rectangle();
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = TankFrame.bulletWidth;
        rectangle.height = TankFrame.bulletHeight;
        gm.addObject(this);
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Group getGroup() {
        return group;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public GameModel getGm() {
        return gm;
    }
}
