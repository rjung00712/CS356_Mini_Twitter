package Controller;

import GUI.Panels.AdminControlPanel;
import Model.UserComponent;
import Model.UserComposite;
import Model.UserLeaf;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class with Double Checked Locking instantiation
 *
 * Created by Richard on 11/5/16.
 */
public class Controller {
    // singleton instance of Controller class
    private static Controller instance = null;

    private AdminControlPanel adminPanel;

    private DefaultMutableTreeNode root;

    private static final UserComponent ROOT = new UserComposite("Root");

    private List<String> listOfUsers = new ArrayList<>();
    private List<String> listofGroups = new ArrayList<>();

    private Controller() {   // constructor
        init();
    }

    // returns the static single instance of this class
    public static Controller getInstance() {
        if(instance == null) {
            synchronized (Controller.class) {
                if(instance == null) {
                    instance = new Controller();
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


//        adminPanel.setTree(root);

    }

    public void addUserId(String id) {
        listOfUsers.add(id);
    }

    public void addGroupId(String id) {
        listofGroups.add(id);
    }

    // checks if user already exists
    public boolean userExists(String id) {
        return (listOfUsers.contains(id) ? true : false);
    }

    // checks if group already exists
    public boolean groupExists(String id) {
        return (listofGroups.contains(id) ? true : false);
    }
}
