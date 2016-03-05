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
        
        Picture picture = new Picture();
        Gui gui = new Gui(picture);
    }
    
}
