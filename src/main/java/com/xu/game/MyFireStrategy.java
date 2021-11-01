package com.xu.game;

/**
 * tank
 * 我的坦克，可以上下发射子弹
 */
public class MyFireStrategy implements IFireStrategy {
    @Override
    public void fire(Tank tank) {
        int bulletX = tank.getX() + TankFrame.tankWidth / 2 - TankFrame.bulletWidth / 2;
        int bulletUpY = tank.getY() + TankFrame.tankHeight / 2 - TankFrame.bulletHeight / 2;
        int bulletDownY = tank.getY() + TankFrame.tankHeight / 2 + TankFrame.bulletHeight / 2;
        new Bullet(bulletX, bulletUpY, Dir.UP, tank.getGroup(), tank.getTankFrame());
        new Bullet(bulletX, bulletDownY, Dir.DOWN, tank.getGroup(), tank.getTankFrame());
    }
}
