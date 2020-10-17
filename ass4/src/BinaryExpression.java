import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BinaryExpression - A parent class that represents expressions containing two internal expressions.
 * The class extends from the BaseExpression.
 * The classes: Plus , Minus , Mult , Pow , Div , Log are extends from this parent class.
 */
public abstract class BinaryExpression extends BaseExpression {
    /**
     * constructor with configurable of the left expression and the right expression.
     *
     * @param expressionLeft  - The expression from the left side of the '+' or "-"
     * @param expressionRight - The expression from the Right side of the '+' or "-"
     */
    public BinaryExpression(Expression expressionLeft, Expression expressionRight) {
        super(new Expression[]{expressionLeft, expressionRight});
    }

    /**
     * getExpressionLeft - Return the left expression (the expression from the left side of the '+').
     *
     * @return the left expression (the expression from the left side of the '+' or "-").
     */
    public Expression getExpressionLeft() {
        return getArrayExpression()[0];
    }

    /**
     * getExpressionRight - Return the right expression (the expression from the right side of the '+').
     *
     * @return the right expression (the expression from the right side of the '+' or "-").
     */
    public Expression getExpressionRight() {
        return getArrayExpression()[1];
    }

    /**
     * getVariables - This function returns the variables in the form of a list.
     *
     * @return Variables in the form of a list
     */
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        // the variables list of the left expression
        list.addAll(getExpressionLeft().getVariables());
        // the variables list of the right expression
        list.addAll(getExpressionRight().getVariables());
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
        // String of the expression from the left side + type of the operation +
        // string of the expression from the right side
        String strExpression = "(" + getExpressionLeft().toString() + typeOfOperation()
                + getExpressionRight().toString() + ")";
        return strExpression;
    }
}
