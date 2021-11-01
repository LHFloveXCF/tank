package com.xu.game.factory;

import com.xu.game.Dir;
import com.xu.game.Group;
import com.xu.game.TankFrame;

public interface AbstractGameFactory {
    /**
     * 坦克工厂
     * @param x
     * @param y
     * @param dir
     * @param tankFrame
     * @param group
     * @return
     */
    BaseTank create(int x, int y, Dir dir, TankFrame tankFrame, Group group);

    /**
     * 子弹工厂
     * @param x
     * @param y
     * @param dir
     * @param group
     * @param tankFrame
     * @return
     */
    BaseBullet create(int x, int y, Dir dir, Group group, TankFrame tankFrame);

    /**
     * 爆炸工厂
     * @param x
     * @param y
     * @param tankFrame
     * @return
     */
    BaseExplode create(int x, int y, TankFrame tankFrame);
}
