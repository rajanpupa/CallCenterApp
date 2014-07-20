package lifecycle;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Rajan Prasad Upadhyay
 */
public class LifeCycleTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        System.out.println("initializing");
        JPanel lpanel = new LPalen();
        System.out.println("Initialized");
        
        System.out.println("Setting background color");
        lpanel.setBackground(Color.yellow);
        System.out.println("yello color set");
        
//        lpanel.setsi
        
        frame.add(lpanel);
        System.out.println("panel added as component to frame");
        
        frame.setSize(600, 400);
        System.out.println("frame size set to 600, 400");
        
        frame.setVisible(true);
        System.out.println("frame set to visible");
//        frame.dispose();//removenotify
    }
}

