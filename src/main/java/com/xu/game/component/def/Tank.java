package com.xu.game.component.def;

import com.xu.game.Dir;
import com.xu.game.Group;
import com.xu.game.ResourceManager;
import com.xu.game.TankFrame;
import com.xu.game.factory.BaseTank;
import com.xu.game.strategy.DefaultFireStrategy;
import com.xu.game.strategy.IFireStrategy;

import java.awt.*;

/**
 * tank
 * 坦克
 */
public class Tank extends BaseTank {
    private static final int SPEED = 5;
    public void paint(Graphics g) {
        /*Color color = g.getColor();
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);
        g.setColor(color);*/
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
            fire(new DefaultFireStrategy());
        }
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

    public Tank(int x, int y, Dir dir, TankFrame tankFrame, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
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
        tankFrame.bullets.add(new Bullet(bulletX, bulletY, dir, group, tankFrame));
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