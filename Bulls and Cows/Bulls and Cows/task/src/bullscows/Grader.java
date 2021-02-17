package bullscows;

import java.util.Scanner;

public class Grader {

    private int cow = 0;
    private int bull = 0;
    boolean stillGuessing = true;

    public int getCode() {
        return code;
    }

    private int code;

    public Grader(int code) {
        this.code = code;
    }

    void graderStart(char[] code) {
        while (stillGuessing){
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            char[] input = s.toCharArray();

            for (int i = 0; i < code.length; i++) {
                if (input[i] == code[i]) {
                    bull++;
                }
            }

            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < code.length; j++) {
                    if (i != j) {
                        if (input[i] == code[j]) {
                            cow++;
                        }
                    }
                }
            }
            printInfo(cow, bull, code);
            if (bull == code.length){
                System.out.println("Congratulations! You guessed the secret code.");
                stillGuessing = false;
            }
            bull = 0;
            cow = 0;
        }

    }

    private void printInfo(int cow, int bull, char[] code) {
        if (cow == 0 && bull == 0){
            System.out.println("Grade: None.");
        } else if (cow > 0 && bull == 0){
            System.out.println("Grade: " + cow + " cow.");
        } else if(cow == 0 && bull > 0){
            System.out.println("Grade: " + bull + " bull.");
        } else if (bull == code.length){
            System.out.println("Congratulations! You guessed the secret code.");
            stillGuessing = false;
        }else{
            System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s).");
        }
    }


}
