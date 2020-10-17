// ID: 208387969

/**
 * The program receives a number of words (strings separated by a space) and one char as the last arguments.
 * The program should print two groups of words:
 * The words in which the char appears.
 * The rest of the words.
 * Each group of words printed in the order that they were recieved.
 * If the last input is not a char or if there are less then 2 inputs the program prints out: 'Invalid input'.
 */
public class CharCount {
    /**
     * The program prints the words that include the char and then the rest of the words.
     *
     * @param args a number of words and one char from the command line.
     */
    public static void main(String[] args) {
        // If the last input is not a char or if there are less then 2 inputs - prints 'Invalid input'
        if ((args.length < 2) || (args[args.length - 1].length() != 1)) {
            System.out.println("Invalid input");
            // get out from the program
            System.exit(0);
        }
        // running on the words (not include the char)
        for (int i = 0; i < args.length - 1; i++) {
            //if the current word contains the char
            if (args[i].contains(args[args.length - 1])) {
                //print the current word
                System.out.println(args[i]);
            }
       }
        // running on the words (not include the char)
        for (int i = 0; i < args.length - 1; i++) {
            //if the current word not contains the char
            if (!(args[i].contains(args[args.length - 1]))) {
                //print the current word
                System.out.println(args[i]);
            }
        }
    }
}