package bullscows;

import java.util.Scanner;

public class Game {

    Generator gen = new Generator();
    Grader grader = new Grader(2);

    public Game() {
        // ask for length
        begin();

        // generating secret code
        gen.gen();
        // game starting info
        next();
        // runing grade
        grader.graderStart(gen.getCode());

    }

    public void begin() {
        System.out.println("Input the length of the secret code:");
    }

    public void next() {
        System.out.println("Okay, let's start a game!");
    }

}
