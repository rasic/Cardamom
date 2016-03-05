package core;

import cardamom.Image;
import java.awt.Color;

/**
 *
 * @author Ondřej Bleha
 */
class ImagePull {
    private final Image image;
    
    public ImagePull(Image image){
        this.image = image;
    }
    
    public String make(){
        ImageIterator iter = new ImageIterator(image);
        String text = "";
        String binary = "";
        
        for (int i = 0; i < image.getPixelsCount(); i++) {
            if(binary.length() == 9){                
                text += (char) Integer.parseInt(binary, 2);
                binary = "";
            }
            
            Color color = iter.getNext();
            binary += toBit(color.getRed());
            binary += toBit(color.getGreen());
            binary += toBit(color.getBlue());
            if(text.endsWith("\n")){
                break;
            }
        }
        
        return text.substring(0, text.length()-1);
    }
    
    private int toBit(int cislo){
        int pom = cislo/2;
        pom *= 2;
        if(cislo == pom){
            return 0;
        }
        return 1;
    }
}
