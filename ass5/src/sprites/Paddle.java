// ID: 208387969


package sprites;


import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gamehelper.GameLevel;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.Collidable;
import interfaces.Sprite;

/**
 * sprites.Paddle - The sprites.Paddle is the player in the game.
 * It is a rectangle that is controlled by the arrow keys, and moves according to the player key presses.
 * The sprites.Paddle Class implement the interfaces.Sprite and the interfaces.Collidable interfaces.
 * The sprites.Paddle also know how to move to the left and to the right (by using the timePassed method he check
 * if the "left" or "right" keys are pressed, and if so move it accordingly).
 */
public class Paddle implements Sprite, Collidable {
    // Characteristics
    // Const number of the minimum and maximum values of the X values of the left point of the paddle
    public static final int X_MIN = 20;
    public static final int X_MAX = GameLevel.SIZE_OF_BOARD_X - 18;
    // Const number of the move of the paddle
    public static final int MOVE = 7;
    // Const number of the regions of the paddle
    public static final int REGIONS = 5;
    // Const number of the angle in region 1 (of the paddle)
    public static final int ANGLE1 = 300;
    // Const number of the angle in region 2 (of the paddle)
    public static final int ANGLE2 = 330;
    // Const number of the angle in region 4 (of the paddle)
    public static final int ANGLE4 = 30;
    // Const number of the angle in region 5 (of the paddle)
    public static final int ANGLE5 = 60;
    // Const number (We will use Epsilon to correct the deflection)
    public static final double EPSILON = Math.pow(10, -10);
    private biuoop.KeyboardSensor keyboard;
    private Block block;

    /**
     * constructor with configurable of keyboard and block that build block and keyboard for the paddle.
     *
     * @param keyboard - keyboard for the paddle.
     * @param block    sprites.Block for the paddle.
     */
    public Paddle(biuoop.KeyboardSensor keyboard, Block block) {
        this.keyboard = keyboard;
        this.block = block;
    }

    /**
     * moveLeft - Make the move of the paddle in case that the left key is pressed.
     */
    public void moveLeft() {
        // The left point of the rectangle (of the paddle)
        Point pointLeft = this.getCollisionRectangle().getUpperLeft();
        // The new X value of the left point of the rectangle
        double xAfterPressed = pointLeft.getX() - MOVE;
        // If the left key is pressed
        if ((keyboard.isPressed(KeyboardSensor.LEFT_KEY)) && (xAfterPressed > X_MIN)) {
            pointLeft.setX(xAfterPressed);
        }
    }

    /**
     * moveRight - Make the move of the paddle in case that the right key is pressed.
     */
    public void moveRight() {
        // The left point of the rectangle (of the paddle)
        Point pointLeft = this.getCollisionRectangle().getUpperLeft();
        // The right point of the rectangle (of the paddle)
        Point pointRight = this.getCollisionRectangle().getUpperRight();
        // The new X value of the left point of the rectangle
        double xLeftAfterPressed = pointLeft.getX() + MOVE;
        // The new X value of the right point of the rectangle
        double xRightAfterPressed = pointRight.getX() + MOVE;
        // If the right key is pressed.
        if ((keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) && (xRightAfterPressed < X_MAX)) {
            pointLeft.setX(xLeftAfterPressed);
        }
    }

    // interfaces.Sprite

    /**
     * timePassed - notify the paddle (sprite) that time has passed.
     */
    public void timePassed() {
        moveLeft();
        moveRight();
    }

    /**
     * drawOn - Draw the paddle (sprite) to the screen.
     *
     * @param surface - The draw.
     */
    public void drawOn(DrawSurface surface) {
        // The rectangle (paddle)
        Rectangle paddle = this.getCollisionRectangle();
        // The left point of the rectangle (paddle)
        Point pointLeft = this.getCollisionRectangle().getUpperLeft();
        // Set the color (to be the color we got)
        surface.setColor(block.getColor());
        // Draw the paddle
        surface.fillRectangle((int) pointLeft.getX(), (int) pointLeft.getY(),
                (int) paddle.getWidth(), (int) paddle.getHeight());
    }

    // interfaces.Collidable

    /**
     * getCollisionRectangle - Return the "collision shape" of the object.
     *
     * @return "collision shape" of the object.
     */
    public Rectangle getCollisionRectangle() {
        return this.block.getCollisionRectangle();
    }

    /**
     * hit - Return the new velocity expected after the hit (based on the force the object inflicted on us).
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param hitter - the hitter ball.
     * @param collisionPoint  - The collision point of the shape.
     * @param currentVelocity - The current velocity.
     * @return New velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // The size of the region , the start of each region , and the end of region 5.
        double sizeOfRegion, startRegion1, startRegion2, startRegion3, startRegion4, startRegion5, endRegion5;
        // Size of each region
        sizeOfRegion = this.getCollisionRectangle().getWidth() / REGIONS;
        // The start of region 1
        startRegion1 = this.getCollisionRectangle().getUpperLeft().getX();
        // The start of region 2
        startRegion2 = startRegion1 + sizeOfRegion;
        // The start of region 3
        startRegion3 = startRegion2 + sizeOfRegion;
        // The start of region 4
        startRegion4 = startRegion3 + sizeOfRegion;
        // The start of region 5
        startRegion5 = startRegion4 + sizeOfRegion;
        // The end of region 5
        endRegion5 = startRegion5 + sizeOfRegion;
        // The dx and dy of the current velocity
        double currentVelocityDx = currentVelocity.getDx();
        double currentVelocityDy = currentVelocity.getDy();
        double speed;
        // Converts the velocity as dx and dy to velocity in speed
        speed = Math.sqrt((currentVelocityDx * currentVelocityDx) + (currentVelocityDy * currentVelocityDy));
        // if the collision point is on the left rib or on the right rib of the paddle
        if ((Math.abs(collisionPoint.getX() - this.getCollisionRectangle().getUpperLeft().getX()) <= EPSILON)
                || (Math.abs(collisionPoint.getX() - this.getCollisionRectangle().getUpperRight().getX()) <= EPSILON)) {
            // Changes the direction of progress along the X axis
            currentVelocityDx = currentVelocityDx * -1;
            // Set the new velocity
            currentVelocity.setDx(currentVelocityDx);
        }
        // if the collision point is on the upper rib of the paddle (rectangle)
        if (Math.abs(this.getCollisionRectangle().getUpperLeft().getY() - collisionPoint.getY()) <= EPSILON) {
            //  If the ball hits region 1
            if ((collisionPoint.getX() >= startRegion1) && (collisionPoint.getX() < startRegion2)) {
                // The ball will bounce back with an angle of 300 degrees (-60) (regardless of where it came from)
                currentVelocity = currentVelocity.fromAngleAndSpeed(ANGLE1, speed);
            }
            //  If the ball hits region 2
            if ((collisionPoint.getX() >= startRegion2) && (collisionPoint.getX() < startRegion3)) {
                // The ball will bounce back with an angle of 330 degrees
                currentVelocity = currentVelocity.fromAngleAndSpeed(ANGLE2, speed);
            }
            //  If the ball hits the middle region (region 3)
            if ((collisionPoint.getX() >= startRegion3) && (collisionPoint.getX() < startRegion4)) {
                //  Keep its horizontal direction and only change its vertical one (like when hitting a block)
                // Changes the direction of progress along the Y axis
                currentVelocityDy = -1 * currentVelocityDy;
                // Set the new velocity
                currentVelocity.setDy(currentVelocityDy);
            }
            //  If the ball hits region 4
            if ((collisionPoint.getX() >= startRegion4) && (collisionPoint.getX() < startRegion5)) {
                // The ball will bounce back with an angle of 30 degrees
                currentVelocity = currentVelocity.fromAngleAndSpeed(ANGLE4, speed);
            }
            //  If the ball hits region 5
            if ((collisionPoint.getX() >= startRegion5) && (collisionPoint.getX() < endRegion5)) {
                // The ball will bounce back with an angle of 60 degrees
                currentVelocity = currentVelocity.fromAngleAndSpeed(ANGLE5, speed);
            }
        }
        // Return the new velocity expected after the hit
        return currentVelocity;
    }

    /**
     * addToGame - Add this paddle to the game.
     * Let each of the game objects know how they should be added to the game.
     *
     * @param gameObject - game objects (sprites and the collidables).
     */
    public void addToGame(GameLevel gameObject) {
        // Adding the paddle to the interfaces.Collidable list
        gameObject.addCollidable(this);
        // Adding the paddle to the interfaces.Sprite list
        gameObject.addSprite(this);
    }
}
