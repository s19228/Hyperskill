import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();

        if (amount < 1){
            System.out.println("no army");
        } else if ( amount >= 1 && amount < 20){
            System.out.println("pack");
        } else if (amount >= 20 && amount < 250){
            System.out.println("throng");
        } else if (amount >= 250 && amount < 1000){
            System.out.println("zounds");
        } else {
            System.out.println("legion");
        }



    }
}