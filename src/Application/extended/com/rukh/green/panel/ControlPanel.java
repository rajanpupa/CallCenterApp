package extended.com.rukh.green.panel;

import core.com.rukh.green.panel.AbstractControlPanel;
import core.com.rukh.green.panel.BasePanel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author Rajan Prasad Upadhyay
 */
public class ControlPanel extends AbstractControlPanel{

    public ControlPanel(BasePanel parent) {
        super(parent);
        
        JTextField textField = new JTextField();
        JButton button = new JButton("Search");
        
        this.add(textField);
        this.add(button);
        
        String [] abc = {"Rajan", "prasad"};
        //this.add(new JList(abc));
    }

}
