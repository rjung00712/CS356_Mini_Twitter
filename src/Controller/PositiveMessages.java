package Controller;

import Model.Visitable;
import Model.Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Richard on 11/7/16.
 */
public class PositiveMessages implements Visitable {

    private static final List<String> positiveWords = Arrays.asList("cool", "nice", "wonderful", "good", "great");

    public PositiveMessages() {}

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public boolean hasPositive(String message) {
        return positiveWords.contains(message) ? true : false;
    }
//    @Override
//    public void checkMessage(String message) {
//        if(hasPositive(String message)) {
//            accept(Controller.getInstance());
//        }
//    }
}
