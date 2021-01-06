import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        int num = in.nextInt();
        int sum = 0;

        for (int j : arr) {
            if (j > num) {
                sum += j;
            }
        }
        System.out.println(sum);
    }
}