package GUI.Panels;

import Controller.Controller;
import Model.UserLeaf;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
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

    private String userId;
    Controller controller = Controller.getInstance();

    // private constructor extending JFrame class
    private AdminControlPanel() {
        super();

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
                String id = textAreaUserId.getText().trim();

                if(id.equals("")) {
                    JOptionPane.showMessageDialog(null, "ID is blank");
                } else if(controller.userExists(id)) {
                    JOptionPane.showMessageDialog(null, "User already exists");
                    textAreaUserId.setText("");
                } else {
                    controller.addUserId(id);
                    textAreaUserId.setText("");
                }
            }
        });

        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                String id = textAreaGroupId.getText().trim();

                if(id.equals("")) {
                    JOptionPane.showMessageDialog(null, "ID is blank");
                } else if()

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
