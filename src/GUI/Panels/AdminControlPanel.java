package GUI.Panels;

import javax.swing.*;
import java.awt.*;

/**
 * This is the GUI panel and its attributes for the admin
 * control panel UI. This class is based off the Singleton
 * Design Pattern with double checked locking implementation
 *
 * Created by Richard on 11/2/16.
 */
public class AdminControlPanel extends JFrame {

    // private instance intialized to null
    private static AdminControlPanel instance = null;

    // all the GUI components that make up the admin control panel
    private JPanel panel1;
    private JTree tree1;
    private JButton showUserTotalButton;
    private JButton showGroupTotalButton;
    private JButton showMessagesTotalButton;
    private JButton showPositivePercentageButton;
    private JButton openUserViewButton;
    private JButton addUserButton;
    private JButton addGroupButton;
    private JTextArea textAreaUserId;
    private JTextArea textAreaGroupId;

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
    }

    // double checked locking to maintain single thread calls
    public static AdminControlPanel getInstance() {
        if(instance == null) {
            synchronized (AdminControlPanel.class) {
                if(instance == null) {
                    instance = new AdminControlPanel();
                }
            }
        }
        return instance;
    }
}
