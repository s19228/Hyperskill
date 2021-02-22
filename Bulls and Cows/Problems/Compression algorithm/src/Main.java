import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] letters = s.toCharArray();

        char letter = 0;
        int count = 0;

        for (int i = 0; i < letters.length - 1; i++) {
            letter = letters[i];
            if (letters[i] == letters[i + 1]) {
                count++;
            } else {
                System.out.print(letters[i] + Integer.toString(count + 1));
                count = 0;
            }
        }
        if (letters[letters.length - 1] != letters.length - 2) {
            System.out.print(letters[letters.length - 1] + Integer.toString(count + 1));
        } else {
            System.out.print(letter + Integer.toString(count + 1));
        }

    }
}