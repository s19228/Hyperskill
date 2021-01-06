import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int val = in.nextInt();
        int counter = 0;

        for (int i = 0; i <= val; i++)
            for (int j = 0; j < i; j++)
                if (counter < val) {
                    System.out.print(i + " ");
                    counter++;
                }

    }
}