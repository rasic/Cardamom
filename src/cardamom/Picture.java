package cardamom;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Ondřej Bleha
 */
public class Picture {
    private BufferedImage image;
    private BufferedImage original;
    
    public Picture() {
        original = new BufferedImage(20, 20, 1);
    }
    
    public void loadPicture(File file){
        try {
            image = ImageIO.read(file);
            original = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(Picture.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public Icon getIcon(int width, int height){
        if (width > height){
            height = (original.getHeight()*width)/original.getWidth();
        }else if (height > width){
            width = (original.getWidth()*height)/original.getHeight();
        }
        return new ImageIcon(original.getScaledInstance(width, height, 1));
    }
}
