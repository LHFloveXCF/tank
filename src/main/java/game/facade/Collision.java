package game.facade;

import java.io.Serializable;

public interface Collision extends Serializable {
    boolean checkCollision(GameObject o1, GameObject o2);
}
