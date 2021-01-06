import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = 0;

        while (in.hasNext()) {

            int val = in.nextInt();

            if (val > max) {
                max = val;
            }

            if (val == 0) {
                break;
            }
        }
        System.out.println(max);
    }
}