package Visitor;

import Controller.Controller;
import Controller.PositiveMessages;
import GUI.Panels.UserViewPanel;
import Model.UserLeaf;

/**
 * Created by Richard on 11/5/16.
 */
public interface Visitor {

    public void visit(UserLeaf user);

    public void visit(UserViewPanel userViewPanel);

    public void visit(PositiveMessages positiveMessages);

    public void visit(Controller controller);

    public int getPositiveMessages();

    public int getUserTotal();

    public int getGroupTotal();

    public int getMessageTotal();
}
