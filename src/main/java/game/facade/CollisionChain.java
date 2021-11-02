package game.facade;

import java.util.LinkedList;
import java.util.List;

/**
 * tank
 */
public class CollisionChain implements Collision {

    private List<Collision> list = new LinkedList<>();

    public CollisionChain() {
        addCollision(new BulletTankCollision());
        addCollision(new TankTankCollision());
    }

    public void addCollision(Collision collision) {
        list.add(collision);
    }

    @Override
    public boolean checkCollision(GameObject o1, GameObject o2) {
        for (Collision collision : list) {
            boolean checkCollision = collision.checkCollision(o1, o2);
            if (checkCollision) {
                return true;
            }
        }
        return false;
    }
}
