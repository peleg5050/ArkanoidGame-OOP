// ID: 208387969

import java.util.Map;

/**
 * Log - The class represents a log operation (two internal expressions - the log and the base , and calculate the log)
 * The class extends from the BinaryExpression.
 */

public class Log extends BinaryExpression {
    private static final double ZERO = 0;
    private static final double ONE = 1;
    private static final String BASE = "e";

    /**
     * constructor with configurable of the left expression and the right expression (do log of the right expression
     * in base of the left expression).
     *
     * @param expressionLeft  - The base of the expression.
     * @param expressionRight - The phrase that Log is performed on.
     */
    public Log(Expression expressionLeft, Expression expressionRight) {
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
        // If the base of the expression or the phrase that Log is performed on are negative numbers - throw exception
        if ((getExpressionRight().evaluate(assignment) <= ZERO) || ((getExpressionLeft().evaluate(assignment) <= ZERO)
                || (getExpressionLeft().evaluate(assignment) == ONE))) {
            throw new Exception("illegal !!");
        }
        // return the result of the expression
        return Math.log(getExpressionRight().evaluate(assignment)) / Math.log(getExpressionLeft().evaluate(assignment));
    }

    /**
     * evaluate - A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return the result of the expression.
     * @throws Exception - If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    @Override
    public double evaluate() throws Exception {
        // If the base of the expression or the phrase that Log is performed on are negative numbers - throw exception
        if ((getExpressionRight().evaluate() <= ZERO) || ((getExpressionLeft().evaluate() <= ZERO)
                || (getExpressionLeft().evaluate() == ONE))) {
            throw new Exception("illegal !! - the base of the log is 1");
        }
        // return the result of the expression
        return Math.log(getExpressionRight().evaluate()) / Math.log(getExpressionLeft().evaluate());
    }

    /**
     * typeOfOperation - Return the type of the operation.
     *
     * @return The type of the operation.
     */
    @Override
    public String typeOfOperation() {
        return "log";
    }

    /**
     * toString - This function returns a nice string representation of the expression.
     *
     * @return A string representation of the expression.
     */
    @Override
    public String toString() {
        return (typeOfOperation() + "(" + getExpressionLeft().toString() + ", "
                + getExpressionRight().toString() + ")");
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
        return new Log(newExpression1, newExpression2);
    }

    /**
     * differentiate - Returns the expression tree resulting from differentiating the current
     * expression relative to variable `var`.
     *
     * @param var - The simplest level expression represents a standard variable (contains a string).
     * @return the expression tree resulting from differentiating the current expression (relative to variable).
     */
    public Expression differentiate(String var) {
        Expression expressionLog, expressionMult, newExpression;
        // ln(base) = log e(F(x))
        expressionLog = new Log(new Var(BASE), getExpressionLeft());
        // log e(F(x)) * (G(x)) = ln(base) * (G(x))
        expressionMult = new Mult(expressionLog, getExpressionRight());
        // (G(x))' / (log e(F(x)) * (G(x)))  =  (G(x))' / (ln(base) * (G(x)))
        newExpression = new Div(getExpressionRight().differentiate(var), expressionMult);
        // Return the expression tree resulting from differentiating the current expression relative to variable `var`
        return newExpression;

        /**
         // ( log f(x) (G(x)) )'
         //
         Expression expressionLog1 , expressionMult1 , expressionDiv1 , expressionLog2 , expressionMult2
         , expressionDiv2 , numerator , denominator , newExpression;
         // log10(F(x))
         expressionLog1 = new Log(new Num(BASE) , getExpressionLeft());
         // log10(F(x)) * (G(x))'
         expressionMult1 = new Mult(expressionLog1 , getExpressionRight().differentiate(var));
         // (log10(F(x)) * (G(x))') / G(x)
         expressionDiv1 = new Div(expressionMult1 , getExpressionRight());
         // log10(G(x))
         expressionLog2 = new Log(new Num(BASE) , getExpressionRight());
         // (F(x))' * log10(G(x))
         expressionMult2 = new Mult(getExpressionLeft().differentiate(var) , expressionLog2);
         // (F(x))' * log10(G(x)) / F(x)
         expressionDiv2 = new Div(expressionMult2 , getExpressionLeft());
         // ( (log10(F(x)) * (G(x))') / G(x) ) - ( (F(x))' * log10(G(x)) / F(x) )
         numerator = new Minus(expressionDiv1 , expressionDiv2);
         // log10(F(x)) * log10(F(x))
         denominator = new Mult(expressionLog1 , expressionLog1);
         // [( (log10(F(x)) * (G(x))') / G(x) ) - ( (F(x))' * log10(G(x)) / F(x) )] / [log10(F(x)) * log10(F(x))]
         newExpression = new Div(numerator , denominator);
         // Return the expression tree resulting from differentiating the current expression relative to variable `var`
         return newExpression;
         */
    }

    /**
     * simplify - Returned a simplified version of the current expression.
     *
     * @return a simplified version of the current expression.
     */
    public Expression simplify() {
        double expressionLog;
        // Simplify of the left expression
        Expression simplifyLeft = getExpressionLeft().simplify();
        // Simplify of the right expression
        Expression simplifyRight = getExpressionRight().simplify();
        // If the left expression is equals to the right expression
        if (simplifyLeft.toString().equals(simplifyRight.toString())) {
            // Return 1
            return new Num(ONE);
        }
        try {
            expressionLog = (new Log(simplifyLeft, simplifyRight)).evaluate();
            return new Num(expressionLog);
        } catch (Exception exc) {
            // Return the expression without change (and simplify the inside expression)
            return new Log(simplifyLeft, simplifyRight);
        }
    }
}
