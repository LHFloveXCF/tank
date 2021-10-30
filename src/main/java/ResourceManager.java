import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * tank
 */
public class ResourceManager {
    public static BufferedImage tankU, tankD, tankL, tankR;
    public static BufferedImage bulletU, bulletD, bulletL, bulletR;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
