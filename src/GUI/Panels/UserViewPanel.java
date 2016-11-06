package GUI.Panels;

import javax.swing.*;
import java.awt.*;

import static com.sun.glass.ui.Cursor.setVisible;

/**
 * Created by Richard on 11/2/16.
 */
public class UserViewPanel extends JFrame {
    private JTextArea UserIdTextArea;
    private JList currentFollowingListView;
    private JTextArea TweetMessageTextArea;
    private JButton postTweetButton;
    private JList newsFeedListView;
    private JPanel panel2;
    private JButton followUserButton;

    public UserViewPanel() {
        super();

        setPreferredSize(new Dimension(600, 400));
        setLocationRelativeTo(null);
        setContentPane(panel2);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

}
