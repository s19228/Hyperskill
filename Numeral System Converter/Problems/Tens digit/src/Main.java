import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        if (s.length() == 1){
            System.out.println("0");
        }
        else if (s.length() > 1 ){
            System.out.println(s.charAt(s.length()-2));
        }

    }
}