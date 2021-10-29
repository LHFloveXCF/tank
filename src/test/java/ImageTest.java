import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * tank
 */
public class ImageTest {
    @Test
    public void test1() {
        try {
            BufferedImage image = ImageIO.read(this.getClass().getResourceAsStream("/images/0.gif"));
            Assert.assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
