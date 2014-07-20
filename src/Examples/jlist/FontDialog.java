package jlist;

import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FontDialog extends JFrame implements ActionListener,
        ListSelectionListener {

    private JList style = new JList(new String[]{"Serif", "SansSerif",
        "Monospaced", "Dialog", "DialogInput"});

    private JCheckBox bold = new JCheckBox("Bold");

    private JCheckBox italic = new JCheckBox("Italic");

    private JTextField size = new JTextField("10", 2);

    private JTextField sample = new JTextField();

    public FontDialog() {
        setTitle("FontDialog");
        setSize(600, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Container contentPane = getContentPane();
        GridBagLayout gbl = new GridBagLayout();
        contentPane.setLayout(gbl);

        style.setSelectedIndex(0);

        JLabel label = new JLabel("Size: ");

        sample.setEditable(false);

        getContentPane().add(new JScrollPane(style));
        getContentPane().add(bold);
        getContentPane().add(italic);
        getContentPane().add(label);
        getContentPane().add(size);
        getContentPane().add(sample);
        sample.setText("The quick brown fox");

        bold.addActionListener(this);
        italic.addActionListener(this);
        style.addListSelectionListener(this);
        size.addActionListener(this);
    }

    public void valueChanged(ListSelectionEvent evt) {
        if(evt.getValueIsAdjusting())
        System.out.println("value changed");
        updateFont();
    }

    public void actionPerformed(ActionEvent evt) {
        updateFont();
    }

    public void updateFont() {
        Font font = new Font((String) style.getSelectedValue(), (bold
                .isSelected() ? Font.BOLD : 0)
                + (italic.isSelected() ? Font.ITALIC : 0), Integer
                .parseInt(size.getText()));
        sample.setFont(font);
        repaint();
    }

    public static void main(String[] args) {
        Frame f = new FontDialog();
        f.show();
    }
}
