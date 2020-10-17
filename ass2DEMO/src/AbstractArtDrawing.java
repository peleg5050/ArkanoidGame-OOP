// ID: 208387969

import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.Color;
import java.util.Random;

/**
 * AbstractArtDrawing - The class handles drawing graphics to a window and use the GUI class
 * to generate random pictures.
 * <p>
 * The class draw 10 lines in black. The middle point in each line is indicated in blue.
 * The intersection points between the lines are indicated in red
 * (the points are filled circles with a radius of 3).
 */
public class AbstractArtDrawing {

    /**
     * generateRandomLine - Helper method that returns random line.
     * The methods gives two random points and create a line between this points.
     *
     * @return Random line.
     */
    public Line generateRandomLine() {
        // create a random-number generator
        Random rand = new Random();
        // get integer in range 1-400
        int x1 = rand.nextInt(400) + 1;
        // get integer in range 1-300
        int y1 = rand.nextInt(300) + 1;
        // get integer in range 1-400
        int x2 = rand.nextInt(400) + 1;
        // get integer in range 1-300
        int y2 = rand.nextInt(300) + 1;
        // Create a line from this two random points
        Line line = new Line(x1, y1, x2, y2);
        // Return the random line
        return line;
    }

    /**
     * drawLine - Draw 10 lines in black. The middle point in each line is indicated in blue.
     * The intersection points between the lines are indicated in red.
     * The method use an helper method
     */
    public void drawLine() {
        // The start and the end X and Y values, of the random line
        double randStartX, randStartY, randEndX, randEndY;
        // Create a window with the title "Random geometry.Line Example"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Random geometry.Line Example", 400, 300);
        DrawSurface draw = gui.getDrawSurface();
        // Array of lines in size of 10
        Line[] arrayLine = new Line[10];
        // for from 0 to 10
        for (int i = 0; i < 10; ++i) {
            // Set the color in black (so the lines will draw in black)
            draw.setColor(Color.black);
            // Save the random line (that we got from "generateRandomLine") in the array
            arrayLine[i] = generateRandomLine();
            // Save the X value of the start of the random line
            randStartX = arrayLine[i].start().getX();
            // Save the Y value of the start of the random line
            randStartY = arrayLine[i].start().getY();
            // Save the X value of the end of the random line
            randEndX = arrayLine[i].end().getX();
            // Save the Y value of the end of the random line
            randEndY = arrayLine[i].end().getY();
            // Draw the line (in black)
            draw.drawLine((int) randStartX, (int) randStartY, (int) randEndX, (int) randEndY);
            // Save the middle point of the line
            Point pointMiddle = arrayLine[i].middle();
            // Set the color in blue (so the middle will draw in blue)
            draw.setColor(Color.blue);
            // Draw the middle point of the line (in blue)
            draw.fillCircle((int) pointMiddle.getX(), (int) pointMiddle.getY(), 3);
            // Check for each line if he intersect with others lines
            for (int j = 0; j < i; ++j) {
                if (arrayLine[i].isIntersecting(arrayLine[j])) {
                    // Set the color in red (so the intersect will draw in red)
                    draw.setColor(Color.red);
                    // Save the intersection point of the line
                    Point pointIntersect = arrayLine[i].intersectionWith(arrayLine[j]);
                    // Draw the intersection point (in red)
                    draw.fillCircle((int) pointIntersect.getX(), (int) pointIntersect.getY(), 3);
                }
            }
        }
        // Show the draw
        gui.show(draw);
    }

    /**
     * main - Call the drawLine function.
     *
     * @param args - array of string.
     */
    public static void main(String[] args) {
        AbstractArtDrawing example = new AbstractArtDrawing();
        // Call the function to draw
        example.drawLine();
    }
}
