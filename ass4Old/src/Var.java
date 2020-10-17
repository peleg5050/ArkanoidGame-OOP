// ID: 208387969

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Var - The simplest level expression represents a standard variable (contains a string that represents a variable).
 * The class implements the Expression interface.
 */
public class Var implements Expression {
    private static final double ZERO = 0;
    private static final double ONE = 1;
    private static final String SIGN_E = "e";
    private static final String PI = "Pi";
    // Characteristics
    private String var;

    /**
     * constructor with configurable of var.
     *
     * @param var -  An expression from the simplest level represents a standard variable (contains a string).
     */
    public Var(String var) {
        this.var = var;
    }

    /**
     * evaluate - The expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment - A data structure that uses the string and double to store data.
     * @return the result of the expression.
     * @throws Exception - If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        // If the var is not contains in the map
        if (!assignment.containsKey(var)) {
            // If the var that we got is e
            if (var.equals(SIGN_E)) {
                return Math.E;
            }
            // If the var that we got is pi
            if (var.equals(PI)) {
                return Math.PI;
            }
            // Throws exception
            throw new Exception("Exception - " + var + " is not contains in the map");
        // If the value of the var is not contains in the map - throw exception
        } else if (assignment.get(var) == null) {
            throw new Exception("Exception - the value of the var: " + var + " is not contains in the map");
        } else {
            // Return the value that contains in the map
            return assignment.get(var);
        }
    }

    /**
     * evaluate - A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment so
     * an exception is thrown.
     *
     * @return the result of the expression (here it's will just throw exception).
     * @throws Exception - an exception is thrown.
     */
    public double evaluate() throws Exception {
        // If the var that we got is e
        if (var.equals(SIGN_E)) {
            return Math.E;
        }
        // If the var that we got is pi
        if (var.equals(PI)) {
            return Math.PI;
        }
        throw new Exception("Exception - no map");
    }

    /**
     * getVariables - This function returns the variables in the form of a list.
     *
     * @return Variables in the form of a list
     */
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        list.add(this.var);
        return list;
    }

    /**
     * toString - This function returns a nice string representation of the expression (val).
     *
     * @return A string representation of the expression (val).
     */
    public String toString() {
        return this.var;
    }

    /**
     * assign - This function returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the current expression).
     * Here the function return provided expression.
     *
     * @param currentVar        - The simplest level expression represents a standard variable (contains a string).
     * @param expression - The provided expression.
     * @return The provided expression.
     */
    public Expression assign(String currentVar, Expression expression) {
        // If the current var is not equals to the given var
        if (!((this.var).equals(currentVar))) {
            // return the var
            return new Var(this.var);
        }
        // If the current var is equals to the given var
        //Return the provided expression.
        return expression;
    }

    /**
     * differentiate - Returns the expression tree resulting from differentiating the current
     * expression relative to variable `var`.
     *
     * @param currentVar - The simplest level expression represents a standard variable (contains a string).
     * @return the expression tree resulting from differentiating the current expression (relative to variable).
     */
    public Expression differentiate(String currentVar) {
        // If the current var is not equals to the given var
        if (!((this.var).equals(currentVar))) {
            // Return 0 (differentiate of a num is 0)
            return new Num(ZERO);
        }
        // The current var is not equals to the given var
        // Return 1 (differentiate of a variable is 1)
        return new Num(ONE);
    }

    /**
     * simplify - Returned a simplified version of the current expression (return the variable).
     *
     * @return a simplified version of the current expression.
     */
    public Expression simplify() {
        // return the var
        return new Var(this.var);
    }
}
