package com.xu.game;

import com.xu.game.factory.AbstractGameFactory;
import com.xu.game.factory.DefaultGameFactory;

/**
 * tank
 */
public class Main {
    // private static final int TANKS_COUNT = com.xu.game.PropertiesManager.getIntValue("tank");
    private static final int TANKS_COUNT = PropertiesManager.getInstance().getIntValue("tank");
    public static void main(String[] args) throws InterruptedException {
        AbstractGameFactory factory = DefaultGameFactory.getInstance();
        TankFrame tankFrame = new TankFrame();
        for (int i = 0; i < TANKS_COUNT; i++) {
            tankFrame.tanks.add(factory.create(100 + i * 60, 100, Dir.DOWN, tankFrame, Group.BAD));
        }

        while (true) {
            Thread.sleep(100L);
            tankFrame.repaint();
        }
    }
}
