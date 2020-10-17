// ID: 208387969

import java.util.Map;

/**
 * Pow - The class represents a power operation (do pow for two internal expressions and calculate them).
 * The class extends from the BinaryExpression.
 */
public class Pow extends BinaryExpression {
    private static final double ZERO = 0;
    private static final double ONE = 1;
    private static final String BASE = "e";

    /**
     * constructor with configurable of the left expression and the right expression (the basic and his pow).
     *
     * @param expressionLeft  - The expression of the basic
     * @param expressionRight - The strongest expression
     */
    public Pow(Expression expressionLeft, Expression expressionRight) {
        super(expressionLeft, expressionRight);
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
        // fraction to negative number
        if ((getExpressionLeft().evaluate(assignment) < ZERO) && ((getExpressionRight().evaluate(assignment) < ONE)
                && (getExpressionRight().evaluate(assignment) > ZERO))) {
            throw new Exception("fraction to negative number!!");
        }
        // return the result of the expression
        return Math.pow(getExpressionLeft().evaluate(assignment), getExpressionRight().evaluate(assignment));
    }

    /**
     * evaluate - A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return the result of the expression.
     * @throws Exception - If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    @Override
    public double evaluate() throws Exception {
        // fraction to negative number
        if ((getExpressionLeft().evaluate() < ZERO) && ((getExpressionRight().evaluate() < ONE)
                && (getExpressionRight().evaluate() > ZERO))) {
            throw new Exception("fraction to negative number!!");
        }
        // return the result of the expression
        return Math.pow(getExpressionLeft().evaluate(), getExpressionRight().evaluate());
    }

    /**
     * typeOfOperation - Return the type of the operation.
     *
     * @return The type of the operation.
     */
    @Override
    public String typeOfOperation() {
        return "^";
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
        //new expression for the basic expression (the variable var are replaced with the provided expression)
        newExpression1 = getExpressionLeft().assign(var, expression);
        //new expression for the pow expression (the variable var are replaced with the provided expression)
        newExpression2 = getExpressionRight().assign(var, expression);
        return new Pow(newExpression1, newExpression2);
    }

    /**
     * differentiate - Returns the expression tree resulting from differentiating the current
     * expression relative to variable `var`.
     *
     * @param var - The simplest level expression represents a standard variable (contains a string).
     * @return the expression tree resulting from differentiating the current expression (relative to variable).
     */
    public Expression differentiate(String var) {
        // (F(x) ^ G(x))'
        Expression expressionPow, expressionDiv, expressionMult1, expressionLn, expressionMult2, expressionPlus,
                expressionMult3;
        // F(x) ^ G(x)
        expressionPow = new Pow(getExpressionLeft(), getExpressionRight());
        // G(x) / F(x)
        expressionDiv = new Div(getExpressionRight(), getExpressionLeft());
        // F'(x) * ( G(x) / F(x) )
        expressionMult1 = new Mult(getExpressionLeft().differentiate(var), expressionDiv);
        // ln( F(x) )
        expressionLn = new Log(new Var(BASE), getExpressionLeft());
        // G'(x) * ln(F(x))
        expressionMult2 = new Mult(getExpressionRight().differentiate(var), expressionLn);
        // F'(x) * ( G(x) / F(x) ) + ( G'(x) * ln(F(x)) )
        expressionPlus = new Plus(expressionMult1, expressionMult2);
        // (F(x) ^ G(x)) * [F'(x) * ( G(x) / F(x) ) + ( G'(x) * ln(F(x)) )]
        expressionMult3 = new Mult(expressionPow, expressionPlus);
        // Return the expression tree resulting from differentiating the current expression relative to variable `var`
        return expressionMult3;
    }

    /**
     * simplify - Returned a simplified version of the current expression.
     *
     * @return a simplified version of the current expression.
     */
    public Expression simplify() {
        double expressionPow;
        // Simplify of the left expression
        Expression simplifyLeft = getExpressionLeft().simplify();
        // Simplify of the right expression
        Expression simplifyRight = getExpressionRight().simplify();
        // If the right expression is 1
        if (simplifyRight.toString().equals("1.0")) {
            // Return the left expression
            return simplifyLeft;
        }
        // If the right expression is 0
        if (simplifyRight.toString().equals("0.0")) {
            // Return 1
            return new Num(ONE);
        }
        // If the left expression is 1
        if (simplifyLeft.toString().equals("1.0")) {
            // Return 1
            return new Num(ONE);
        }
        try {
            expressionPow = (new Pow(simplifyLeft, simplifyRight)).evaluate();
            return new Num(expressionPow);
        } catch (Exception exc) {
            // Return the expression without change (and simplify the inside expression)
            return new Pow(simplifyLeft, simplifyRight);
        }
    }
}
