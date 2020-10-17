// ID: 208387969

/**
 * The program receives three decimal numbers as arguments.
 * The program check two things:
 * - check if the three numbers represent the lengths of edges of a triangle.
 * - check if one of the angels in this triangle is 90 degrees.
 * If the input has less than 3 values or if one of the values is 0 or less, the program prints “Invalid input”.
 */
public class TriangleCheck {
    /**
     * check if it's a triangle and if one of the angels in this triangle is 90 degrees.
     *
     * @param args three decimal numbers from the command line.
     */
    // if one of the values is 0 or less, the program must print “Invalid input”.
    public static void main(String[] args) {
        // If the input has less than 3 values the input is invalid
        if (args.length < 3) {
            System.out.println("Invalid input");
            // get out from the program
            System.exit(0);
        }
        // The ribs in the triangle
        double ribA = Double.parseDouble(args[0]);
        double ribB = Double.parseDouble(args[1]);
        double ribC = Double.parseDouble(args[2]);
        // indication that the triangle is right angled
        boolean isRightAngled = false;
        // A low number that represents the calculation deviation
        double deviation = Math.pow(10 , -14);
        // If one of the values is 0 or less, the input is invalid
        if ((ribA <= 0) || (ribB <= 0) || (ribC <= 0)) {
            System.out.println("Invalid input");
            // get out from the program
            System.exit(0);
            // If all the values are bigger then 0
        } else {
            // if pair of ribs in a triangle not larger than the third it means not triangle
            if (((ribA + ribB) <= ribC) || ((ribB + ribC) <= ribA) || ((ribA + ribC) <= ribB)) {
                System.out.println("not triangle");
                // get out from the program
                System.exit(0);
            } else {
                //if pair of ribs in a triangle are larger than the third it means it's a triangle
                System.out.println("triangle!");
                // If a Pythagorean theorem is held then it is a right-angled triangle
                if (((Math.abs(Math.sqrt(ribC * ribC + ribB * ribB) - ribA) < deviation)
                        || (Math.abs(Math.sqrt(ribA * ribA + ribC * ribC) - ribB) < deviation))
                        || (Math.abs(Math.sqrt(ribA * ribA + ribB * ribB) - ribC) < deviation)) {
                    isRightAngled = true;
                }
                // If it's a right angled triangle
                if (isRightAngled) {
                    System.out.println("right angled!");
                }
            }
        }
    }
}



