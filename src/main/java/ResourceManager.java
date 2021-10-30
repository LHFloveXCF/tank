import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * tank
 */
public class ResourceManager {
    public static BufferedImage tankU, tankD, tankL, tankR;
    public static BufferedImage bulletU, bulletD, bulletL, bulletR;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            tankU = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankU.gif"));
            tankD = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankD.gif"));
            tankL = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankL.gif"));
            tankR = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankR.gif"));

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
