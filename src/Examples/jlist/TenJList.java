package jlist;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class TenJList {
  public static void main(String args[]) {
        String labels[] = { "scroll", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        String labels2[] = { "NoScroll", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
    JFrame f = new JFrame("Example JList");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JList jlistNoScroll = new JList(labels2);
    JList jlistScroll = new JList(labels);
    Container c = f.getContentPane();
    c.add(jlistNoScroll, BorderLayout.WEST);
    JScrollPane sp = new JScrollPane(jlistScroll);
    c.add(sp, BorderLayout.EAST);
    f.setSize(300, 200);
    f.setVisible(true);
  }
}
