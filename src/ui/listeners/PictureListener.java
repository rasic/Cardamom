package ui.listeners;

import cardamom.Picture;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 *
 * @author Ondřej Bleha
 */
public class PictureListener implements ActionListener{
    private final Picture pict;
    private final JButton button;
    private final int width;
    private final int height;

    public PictureListener(Picture pict, JButton button) {
        this.pict = pict;
        this.button = button;
        this.width = button.getWidth();
        this.height = button.getHeight();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        File file = showFileChooser();
        if(file != null){
            pict.loadPicture(file);
            button.setIcon(pict.getIcon(width, height));
            button.setText("");
        }
    }
    
    private File showFileChooser(){
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          return fileChooser.getSelectedFile();          
        }
        return null;
    }
    
}
