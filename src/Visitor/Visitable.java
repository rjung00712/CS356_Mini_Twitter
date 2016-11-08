package Visitor;

import Visitor.Visitor;

/**
 * Created by Richard on 11/5/16.
 */
public interface Visitable {
    public void accept(Visitor visitor);
}
