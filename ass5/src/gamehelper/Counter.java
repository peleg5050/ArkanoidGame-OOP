// ID: 208387969

package gamehelper;

/**
 * gamehelper.Counter - The class is a simple class that is used for counting things.
 */
public class Counter {
    // Characteristics
    private int counter;

    /**
     * constructor with configurable of the counter.
     *
     * @param counter - an integer number.
     */
    public Counter(int counter) {
        this.counter = counter;
    }

    /**
     * increase - Add number to current count.
     *
     * @param number - The number that we add to the current count.
     */
    public void increase(int number) {
        // Add the number to the current count.
        counter = counter + number;
    }

    /**
     * decrease - Subtract number from the current count.
     *
     * @param number - The number that we subtract from the current count.
     */
    public void decrease(int number) {
        // subtract the number from the current count.
        counter = counter - number;
    }

    /**
     * getValue - Get the current count.
     *
     * @return the value of the count.
     */
    public int getValue() {
        return this.counter;
    }
}
