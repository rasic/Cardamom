package cardamom;

import ui.Gui;
import utilities.Utilities;

/**
 *
 * @author Ondřej Bleha
 */
public class Cardamom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utilities.tryLinuxLF();
        
        Image picture = new Image();
        Gui gui = new Gui(picture);
    }
    
}
