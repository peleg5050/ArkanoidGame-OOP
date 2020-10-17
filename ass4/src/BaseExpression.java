// ID: 208387969

/**
 * BaseExpression - A master class that represents the most basic phrase.
 * The class implements from  the Expression.
 * The classes: UnaryExpression , BinaryExpression are extends from this parent class.
 */

public abstract class BaseExpression implements Expression {
    // Characteristics
    private Expression[] arrExpression;

    /**
     * constructor with configurable of array expressions.
     *
     * @param arrExpression - array of expressions.
     */
    public BaseExpression(Expression[] arrExpression) {
        this.arrExpression = arrExpression;
    }

    /**
     * getArrayExpression - Return the expression array.
     *
     * @return the expression array.
     */
    public Expression[] getArrayExpression() {
        return this.arrExpression;
    }

    /**
     * typeOfOperation - Return the type of the operation.
     *
     * @return The type of the operation.
     */
    public abstract String typeOfOperation();
}
