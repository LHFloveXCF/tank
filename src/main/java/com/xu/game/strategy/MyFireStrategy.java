package com.xu.game.strategy;

import com.xu.game.*;
import com.xu.game.component.def.Tank;
import com.xu.game.factory.BaseTank;

/**
 * tank
 * 我的坦克，可以上下发射子弹
 */
public class MyFireStrategy implements IFireStrategy {
    @Override
    public void fire(BaseTank tank) {
        int bulletX = tank.getX() + TankFrame.tankWidth / 2 - TankFrame.bulletWidth / 2;
        int bulletUpY = tank.getY() + TankFrame.tankHeight / 2 - TankFrame.bulletHeight / 2;
        int bulletDownY = tank.getY() + TankFrame.tankHeight / 2 + TankFrame.bulletHeight / 2;
        Main.FACTORY.create(bulletX, bulletUpY, Dir.UP, tank.getGroup(), tank.getTankFrame());
        Main.FACTORY.create(bulletX, bulletDownY, Dir.DOWN, tank.getGroup(), tank.getTankFrame());
    }
}
