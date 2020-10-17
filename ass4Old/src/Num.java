// ID: 208387969

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Num - The class representing numbers.
 * Num is an expression from the simplest level represents a regular number (contains a double value number).
 * The class implements the Expression interface.
 */
public class Num implements Expression {
    // Characteristics
    private static final double ZERO = 0;
    private double num;

    /**
     * constructor with configurable of num.
     *
     * @param num -  An expression from the simplest level represents a regular number (contains a double value Number)
     */
    public Num(double num) {
        this.num = num;
    }

    /**
     * evaluate - Return the num.
     * Evaluate the expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown, but here we will
     * just return the num.
     *
     * @param assignment - A data structure that uses the string and double to store data.
     * @return The num.
     * @throws Exception -  If the expression contains a variable which is not in the assignment
     * ,an exception is thrown.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.num;
    }

    /**
     * evaluate - Return the num.
     * Evaluate the expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown, but here we will
     * just return the num.
     *
     * @return The num.
     * @throws Exception - If the expression contains a variable which is not in the assignment
     * ,an exception is thrown.
     */
    public double evaluate() throws Exception {
        return this.num;
    }

    /**
     * getVariables - This function returns the variables in the form of a list.
     *
     * @return Variables in the form of a list
     */
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        return list;
    }

    /**
     * toString - This function returns a nice string representation of the expression (num).
     *
     * @return A string representation of the expression (num).
     */
    public String toString() {
        return Double.toString(this.num);
    }

    /**
     * assign - This function returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the current expression).
     * Here the function return provided expression.
     *
     * @param var        - The simplest level expression represents a standard variable (contains a string).
     * @param expression - The provided expression.
     * @return The provided expression.
     */
    public Expression assign(String var, Expression expression) {
        //Return the num
        return new Num(this.num);
    }

    /**
     * differentiate - Returns the expression tree resulting from differentiating the current
     * expression relative to variable `var`.
     *
     * @param var - The simplest level expression represents a standard variable (contains a string).
     * @return the expression tree resulting from differentiating the current expression (relative to variable).
     */
    public Expression differentiate(String var) {
        return new Num(ZERO);
    }

    /**
     * simplify - Returned a simplified version of the current expression (return the num).
     *
     * @return a simplified version of the current expression.
     */
    public Expression simplify() {
        //Return the num
        return new Num(this.num);
    }
}
