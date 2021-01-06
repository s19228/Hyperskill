import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int height = in.nextInt();
        int howmManyBirdges = in.nextInt();

        int[] tmp = new int[howmManyBirdges];

        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = in.nextInt();
        }

        int min = tmp[0];

        for (int value : tmp) {
            if (value < min) {
                min = value;
            }
        }

        for (int i = 0; i < tmp.length; i++) {
            if (height < min) {
                System.out.println("Will not crash");
                break;
            } else if (height >= tmp[i]) {
                System.out.println("Will crash on bridge " + (i + 1));
                break;
            }
        }
    }
}

