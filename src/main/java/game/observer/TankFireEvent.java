package game.observer;

import game.Tank;

/**
 * tank
 */
public class TankFireEvent extends Event<Tank> {
    Tank tank;

    public TankFireEvent (Tank tank) {
        this.tank = tank;
    }

    @Override
    Tank getSource() {
        return this.tank;
    }

}
