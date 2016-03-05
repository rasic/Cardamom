package core;

import cardamom.Picture;

/**
 *
 * @author Ondřej Bleha
 */
public class Manager {
    private final ImagePull pull;
    private final ImagePush push;
    
    private final Picture pict;
    
    public Manager(Picture pict){
        this.pict = pict;
        
        this.pull = new ImagePull(pict);
        this.push = new ImagePush(pict);
    }
    
    public String pullText(){
        return pull.make();
    }
    
    public void pushText(String text){
        push.make(text);
    }
}
