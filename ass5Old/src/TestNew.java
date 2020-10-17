import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Ball;
import sprites.Block;

import java.awt.Color;


public class TestNew {
    public static final double guiWidth = 1000;
    public static final double guiHeight = 1000;

    static private void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title", (int) guiWidth, (int) guiHeight);
        Sleeper sleeper = new Sleeper();

        Ball ball = new Ball((int) start.getX(), (int) start.getY(), 5, Color.black);

        Block b1 = new Block(new Rectangle(new Point(300, 450), 30, 20), Color.ORANGE);
        Block b2 = new Block(new Rectangle(new Point(100, 100), 30, 20), Color.ORANGE);
        Block b3 = new Block(new Rectangle(new Point(400, 570), 40, 30), Color.ORANGE);
        Block b4 = new Block(new Rectangle(new Point(70, 70), 20, 20), Color.ORANGE);
        Block b5 = new Block(new Rectangle(new Point(650, 500), 20, 40), Color.ORANGE);
        Block b6 = new Block(new Rectangle(new Point(80, 200), 50, 30), Color.ORANGE);
        Block b7 = new Block(new Rectangle(new Point(2, 2), 20, 574), Color.BLACK);
        Block b8 = new Block(new Rectangle(new Point(24, 2), 774, 20), Color.BLACK);
        Block b9 = new Block(new Rectangle(new Point(778, 24), 20, 574), Color.BLACK);
        Block b10 = new Block(new Rectangle(new Point(2, 578), 774, 20), Color.black);


        ball.getGameEnvironment().addCollidable(b1);
        ball.getGameEnvironment().addCollidable(b2);
        ball.getGameEnvironment().addCollidable(b3);
        ball.getGameEnvironment().addCollidable(b4);
        ball.getGameEnvironment().addCollidable(b5);
        ball.getGameEnvironment().addCollidable(b6);
        ball.getGameEnvironment().addCollidable(b7);
        ball.getGameEnvironment().addCollidable(b8);
        ball.getGameEnvironment().addCollidable(b9);
        ball.getGameEnvironment().addCollidable(b10);

        Velocity v = Velocity.fromAngleAndSpeed(25, 15);
        ball.setVelocity(v);
        //ball.setVelocity(dx, dy);
        while (true) {
            //drawing on the screen by using 'DrawSurface'
            DrawSurface drawSurface = gui.getDrawSurface();
            drawSurface.setColor(Color.orange);
            //drawing the rectangles
            drawSurface.fillRectangle(300, 450, 30, 20);
            drawSurface.fillRectangle(100, 100, 30, 20);
            drawSurface.fillRectangle(400, 570, 40, 30);
            drawSurface.fillRectangle(70, 70, 20, 20);
            drawSurface.fillRectangle(650, 500, 20, 40);
            drawSurface.fillRectangle(80, 200, 50, 30);

            drawSurface.setColor(Color.black);
            //drawing the rectangles in the sides
            drawSurface.fillRectangle(2, 2, 20, 574);
            drawSurface.fillRectangle(24, 2, 774, 20);
            drawSurface.fillRectangle(778, 24, 20, 574);
            drawSurface.fillRectangle(2, 578, 774, 20);

            ball.moveOneStepHelper(0, 0, 1000, 1000);
            ball.drawOn(drawSurface);
            gui.show(drawSurface);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(30, 450);
        drawAnimation(p1, 10, 10);
    }
}
