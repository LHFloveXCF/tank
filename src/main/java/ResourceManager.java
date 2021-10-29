import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * tank
 */
public class ResourceManager {
    public static BufferedImage tankU, tankD, tankL, tankR;

    static {
        try {
            tankU = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankU.gif"));
            tankD = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankD.gif"));
            tankL = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankL.gif"));
            tankR = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankR.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
