// ID: 208387969

package gamehelper;
import biuoop.GUI;
import interfaces.LevelInformation;
import java.util.List;

/**
 * gamehelper.GameFlow - The class will be in charge of creating the different levels, and moving
 * from one level to the next.
 */
public class GameFlow {
    private static final int ZERO = 0;
    private static final String KEY = "space";
    // gamehelper.Counter of the score
    private Counter counterScore;
    // Characteristics
    private GUI gui;
    private AnimationRunner animationRunner;
    private biuoop.KeyboardSensor keyboard;
    private boolean isWin;

    /**
     * constructor with configurable of center point, radius and color of the ball.
     *
     * @param gui - the gui.
     */
    public GameFlow(GUI gui) {
        this.gui = gui;
        // Create a gamehelper.Counter of the score (initial in 0)
        this.counterScore = new Counter(ZERO);
        this.animationRunner = new AnimationRunner(gui);
        this.keyboard = gui.getKeyboardSensor();
        this.isWin = true;
    }

    /**
     * runLevels - runs different levels, and moving from one level to the next.
     *
     * @param levels - list of LevelInformation.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(this.gui, levelInfo, this.counterScore, this.animationRunner);
            level.initialize();
            // if the amount of the blocks is not 0 and there is more balls in the game - continue
            while ((level.getCounterBlocks() != ZERO) && (level.getCounterBalls() != ZERO)) {
                level.run();
            }
            // if there is no more balls at the game - he lose
            if (level.getCounterBalls() == 0) {
                // He lose = he isn't the winner
                this.isWin = false;
                //close the program
                break;
            }
        }
        // if there is no more balls or if he win in all the levels - Open the end screen
        EndScreen endScreen = new EndScreen(this.counterScore, this.isWin, this.gui);
        KeyPressStoppableAnimation keyPress = new KeyPressStoppableAnimation(keyboard, KEY, endScreen);
        animationRunner.run(keyPress);
        if (keyPress.shouldStop()) {
            gui.close();
        }
    }
}
