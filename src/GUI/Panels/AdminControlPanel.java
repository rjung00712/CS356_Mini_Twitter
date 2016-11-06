package GUI.Panels;

import Controller.Controller;
import Model.UserComponent;
import Model.UserComposite;
import Model.UserLeaf;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the GUI panel and its attributes for the admin
 * control panel UI. This class is based off the Singleton
 * Design Pattern with lazy instantiation
 *
 * Created by Richard on 11/2/16.
 */
public class AdminControlPanel extends JFrame {
    // private instance initialized to null
    private static AdminControlPanel instance = null;

    // all the GUI components that make up the admin control panel
    private JPanel panel1;
    private JTree tree;
    private JButton showUserTotalButton;
    private JButton showGroupTotalButton;
    private JButton showMessagesTotalButton;
    private JButton showPositivePercentageButton;
    private JButton openUserViewButton;
    private JButton addUserButton;
    private JButton addGroupButton;
    private JTextArea textAreaUserId;
    private JTextArea textAreaGroupId;

    private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
    private DefaultTreeModel treeModel= new DefaultTreeModel(root);

    private String userId;
    Controller controller = Controller.getInstance();

    private static UserComposite userGroup;
    private static UserLeaf user;

    // private constructor extending JFrame class
    private AdminControlPanel() {
        super();

        tree = new JTree(treeModel);
        tree.setEditable(true);

        TreeSelectionModel tsm = tree.getSelectionModel();
        tsm.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        treeModel.reload(root);

        // all the descriptions and placement of GUI components
        setPreferredSize(new Dimension(600, 400));
        setLocationRelativeTo(null);
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        initUI();
    }

    // double checked locking to maintain single thread calls
    public static AdminControlPanel getInstance() {
        if(instance == null) {
            instance = new AdminControlPanel();
        }
        return instance;
    }

    public void initUI() {
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                String id = textAreaUserId.getText().trim();

                if(id.equals("")) {
                    JOptionPane.showMessageDialog(null, "ID is blank");
                } else if(controller.userExists(id)) {
                    JOptionPane.showMessageDialog(null, "User already exists");
                    textAreaUserId.setText("");
                } else {
                    user = new UserLeaf(id);
                    user.add(root);
                    controller.addUserId(id);
                    textAreaUserId.setText("");
                }
                treeModel.reload(root);
            }
        });

        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                String id = textAreaGroupId.getText().trim();

                if(id.equals("")) {
                    JOptionPane.showMessageDialog(null, "ID is blank");
                } else if(controller.groupExists(id)) {
                    JOptionPane.showMessageDialog(null, "Group already exists");
                    textAreaGroupId.setText("");
                } else if(controller.userExists(id) || controller.userExists(treeNode.toString())) {
                    JOptionPane.showMessageDialog(null, "This is a user");
                    textAreaGroupId.setText("");
                } else {
                    if(treeNode != root) {
                        root = treeNode;    // set the current node as the subroot
                    }
                    userGroup = new UserComposite(id);

                    DefaultMutableTreeNode subroot = new DefaultMutableTreeNode(id);
                    userGroup.add(treeModel, root, subroot);
                    textAreaGroupId.setText("");
                    treeModel.reload(root);
                }

            }
        });

        openUserViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserViewPanel userViewPanel = new UserViewPanel();
            }
        });
    }

    public void setTree(DefaultMutableTreeNode root) {

        tree.setModel(new DefaultTreeModel(root));
        tree.setRootVisible(true);
        tree.setShowsRootHandles(true);
    }

    public JTree getTree() {
        return this.tree;
    }
}
