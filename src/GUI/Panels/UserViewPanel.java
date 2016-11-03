package GUI.Panels;

import javax.swing.*;
import java.awt.*;

import static com.sun.glass.ui.Cursor.setVisible;

/**
 * Created by Richard on 11/2/16.
 */
public class UserViewPanel extends JFrame {
    private JTextArea textArea1;
    private JButton button1;
    private JList list1;
    private JTextArea textArea2;
    private JButton button2;
    private JList list2;
    private JPanel panel2;

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
