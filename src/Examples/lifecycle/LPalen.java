package lifecycle;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Rajan Prasad Upadhyay
 */
public class LPalen extends JPanel{
    
    @Override
    public void paint(Graphics grphcs){
        System.out.println("Callint the lPanel paint(Graphics ) method.");
        super.paint(grphcs);
    }
    
    @Override
    public void paintAll(Graphics grphcs){
        System.out.println("Calling the lPanel paintAll(Graphics ) method.");
        super.paint(grphcs);
    }
    
    @Override
    public void setSize(int i, int j){
        System.out.println("Calling the lPanel setSize(int, int ) method.");
        super.setSize(i, j);
    }
    
    @Override
    public void paintComponent (Graphics g){
        System.out.println("Calling the lPanel paintComponent(Graphics ) method.");
        super.paintComponent(g);
    }
    
    @Override
    public void setSize(Dimension d){
        System.out.println("Calling the lPanel setSize(Dimension) method.");
        super.setSize(d);
    }
    
    @Override
    public void list(){
        System.out.println("Calling the lPanel list() method.");
        super.list();
    }
    
    @Override
    public void doLayout(){
        System.out.println("Calling the lPanel doLayout() method.");
    }
    
    @Override
    public void addNotify(){
        System.out.println("Calling the lPanel addNotify() method.");
    }
    
    @Override
    public void removeNotify(){
        System.out.println("Calling the lPanel removeNotify() method.");
    }
    
    @Override
    public void setVisible(boolean bool){
        System.out.println("Calling the setVisible(boolean) method.");
        super.setVisible(bool);
    }
}
