package GUI.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.glass.ui.Cursor.setVisible;

/**
 * Created by Richard on 11/2/16.
 */
public class UserViewPanel extends JFrame {
    private JTextArea UserIdTextArea;
    private JList currentFollowingListView;
    private JTextArea tweetMessageTextArea;
    private JButton postTweetButton;
    private JList newsFeedListView;
    private JPanel panel2;
    private JButton followUserButton;

    public UserViewPanel() {
        super();

        setPreferredSize(new Dimension(400, 300));
//        setLocationRelativeTo(null);
        setContentPane(panel2);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        initUI();
    }

    public void initUI() {
        postTweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = tweetMessageTextArea.getText();
//                System.out.println("you posted a tweet");
            }
        });

    }

}
