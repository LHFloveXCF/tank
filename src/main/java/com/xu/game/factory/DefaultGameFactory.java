package com.xu.game.factory;

import com.xu.game.Dir;
import com.xu.game.Group;
import com.xu.game.Tank;
import com.xu.game.TankFrame;

/**
 * tank
 */
public class DefaultGameFactory implements AbstractGameFactory {
    private DefaultGameFactory() {
    }

    static class InnerDefaultGameFactory {
        private static final DefaultGameFactory FACTORY = new DefaultGameFactory();
    }

    public static DefaultGameFactory getInstance() {
        return InnerDefaultGameFactory.FACTORY;
    }

    @Override
    public BaseTank create(int x, int y, Dir dir, TankFrame tankFrame, Group group) {
        return new Tank(x, y, dir, tankFrame, group);
    }

    @Override
    public BaseBullet create(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return null;
    }

    @Override
    public BaseExplode create(int x, int y, TankFrame tankFrame) {
        return null;
    }
}
