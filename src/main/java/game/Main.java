package game;

/**
 * tank
 */
public class Main {
    private static final int TANKS_COUNT = PropertiesManager.getInstance().getIntValue("tank");

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        for (int i = 0; i < 1; i++) {
            tankFrame.gameModel.addObject(new Tank(100 + i * 60, 100, Dir.DOWN, tankFrame.gameModel, Group.BAD));
        }
        while (true) {
            Thread.sleep(100L);
            tankFrame.repaint();
        }
    }
}
