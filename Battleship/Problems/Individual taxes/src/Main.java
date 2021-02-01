import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfComapnies = in.nextInt();
        int[] income = new int[numberOfComapnies];
        int[] taxes = new int[numberOfComapnies];
        double[] resTab = new double[numberOfComapnies];
        double max = 0;
        int maxPosition = 0;

        fillTab(in, income);
        fillTab(in, taxes);

        for (int i = 0; i < resTab.length; i++) {
            resTab[i] = income[i] * taxes[i];
        }

        for (int i = 0; i < resTab.length; i++) {
            if (resTab[i] > max) {
                max = resTab[i];
                maxPosition = i;
            }
        }

        //printTab(resTab);
        System.out.println(maxPosition + 1);
    }

    static void printTab(double[] tab) {
        for (double v : tab) {
            System.out.print(v + ", ");
        }
        System.out.println();
    }


    private static void fillTab(Scanner in, int[] income) {
        for (int i = 0; i < income.length; i++) {
            income[i] = in.nextInt();
        }
    }
}