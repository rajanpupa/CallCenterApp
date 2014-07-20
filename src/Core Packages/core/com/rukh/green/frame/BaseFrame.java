package core.com.rukh.green.frame;

import core.com.rukh.green.panel.BasePanel;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Rajan Prasad Upadhyay
 */
public class BaseFrame extends javax.swing.JFrame {

    //other properties
    private String fileDir = null;
    private String fileName = null;

    //base panel
    protected BasePanel basePanel = new BasePanel();

    /**
     * Creates new form BaseFrame
     */
    public BaseFrame() {
        initComponents();
        // initialization code
        this.setTitle("Test Automata");
//        //this.set
//        this.setContentPane(basePanel);
//        basePanel.setParentFrame(this);
    }
    
    public void setBasePanel(BasePanel bPanel){
        //this.set
        this.basePanel = bPanel;
        this.setContentPane(bPanel);
        basePanel.setParentFrame(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newProjectMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        OpenMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        runMenuItem = new javax.swing.JMenu();
        executeMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        newProjectMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newProjectMenuItem.setText("New Project");
        newProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(newProjectMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenuItem);

        OpenMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        OpenMenuItem.setText("Open");
        OpenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(OpenMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        runMenuItem.setText("Run");

        executeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        executeMenuItem.setText("Execute");
        executeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeMenuItemActionPerformed(evt);
            }
        });
        runMenuItem.add(executeMenuItem);

        jMenuBar1.add(runMenuItem);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectMenuItemActionPerformed
        this.basePanel.newProjectMenuItemActionPerformed(evt);
    }//GEN-LAST:event_newProjectMenuItemActionPerformed

    private void executeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeMenuItemActionPerformed
        this.basePanel.executeMenuItemActionPerformed(evt);
    }//GEN-LAST:event_executeMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.basePanel.exitMenuItemActionPerformed(evt);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
       this.basePanel.saveMenuItemActionPerformed(evt);
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void OpenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMenuItemActionPerformed
        this.basePanel.OpenMenuItemActionPerformed(evt);
    }//GEN-LAST:event_OpenMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BaseFrame bFrame = new BaseFrame();//.setVisible(true);
                //bFrame.setLocation(500, 100);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                Dimension windowSize ;//= bFrame.getSize();
                windowSize = new Dimension(screenSize.width/2, screenSize.height/2);
                
                int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
                int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
                bFrame.setLocation(windowX, windowY);  // Don't use "f." inside constructor.
                bFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OpenMenuItem;
    private javax.swing.JMenuItem executeMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem newProjectMenuItem;
    private javax.swing.JMenu runMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
}