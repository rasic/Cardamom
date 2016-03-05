package core;

import cardamom.Image;
import java.awt.Color;

/**
 *
 * @author Ondřej Bleha
 */
class ImagePush {
    private final Image image;
    
    public ImagePush(Image image){
        this.image = image;
    }
    
    public void make(String text){
        ImageIterator iter = new ImageIterator(image);
        for (int i = 0; i < text.length(); i++) {
            int znak = text.charAt(i);
            
            //vytvoří binární řetězec
            String binary = Integer.toString(znak, 2);
            int index = 0;
            while(binary.length() < 9){
                binary = "0"+binary;
            }
            
            for (int j = 0; j < 3; j++) {
                Color color = iter.getNext();
                int r = vypocti(color.getRed(), binary.charAt(index++));
                int g = vypocti(color.getGreen(), binary.charAt(index++));
                int b = vypocti(color.getBlue(), binary.charAt(index++));
                iter.setActual(new Color(r, g, b));
            }         
        }
        
        //posledni 2 znaky
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    Color color = iter.getNext();
                    int r = vypocti(color.getRed(), '0');
                    int g = vypocti(color.getGreen(), '0');
                    int b = vypocti(color.getBlue(), '0');
                    iter.setActual(new Color(r, g, b));
                }
            } 
    }
    
    private int vypocti(int barva, char bit){
        if(liche(bit) == liche(barva)){
            return barva;
        }else{
            if(barva < 255){
                return barva+1;
            }else{
                return barva-1;
            }
        }
    }
    
    private boolean liche(int cislo){
        int pom = cislo/2;
        pom *= 2;
        if(cislo == pom){
            return false;
        }
        return true;
    }
}
