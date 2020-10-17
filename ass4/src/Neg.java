// ID: 208387969

import java.util.Map;

/**
 * Neg - An expression that represents a negative number(and calculate the inner expression).
 * The class extends from the UnaryExpression.
 */

public class Neg extends UnaryExpression {
    /**
     * constructor with configurable of the expression.
     *
     * @param expression - The expression.
     */
    public Neg(Expression expression) {
        super(expression);
    }

    /**
     * evaluate - The expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment - A data structure that uses the string and double to store data.
     * @return the result of the expression.
     * @throws Exception - If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        // return the result of the expression (multiply by minus for this expression)
        return -1 * (getExpression().evaluate(assignment));
    }

    /**
     * evaluate - A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return the result of the expression.
     * @throws Exception - If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    @Override
    public double evaluate() throws Exception {
        // return the result of the expression (multiply by minus for this expression)
        return -1 * (getExpression().evaluate());
    }

    /**
     * typeOfOperation - Return the type of the operation.
     *
     * @return The type of the operation.
     */
    @Override
    public String typeOfOperation() {
        return "-";
    }

    /**
     * toString - This function returns a nice string representation of the expression.
     *
     * @return A string representation of the expression.
     */
    @Override
    public String toString() {
        // String of the expression
        String strExpression = "(" + typeOfOperation() + getExpression().toString() + ")";
        return strExpression;
    }

    /**
     * assign - This function returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the current expression).
     *
     * @param var        - The simplest level expression represents a standard variable (contains a string).
     * @param expression - The provided expression.
     * @return The provided expression.
     */
    @Override
    public Expression assign(String var, Expression expression) {
        Expression newExpression;
        //new expression for the expression in the sin (the variable var are replaced with the provided expression)
        newExpression = getExpression().assign(var, expression);
        return new Neg(newExpression);
    }

    /**
     * differentiate - Returns the expression tree resulting from differentiating the current
     * expression relative to variable `var`.
     *
     * @param var - The simplest level expression represents a standard variable (contains a string).
     * @return the expression tree resulting from differentiating the current expression (relative to variable).
     */
    public Expression differentiate(String var) {
        Expression differentiate;
        // Differentiate to the expression
        differentiate = getExpression().differentiate(var);
        return new Neg(differentiate);
    }

    /**
     * simplify - Returned a simplified version of the current expression.
     *
     * @return a simplified version of the current expression.
     */
    public Expression simplify() {
        double expressionNeg;
        // Simplify of the expression
        Expression simplify = getExpression().simplify();
        try {
            expressionNeg = (new Neg(simplify)).evaluate();
            return new Num(expressionNeg);
        } catch (Exception exc) {
            // Return the expression without change (and simplify the inside expression)
            return new Neg(simplify);
        }
    }
}
