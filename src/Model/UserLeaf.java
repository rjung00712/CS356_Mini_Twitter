package Model;

import javax.security.auth.Subject;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.List;

/**
 * Created by Richard on 11/3/16.
 */
public class UserLeaf extends UserComponent implements Observer implements Subject {

    private String userId;
    private List<UserComponent> followers;
    private List<UserComponent> followings;
    private List<String> twitterMessages;

    public UserLeaf(String userId) {
        super(userId);
        this.userId = userId;
    }

    // adds a follower to user's list of followers
    public void addFollower(UserComponent follower) {
        followers.add(follower);
    }

    public List<UserComponent> getFollowers() {
        return this.followers;
    }

    public DefaultMutableTreeNode getTree() {
        return new DefaultMutableTreeNode(this);
    }

    // user can't add another user
    @Override
    public void add(UserComponent userComponent) {
        throw new UnsupportedOperationException("can't add user to user!");
    }

    @Override
    public void update(Subject subject) {

    }
}