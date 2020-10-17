// ID: 208387969

import java.util.Map;

/**
 * Cos - The class represents a cosine (a cosine to the inner expression).
 * The class extends from the UnaryExpression.
 */
public class Cos extends UnaryExpression {
    /**
     * constructor with configurable of the expression.
     *
     * @param expression - The expression.
     */
    public Cos(Expression expression) {
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
        // return the result of the expression in radians (before the cosine)
        double resultInRadians = Math.toRadians(getExpression().evaluate(assignment));
        // return the result of the expression (cosine for this expression) in radians
        return Math.cos(resultInRadians);
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
        // return the result of the expression (cosine for this expression) in radians
        return Math.cos(resultInRadians);
    }

    /**
     * typeOfOperation - Return the type of the operation.
     *
     * @return The type of the operation.
     */
    @Override
    public String typeOfOperation() {
        return "cos";
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
        return new Cos(newExpression);
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
        // Differentiate to the expression (without the inside differentiate) ( cos[x] = -sin[x] )
        // The minus will be for all the expression
        differentiate1 = new Sin(getExpression());
        // Differentiate to the inside expression
        differentiate2 = getExpression().differentiate(var);
        //  ( cos[f(x)] = -sin[f(x)] * f'(x) )
        return new Neg(new Mult(differentiate2, differentiate1));
    }

    /**
     * simplify - Returned a simplified version of the current expression.
     *
     * @return a simplified version of the current expression.
     */
    public Expression simplify() {
        double expressionCos;
        // Simplify of the expression
        Expression simplify = getExpression().simplify();
        try {
            expressionCos = (new Cos(simplify)).evaluate();
            return new Num(expressionCos);
        } catch (Exception exc) {
            // Return the expression without change (and simplify the inside expression)
            return new Cos(simplify);
        }
    }
}
