// ID: 208387969

import alllevels.FirstLevel;
import alllevels.FourthLevel;
import alllevels.SecondLevel;
import alllevels.ThirdLevel;
import biuoop.GUI;
import gamehelper.GameFlow;
import gamehelper.GameLevel;
import interfaces.LevelInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Ass5Game - The class run the game by a main method.
 */
public class Ass6Game {

    /**
     * main - Run the game.
     *
     * @param args - String that we get.
     */
    public static void main(String[] args) {
        boolean indication = false;
        // Create a window with the title "game"
        // which is 800 pixels wide and 600 pixels high
        GUI gui = new GUI("game", GameLevel.SIZE_OF_BOARD_X, GameLevel.SIZE_OF_BOARD_Y);
        // Call the game flow
        GameFlow gameFlow = new GameFlow(gui);
        FirstLevel firstLevel = new FirstLevel();
        SecondLevel secondLevel = new SecondLevel();
        ThirdLevel thirdLevel = new ThirdLevel();
        FourthLevel fourthLevel = new FourthLevel();
        // create a list of levels
        List<LevelInformation> levelsArgs = new ArrayList<>();
        List<LevelInformation> levels = new ArrayList<>();
        for (String currentArg : args) {
            switch (currentArg) {
                // if it's 1 so add secondLevel to the list of the levels
                case "1":
                    levelsArgs.add(firstLevel);
                    indication = true;
                    break;
                // if it's 2 so add secondLevel to the list of the levels
                case "2":
                    levelsArgs.add(secondLevel);
                    indication = true;
                    break;
                // if it's 3 so add secondLevel to the list of the levels
                case "3":
                    levelsArgs.add(thirdLevel);
                    indication = true;
                    break;
                // if it's 4 so add secondLevel to the list of the levels
                case "4":
                    levelsArgs.add(fourthLevel);
                    indication = true;
                    break;
                default:
                    break;
            }
        }
     if (!indication) {
         levels.add(firstLevel);
         levels.add(secondLevel);
         levels.add(thirdLevel);
         levels.add(fourthLevel);
         gameFlow.runLevels(levels);
     } else {
         gameFlow.runLevels(levelsArgs);
     }
    }
}
