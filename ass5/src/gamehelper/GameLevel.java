// ID: 208387969

package gamehelper;

import biuoop.DrawSurface;
import biuoop.GUI;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Ball;
import sprites.Block;
import sprites.Paddle;

import java.awt.Color;

/**
 * gamehelper.Game - The class hold the sprites and the collidables, and will be in charge of the animation
 * The class create a list of sprites and a list of environment, initialize a new game and run the game.
 */
public class GameLevel implements Animation {
    private static final String KEY = "space";
    // Characteristics
    private GUI gui;
    // gamehelper.Counter of the blocks
    private Counter counterBlocks;
    // gamehelper.Counter of the balls
    private Counter counterBalls;
    // gamehelper.Counter of the score
    private Counter counterScore;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private AnimationRunner animationRunner;

    // The amount of the blocks at the beginning
    private static final int AMOUNT_BLOCKS = 57;
    // The amount of the balls at the beginning
    private static final int AMOUNT_BALLS = 3;
    private static final int ZERO = 0;
    // Const number of the size of the board
    public static final int SIZE_OF_BOARD_X = 800;
    public static final int SIZE_OF_BOARD_Y = 600;
    // Const number of the thickness (width) of the board
    public static final int THICKNESS_OF_BOARD = 20;
    // Const number of the width of the block
    public static final int WIDTH_OF_BLOCK = 40;
    // Const number of the height of the block
    public static final int HEIGHT_OF_BLOCK = 25;
    // The width of the paddle
    public static final int WIDTH_OF_PADDLE = 100;
    // The height of the paddle
    public static final int HEIGHT_OF_PADDLE = 10;
    // Const number for the start rectangle point (x and y)
    public static final int START_RECT_X = SIZE_OF_BOARD_X - 20;
    public static final int START_RECT_Y = SIZE_OF_BOARD_Y - 350;
    // Const number of the radius of the ball
    public static final int RADIUS = 5;
    // The angle of ball 1
    public static final double ANGLE_BALL1 = 25;
    // The angle of ball 2
    public static final double ANGLE_BALL2 = 25;
    // The angle of ball 3
    public static final double ANGLE_BALL3 = 25;
    // The angle of ball 1
    public static final double SPEED_BALL1 = 5;
    // The angle of ball 2
    public static final double SPEED_BALL2 = 5;
    // The angle of ball 3
    public static final double SPEED_BALL3 = 5;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private LevelInformation levelInformation;
    // The point of the start of the board (the upper left point)
    private Point pointUpperLeft = new Point(0, 0);

    /**
     * Constructor that create a list of sprites and a list of environment.
     *
     * @param gui              - the gui.
     * @param levelInformation - the Level information.
     * @param counterScore     - the score (created at the GameFlow, kept across levels, throughout the entire game).
     * @param runner           - animation runner that we get from the GameFlow.
     */
    public GameLevel(GUI gui, LevelInformation levelInformation, Counter counterScore, AnimationRunner runner) {
        this.levelInformation = levelInformation;
        // Create a list of the environment (things that can be collided with) in the environment
        this.sprites = new SpriteCollection();
        // Create a list of the environment (things that can be collided with) in the environment
        this.environment = new GameEnvironment();
        // Create a gamehelper.Counter of the blocks (initial in the size of the blocks at the beginning of the game)
        this.counterBlocks = new Counter(levelInformation.numberOfBlocksToRemove());
        // Create a gamehelper.Counter of the balls (initial in the size of the balls at the beginning of the game)
        this.counterBalls = new Counter(levelInformation.numberOfBalls());
        // Create a gamehelper.Counter of the score (initial in 0)
        this.counterScore = counterScore;
        this.runner = runner;
        this.running = false;
        this.gui = gui;
        this.keyboard = gui.getKeyboardSensor();
        this.animationRunner = new AnimationRunner(gui);
    }

    /**
     * addCollidable - Add the given collidable.
     *
     * @param collidable - The collide object that we want to add.
     */
    public void addCollidable(Collidable collidable) {
        // Add the collidable object to the List of the collidables
        this.environment.addCollidable(collidable);
    }

    /**
     * addCollidable - Add the given sprite.
     *
     * @param sprite - The sprite object that we want to add.
     */
    public void addSprite(Sprite sprite) {
        // Add the sprite object to the List of the sprites
        this.sprites.addSprite(sprite);
    }

    /**
     * initialize - Initialize a new game.
     * create the Blocks , sprites.Ball and sprites.Paddle , and add them to the game.
     */
    public void initialize() {
        // Add the background as a sprite
        this.addSprite(levelInformation.getBackground());
        // Create a PrintingHitListener
        // Create a gamehelper.BlockRemover (that holds a reference to the counter)
        BlockRemover blockRemover = new BlockRemover(this, this.counterBlocks);
        // Create a gamehelper.BallRemover (that holds a reference to the counter)
        BallRemover ballRemover = new BallRemover(this, this.counterBalls);
        // Create a Score Tracking Listener
        ScoreTrackingListener scoreTracking = new ScoreTrackingListener(counterScore);
        // Create blocks
        // left rib
        Block block1 = new Block(new Rectangle(new Point(pointUpperLeft.getX(), THICKNESS_OF_BOARD),
                THICKNESS_OF_BOARD, SIZE_OF_BOARD_Y), Color.darkGray);
        // right rib
        Block block2 = new Block(new Rectangle(new Point((SIZE_OF_BOARD_X - THICKNESS_OF_BOARD), THICKNESS_OF_BOARD),
                THICKNESS_OF_BOARD, (SIZE_OF_BOARD_Y - THICKNESS_OF_BOARD)), Color.darkGray);
        // upper rib
        Block block3 = new Block(new Rectangle(pointUpperLeft, SIZE_OF_BOARD_X, THICKNESS_OF_BOARD), Color.darkGray);
        // lower rib
        Block block4 = new Block(new Rectangle(new Point(pointUpperLeft.getX(), SIZE_OF_BOARD_Y),
                SIZE_OF_BOARD_X, THICKNESS_OF_BOARD), Color.GRAY);
        // Add the blocks to the game
        block1.addToGame(this);
        block2.addToGame(this);
        block3.addToGame(this);
        block4.addToGame(this);

        // Register the gamehelper.BallRemover as a listener of the death-region block (the lower block),
        // so that gamehelper.BallRemover will be notified whenever a ball hits the death-region.
        block4.addHitListener(ballRemover);
        // Create the blacks
        //
        for (int i = 0; i < levelInformation.blocks().size(); i++) {
            Block blockLevel = levelInformation.blocks().get(i);
            blockLevel.addToGame(this);
            // The blockRemover will be the listener of each block
            blockLevel.addHitListener(blockRemover);
            // The scoreTracking will be the listener of each block
            blockLevel.addHitListener(scoreTracking);
        }
        // Create a Score indicator
        ScoreIndicator scoreIndicator = new ScoreIndicator(counterScore);
        // Create a Score indicator
        LevelIndicator levelNameIndicator = new LevelIndicator(levelInformation.levelName());
        this.addSprite(scoreIndicator);
        this.addSprite(levelNameIndicator);
        // Create a new block for the paddle paddle
        // The width of the paddle
        double paddleWidth = levelInformation.paddleWidth();
        // The upper left point of the paddle
        Point pointPaddle = new Point(((SIZE_OF_BOARD_X / 2) - (paddleWidth / 2)), 570);
        Block paddleBlock = new Block(new Rectangle(pointPaddle, paddleWidth,
                HEIGHT_OF_PADDLE), Color.ORANGE);
        // Create a new paddle
        Paddle paddle = new Paddle(keyboard, paddleBlock);
        // Add the paddle to the game
        paddle.addToGame(this);
        // Create 2 balls
        //
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            // Create a new ball (in white color) with radius , and his center is the center of the paddle
            Ball ball = new Ball((int) (pointPaddle.getX() + (paddleWidth / 2)), (int) pointPaddle.getY() - 25,
                    RADIUS, Color.white);
            // Set the velocity of the ball (using the list of the ball's velocity)
            Velocity velocity = levelInformation.initialBallVelocities().get(i);
            ball.setVelocity(velocity);
            ball.setGame(this.environment);
            // Add ball1 to the game
            ball.addToGame(this);
        }
    }

    /**
     * doOneFrame - help to run the game (frame by frame).
     *
     * @param draw - the draw surface
     */
    public void doOneFrame(DrawSurface draw) {
        // Add the sprites to the draw (draw the sprites)
        this.sprites.drawAllOn(draw);
        this.sprites.notifyAllTimePassed();
        //when we identify the key p being pressed, we start running the PauseScreen animation instead of the Game one
        PauseScreen pauseScreen = new PauseScreen();
        KeyPressStoppableAnimation keyPress = new KeyPressStoppableAnimation(keyboard, KEY, pauseScreen);
        if (this.keyboard.isPressed("p")) {
            // this.runner.run(new PauseScreen());
            animationRunner.run(keyPress);
        }
        // Close the program when the amount of the blocks is 0
        if (counterBlocks.getValue() == ZERO) {
            // Clearning an entire level (destroying all blocks) is worth another 100 points.
            counterScore.increase(100);
            // gui.close();
            this.running = false;
        }
        if (counterBalls.getValue() == ZERO) {
            // gui.close();
            this.running = false;
        }
    }

    /**
     * shouldStop - return true if the game is continue, false otherwise.
     *
     * @return true if the game is continue, false otherwise.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * run - The function run the game (start the animation loop).
     */
    public void run() {
        // countdown before turn starts.
        this.runner.run(new CountdownAnimation(2, 3, sprites));
        // use our runner to run the current animation -- which is one turn of the game.
        this.running = true;
        this.runner.run(this);
    }

    /**
     * removeCollidable - Remove the given collidable (and by this we remove blocks from the game).
     *
     * @param collide - The things that can be collided with (as Blocks and the sprites.Paddle)
     *                (that we wont to remove).
     */
    public void removeCollidable(Collidable collide) {
        // Remove the collidable object from the List of the collidables
        this.environment.removeCollide(collide);

    }

    /**
     * removeSprite - Remove the given sprite (and by this we remove blocks from the game).
     *
     * @param sprite - The object that can be drawn to the screen (that we wont to remove).
     */
    public void removeSprite(Sprite sprite) {
        // Remove the sprite object from the List of the sprites
        this.sprites.removeGivenSprite(sprite);
    }

    /**
     * getCounterBalls - return the num of the current balls.
     *
     * @return num of the current balls.
     */
    public int getCounterBalls() {
        return this.counterBalls.getValue();
    }

    /**
     * getCounterBlocks - return the num of the blocks that on the screen.
     *
     * @return num of the blocks.
     */
    public int getCounterBlocks() {
        return this.counterBlocks.getValue();
    }
}
