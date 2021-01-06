import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int howManyParticipants = scanner.nextInt();
        boolean isWeekend = Boolean.parseBoolean(scanner.next());

        if (isWeekend){
            System.out.println(howManyParticipants >= 15 && howManyParticipants <= 25);
        } else {
            System.out.println(howManyParticipants >= 10 && howManyParticipants <= 20);
        }

    }
}