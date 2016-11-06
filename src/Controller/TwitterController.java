package Controller;

import GUI.Panels.AdminControlPanel;
import Model.UserComponent;
import Model.UserComposite;
import Model.UserLeaf;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.List;

/**
 * Singleton class with Double Checked Locking instantiation
 *
 * Created by Richard on 11/5/16.
 */
public class TwitterController {

    private static TwitterController instance = null;

    private AdminControlPanel adminPanel;

    private DefaultMutableTreeNode root;

    private static final UserComponent ROOT = new UserComposite("Root");

    private TwitterController() {   // constructor
        adminPanel = AdminControlPanel.getInstance();

        // creates and displays the admin control panel
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                adminPanel.setVisible(true);
            }
        });

        init();
    }

    // returns the static single instance of this class
    public static TwitterController getInstance() {
        if(instance == null) {
            synchronized (TwitterController.class) {
                if(instance == null) {
                    instance = new TwitterController();
                }
            }
        }
        return instance;
    }

    private void init() {

        root = new DefaultMutableTreeNode(ROOT);

        UserComponent admin = new UserLeaf("admin");
        UserComponent cs356 = new UserComposite("cs356");
        UserComponent richard = new UserLeaf("Richard");

        ROOT.add(admin);
        ROOT.add(cs356);
        cs356.add(richard);

//        DefaultMutableTreeNode sub1 = new DefaultMutableTreeNode("sub1");
//
//
//
//        UserComposite cs356 = new UserComposite("cs356");
//        cs356.add(new UserLeaf("Rich"));
//        cs356.add(new UserComposite("cs408"));
//
//        sub1.add(new DefaultMutableTreeNode(cs356));
//        sub1.add(new DefaultMutableTreeNode())
//
//        root.add(sub1);
//
//        List<UserComponent> followers = cs356.getFollowers();


        adminPanel.setTree(root);

    }


}
