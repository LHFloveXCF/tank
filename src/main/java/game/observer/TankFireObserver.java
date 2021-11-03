package game.observer;

import game.Tank;

/**
 * tank
 */
public class TankFireObserver implements Observer {

    @Override
    public void actionOn(Event event) {
        if (event instanceof TankFireEvent) {
            TankFireEvent fireEvent = (TankFireEvent) event;
            Tank source = fireEvent.getSource();
            source.fire();
        }
    }
}
