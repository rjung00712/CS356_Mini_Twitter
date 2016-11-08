package Model;

import Controller.PositiveMessages;
import GUI.Panels.AdminControlPanel;
import GUI.Panels.UserViewPanel;
import com.sun.tools.corba.se.idl.constExpr.Positive;

/**
 * Created by Richard on 11/5/16.
 */
public interface Visitor {

    public void visit(PositiveMessages admin);

    public void visit(UserLeaf user);

    public void visit(UserViewPanel userViewPanel);

    public void visit(AdminControlPanel adminControlPanel);

    public void visit(PositiveMessages positiveMessages);

    public int getPositiveMessages();

    public int getUserTotal();
//    public int getGroupTotal();
//    public int getMessageTotal();
}
