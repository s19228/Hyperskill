package bullscows;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Generator {

    public char[] getCode() {
        return code.toCharArray();
    }

    public String getCodeString() {
        return code;
    }

    private static String code;

    public void gen() {

        char letter;
        Scanner scanner = new Scanner(System.in);
        String in = null;
        in = scanner.nextLine();
        boolean flag = true;

        if (in.length() > 2){
            System.out.println("Error: \"" + in + "\" isn't a valid number.");
            return;
        }

        System.out.println("Input the number of possible symbols in the code:");
        int sym = scanner.nextInt();


        int valOfIn = Integer.parseInt(in);

        if (valOfIn > sym || valOfIn == 0) {
            System.out.println("Error: it's not possible to generate a code with a length of " + in + " with " + sym + " unique symbols.");
            flag = false;
        }

        if (valOfIn > 36 && flag) {
            System.out.println("Error: can't generate a secret number with a length of " + in + " because there aren't enough unique digits.");
            flag = false;
        }

        if (sym > 36 && flag) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            flag = false;
        }


    /*
        long pseudoRandomNumber = System.nanoTime();
        String pseudoNum = String.valueOf(pseudoRandomNumber);
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (sb.length() != in) {

            String s = String.valueOf(pseudoNum.charAt(i));

            if (pseudoNum.length() - 1 == i) {
                pseudoNum = String.valueOf(System.nanoTime());
                i = 0;
            } else {
                i++;
            }

            if (!sb.toString().contains(s)) {
                sb.append(s);
            }
        }*/


        if (flag) {
            StringBuilder sb = new StringBuilder();

            char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'w', 'x', 'y', 'z'};
            char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

            Random random = new Random();


            ArrayList<Character> used = new ArrayList<Character>();

            while (sb.length() != valOfIn) {
                int letterOrNumber = random.nextInt(100);
                if (sym <= 10) {
                    char choosenNumber = numbers[random.nextInt(10)];
                    if (!used.contains(choosenNumber)) {
                        sb.append(choosenNumber);
                        used.add(choosenNumber);
                    }
                } else {
                    if (letterOrNumber % 2 == 0) {
                        //take from letter
                        char choosenLetter = letters[random.nextInt(sym - 10)];
                        if (!used.contains(choosenLetter)) {
                            sb.append(choosenLetter);
                            used.add(choosenLetter);
                        }
                    } else {
                        //take from numbers
                        char choosenNumber = numbers[random.nextInt(10)];
                        if (!used.contains(choosenNumber)) {
                            sb.append(choosenNumber);
                            used.add(choosenNumber);
                        }
                    }
                }
            }

            System.out.print("The secret is prepared: ");

            for (int j = 1; j <= valOfIn; j++) {
                System.out.print('*');
            }

            if (sym <= 10) {
                System.out.println("(0-" + (sym - 1) + ")");
            } else {
                switch (sym) {
                    case 11:
                        letter = 'a';
                        break;
                    case 12:
                        letter = 'b';
                        break;
                    case 13:
                        letter = 'c';
                        break;
                    case 14:
                        letter = 'd';
                        break;
                    case 15:
                        letter = 'e';
                        break;
                    case 16:
                        letter = 'f';
                        break;
                    case 17:
                        letter = 'g';
                        break;
                    case 18:
                        letter = 'h';
                        break;
                    case 19:
                        letter = 'i';
                        break;
                    case 20:
                        letter = 'j';
                        break;
                    case 21:
                        letter = 'k';
                        break;
                    case 22:
                        letter = 'l';
                        break;
                    case 23:
                        letter = 'm';
                        break;
                    case 24:
                        letter = 'n';
                        break;
                    case 25:
                        letter = 'o';
                        break;
                    case 26:
                        letter = 'p';
                        break;
                    case 27:
                        letter = 'q';
                        break;
                    case 28:
                        letter = 'r';
                        break;
                    case 29:
                        letter = 's';
                        break;
                    case 30:
                        letter = 't';
                        break;
                    case 31:
                        letter = 'u';
                        break;
                    case 32:
                        letter = 'w';
                        break;
                    case 33:
                        letter = 'v';
                        break;
                    case 34:
                        letter = 'x';
                        break;
                    case 35:
                        letter = 'y';
                        break;
                    case 36:
                        letter = 'z';
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + sym);
                }
                System.out.print(" (0-9, a-" + letter + ")." + "\n");
            }

            code = sb.toString();
            // printing secret code for tests
            //System.out.println("***code: " + code + " ***");

        } else code = "0";
    }
}
