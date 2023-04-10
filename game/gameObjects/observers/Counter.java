package game.gameObjects.observers;

/**
 * @author David Shnaiderov - 209198308
 * A counter used to keep track of a value
 * User ID - shnaidd1
 */
public class Counter {
    private int numOfBlocs = 0;

    /**
     * Increase value.
     *
     * @param number increase by number
     */
    public void increase(int number) {
        this.numOfBlocs = numOfBlocs + number;
    }

    /**
     * Decrease value.
     *
     * @param number Decrease by number
     */
    public void decrease(int number) {
        this.numOfBlocs = numOfBlocs - number;
    }

    /**
     * get current count.
     *
     * @return value
     */
    public int getValue() {
        return numOfBlocs;
    }
}