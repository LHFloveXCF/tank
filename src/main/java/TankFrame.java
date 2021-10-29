import java.awt.*;
import java.awt.event.*;

import static java.awt.event.KeyEvent.*;

/**
 * tank
 * 一、让黑色的方块动起来：
 *  1.坦克需要有方向
 *  2.根据不同的方向进行移动
 *  3.让坦克初始的时候是静止的
 * 二、封装的思维过程：
 * 1：此时我们的面板上只有一个黑色的正方形方块，我们可以把他想象成一个坦克，
 * 但是如果我们想要有多个坦克呢？每个坦克的位置都不同呢？
 * 这个时候我们就要抽象出来一个坦克的类，这个坦克包含了起始位置，坦克的移动
 */
public class TankFrame extends Frame {
    private int x = 100, y = 100;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    private boolean moving = false;

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
    }

    class MyKeyListener extends KeyAdapter{
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
                default:
                    break;
            }
            setDir();
        }

        private void setDir() {
            if (!bR && !bL && !bU && !bD) {
                moving = false;
            } else {
                moving = true;
                if (bU) {
                    dir = Dir.UP;
                }
                if (bD) {
                    dir = Dir.DOWN;
                }
                if (bL) {
                    dir = Dir.LEFT;
                }
                if (bR) {
                    dir = Dir.RIGHT;
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
