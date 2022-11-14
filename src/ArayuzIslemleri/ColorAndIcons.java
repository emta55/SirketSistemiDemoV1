
package ArayuzIslemleri;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ColorAndIcons {
    
    //Icons
    private Icon cancel = new ImageIcon(getClass().getResource("/Images/cancel.png"));
    private Icon cancel2 = new ImageIcon(getClass().getResource("/Images/cancel2.png"));
    private Icon minimize = new ImageIcon(getClass().getResource("/Images/minimize.png"));
    private Icon minimize2 = new ImageIcon(getClass().getResource("/Images/minimize2.png"));
    private Icon move = new ImageIcon(getClass().getResource("/Images/move.png"));
    private Icon move2 = new ImageIcon(getClass().getResource("/Images/move2.png"));
    private Icon user = new ImageIcon(getClass().getResource("/Images/user.png"));
    private Icon user2 = new ImageIcon(getClass().getResource("/Images/user2.png"));

    
    //Colors
    private Color mavi = new Color(51,51,255);
    
    private String roleMudur[] = {" ", "Personel"};
    private String roleAdmin[] = {" ", "Mudur", "BirimSorumlusu"};
    
    private DefaultComboBoxModel modelMudur = new DefaultComboBoxModel(roleMudur);
    private DefaultComboBoxModel modelAdmin = new DefaultComboBoxModel(roleAdmin);

    public DefaultComboBoxModel getModelMudur() {
        return modelMudur;
    }

    public DefaultComboBoxModel getModelAdmin() {
        return modelAdmin;
    }
    
    

    public Icon getUser() {
        return user;
    }

    public Icon getUser2() {
        return user2;
    }
    public Icon getCancel() {
        return cancel;
    }

    public Icon getCancel2() {
        return cancel2;
    }

    public Icon getMinimize() {
        return minimize;
    }

    public Icon getMinimize2() {
        return minimize2;
    }

    public Icon getMove() {
        return move;
    }

    public Icon getMove2() {
        return move2;
    }

    public Color getMavi() {
        return mavi;
    }
    
    
    
    
}
