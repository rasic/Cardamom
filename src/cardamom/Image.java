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
public class Image {
    private BufferedImage image;
    private BufferedImage original;
    
    public Image() {
        original = new BufferedImage(20, 20, 1);
    }
    
    public void loadPicture(File file){
        try {
            image = ImageIO.read(file);
            original = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public int getWidth(){
        return image.getWidth();
    }
    
    public int getHeight(){
        return image.getHeight();
    }
    
    public int getPixelsCount(){
        return image.getWidth()*image.getHeight();
    }
    
    private int getRGB(int x, int y, BufferedImage image){
        if(x < getWidth() && y < getHeight() && x > 0 && y > 0){
            return image.getRGB(x, y);
        }else if (x < getWidth() && x > 0){
            if(y >= getHeight()){
                return image.getRGB(x, y-getHeight());
            }else{
                return image.getRGB(x, y+getHeight());
            }
        }else{
            if(x >= getWidth()){
                return image.getRGB(x-getWidth(), y);
            }else{
                return image.getRGB(x+getWidth(), y);
            }
        }
    }
    
    public int getRGB(int x, int y){
        //return getRGB(x, y, this.image);
        return image.getRGB(x, y);
    }
    
    public void setRGB(int x, int y, int rgb){
        //if(x < getWidth() && y < getHeight() && x > 0 && y > 0){
            image.setRGB(x, y, rgb);
        //}
    }
    
    public Icon getIcon(int width, int height){
        if (width > height){
            height = (original.getHeight()*width)/original.getWidth();
        }else if (height > width){
            width = (original.getWidth()*height)/original.getHeight();
        }
        return new ImageIcon(original.getScaledInstance(width, height, 1));
    }
    
    public void saveImage(String ref) {  
        try {  
            String format = "png";
            ImageIO.write(image, format, new File(ref));  
        } catch (IOException e) {
            e.printStackTrace();  
        }  
    }  
}
