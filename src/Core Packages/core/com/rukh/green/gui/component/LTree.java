package core.com.rukh.green.gui.component;


import core.com.rukh.green.panel.BasePanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Rajan Prasad Upadhyay
 */
/**
 * LeftTree extends JTree, It had custom CellRenderer It expects Object of type
 * BaseElement in its nodes, and can handle right click events on the Test and
 * Page type objects which extends BaseElement
 *
 * This tree is created by {com.green.rukh.test.manager.TreeHelper} class on the
 * basis of a TestPlan
 */
public class LTree extends JTree {

    static Logger logger = LogManager.getLogger(LTree.class.getName());

    //Properties
    BasePanel basePanel;

    public LTree(DefaultMutableTreeNode rootNode) {
        super(rootNode);
        //this.setCellRenderer(new CustomCellRenderer());

        initComponents();
    }

    public LTree() {
        initComponents();
    }

    private void initComponents() {
        // add the mouse listener for the popup events
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logger.trace("LeftTree.java: addMouseListener");
                jTree1MouseReleased(evt);
            }

        });
    }

    public BasePanel getBasePanel() {
        return basePanel;
    }

    public void setBasePanel(BasePanel basePanel) {
        this.basePanel = basePanel;
    }

    // <editor-fold defaultstate="collapsed" desc="MouseReleased PopupEvent Action">
    private void jTree1MouseReleased(java.awt.event.MouseEvent evt) {
        // TODO addMenu your handling code here:
        if (evt.isPopupTrigger()) {
            popUpTriggerEvent(evt);
        } else {
            logger.trace("Not a popup trigger event");
            notPopUpTriggerEvent(evt);
        }

    }

    private void popUpTriggerEvent(java.awt.event.MouseEvent evt) {
        logger.trace("Pop up on release");
        //display pop up menu here
        int x = evt.getX();
        int y = evt.getY();
        JTree tree = (JTree) evt.getSource();
        TreePath path = tree.getPathForLocation(x, y);

        if (path == null) {
            return;
        }

        tree.setSelectionPath(path);

        DefaultMutableTreeNode obj = (DefaultMutableTreeNode) path.getLastPathComponent();

        String objectType = "";
        Object object = obj.getUserObject();

        
    }

    private void notPopUpTriggerEvent(java.awt.event.MouseEvent evt) {
        //System.out.println("Not a popup event");
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="TesePlan element Right Clicked methods, add new page event">
    public void testPlanRightClickAction(final JTree tree, int x, int y) {
        TreePath path = tree.getPathForLocation(x, y);
        final DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
        
        JPopupMenu popup = new JPopupMenu();

        //level 1 menus
        JMenu addMenu = new JMenu("Add");
        //JMenuItem delete = new JMenuItem("Delete");

        //level 2 items
        JMenuItem addPageMenuItem = new JMenuItem("Test");

        addPageMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                addNewTestEvent(tree, node);
            }
        });

        addMenu.add(addPageMenuItem);

        popup.add(addMenu);
        //popup.add(delete);

        popup.show(tree, x, y);
    }

    public void addNewTestEvent(JTree tree, DefaultMutableTreeNode node) {
        
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("new test");
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

        model.insertNodeInto(newNode, node, node.getChildCount());

        newNode.setUserObject("user Object");
        TreeNode[] nodes = model.getPathToRoot(newNode);
        TreePath path = new TreePath(nodes);
        tree.scrollPathToVisible(path);
        tree.setSelectionPath(path);

        logger.trace("addNewPageEvent Path :" + path);

        tree.startEditingAtPath(path);
    }
    // test right clicked action
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Tese element Right Clicked methods, add new page event">
    public void testRightClickAction(final JTree tree, int x, int y) {
        TreePath path = tree.getPathForLocation(x, y);
        final DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
//        final BaseElement element = (BaseElement) node.getUserObject();

        JPopupMenu popup = new JPopupMenu();

        //level 1 menus
        JMenu addMenu = new JMenu("Add");
        JMenuItem delete = new JMenuItem("Delete");
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                deleteTestEvent(tree, node);
            }

        });

        //level 2 items
        JMenuItem addPageMenuItem = new JMenuItem("Page");

        addPageMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                addNewPageEvent(tree, node);
            }
        });

        addMenu.add(addPageMenuItem);

        popup.add(addMenu);
        popup.add(delete);

        popup.show(tree, x, y);
    }

    public void addNewPageEvent(JTree tree, DefaultMutableTreeNode node) {
        
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("page");
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

        model.insertNodeInto(newNode, node, node.getChildCount());

        newNode.setUserObject("page");
        TreeNode[] nodes = model.getPathToRoot(newNode);
        TreePath path = new TreePath(nodes);
        tree.scrollPathToVisible(path);
        tree.setSelectionPath(path);

        logger.trace("addNewPageEvent Path :" + path);

        tree.startEditingAtPath(path);
    }

    public void deleteTestEvent(JTree tree, DefaultMutableTreeNode node) {
//        Test elem = (Test) node.getUserObject();
        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) node.getParent();
//        TestPlan parentElem = (TestPlan) parentNode.getUserObject();

        int childNodeIndex = parentNode.getIndex(node);
//        parentElem.remove(childNodeIndex);

        logger.trace("Inside the delete event. Index of selected " + childNodeIndex);

        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

        if (node.getParent() != null) {
            model.removeNodeFromParent(node);
        }
    }

    // test right clicked action
    // </editor-fold>     
    
    // <editor-fold defaultstate="collapsed" desc="page element right clicked action, delete, add event event">
    public void pageRightClickAction(final JTree tree, int x, int y) {
        TreePath path = tree.getPathForLocation(x, y);
        final DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
//        final BaseElement element = (BaseElement) node.getUserObject();

        JPopupMenu popup = new JPopupMenu();

        //level 1 menus
        //menu item
        JMenu addEvent = new JMenu("Add Event");

        //submenu item
        JMenuItem clearItem = new JMenuItem("Clear Event");
        JMenuItem clickItem = new JMenuItem("Click Event");
        JMenuItem hoverItem = new JMenuItem("Hover Event");
        JMenuItem navigationItem = new JMenuItem("Navigation Event");
        JMenuItem sendKeysItem = new JMenuItem("Send Keys Event");
        JMenuItem snapshotItem = new JMenuItem("Snapshot Event");
        JMenuItem WaitItem = new JMenuItem("Wait Event");

        //add the items to the menu
        addEvent.add(clearItem);
        addEvent.add(clickItem);
        addEvent.add(hoverItem);
        addEvent.add(navigationItem);
        addEvent.add(sendKeysItem);
        addEvent.add(snapshotItem);
        addEvent.add(WaitItem);

        //adding eventHandlers
        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                addClearEvent(tree, node);
            }
        });
        hoverItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                addHoverEvent(tree, node);
            }
        });
        clickItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                addClickEvent(tree, node);
            }
        });
        navigationItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                addNavigationEvent(tree, node);
            }
        });
        sendKeysItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                addSendKeysEvent(tree, node);
            }
        });
        snapshotItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                addSnapshotEvent(tree, node);
            }
        });
        WaitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                addWaitEvent(tree, node);
            }
        });

        popup.add(addEvent);
        addEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                deletePageEvent(tree, node);
            }
        });

        //delete
        JMenuItem delete = new JMenuItem("Delete");
        popup.add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                deletePageEvent(tree, node);
            }
        });

        popup.show(tree, x, y);
    }

    public void deletePageEvent(JTree tree, DefaultMutableTreeNode node) {
//        Page elem = (Page) node.getUserObject();
        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) node.getParent();
//        Test parentElem = (Test) parentNode.getUserObject();

        int childNodeIndex = parentNode.getIndex(node);
//        parentElem.remove(childNodeIndex);

        logger.trace("Inside the delete event. Index of selected " + childNodeIndex);

        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

        if (node.getParent() != null) {
            model.removeNodeFromParent(node);
        }
    }

    
    // </editor-fold>

    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = LTree.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            logger.error("Couldn't find file: " + path);
            String str = "  Wait ";
            return null;
        }
    }
}

// <editor-fold defaultstate="collapsed" desc="CustomCellRenderer class">
//class CustomCellRenderer extends DefaultTreeCellRenderer {
//    Icon cup;
//    Icon triangle;
//    Icon page;
//    Icon chasma;
//    Icon house;
//    Icon upArrow;
//    Icon downArrow;
//    Icon leftArrow;
//    Icon rightArrow;
//    Icon smallWeb;
//    Icon circularTick;
//    Icon circularPlus;
//    Icon circularCross;
//    Icon tree4;
//    Icon leaf3;
//    Icon camera3;
//    Icon text;
//    Icon click;
//    Icon hover;
//    Icon clear;
//    Icon wait;
//
//    public CustomCellRenderer() {
//        cup = LTree.createImageIcon("/image/cup.GIF");
//        triangle = LTree.createImageIcon("/image/middle.GIF");
//        page = LTree.createImageIcon("/icons/notebook.GIF");
//        house = LTree.createImageIcon("/icons/house.GIF");
//        chasma = LTree.createImageIcon("/icons/chasma.GIF");
//        smallWeb = LTree.createImageIcon("/icons/small-web.GIF");
//        tree4 = LTree.createImageIcon("/icons/tree4.GIF");
//        leaf3 = LTree.createImageIcon("/icons/leaf3.GIF");
//        rightArrow = LTree.createImageIcon("/icons/right-arrow.GIF");
//        camera3 = LTree.createImageIcon("/icons/camera3.GIF");
//        text = LTree.createImageIcon("/icons/text.GIF");
//        click = LTree.createImageIcon("/icons/click.GIF");
//        hover = LTree.createImageIcon("/icons/hover.GIF");
//        clear = LTree.createImageIcon("/icons/clear.GIF");
//        wait = LTree.createImageIcon("/icons/wait.GIF");
//    }

//    public Component getTreeCellRendererComponent(
//            JTree tree,
//            Object value,
//            boolean sel,
//            boolean expanded,
//            boolean leaf,
//            int row,
//            boolean hasFocus) {
//
//        super.getTreeCellRendererComponent(
//                tree, value, sel,
//                expanded, leaf, row,
//                hasFocus);
//
//        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
//        Object obj = node.getUserObject();
//
//        if (BaseElement.class.isInstance(obj)) {
//            BaseElement elem = (BaseElement) node.getUserObject();
//
//            if (elem.getType().equalsIgnoreCase("TestPlan")) {
//                setIcon(tree4);
//            } else if (elem.getType().equalsIgnoreCase("test")) {
//                setIcon(chasma);
//            } else if (elem.getType().equalsIgnoreCase("page")) {
//                setIcon(leaf3);
//            }
//        } else {
//            if (obj instanceof NavigateEvent) {
//                setIcon(triangle);
//            } else if (obj instanceof SnapShotEvent) {
//                setIcon(camera3);
//            } else if (obj instanceof SendKeysEvent) {
//                setIcon(text);
//            }else if (obj instanceof ClickEvent){
//                setIcon(click);
//            }else if (obj instanceof HoverEvent){
//                setIcon(hover);
//            }else if (obj instanceof ClearEvent){
//                setIcon(clear);
//            }else if (obj instanceof WaitEvent){
//                setIcon(wait);
//            }
//        }
//        return this;
//    }
//
//}

// </editor-fold>
