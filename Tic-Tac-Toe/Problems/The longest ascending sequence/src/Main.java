import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }

        int longestSequence = 1;
        int currSequence = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                currSequence++;
                if (currSequence > longestSequence) {
                    longestSequence = currSequence;
                }
            } else {
                currSequence = 1;
            }
        }
        System.out.println(longestSequence);
    }
}