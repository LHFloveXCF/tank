import java.awt.*;

/**
 * tank
 * 子弹
 */
public class Bullet {
    private int x, y;
    private static final int SPEED = 20;
    private static final int WIDTH = 30, HEIGHT = 30;
    private Dir dir;
    private boolean live = true;
    private Group group;
    private TankFrame tankFrame;
    private Rectangle rectangle;

    public void paint(Graphics g) {
        /*Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH, HEIGHT);
        g.setColor(color);*/

        addBuffImage(g);
        move();

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }

    private void addBuffImage(Graphics g) {
        switch (dir) {
            case UP:
                g.drawImage(ResourceManager.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR, x, y, null);
                break;
            default:
                break;
        }
    }

    private void move() {
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
    }

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
        rectangle = new Rectangle();
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = TankFrame.bulletWidth;
        rectangle.height = TankFrame.bulletHeight;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void collisionDetection(Tank tank) {
        if (group == tank.getGroup()) {
            return;
        }
        /*// 每次碰撞检测都新建对象，这个地方是存在问题的
        Rectangle bulletRectangle = new Rectangle(x,y);
        Rectangle tankRectangle = new Rectangle(tank.getX(), tank.getY());
        if (bulletRectangle.intersects(tankRectangle)) {
            tankFrame.tanks.remove(tank);
            setLive(false);
        }*/

        if (isLive() && tank.isLive() && rectangle.intersects(tank.getRectangle())) {
            tank.setLive(false);
            setLive(false);
        }
    }
}
