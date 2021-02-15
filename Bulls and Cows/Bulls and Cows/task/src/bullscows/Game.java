package bullscows;

import java.util.Scanner;

public class Game {

    int turn = 1;
    int turns = 2;

    int[] numbers = {1234, 9876};
    String[] grades = {"None.", "4 bulls."};

    public void begin() {
        System.out.println("The secret code is prepared: ****.");
    }

    public void start() {
        do {
            System.out.println("\n" + "Turn " + turn + ". Answer:");
            Scanner in = new Scanner(System.in);
            int number = numbers[turn - 1];
            System.out.println(number);
            System.out.println("Grade: " + grades[turn - 1]);
            turn++;
            turns--;
        } while (turns != 0);
        System.out.print("Congrats! The secret code is 9876.");
    }

}
