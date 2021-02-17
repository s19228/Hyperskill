package bullscows;

import java.util.Scanner;

public class Game {

    int turn = 1;
    boolean guessed = false;

    int[] numbers = {1234, 9876};
    String[] grades = {"None.", "4 bulls."};

    Generator gen = new Generator();
    Grader grader = new Grader(2);

    public Game() {
        // print first information
        begin();
        // generating secret code
        gen.gen();
        System.out.println(gen.getCode());
        // checking secretCode
        if (gen.getCode() == 0){
            return;
        }
        // game starting info
        next();
        // runing grade
        grader.graderStart(Integer.toString(gen.getCode()).toCharArray());

    }

    public void begin() {
        System.out.println("Please, enter the secret code's length:");
    }

    public void next() {
        System.out.println("Okay, let's start a game!");
    }

}
