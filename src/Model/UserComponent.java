package Model;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.List;

/**
 * Created by Richard on 11/5/16.
 */
public abstract class UserComponent {

    private String id;

    public UserComponent(String id) {
        this.id = id;
    }

    public UserComponent getUser() {
        return this;
    }

    @Override
    public String toString() {
        return this.id;
    }

    public abstract void add(UserComponent userComponent);
    public abstract DefaultMutableTreeNode getTree();
}
