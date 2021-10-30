import java.awt.*;

/**
 * tank
 */
public class Tank {
    private int x, y;
    private Dir dir;
    private static final int SPEED = 5;
    private boolean moving = true;
    private TankFrame tankFrame;
    private Group group;
    private Rectangle rectangle;
    private boolean live = true;

    public void paint(Graphics g) {
        /*Color color = g.getColor();
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);
        g.setColor(color);*/
        switch (dir) {
            case UP:
                g.drawImage(ResourceManager.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.tankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.tankR, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        if (!moving) {
            return;
        }
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }

        rectangle.x = x;
        rectangle.y = y;

        // 如果是地方坦克，判断是否需要发射子弹
        if (group == Group.BAD && Math.random() * 100 < 50) {
            fire();
        }
    }

    public Tank(int x, int y, Dir dir, TankFrame tankFrame, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;
        rectangle = new Rectangle();
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = TankFrame.tankWidth;
        rectangle.height = TankFrame.tankHeight;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * 坦克发射子弹的时候定位子弹的初始位置
     */
    public void fire() {
        int bulletX = x + TankFrame.tankWidth / 2 - TankFrame.bulletWidth / 2;
        int bulletY = y + TankFrame.tankHeight / 2 - TankFrame.bulletHeight / 2;
        tankFrame.bullets.add(new Bullet(bulletX, bulletY, dir, group, tankFrame));
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
