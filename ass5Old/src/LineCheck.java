import geometry.Line;
import geometry.Point;

public class LineCheck {
    public static void main(String[] args) {
        /**
         boolean problem = false;

         geometry.Line l1 = new geometry.Line(1, 1, 2, 2);
         geometry.Line l2 = new geometry.Line(3, 3, 2, 2);
         geometry.Line l3 = new geometry.Line(1.1, 0, 1.1, 1.1);
         geometry.Line l4 = new geometry.Line(0, 1.75, 2, 1.75);
         geometry.Line l5 = new geometry.Line(2.5, 2.5, 2.5, 2.5);
         */
        Line l6 = new Line(64.64101615137753, 80.0, 73.30127018922191, 75.0);
        Line l7 = new Line(70.0, 70.0, 70.0, 90.0);


        if (l6.isIntersecting(l7)) {
            Point pointCheck = l6.intersectionWith(l7);
            System.out.println(" Intersecting ");
            System.out.println("  ");
            System.out.println(" ****intersection:  " + "(" + pointCheck.getX() + "," + pointCheck.getY() + ")");
            System.out.println("  ");
            System.out.println("  ");
        }

/**
 if (!l1.intersectionWith(l2).equals(new geometry.Point(2, 2))) {
 problem = true;
 System.out.println("ERROR, intersectionWith problematic");
 }
 if (l2.isIntersecting(l4) || l2.intersectionWith(l4) != null) {
 problem = true;
 System.out.println("ERROR, intersectionWith or isIntersecting problematic");
 }
 if (l3.isIntersecting(l4) || l3.intersectionWith(l4) != null) {
 problem = true;
 System.out.println("ERROR, intersectionWith problematic");
 }
 if (!l1.middle().equals(new geometry.Point(1.5, 1.5)) || !l2.middle().equals(new geometry.Point(2.5, 2.5))) {
 problem = true;
 System.out.println("ERROR, middle problematic");
 }
 if (!l5.intersectionWith(l2).equals(l5.start())) {
 System.out.println("ERROR, intersectionWith problematic");
 }
 if (!problem) {
 System.out.println("Your line is fine, although you can check again because why not, yair koskas hameleh");
 }
 */
    }
}
