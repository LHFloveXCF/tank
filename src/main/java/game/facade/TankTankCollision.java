package game.facade;

import game.Bullet;
import game.Explode;
import game.Tank;
import game.TankFrame;

/**
 * tank
 */
public class TankTankCollision implements Collision {
    @Override
    public boolean checkCollision(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            return collisionDetect((Tank) o1, (Tank)o2);
        }
        return false;
    }

    private boolean collisionDetect(Tank t1, Tank t2) {
        if (t1.getRectangle().intersects(t2.getRectangle())) {
            t1.back();
            t2.back();
            // return true;
        }
        return false;
    }
}
