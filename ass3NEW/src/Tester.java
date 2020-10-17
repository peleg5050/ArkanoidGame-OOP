public class Tester {
    public static void main(String[] args) {

        Line l1 = new Line(6, 6, 9, 9);
        Line l2 = new Line(6, 6, 3, 3);
        Line l3 = new Line(6, 6, 9, 9);
        Line l4 = new Line(6, 6, 8, 8);
        Line l5 = new Line(5, 0, 5, 5);
        Line l6 = new Line(0, 0, 5, 5);
        Line l7 = new Line(0, 0, 1, 1);
        Line l8 = new Line(2, 2, 3, 3);
        Line l9 = new Line(6, 8, 9, 9);
        Line l10 = new Line(10, 10, 5, 7);
        Line a1 = new Line(5, 0, 5, 5);
        Line a2 = new Line(4, 5, 4, 6);
        Line a3 = new Line(4, 5, 6, 5);
        Line a4 = new Line(0, 0, 0, 5);
        Line a5 = new Line(0, 5, 0, 7);
        Line a6 = new Line(0, 5, 2, 5);
        Line a7 = new Line(0, 0, 0, 6);
        Line a8 = new Line(0, 2, 2, 2);
        Line a9 = new Line(1, 2, 4, 2);


        assertEquals(l1.isIntersecting(l2), true, "test 1");
        assertEquals(l2.isIntersecting(l1), true, "test 2");
        assertEquals(l3.isIntersecting(l4), false, "test 3");
        assertEquals(l4.isIntersecting(l3), false, "test 4");
        assertEquals(l5.isIntersecting(l6), true, "test 5");
        assertEquals(l6.isIntersecting(l5), true, "test 6");
        assertEquals(l7.isIntersecting(l8), false, "test 7");
        assertEquals(l8.isIntersecting(l7), false, "test 8");
        assertEquals(l9.isIntersecting(l10), true, "test 9");
        assertEquals(l10.isIntersecting(l9), true, "test 10");
        assertEquals(a1.isIntersecting(a2), false, "test 11");
        assertEquals(a2.isIntersecting(a1), false, "test 12");
        assertEquals(a1.isIntersecting(a3), true, "test 13");
        assertEquals(a3.isIntersecting(a1), true, "test 14");
        assertEquals(a4.isIntersecting(a5), true, "test 15");
        assertEquals(a5.isIntersecting(a4), true, "test 16");
        assertEquals(a4.isIntersecting(a6), true, "test 17");
        assertEquals(a6.isIntersecting(a4), true, "test 18");
        assertEquals(a4.isIntersecting(a7), false, "test 19");
        assertEquals(a7.isIntersecting(a4), false, "test 20");
        assertEquals(a8.isIntersecting(a9), false, "test 21");
        assertEquals(a9.isIntersecting(a8), false, "test 22");
    }

    static void assertEquals(Boolean actual, Boolean expected, String message) {
        if (actual == expected) {
            System.out.println("[PASSED] " + message);
        } else {
            System.out.println("[FAILED] " + message + " {EXPECTED: " + expected + ", ACTUAL: " + actual + "}");
        }
    }
}