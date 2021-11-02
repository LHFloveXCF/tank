package game;

import game.facade.GameModel;
import game.facade.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

/**
 * tank
 * 坦克
 */
public class Tank extends GameObject {
    private int x, y;
    private Dir dir;
    private static final int SPEED = 5;
    private boolean moving = true;
    private GameModel gm;
    private Group group;
    private Rectangle rectangle;

    boolean bU = false;
    boolean bD = false;
    boolean bL = false;
    boolean bR = false;
    /** 上一个位置 */
    int oldX, oldY;

    @Override
    public void keyPressEvent(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case VK_DOWN:
                bD = true;
                break;
            case VK_UP:
                bU = true;
                break;
            case VK_LEFT:
                bL = true;
                break;
            case VK_RIGHT:
                bR = true;
                break;
            case VK_CONTROL:
                // 1.0.0版本
                fire();
            default:
                break;
        }
        setDir();
    }

    private void setDir() {
        if (!bR && !bL && !bU && !bD) {
            setMoving(false);
        } else {
            setMoving(true);
            if (bU) {
                setDir(Dir.UP);
            }
            if (bD) {
                setDir(Dir.DOWN);
            }
            if (bL) {
                setDir(Dir.LEFT);
            }
            if (bR) {
               setDir(Dir.RIGHT);
            }
        }
    }

    @Override
    public void keyReleasedEvent(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case VK_DOWN:
                bD = false;
                break;
            case VK_UP:
                bU = false;
                break;
            case VK_LEFT:
                bL = false;
                break;
            case VK_RIGHT:
                bR = false;
                break;
            default:
                break;
        }
        setDir();
    }

    public void paint(Graphics g) {
        switch (dir) {
            case UP:
                g.drawImage(group == Group.GOOD ? ResourceManager.goodTankU : ResourceManager.badTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(group == Group.GOOD ? ResourceManager.goodTankD : ResourceManager.badTankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(group == Group.GOOD ? ResourceManager.goodTankL : ResourceManager.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(group == Group.GOOD ? ResourceManager.goodTankR : ResourceManager.badTankR, x, y, null);
                break;
            default:
                break;
        }
        randomDir();
        move();
    }

    /**
     * 敌方坦克随机移动
     */
    private void randomDir() {
        if (group == Group.BAD && (Math.random() * 100) < 10) {
            int dirIndex = (int) (Math.random() * Dir.values().length);
            dir = Dir.values()[dirIndex];
        }
    }

    private void move() {
        if (!moving) {
            return;
        }

        setOldPosition(x, y);

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

        checkBoundary();


        rectangle.x = x;
        rectangle.y = y;

        // 如果是地方坦克，判断是否需要发射子弹
        if (group == Group.BAD && Math.random() * 100 < 10) {
            // 1.0.0版本
            // fire(new game.DefaultFireStrategy());
            fire();
        }
    }

    private void setOldPosition(int x, int y) {
        this.oldX = x;
        this.oldY = y;
    }

    /**
     * 碰撞后回到上一个位置
     */
    public void back() {
        this.x = oldX;
        this.y = oldY;
    }

    private void checkBoundary() {
        if (x < 30) {
            x = 30;
        }
        if (y < 0) {
            y = 30;
        }
        if (x > TankFrame.GAME_WIDTH - TankFrame.tankWidth) {
            x = TankFrame.GAME_WIDTH - TankFrame.tankWidth;
        }
        if (y > TankFrame.GAME_HEIGHT - TankFrame.tankHeight) {
            y = TankFrame.GAME_HEIGHT - TankFrame.tankHeight;
        }
    }

    public Tank(int x, int y, Dir dir, GameModel gm, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
        this.group = group;
        rectangle = new Rectangle();
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = TankFrame.tankWidth;
        rectangle.height = TankFrame.tankHeight;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * 坦克发射子弹的时候定位子弹的初始位置
     * version 1.0.0
     */
    public void fire() {
        int bulletX = x + TankFrame.tankWidth / 2 - TankFrame.bulletWidth / 2;
        int bulletY = y + TankFrame.tankHeight / 2 - TankFrame.bulletHeight / 2;
        gm.addObject(new Bullet(bulletX, bulletY, dir, group, gm));
    }

    /**
     * 根据策略发射子弹
     * version 1.0.1
     *
     * @param fireStrategy
     */
    public void fire(IFireStrategy fireStrategy) {
        fireStrategy.fire(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public GameModel getGm() {
        return gm;
    }
}
