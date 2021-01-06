import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        int sum = 0;

        while (flag) {
            int tmp = in.nextInt();
            sum += tmp;
            if (tmp == 0) {
                flag = false;
            }
        }
        System.out.println(sum);
    }
}