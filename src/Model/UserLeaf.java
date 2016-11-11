package Model;

import Visitor.Visitor;
import Visitor.Visitable;

import javax.security.auth.Subject;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Richard on 11/3/16.
 */
public class UserLeaf extends Observable implements UserComponent, Visitable {
    private String userId;

    private String message;

    private List<String> followers = new ArrayList<>();
    private List<String> followings = new ArrayList<>();
    private List<String> newsFeed = new ArrayList<>();

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

    @Override
    public String toString() {
        return this.userId;
    }

//    @Override
//    public void update(Observable o, Object arg) {
//
//    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
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

    // updates news feed and ends to observers
    public void upDateFeed(String tweet) {
        this.message = userId + ": " + tweet;
        setChanged();
        notifyObservers(message);
    }

    public void add(DefaultMutableTreeNode node) {
        node.add(new DefaultMutableTreeNode(this.userId));
    }

    public DefaultMutableTreeNode getTree() {
        return new DefaultMutableTreeNode(this);
    }
}