package core;

import cardamom.Image;
import java.awt.Color;

/**
 *
 * @author Ondřej Bleha
 */
public class ImageIterator {
    private final Image image;
    private int x;
    private int y;
    
    public ImageIterator(Image image){
        this.image = image;
        this.x = 0;
        this.y = 0;
    }
    
    public void vynulujIterator(){
        this.x = 0;
        this.y = 0;
    }
    
    public Color getNext(){
        x++;
        if(x > image.getWidth()){
            x = 0;
            y++;
        }
        return getActual();
    }
    
    public Color getActual(){
        return new Color(image.getRGB(x, y));
    }
    
    public void setActual(Color color){
        image.setRGB(x, y, color.getRGB());
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}
