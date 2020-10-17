// ID: 208387969

import java.util.Map;

/**
 * Sin - The class represents a sine (a sine to the inner expression).
 * The class extends from the UnaryExpression.
 */
public class Sin extends UnaryExpression {
    private static final double EPSILON = 10 ^ -10;

    /**
     * constructor with configurable of the expression.
     *
     * @param expression - The expression.
     */
    public Sin(Expression expression) {
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
        double toRad, resultInRadians;
        // return the result of the expression in radians (before the sine)
        toRad = Math.toRadians(getExpression().evaluate(assignment));
        // The result of the expression (sin for this expression) in radians
        resultInRadians = Math.sin(toRad);
        if (resultInRadians <= EPSILON) {
            return 0;
        }
        // return the result of the expression (sin for this expression) in radians
        return resultInRadians;
    }

    /**
     * evaluate - A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return the result of the expression.
     * @throws Exception - If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    @Override
    public double evaluate() throws Exception {
        // return the result of the expression in radians (before the sine)
        double resultInRadians = Math.toRadians(getExpression().evaluate());
        // return the result of the expression (sin for this expression) in radians
        return Math.sin(resultInRadians);
    }

    /**
     * typeOfOperation - Return the type of the operation.
     *
     * @return The type of the operation.
     */
    @Override
    public String typeOfOperation() {
        return "sin";
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
        return new Sin(newExpression);
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
        // Differentiate to the expression (without the inside differentiate) ( sin[x] = cos[x] )
        differentiate1 = new Cos(getExpression());
        // Differentiate to the inside expression
        differentiate2 = getExpression().differentiate(var);
        //  ( sin[f(x)] = cos[f(x)] * f'(x) )
        return new Mult(differentiate2, differentiate1);
    }

    /**
     * simplify - Returned a simplified version of the current expression.
     *
     * @return a simplified version of the current expression.
     */
    public Expression simplify() {
        double expressionSin;
        // Simplify of the expression
        Expression simplify = getExpression().simplify();
        try {
            expressionSin = (new Sin(simplify)).evaluate();
            return new Num(expressionSin);
        } catch (Exception exc) {
            // Return the expression without change (and simplify the inside expression)
            return new Sin(simplify);
        }
    }
}
