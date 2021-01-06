import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        String[] newText = text.split(" ");

        boolean isAlphabetical = false;

        for (int i = 1; i < newText.length; i++) {
            if (newText[i - 1].compareTo(newText[i]) <= 0) {
                isAlphabetical = true;
            } else  {
                isAlphabetical = false;
                break;
            }
        }
        System.out.println(isAlphabetical);
    }
}