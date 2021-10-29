import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.awt.event.KeyEvent.*;

/**
 * tank
 * 一、让黑色的方块动起来：
 * 1.坦克需要有方向
 * 2.根据不同的方向进行移动
 * 3.让坦克初始的时候是静止的
 * 二、封装的思维过程：
 * 1：此时我们的面板上只有一个黑色的正方形方块，我们可以把他想象成一个坦克，
 * 但是如果我们想要有多个坦克呢？每个坦克的位置都不同呢？
 * 这个时候我们就要抽象出来一个坦克的类，这个坦克包含了起始位置，坦克的移动
 * 2：封装一个子弹bullet对象，并让子弹可以移动
 * 3：让坦克发射一枚子弹
 * 4：让坦克发射多个子弹,让坦克持有一个画板的引用，这样可以将生成的子弹发送到画板上。
 */
public class TankFrame extends Frame {
    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 800;
    List<Bullet> bullets = new ArrayList<>();
    Tank myTank = new Tank(200, 200, Dir.DOWN, this);
    Bullet bullet = new Bullet(300, 300, Dir.DOWN);

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

    Image offImage = null;
    @Override
    public void update(Graphics g) {
        if (null == offImage) {
            offImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics offImageGraphics = offImage.getGraphics();
        Color color = offImageGraphics.getColor();
        offImageGraphics.setColor(Color.BLACK);
        offImageGraphics.fillRect(0, 0,GAME_WIDTH, GAME_HEIGHT);
        offImageGraphics.setColor(color);
        paint(offImageGraphics);
        g.drawImage(offImage,0,0,null);
    }

    @Override
    public void paint(Graphics g) {

        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("bullet count : " + bullets.size(), 10, 40);
        g.setColor(color);

        myTank.paint(g);

        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            Bullet next = iterator.next();
            if (next.isLive()) {
                next.paint(g);
            } else {
                iterator.remove();
            }
        }
    }

    class MyKeyListener extends KeyAdapter {
        boolean bU = false;
        boolean bD = false;
        boolean bL = false;
        boolean bR = false;

        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println("1");
            int code = e.getKeyCode();
            switch (code) {
                case VK_DOWN:
                    bD = true;
                    break;
                case VK_UP:
                    bU = true;
                    break;
                case VK_LEFT:
                    bL = true;
                    break;
                case VK_RIGHT:
                    bR = true;
                    break;
                case VK_CONTROL:
                    myTank.fire();
                default:
                    break;
            }
            setDir();
        }

        private void setDir() {
            if (!bR && !bL && !bU && !bD) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bU) {
                    myTank.setDir(Dir.UP);
                }
                if (bD) {
                    myTank.setDir(Dir.DOWN);
                }
                if (bL) {
                    myTank.setDir(Dir.LEFT);
                }
                if (bR) {
                    myTank.setDir(Dir.RIGHT);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
//            System.out.println("2");
            int code = e.getKeyCode();
            switch (code) {
                case VK_DOWN:
                    bD = false;
                    break;
                case VK_UP:
                    bU = false;
                    break;
                case VK_LEFT:
                    bL = false;
                    break;
                case VK_RIGHT:
                    bR = false;
                    break;
                default:
                    break;
            }
            setDir();
        }
    }

}
