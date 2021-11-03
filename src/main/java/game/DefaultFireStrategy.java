package game;

/**
 * tank
 */
public class DefaultFireStrategy implements IFireStrategy {
    @Override
    public void fire(Tank tank) {
        int bulletX = tank.getX() + Tank.WIDTH / 2 - TankFrame.bulletWidth / 2;
        int bulletDownY = tank.getY() + Tank.HEIGHT / 2 - TankFrame.bulletHeight / 2;
        new Bullet(bulletX, bulletDownY, tank.getDir(), tank.getGroup(), null);
    }
}
