package game.facade;

import game.Bullet;

/**
 * tank
 */
public class WallBulletCollision implements Collision {
    @Override
    public boolean checkCollision(GameObject o1, GameObject o2) {
        if (o1 instanceof Wall && o2 instanceof Bullet) {
            return collisionDetect((Bullet)o2, (Wall)o1);
        } else if (o2 instanceof Wall && o1 instanceof Bullet) {
            return collisionDetect((Bullet)o1, (Wall)o2);
        } else {
            return false;
        }
    }

    private boolean collisionDetect(Bullet o2, Wall o1) {
        if (o2.getRectangle().intersects(o1.getRectangle())) {
            o2.getGm().list.remove(o2);
        }
        return false;
    }
}
