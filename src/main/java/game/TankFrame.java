package game;

import game.facade.GameModel;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

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
 * 5：给坦克添加图片
 * 6：给子弹添加图片
 * 7：增加敌军坦克
 * 8：让敌方坦克发射子弹
 */
public class TankFrame extends Frame {
    public static final int GAME_WIDTH = PropertiesManager.getInstance().getIntValue("game_width"),
            GAME_HEIGHT = PropertiesManager.getInstance().getIntValue("game_height");
    public static int bulletWidth = ResourceManager.bulletD.getWidth();
    public static int bulletHeight = ResourceManager.bulletD.getHeight();
    public static int tankWidth = ResourceManager.goodTankU.getWidth();
    public static int tankHeight = ResourceManager.goodTankU.getHeight();


    public GameModel gameModel = new GameModel();

    Tank myTank = new Tank(100, 100, Dir.DOWN, gameModel, Group.GOOD);


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

    /**
     * 双缓冲解决闪烁问题
     */
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
        // g.drawString("子弹数量 : " + bullets.size(), 10, 40);
        // g.drawString("敌方坦克数量 : " + tanks.size(), 10, 60);
        g.setColor(color);

        myTank.paint(g);

        gameModel.checkValid(g);
        gameModel.checkCollision();
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            myTank.keyPressEvent(e);
        }
        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keyReleasedEvent(e);
        }
    }

}
