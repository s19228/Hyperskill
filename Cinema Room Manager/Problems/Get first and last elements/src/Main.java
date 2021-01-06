import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] getFirstAndLast(int[] arr) {
        int[] newTab = new int[2];

        if (arr.length == 1) {
            newTab[0] = arr[0];
            newTab[1] = arr[0];
        } else {
            newTab[0] = arr[0];
            newTab[1] = arr[arr.length - 1];
        }

        return newTab;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = getFirstAndLast(array);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}