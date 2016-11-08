package Controller;

import GUI.Panels.UserViewPanel;
import Visitor.Visitor;

import GUI.Panels.AdminControlPanel;
import Model.UserComponent;
import Model.UserComposite;
import Model.UserLeaf;

import javax.swing.tree.DefaultMutableTreeNode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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

    private static List<String> listOfUsers = new ArrayList<>();
    private static List<String> listofGroups = new ArrayList<>();

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

    // returns total number of groups
    @Override
    public int getGroupTotal() { return groupTotal; }

    // returns total number of messages
    @Override
    public int getMessageTotal() { return messageTotal; }

    @Override
    public int getPositiveMessages() {
        return positiveMessageTotal;
    }

    public String findPositivePercentage() {
        String positivePercentage = new DecimalFormat("##.##")
                .format((double)positiveMessageTotal / (double)messageTotal * 100);
        return positivePercentage;
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
