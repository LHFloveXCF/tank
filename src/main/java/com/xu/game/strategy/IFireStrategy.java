package com.xu.game.strategy;

import com.xu.game.factory.BaseTank;

/**
 * 坦克的发射策略
 */
public interface IFireStrategy {
    void fire(BaseTank tank);
}
