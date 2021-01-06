import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int sum = 0;


        while (in.hasNext()) {
            int val = in.nextInt();

            sum += val;
            if (sum >= 1000) {
                break;
            }

            if (val == 0) {
                break;
            }
        }

        if (sum >= 1000) {
            System.out.println(sum - 1000);
        } else {
            System.out.println(sum);
        }

    }
}