import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int offset = in.nextInt();

        String[] tab = s.split(" ");
        int[] numbers = new int[tab.length];
        List<Integer> collectionNumberz = new ArrayList<>();

        convert(tab, numbers, collectionNumberz);
        Collections.rotate(collectionNumberz, offset);
        print(collectionNumberz);

    }

    private static void print(List<Integer> collectionNumberz) {
        for (int x : collectionNumberz) {
            System.out.print(x + " ");
        }
    }

    private static void convert(String[] tab, int[] numbers, List<Integer> collectionNumberz) {
        for (int i = 0; i < tab.length; i++) {
            numbers[i] = Integer.parseInt(tab[i]);
            collectionNumberz.add(numbers[i]);
        }
    }
}