import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double begin = in.nextInt();
        double end = in.nextInt();

        double sum = 0;
        int counter = 0;

        for (; begin <= end; begin++) {
            if (begin % 3 == 0) {
                sum += begin;
                counter++;
            }
        }

        double res = sum / counter;
        System.out.println(res);

    }
}