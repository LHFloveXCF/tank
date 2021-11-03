package game.facade;

import game.Dir;
import game.Group;
import game.Tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * tank
 */
public class GameModel {
    List<GameObject> list = new ArrayList<>();
    List<Collision> collisions = new LinkedList<>();

    private Tank myTank = new Tank(100, 100, Dir.DOWN, this, Group.GOOD);

    public GameModel() {
        collisions.add(new CollisionChain());

        list.add(new Wall(130, 130, 100, 30));
        list.add(new Wall(230, 330, 30, 30));
        list.add(new Wall(230, 430, 149, 22));
    }

    public void addObject(GameObject gameObject) {
        list.add(gameObject);
    }

    public void checkValid(Graphics g) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isLive()) {
                list.get(i).paint(g);
            }
        }
    }

    public void checkCollision() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (Collision collision : collisions) {
                    if (collision.checkCollision(list.get(i), list.get(j))) {
                        break;
                    }
                }
            }
        }
    }

    public Tank getMyTank() {
        return myTank;
    }
}
