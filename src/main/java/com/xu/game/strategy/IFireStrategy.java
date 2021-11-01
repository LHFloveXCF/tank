package com.xu.game.strategy;

import com.xu.game.Tank;

/**
 * 坦克的发射策略
 */
public interface IFireStrategy {
    void fire(Tank tank);
}
