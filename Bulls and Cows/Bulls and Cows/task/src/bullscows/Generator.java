package bullscows;

import java.util.Scanner;

public class Generator {

    public int getCode() {
        return code;
    }

    private static int code;

    public void gen() {

        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();

        if (in > 10) {
            System.out.println("Error: can't generate a secret number with a length of " + in + " because there aren't enough unique digits.");
            return;
        }

        long pseudoRandomNumber = System.nanoTime();
        String pseudoNum = String.valueOf(pseudoRandomNumber);
        StringBuilder sb = new StringBuilder();
        int i = 0;

        if (pseudoNum.startsWith("0")) {
            pseudoNum = pseudoNum.substring(1);
        }

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
        }

        code = Integer.parseInt(sb.toString());
    }

}
