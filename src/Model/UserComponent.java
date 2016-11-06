package Model;

import javax.swing.tree.MutableTreeNode;

/**
 * Created by Richard on 11/5/16.
 */
public interface UserComponent {
    
    public UserComponent getUser();

    public void add(UserComponent component);

    MutableTreeNode getTree();

    //MutableTreeNode getTree();

//    public abstract void add(UserComponent userComponent);
//    public abstract DefaultMutableTreeNode getTree();
}
