/**
 * tank
 */
public class Main {
    private static final int TANKS_COUNT = 5;
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        for (int i = 0; i < TANKS_COUNT; i++) {
            tankFrame.tanks.add(new Tank(100 + i * 60, 100, Dir.DOWN, tankFrame, Group.BAD));
        }

        while (true) {
            Thread.sleep(100L);
            tankFrame.repaint();
        }
    }
}
