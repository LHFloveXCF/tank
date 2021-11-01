package com.xu.game.factory;

import com.xu.game.Dir;
import com.xu.game.Group;
import com.xu.game.TankFrame;
import com.xu.game.component.def.Explode;
import com.xu.game.component.def.Tank;
import com.xu.game.component.strange.StrangeBullet;
import com.xu.game.component.strange.StrangeExplode;
import com.xu.game.component.strange.StrangeTank;

/**
 * tank
 * 奇怪的游戏工厂，生产一些奇怪的坦克、子弹、和爆炸
 */
public class StrangeGameFactory implements AbstractGameFactory{

    public static StrangeGameFactory getInstance() {
        return InnerStrangeGameFactory.FACTORY;
    }

    private StrangeGameFactory() {}

    private static class InnerStrangeGameFactory {
        private static final StrangeGameFactory FACTORY = new StrangeGameFactory();
    }

    @Override
    public BaseTank create(int x, int y, Dir dir, TankFrame tankFrame, Group group) {
        return new StrangeTank(x, y, dir, tankFrame, group);
    }

    @Override
    public BaseBullet create(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new StrangeBullet(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseExplode create(int x, int y, TankFrame tankFrame) {
        return new StrangeExplode(x, y, tankFrame);
    }
}
