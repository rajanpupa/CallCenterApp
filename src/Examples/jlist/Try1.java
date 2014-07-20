package jlist;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Rajan Prasad Upadhyay
 */
public class Try1 extends JPanel {
    
    Frame frame;
    JList list;
    
    public Try1(){
        String [] arr = {"a", "b", "c"};
        list = new JList(arr);
        
        this.setLayout(new BorderLayout());
        this.add(list);
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public JList getList() {
        return list;
    }

    public void setList(JList list) {
        this.list = list;
    }
    
    

    public static void main(String[] args) {
        Try1 panel = new Try1();

        Frame frame = new Frame(panel);

        panel.setFrame( frame);
        
        frame.setVisible(true);
        
        //frame.pack();
    }

    public void newProjectMenuItemActionPerformed(ActionEvent evt) {
        String [] arr = {"apple", "banana", "canberry"};
        list = new JList(arr);
        
        this.removeAll();
        this.add(list);
        
        this.revalidate();
        this.repaint();
        
        System.out.println("Panel, menu clicked");
    }

}

class Frame extends JFrame {

    Try1 try1;

    public Frame(Try1 try1) {
        this.try1 = try1;
        initComponents();
        
        this.setContentPane(try1);
        super.setMinimumSize(new Dimension(500, 400));
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        javax.swing.JMenuItem newProjectMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("File");

        newProjectMenuItem.setText("New Project");
        newProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectMenuItemActionPerformed(evt);
            }
        });

        jMenu1.add(newProjectMenuItem);

        jMenuBar1.add(jMenu1);
        setJMenuBar(jMenuBar1);

    }

    public void newProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Menu clicked on the Frame.");
        this.try1.newProjectMenuItemActionPerformed(evt);
    }

}
