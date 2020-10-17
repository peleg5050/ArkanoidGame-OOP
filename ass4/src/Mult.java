// ID: 208387969

import java.util.Map;

/**
 * Mult - The class represents a multiplication operation (multiple two internal expressions and calculate them).
 * The class extends from the BinaryExpression
 */
public class Mult extends BinaryExpression {
    private static final double ZERO = 0;
    private static final double ONE = 1;
    private static final double TWO = 2;

    /**
     * constructor with configurable of the left expression and the right expression.
     *
     * @param expressionLeft  - The expression from the left side of the '*'
     * @param expressionRight - The expression from the Right side of the '*'
     */
    public Mult(Expression expressionLeft, Expression expressionRight) {
        super(expressionLeft, expressionRight);
    }

    /**
     * evaluate - The expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment - A data structure that uses the string and double to store data.
     * @return the result of the expression (calculate the multiple of the two internal expressions).
     * @throws Exception - If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        // return the multiple of the  two internal expressions
        return getExpressionLeft().evaluate(assignment) * getExpressionRight().evaluate(assignment);
    }

    /**
     * evaluate - A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return the result of the expression.
     * @throws Exception - If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    @Override
    public double evaluate() throws Exception {
        // return the multiple of the  two internal expressions
        return getExpressionLeft().evaluate() * getExpressionRight().evaluate();
    }

    /**
     * typeOfOperation - Return the type of the operation.
     *
     * @return The type of the operation.
     */
    @Override
    public String typeOfOperation() {
        return " * ";
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
        Expression newExpression1, newExpression2;
        //new expression for the left expression (the variable var are replaced with the provided expression)
        newExpression1 = getExpressionLeft().assign(var, expression);
        //new expression for the right expression (the variable var are replaced with the provided expression)
        newExpression2 = getExpressionRight().assign(var, expression);
        return new Mult(newExpression1, newExpression2);
    }

    /**
     * differentiate - Returns the expression tree resulting from differentiating the current
     * expression relative to variable `var`.
     *
     * @param var - The simplest level expression represents a standard variable (contains a string).
     * @return the expression tree resulting from differentiating the current expression (relative to variable).
     */
    public Expression differentiate(String var) {
        Expression differentiate1, differentiate2;
        // Left expression (differentiate the left expression according to a given
        // variable and multiple in the right expression).
        differentiate1 = new Mult(getExpressionLeft().differentiate(var), getExpressionRight());
        // Right expression (differentiate the right expression according to a given
        // variable and multiple in the left expression).
        differentiate2 = new Mult(getExpressionRight().differentiate(var), getExpressionLeft());
        // Return the differentiate of the  two internal expressions (according to a given variable)
        return new Plus(differentiate1, differentiate2);
    }

    /**
     * simplify - Returned a simplified version of the current expression.
     *
     * @return a simplified version of the current expression.
     */
    public Expression simplify() {
        double expressionMult;
        // Simplify of the left expression
        Expression simplifyLeft = getExpressionLeft().simplify();
        // Simplify of the right expression
        Expression simplifyRight = getExpressionRight().simplify();

        // If the left expression is 1
        if (simplifyLeft.toString().equals("1.0")) {
            // Return the right expression
            return simplifyRight;
        }
        // If the right expression is 1
        if (simplifyRight.toString().equals("1.0")) {
            // Return the left expression
            return simplifyLeft;
        }
        // If the left expression is 0 or if the right expression is 0
        if ((simplifyLeft.toString().equals("0.0")) || (simplifyRight.toString().equals("0.0"))) {
            // Return 0
            return new Num(ZERO);
        }
        // If the left expression is equals to the right expression
        if ((simplifyLeft.toString().equals(simplifyRight.toString()))) {
            // Return x^2
            return new Pow(simplifyLeft, new Num(TWO));
        }
        // If the left expression and the right expression are different from 1 or 0
        // Return the expression without change
        try {
            expressionMult = (new Mult(simplifyLeft, simplifyRight)).evaluate();
            return new Num(expressionMult);
        } catch (Exception exc) {
            // Return the expression without change (and simplify the inside expression)
            return new Mult(simplifyLeft, simplifyRight);
        }
    }
}
