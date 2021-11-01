package com.xu.game.strategy;

import com.xu.game.Main;
import com.xu.game.TankFrame;
import com.xu.game.factory.BaseTank;

/**
 * tank
 */
public class DefaultFireStrategy implements IFireStrategy {
    @Override
    public void fire(BaseTank tank) {
        int bulletX = tank.getX() + TankFrame.tankWidth / 2 - TankFrame.bulletWidth / 2;
        int bulletDownY = tank.getY() + TankFrame.tankHeight / 2 - TankFrame.bulletHeight / 2;
        Main.FACTORY.create(bulletX, bulletDownY, tank.getDir(), tank.getGroup(), tank.getTankFrame());
    }
}
