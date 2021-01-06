import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }

        int first = in.nextInt();
        int second = in.nextInt();
        boolean flag = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == first && arr[i + 1] == second || arr[i] == second && arr[i + 1] == first) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}