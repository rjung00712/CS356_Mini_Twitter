package Controller;

import GUI.Panels.UserViewPanel;
import Model.Visitor;

import GUI.Panels.AdminControlPanel;
import Model.UserComponent;
import Model.UserComposite;
import Model.UserLeaf;
import com.sun.tools.classfile.ReferenceFinder;
import com.sun.tools.corba.se.idl.constExpr.Positive;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.M;

/**
 * Singleton class with Double Checked Locking instantiation
 *
 * Created by Richard on 11/5/16.
 */
public class Controller implements Visitor {
    // singleton instance of Controller class
    private static Controller instance = null;

    private AdminControlPanel adminPanel;

    private int userTotal, groupTotal, messageTotal, positiveMessageTotal = 0;
    double positivePercentage;

    private DefaultMutableTreeNode root;

    private static final UserComponent ROOT = new UserComposite("Root");

    private List<String> listOfUsers = new ArrayList<>();
    private List<String> listofGroups = new ArrayList<>();

    // constructor
    private Controller() {}

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

//    private void init() {
//
//        root = new DefaultMutableTreeNode(ROOT);
//
//        UserComponent admin = new UserLeaf("admin");
//        UserComponent cs356 = new UserComposite("cs356");
//        UserComponent richard = new UserLeaf("Richard");
//
//        ROOT.add(admin);
//        ROOT.add(cs356);
//        cs356.add(richard);
//
//        DefaultMutableTreeNode sub1 = new DefaultMutableTreeNode("sub1");
////
////
////        UserComposite cs356 = new UserComposite("cs356");
//        cs356.add(new UserLeaf("Rich"));
//        cs356.add(new UserComposite("cs408"));
//
//        sub1.add(new DefaultMutableTreeNode(cs356));
//        sub1.add(new DefaultMutableTreeNode());
////
//        root.add(sub1);
////
////        List<UserComponent> followers = cs356.getFollowers();
//
////        adminPanel.setTree(root);
//
//    }

    // add to group total per visit
    @Override
    public void visit(AdminControlPanel adminControlPanel) { groupTotal++; }

    // add to message total per visit
    @Override
    public void visit(UserViewPanel userViewPanel) { messageTotal++; }

    // add to user total per visit
    @Override
    public void visit(UserLeaf userLeaf) { userTotal++; }

    // add to positive message total per visit
    @Override
    public void visit(PositiveMessages positiveMessages) { positiveMessageTotal++; }

    // returns total number of users
    @Override
    public int getUserTotal() { return userTotal; }
//
//    // returns total number of groups
//    @Override
//    public int getGroupTotal() { return groupTotal; }
//
//    // returns total number of messages
//    @Override
//    public int getMessageTotal() { return messageTotal; }


    @Override
    public int getPositiveMessages() {
        return positiveMessageTotal;
    }

    public void findPositivePercentage() {
        positivePercentage = (double)positiveMessageTotal / (double)messageTotal * 100;
    }

    // adds user to list of users
    public void addUserId(String id) {
        listOfUsers.add(id);
    }

    // adds group to list of groups
    public void addGroupId(String id) {
        listofGroups.add(id);
    }

    // checks if user already exists
    public boolean userExists(String id) { return (listOfUsers.contains(id) ? true : false); }

    // checks if group already exists
    public boolean groupExists(String id) {
        return (listofGroups.contains(id) ? true : false);
    }
}
