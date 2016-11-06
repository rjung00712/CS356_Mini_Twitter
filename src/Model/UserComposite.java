package Model;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richard on 11/3/16.
 */
public class UserComposite extends UserComponent {

    private List<UserComponent> followers;

    // constructor
    public UserComposite(String id) {
        super(id);
        followers = new ArrayList<>();
    }

    // returns list of followers
    public List<UserComponent> getFollowers() {
        return this.followers;
    }

    public DefaultMutableTreeNode getTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(this);
        followers.stream().forEach((each) -> {
            root.add(each.getTree());
        });
        return root;
    }

    @Override
    public void add(UserComponent userComponent) {
        followers.add(userComponent);
    }
}
