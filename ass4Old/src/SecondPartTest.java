/**
 * The type Second part test.
 */
public class SecondPartTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Expression[] e = new Expression[28];
        e[0] = new Plus(new Num(0), new Var("x"));
        e[1] = new Plus(new Var("x"), new Num(0));
        e[2] = new Plus(new Var("x"), new Var("x"));
        e[3] = new Minus(new Var("x"), new Num(0));
        e[4] = new Minus(new Num(0), new Var("x"));
        e[5] = new Minus(new Var("x"), new Var("x"));
        e[6] = new Mult(new Num(0), new Var("x"));
        e[7] = new Mult(new Var("x"), new Num(0));
        e[8] = new Mult(new Num(1), new Var("x"));
        e[9] = new Mult(new Var("x"), new Num(1));
        e[10] = new Mult(new Var("x"), new Var("x"));
        e[11] = new Div(new Var("x"), new Num(3));
        e[12] = new Div(new Num(0), new Var("x"));
        e[13] = new Div(new Var("x"), new Num(1));
        e[14] = new Div(new Num(1), new Var("x"));
        e[15] = new Div(new Var("x"), new Var("x"));
        e[16] = new Pow(new Var("x"), new Num(0));
        e[17] = new Pow(new Var("x"), new Num(5));
        e[18] = new Pow(new Var("x"), new Num(1));
        e[19] = new Pow(new Var("e"), new Var("x"));
        e[20] = new Log(new Var("x"), new Var("x"));
        e[21] = new Log(new Var("x"), new Num(2));
        e[22] = new Log(new Var("x"), new Num(1));
        e[23] = new Log(new Var("x"), new Num(4));
        e[24] = new Log(new Num(2), new Var("x"));
        e[25] = new Neg(new Neg(new Sin(new Neg(new Sin(new Neg(new Var("x")))))));
        e[26] = new Mult(
                new Mult(new Sin(new Var("x")), new Sin(new Var("x"))),
                new Mult(new Sin(new Var("x")), new Sin(new Var("x")))
        );
        e[27] = new Plus(
                new Cos(new Var("x")),
                new Plus(new Plus(new Cos(new Var("x")), new Cos(new Var("x"))), new Cos(new Var("x")))
        );
        java.util.Map<String, Double> assignment = new java.util.TreeMap<String, Double>();
        assignment.put("x", 1.5);
        assignment.put("e", 2.71);
        for (int i = 0; i < e.length; i++) {

            System.out.println("Expression " + (i) + " : " + e[i].toString());
            try {
                System.out.println("Expression " + (i) + " evaluate x = 1.5: " + e[i].evaluate(assignment));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            e[i] = e[i].differentiate("x");
            System.out.println("Expression " + (i) + " differentiate: " + e[i].toString());
            try {
                System.out.println(
                        "Expression " + (i) + " differentiate evaluate x = 1.5: " + e[i].evaluate(assignment));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        Expression e1 = new Mult(new Var("x"), new Num(1.0));
        System.out.println("checkNew e1  x*1:  " + e1.simplify());
        Expression e2 = new Mult(new Num(1.0), new Var("x"));
        System.out.println("checkNew e2   1*x:  " + e2.simplify());
        Expression e3 = new Mult(new Num(0.0), new Var("x"));
        System.out.println("checkNew e3   0*x:  " + e3.simplify());
        Expression e4 = new Mult(new Var("x"), new Num(0.0));
        System.out.println("checkNew e4   x*0:  " + e4.simplify());
        Expression e5 = new Div(new Var("x"), new Var("x"));
        System.out.println("checkNew e5    x/x:  " + e5.simplify());
        Expression e6 = new Div(new Var("x"), new Num(1.0));
        System.out.println("checkNew e6   x/1:  " + e6.simplify());
        Expression e7 = new Minus(new Var("x"), new Num(0.0));
        System.out.println("checkNew e7   x-0:  " + e7.simplify());
        Expression e8 = new Minus(new Num(0.0), new Var("x"));
        System.out.println("checkNew e8    0-x:  " + e8.simplify());
        Expression e9 = new Plus(new Num(0.0), new Var("x"));
        System.out.println("checkNew e9  0+x:  " + e9.simplify());
        Expression e10 = new Plus(new Var("x"), new Num(0.0));
        System.out.println("checkNew e10   x+0:  " + e10.simplify());
        Expression e11 = new Minus(new Var("x"), new Var("x"));
        System.out.println("checkNew e11    x-x:  " + e11.simplify());
        Expression e12 = new Log(new Var("x"), new Var("x"));
        System.out.println("checkNew e12    log(x,x):  " + e12.simplify());
        Expression e13 = new Plus(new Mult(new Num(0.0), new Var("x")), new Mult(new Num(1.0), new Num(0.0)));
        System.out.println("checkNew e13   0*x + 1*0:  " + e13.simplify());
        Expression e14 = new Mult(new Pow(new Var("x"), new Num(5)), (new Pow(new Var("x"), (new Div((new Mult(new Num(-1), (new Mult(new Num(-1), (new Mult(new Num(-1)
                , (new Mult(new Num(-1), (new Mult((new Minus(new Num(5), (new Pow((new Mult((new Plus(new Num(1)
                , (new Plus(new Mult(new Num(0.0), new Var("x")), new Mult(new Num(1.0), new Num(0.0))))))
                , new Num(2))), new Num(3))))), new Num(-3))))))))))), new Num(-2))))));
        System.out.println("checkNew e14  (x^(-4.5)) * (x^(-1 * (-1 * (-1 * ((5 - ((1 + (0*x + 1*0)) * 2)^3) * -3))))) :  " + e14.simplify());
        Expression e15 = new Log(new Num(10), new Num(10));
        System.out.println("checkNew e15    log (10.0, 10.0):  " + e15.simplify());
    }
    /*
    answers:"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.3.1\lib\idea_rt.jar=14409:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.3.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\Tomer\אוניברסיטה\תכנות\שיעורי בית-תכנות\מונחה עצמים\ass4\out\production\ass4" SecondPartTest
Expression 0 : (0.0 + x)
Expression 0 evaluate x = 1.5: 1.5
Expression 0 differentiate: (0.0 + 1.0)
Expression 0 differentiate evaluate x = 1.5: 1.0
Expression 1 : (x + 0.0)
Expression 1 evaluate x = 1.5: 1.5
Expression 1 differentiate: (1.0 + 0.0)
Expression 1 differentiate evaluate x = 1.5: 1.0
Expression 2 : (x + x)
Expression 2 evaluate x = 1.5: 3.0
Expression 2 differentiate: (1.0 + 1.0)
Expression 2 differentiate evaluate x = 1.5: 2.0
Expression 3 : (x - 0.0)
Expression 3 evaluate x = 1.5: 1.5
Expression 3 differentiate: (1.0 - 0.0)
Expression 3 differentiate evaluate x = 1.5: 1.0
Expression 4 : (0.0 - x)
Expression 4 evaluate x = 1.5: -1.5
Expression 4 differentiate: (0.0 - 1.0)
Expression 4 differentiate evaluate x = 1.5: -1.0
Expression 5 : (x - x)
Expression 5 evaluate x = 1.5: 0.0
Expression 5 differentiate: (1.0 - 1.0)
Expression 5 differentiate evaluate x = 1.5: 0.0
Expression 6 : (0.0 * x)
Expression 6 evaluate x = 1.5: 0.0
Expression 6 differentiate: ((0.0 * x) + (1.0 * 0.0))
Expression 6 differentiate evaluate x = 1.5: 0.0
Expression 7 : (x * 0.0)
Expression 7 evaluate x = 1.5: 0.0
Expression 7 differentiate: ((1.0 * 0.0) + (0.0 * x))
Expression 7 differentiate evaluate x = 1.5: 0.0
Expression 8 : (1.0 * x)
Expression 8 evaluate x = 1.5: 1.5
Expression 8 differentiate: ((0.0 * x) + (1.0 * 1.0))
Expression 8 differentiate evaluate x = 1.5: 1.0
Expression 9 : (x * 1.0)
Expression 9 evaluate x = 1.5: 1.5
Expression 9 differentiate: ((1.0 * 1.0) + (0.0 * x))
Expression 9 differentiate evaluate x = 1.5: 1.0
Expression 10 : (x * x)
Expression 10 evaluate x = 1.5: 2.25
Expression 10 differentiate: ((1.0 * x) + (1.0 * x))
Expression 10 differentiate evaluate x = 1.5: 3.0
Expression 11 : (x / 3.0)
Expression 11 evaluate x = 1.5: 0.5
Expression 11 differentiate: (((1.0 * 3.0) - (0.0 * x)) / (3.0^2.0))
Expression 11 differentiate evaluate x = 1.5: 0.3333333333333333
Expression 12 : (0.0 / x)
Expression 12 evaluate x = 1.5: 0.0
Expression 12 differentiate: (((0.0 * x) - (1.0 * 0.0)) / (x^2.0))
Expression 12 differentiate evaluate x = 1.5: 0.0
Expression 13 : (x / 1.0)
Expression 13 evaluate x = 1.5: 1.5
Expression 13 differentiate: (((1.0 * 1.0) - (0.0 * x)) / (1.0^2.0))
Expression 13 differentiate evaluate x = 1.5: 1.0
Expression 14 : (1.0 / x)
Expression 14 evaluate x = 1.5: 0.6666666666666666
Expression 14 differentiate: (((0.0 * x) - (1.0 * 1.0)) / (x^2.0))
Expression 14 differentiate evaluate x = 1.5: -0.4444444444444444
Expression 15 : (x / x)
Expression 15 evaluate x = 1.5: 1.0
Expression 15 differentiate: (((1.0 * x) - (1.0 * x)) / (x^2.0))
Expression 15 differentiate evaluate x = 1.5: 0.0
Expression 16 : (x^0.0)
Expression 16 evaluate x = 1.5: 1.0
Expression 16 differentiate: ((0.0 * (x^(0.0 - 1.0))) * 1.0)
Expression 16 differentiate evaluate x = 1.5: 0.0
Expression 17 : (x^5.0)
Expression 17 evaluate x = 1.5: 7.59375
Expression 17 differentiate: ((5.0 * (x^(5.0 - 1.0))) * 1.0)
Expression 17 differentiate evaluate x = 1.5: 25.3125
Expression 18 : (x^1.0)
Expression 18 evaluate x = 1.5: 1.5
Expression 18 differentiate: ((1.0 * (x^(1.0 - 1.0))) * 1.0)
Expression 18 differentiate evaluate x = 1.5: 1.0
Expression 19 : (e^x)
Expression 19 evaluate x = 1.5: 4.461223038584823
Expression 19 differentiate: ((e^x) * ((0.0 * (x / e)) + (1.0 * log(e, e))))
Expression 19 differentiate evaluate x = 1.5: 4.4476102182641375
Expression 20 : log(x, x)
Expression 20 evaluate x = 1.5: 1.0
Expression 20 differentiate: ((((1.0 / x) * log(e, x)) - ((1.0 / x) * log(e, x))) / (log(e, x)^2.0))
Expression 20 differentiate evaluate x = 1.5: 0.0
Expression 21 : log(x, 2.0)
Expression 21 evaluate x = 1.5: 1.7095112913514547
Expression 21 differentiate: ((((0.0 / 2.0) * log(e, x)) - ((1.0 / x) * log(e, 2.0))) / (log(e, x)^2.0))
Expression 21 differentiate evaluate x = 1.5: -2.810782411221132
Expression 22 : log(x, 1.0)
Expression 22 evaluate x = 1.5: 0.0
Expression 22 differentiate: ((((0.0 / 1.0) * log(e, x)) - ((1.0 / x) * log(e, 1.0))) / (log(e, x)^2.0))
Expression 22 differentiate evaluate x = 1.5: 0.0
Expression 23 : log(x, 4.0)
Expression 23 evaluate x = 1.5: 3.4190225827029095
Expression 23 differentiate: ((((0.0 / 4.0) * log(e, x)) - ((1.0 / x) * log(e, 4.0))) / (log(e, x)^2.0))
Expression 23 differentiate evaluate x = 1.5: -5.621564822442264
Expression 24 : log(2.0, x)
Expression 24 evaluate x = 1.5: 0.5849625007211562
Expression 24 differentiate: ((((1.0 / x) * log(e, 2.0)) - ((0.0 / 2.0) * log(e, x))) / (log(e, 2.0)^2.0))
Expression 24 differentiate evaluate x = 1.5: 0.9617966939259756
Expression 25 : (-(-sin((-sin((-x))))))
Expression 25 evaluate x = 1.5: 4.568739202025734E-4
Expression 25 differentiate: (-(-((-((-1.0) * cos((-x)))) * cos((-sin((-x)))))))
Expression 25 differentiate evaluate x = 1.5: 0.9996572206444263
Expression 26 : ((sin(x) * sin(x)) * (sin(x) * sin(x)))
Expression 26 evaluate x = 1.5: 4.6954374723022307E-7
Expression 26 differentiate: (((((1.0 * cos(x)) * sin(x)) + ((1.0 * cos(x)) * sin(x))) * (sin(x) * sin(x))) + ((((1.0 * cos(x)) * sin(x)) + ((1.0 * cos(x)) * sin(x))) * (sin(x) * sin(x))))
Expression 26 differentiate evaluate x = 1.5: 7.172460911709702E-5
Expression 27 : (cos(x) + ((cos(x) + cos(x)) + cos(x)))
Expression 27 evaluate x = 1.5: 3.998629299902229
Expression 27 differentiate: ((-(1.0 * sin(x))) + (((-(1.0 * sin(x))) + (-(1.0 * sin(x)))) + (-(1.0 * sin(x)))))
Expression 27 differentiate evaluate x = 1.5: -0.10470779323149261
*/
}
