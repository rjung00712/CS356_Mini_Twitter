package Model;

import javax.security.auth.Subject;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Richard on 11/3/16.
 */
public class UserLeaf extends Observable implements UserComponent, Observer {
    private String userId;
    private List<String> followers;
    private List<String> followings;
    private List<String> newsFeed;

    public UserLeaf(String userId) {
//        super(userId);
        this.userId = userId;
    }

    @Override
    public UserComponent getUser() {
        return null;
    }

    // user can't add another user
    @Override
    public void add(UserComponent userComponent) {
        throw new UnsupportedOperationException("can't add user to user!");
    }

    public void update(Subject subject) {

    }

    @Override
    public String toString() {
        return this.userId;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    // adds a follower to user's list of followers
    public void addFollower(String follower) {
        this.followers.add(follower);
    }

    public void addFollowings(String following) {
        this.followings.add(following);
    }

    public void addNewsFeed(String message) {
        this.newsFeed.add(message);
    }

    public List<String> getFollowers() {
        return this.followers;
    }

    public List<String> getFollowings() {
        return this.followings;
    }

    public List<String> getNewFeed() {
        return this.newsFeed;
    }

    public void add(DefaultMutableTreeNode node) {
        node.add(new DefaultMutableTreeNode(userId));
    }


    public DefaultMutableTreeNode getTree() {
        return new DefaultMutableTreeNode(this);
    }
}