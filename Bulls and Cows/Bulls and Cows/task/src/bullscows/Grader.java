package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Grader {

    Random random = new Random();
    Integer code = 1000 + random.nextInt(8999);

    void graderStart(char[] code) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] input = s.toCharArray();
        int cow = 0;
        int bull = 0;

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

        printInfo(code, cow, bull);

    }

    private void printInfo(char[] code, int cow, int bull) {
        if (cow == 0 && bull == 0){
            System.out.println("Grade: None. The secret code is " + showCode());
        } else if (cow > 0 && bull == 0){
            System.out.println("Grade: " + cow + " cow(s). The secret code is " + showCode());
        } else if(cow == 0 && bull > 0){
            System.out.println("Grade: " + bull + " bull(s). The secret code is " + showCode());
        } else {
            System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s). The secret code is " +showCode());
        }
    }

    public char[] split() {
        return this.code.toString().toCharArray();
    }

    int showCode() {
        return this.code;
    }
}
