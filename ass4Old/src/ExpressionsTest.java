// ID: 208387969

import java.util.Map;
import java.util.TreeMap;

/**
 * ExpressionsTest - The class Create an expression, print him, print the value of the expression
 * with (x=2,y=0.25,e=2.71) , print the differentiated expression according to x , print the value of the
 * differentiated expression according to x with the assignment above , print the simplified differentiated expression.
 */
public class ExpressionsTest {
    private static final double TWO = 2;
    private static final double FOUR = 4;

    /**
     * main -  Create an expression, print him, print the value of the expression
     * with (x=2,y=0.25,e=2.71) , print the differentiated expression according to x , print the value of the
     * differentiated expression according to x with the assignment above , print the simplified differentiated
     * expression.
     *
     * @param args - what we get.
     */
    public static void main(String[] args) {
        // Create the expression (2x) + (sin(4y)) + (e^x)
        Expression e1 = new Plus((new Plus(new Mult(new Num(TWO), new Var("x")), new Sin(new Mult(new Num(FOUR),
                new Var("y"))))), new Pow(new Var("e"), new Var("x")));
        // Print the expression
        System.out.println(e1.toString());
        Map<String, Double> assignment = new TreeMap<String, Double>();
        // expression: ((x + y) + (z + w))^4
        assignment.clear();
        assignment.put("x", 2.0);
        assignment.put("y", 0.25);
        assignment.put("e", 2.71);
        // Print the value of the expression with (x=2,y=0.25,e=2.71)
        try {
            System.out.println(e1.evaluate(assignment));
        } catch (Exception exc) {
            System.out.println("exception - got problem while calculating the value of the expression");
        }
        // Print the differentiated expression according to x
        System.out.println(e1.differentiate("x").toString());
        // Print the value of the differentiated expression according to x with the assignment above
        try {
            System.out.println(e1.differentiate("x").evaluate(assignment));
        } catch (Exception exc) {
            System.out.println("exception - got problem while calculating the value of the differentiated expression"
                    + " according to x with the assignment above");
        }
        // Print the simplified differentiated expression
        System.out.println(e1.differentiate("x").simplify().toString());

    }
}
