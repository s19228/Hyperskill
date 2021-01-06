import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }

        int numToSearch = in.nextInt();
        int couunter = 0;

        for (int j : arr) {
            if (j == numToSearch) {
                couunter++;
            }
        }

        System.out.println(couunter);

    }
}