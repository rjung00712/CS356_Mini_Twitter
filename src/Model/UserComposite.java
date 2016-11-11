package Model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Created by Richard on 11/3/16.
 */
public class UserComposite implements UserComponent, Observer, Observable {

    private List<String> followers;
    private String id;

    // constructor
    public UserComposite(String id) {
//        super(id);
        this.id = id;
        followers = new ArrayList<>();
    }

    // returns list of followers
    public List<String> getFollowers() {
        return this.followers;
    }

    public DefaultMutableTreeNode getTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(this);
        followers.stream().forEach((each) -> {
//            root.add(each.getTree());
        });
        return root;
    }

    @Override
    public void add(DefaultMutableTreeNode node) {

    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public UserComponent getUser() {
        return null;
    }

    @Override
    public void add(UserComponent component) {

    }

    public void add(DefaultTreeModel treeModel, DefaultMutableTreeNode root, DefaultMutableTreeNode subroot) {
        treeModel.insertNodeInto(subroot, root, 0);
    }

    @Override
    public void update(java.util.Observable o, Object arg) {

    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
