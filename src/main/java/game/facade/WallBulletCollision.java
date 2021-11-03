package game.facade;

import game.Bullet;

/**
 * tank
 */
public class WallBulletCollision implements Collision {
    @Override
    public boolean checkCollision(GameObject o1, GameObject o2) {
        if (o1 instanceof Wall && o2 instanceof Bullet) {
            Bullet b = (Bullet) o2;
            Wall w = (Wall) o1;
            if (b.getRectangle().intersects(w.getRectangle())) {
                b.getGm().list.remove(o2);
            }
            return false;
        } else if (o2 instanceof Wall && o1 instanceof Bullet) {
            return checkCollision(o2, o1);
        } else {
            return false;
        }
    }
}
