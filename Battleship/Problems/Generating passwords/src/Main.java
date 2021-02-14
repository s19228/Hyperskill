import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int N = in.nextInt();

        char[] bigLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'W', 'V', 'X', 'Y', 'Z'};
        char[] smallLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'r', 's', 't', 'u', 'w', 'v', 'x', 'y', 'z'};
        char[] nums = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

        Random random = new Random();

        int last = 0;

        if (N == 0) {
            System.out.println();
        } else if (A != 0) {
            last = getBigLetter(A, bigLetters, random, last);
        }

        if (B != 0) {
            last = getSmallLetters(B, smallLetters, random, last);
        }

        if (C != 0) {
            for (int i = 0; i < C; i++) {
                int acc = random.nextInt(8);
                if (acc != last) {
                    System.out.print(nums[acc]);
                    last = acc;
                } else {
                    System.out.print(nums[acc + 1]);
                    last = acc + 1;
                }
            }
        }

        if ((A + B + C) < N) {
            int less = N - A - B - C;
            getBigLetter(less, bigLetters, random, last);
        }
    }

    private static int getSmallLetters(int b, char[] smallLetters, Random random, int last) {
        for (int i = 0; i < b; i++) {
            int acc = random.nextInt(24);
            if (acc != last) {
                System.out.print(smallLetters[acc]);
                last = acc;
            } else {
                System.out.print(smallLetters[acc + 1]);
                last = acc + 1;
            }
        }
        return last;
    }

    private static int getBigLetter(int a, char[] bigLetters, Random random, int last) {
        last = getSmallLetters(a, bigLetters, random, last);
        return last;
    }
}