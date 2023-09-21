package tools;

import component.DirectionMovement;
import model.animals.AnimalsSex;

public class RandomEvent {

    /** This method generates a random animal sex with 50/50 probability.
     *
     * @return The animal's sex.
     */
    public static AnimalsSex getGenerationSex() {
        int a = (int) (Math.random() * 2); // Generate 0 or 1

        if (a == 0) {
            return AnimalsSex.FEMALE;
        } else {
            return AnimalsSex.MALE;
        }
    }

    /** Generates random coordinates within the game field (100x100).
     * @return Returns an array of random coordinates [Y, X].
     */
    public static int[] randomGenerationOfCoordinates() {
        int[] coordinatesYX = new int[2];
        int Y = randomGenerationNumberCoordinates(600); // Screen height is 600
        int X = randomGenerationNumberCoordinates(800); // Screen width is 800

        if (Y >= 20 && Y < 120) { // Game field height is 100 (20 to 119)
            coordinatesYX[0] = Y;
        } else {
            coordinatesYX[0] = randomGenerationNumberCoordinates(600);
        }

        if (X >= 20 && X < 120) { // Game field width is 100 (20 to 119)
            coordinatesYX[1] = X;
        } else {
            coordinatesYX[1] = randomGenerationNumberCoordinates(800);
        }

        return coordinatesYX;
    }

    public static int randomGenerationNumberCoordinates(int max) {
        return (int) (Math.random() * max); // Generate numbers from 0 to max-1
    }

    public static int randomGenerationNumberParameter(int coll) {
        return (int) (Math.random() * coll);
    }

    /** Generates random numbers from 0 to 100.
     * @return Random number from 0 to 100.
     */
    public static int randomGenerationColl() {
        return (int) (Math.random() * 101); // Generate numbers from 0 to 100 (inclusive)
    }

    public static DirectionMovement randomGenerationOfTheDirectionOfMovement() {
        int number = (int) (Math.random() * 81); // Generate number from 0 to 80 (inclusive)

        if (number <= 20) {
            return DirectionMovement.UP;
        } else if (number <= 40) {
            return DirectionMovement.DOWN;
        } else if (number <= 60) {
            return DirectionMovement.LEFT;
        } else if (number <= 80) {
            return DirectionMovement.RIGHT;
        } else {
            return DirectionMovement.STOP;
        }
    }

    public static int randomGenerationColl(int i) {
        return i;
    }
}
