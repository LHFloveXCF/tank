package com.xu.game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * tank
 */
public class ResourceManager {
    // public static BufferedImage tankU, tankD, tankL, tankR;
    public static BufferedImage goodTankU, goodTankD, goodTankL, goodTankR;
    public static BufferedImage badTankU, badTankD, badTankL, badTankR;

    public static BufferedImage bulletU, bulletD, bulletL, bulletR;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            // tankU = ImageIO.read(com.xu.game.ResourceManager.class.getResourceAsStream("/images/tankU.gif"));
            // tankD = ImageIO.read(com.xu.game.ResourceManager.class.getResourceAsStream("/images/tankD.gif"));
            // tankL = ImageIO.read(com.xu.game.ResourceManager.class.getResourceAsStream("/images/tankL.gif"));
            // tankR = ImageIO.read(com.xu.game.ResourceManager.class.getResourceAsStream("/images/tankR.gif"));

            goodTankU = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/GoodTank1.png"));
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);

            badTankU = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/BadTank1.png"));
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankL = ImageUtil.rotateImage(badTankU, -90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);


            bulletU = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/bulletU.gif"));
            bulletD = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/bulletD.gif"));
            bulletL = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/bulletL.gif"));
            bulletR = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/bulletR.gif"));

            for (int i = 0; i < explodes.length; i++) {
                String sb = "/images/e" +
                        (i + 1) +
                        ".gif";
                explodes[i] = ImageIO.read(ResourceManager.class.getResourceAsStream(sb));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
