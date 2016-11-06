package Model;

import GUI.Panels.AdminControlPanel;
import GUI.Panels.UserViewPanel;
import com.sun.tools.corba.se.idl.constExpr.Positive;

/**
 * Created by Richard on 11/5/16.
 */
public interface Visitor {

    public void visit(AdminControlPanel admin);
    public void visit(UserLeaf user);
    public void visit(UserViewPanel userViewPanel);
//    public void visit(PositiveMessage message);
}
