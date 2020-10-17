// ID: 208387969

import java.util.List;
import java.util.Map;

/**
 * Expression - The interface declares actions: evaluate() , evaluate(Map<String, Double> assignment) , getVariables() ,
 * toString() , assign(String var, Expression expression) , differentiate(String var) , simplify().
 */
public interface Expression {
    /**
     * evaluate - Returns the result of the expression.
     * Evaluate the expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment - A data structure that uses the string and double to store data.
     * @return The result of the expression.
     * @throws Exception - If the expression contains a variable which is not in the assignment,
     * an exception is thrown.
     */
    double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * evaluate - A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @return The result of the expression.
     * @throws Exception - If the expression contains a variable which is not in the assignment,
     * an exception is thrown.
     */
    double evaluate() throws Exception;

    /**
     * getVariables - This function returns the variables in the form of a list.
     *
     * @return a list of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * toString - This function returns a nice string representation of the expression (num).
     *
     * @return A string representation of the expression (num).
     */
    String toString();

    /**
     * assign - This function returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the current expression).
     *
     * @param var        - The simplest level expression represents a standard variable (contains a string).
     * @param expression - The provided expression.
     * @return a new expression in which all occurrences of the variable var are replaced with the provided expression.
     */
    Expression assign(String var, Expression expression);

    /**
     * differentiate - Returns the expression tree resulting from differentiating the current
     * expression relative to variable `var`.
     *
     * @param var - The simplest level expression represents a standard variable (contains a string).
     * @return the expression tree resulting from differentiating the current expression (relative to variable).
     */
    Expression differentiate(String var);

    /**
     * simplify - Returned a simplified version of the current expression.
     *
     * @return a simplified version of the current expression.
     */
    Expression simplify();
}