package extended.com.rukh.green.panel;

import core.com.rukh.green.panel.AbstractPropertyPanel;
import core.com.rukh.green.panel.BasePanel;
import javax.swing.JList;

/**
 *
 * @author Rajan Prasad Upadhyay
 */
public class PropertyPanel extends AbstractPropertyPanel {

    public PropertyPanel(BasePanel parent) {
        super(parent);
        String[] abc = {"Rajan", "prasad", "upadhyay", "is ", "my name and what is yours"};
        //this.add(new JList(abc));
    }

}
