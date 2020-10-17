// ID: 208387969

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UnaryExpression - A parent class that represents expressions containing one internal expressions.
 * The class extends from the BaseExpression.
 * The classes: Sin , Cos and Neg are extends from this parent class.
 */
public abstract class UnaryExpression extends BaseExpression {
    /**
     * constructor with configurable of the expression.
     *
     * @param expression - The expression.
     */
    public UnaryExpression(Expression expression) {
        super(new Expression[]{expression});
    }

    /**
     * getExpressionLeft - Return the expression (the expression inside the sin\cos\neg).
     *
     * @return The expression.
     */
    public Expression getExpression() {
        return getArrayExpression()[0];
    }

    /**
     * getVariables - This function returns the variables in the form of a list.
     *
     * @return Variables in the form of a list
     */
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        // the variables list of the expression
        list.addAll(getExpression().getVariables());
        // Create a new list without duplicates
        List<String> listWithoutDuplicates = list.stream().distinct().collect(Collectors.toList());
        return listWithoutDuplicates;
    }

    /**
     * toString - This function returns a nice string representation of the expression.
     *
     * @return A string representation of the expression.
     */
    public String toString() {
        // String of the expression
        String strExpression = typeOfOperation() + "(" + getExpression().toString() + ")";
        return strExpression;
    }
}
