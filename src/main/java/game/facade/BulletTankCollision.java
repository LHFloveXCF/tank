package game.facade;

import game.Bullet;
import game.Explode;
import game.Tank;
import game.TankFrame;

/**
 * tank
 */
public class BulletTankCollision implements Collision {
    @Override
    public boolean checkCollision(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            return collisionDetect((Bullet) o1, (Tank)o2);
        } else if (o2 instanceof Bullet && o1 instanceof Tank) {
            return collisionDetect((Bullet) o2, (Tank)o1);
        }
        return false;
    }

    private boolean collisionDetect(Bullet bullet, Tank tank) {
        if (bullet.getGroup() == tank.getGroup()) {
            return false;
        }
        if (bullet.isLive() && tank.isLive() && bullet.getRectangle().intersects(tank.getRectangle())) {
            tank.setLive(false);
            bullet.setLive(false);
            bullet.getGm().list.remove(bullet);
            tank.getGm().list.remove(tank);
            int eX = tank.getX() + TankFrame.tankWidth / 2 - Bullet.WIDTH / 2;
            int eY = tank.getY() + TankFrame.tankHeight / 2 - Bullet.HEIGHT / 2;
            bullet.getGm().addObject(new Explode(eX, eY, bullet.getGm()));
            return true;
        }
        return false;
    }
}
