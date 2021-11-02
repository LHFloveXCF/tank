package game.facade;

import java.awt.*;

/**
 * tank
 */
public class Wall extends GameObject {
    int x, y;
    private int width;
    private int height;
    private Rectangle rectangle;

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rectangle = new Rectangle();
        rectangle.x = x;
        rectangle.y = y;
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(x, y,50, 100);
        g.setColor(color);
    }
}
