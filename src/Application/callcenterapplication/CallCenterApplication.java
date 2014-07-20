
package callcenterapplication;

import core.com.rukh.green.frame.BaseFrame;
import core.com.rukh.green.panel.BasePanel;
import extended.com.rukh.green.panel.ControlPanelWithList;
import extended.com.rukh.green.panel.PropertyPanel;

/**
 *
 * @author Rajan Prasad Upadhyay
 */
public class CallCenterApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseFrame frame = new BaseFrame();
        
        BasePanel bPanel = new BasePanel();
        bPanel.setControlPanel(new ControlPanelWithList(bPanel));
        bPanel.setPropertyPanel(new PropertyPanel(bPanel));
        bPanel.programaticInitialize();
        
        frame.setBasePanel(bPanel);
        
        frame.setVisible(true);
       //BaseFrame.main(null);
    }
    
}
