import java.awt.*;
import java.awt.event.*;

/**
 * tank
 */
public class TankFrame extends Frame {
    int x = 100, y = 100;

    public TankFrame() {
        setSize(800, 800);
        setTitle("tank war");
        setResizable(false);
        setVisible(true);

        addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
//        System.out.println("paint");
        g.fillRect(x, y, 50, 50);
        x += 10;
        y += 10;
    }

    static class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("1");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("2");
        }
    }

}
