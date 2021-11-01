package com.xu.game;

/**
 * tank
 */
public class DefaultFireStrategy implements IFireStrategy {
    @Override
    public void fire(Tank tank) {
        int bulletX = tank.getX() + TankFrame.tankWidth / 2 - TankFrame.bulletWidth / 2;
        int bulletDownY = tank.getY() + TankFrame.tankHeight / 2 - TankFrame.bulletHeight / 2;
        new Bullet(bulletX, bulletDownY, tank.getDir(), tank.getGroup(), tank.getTankFrame());
    }
}
