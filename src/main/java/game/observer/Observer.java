package game.observer;

import java.io.Serializable;

public interface Observer extends Serializable {
    void actionOn(Event event);
}
