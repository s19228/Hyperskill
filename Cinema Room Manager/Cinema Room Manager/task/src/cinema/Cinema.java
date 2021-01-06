package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        int rows;
        int seats;
        boolean exitFlag = true;
        int purchasedTickets = 0;
        int currentIncome = 0;

        Scanner in = new Scanner(System.in);

        // generating room
        System.out.println("Enter the number of rows:");
        rows = in.nextInt();

        System.out.println("Enter the number of seats in each row:");
        seats = in.nextInt();

        String[][] room = new String[rows][seats];
        fillArr(room);

        // showing menu
        while (exitFlag) {

            System.out.println("1. Show the seats" + "\n" +
                    "2. Buy a ticket" + "\n" +
                    "3. Statistics" + "\n" +
                    "0. Exit");

            int choice = in.nextInt();

            switch (choice) {
                case 1: {
                    printSeats(room);
                    break;
                }
                case 2: {
                    boolean isAvailable = true;
                    while (isAvailable) {
                        in = new Scanner(System.in);
                        System.out.println("Enter a row number:");
                        int rowNumber = in.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int seatNumber = in.nextInt();

                        if (rowNumber > rows || rowNumber <= 0 || seatNumber > seats || seatNumber <= 0) {
                            System.out.println("Wrong input!");
                        } else if (room[rowNumber - 1][seatNumber - 1].equals("B")) {
                            System.out.println("That ticket has already been purchased!");
                        } else {
                            // checking price
                            checkPriceForSeat(rows, seats, room, rowNumber, seatNumber);
                            System.out.println(" ");
                            isAvailable = false;
                        }

                        currentIncome += getPriceOfSeat(rows, seats, rowNumber);
                        purchasedTickets++;
                    }
                    break;
                }
                case 3: {
                    double purchasedTicketsPercent;
                    purchasedTicketsPercent = (purchasedTickets / ((double) rows * seats)) * 100;
                    System.out.println("Number of purchased tickets: " + purchasedTickets);
                    if (purchasedTicketsPercent == 0) {
                        System.out.println("Percentage: 0.00%");
                    } else {
                        System.out.printf("%s %.2f%s %n", "Percentage", purchasedTicketsPercent, "%");
                    }
                    System.out.println("Current income: $" + currentIncome + "\n" +
                            "Total income: $" + getTotalIncome(rows, seats));
                    break;
                }
                case 0: {
                    exitFlag = false;
                    break;
                }
                default: {
                    System.out.println("Some err!");
                    break;
                }
            }
        }
    }

    private static void fillArr(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                arr[i][j] = "S";
            }
        }
    }

    private static int getTotalIncome(int rows, int seats) {
        int totalIncome;
        if (seats * rows <= 60) {
            totalIncome = seats * rows * 10;
        } else {
            int front = rows / 2; // 7/2=3
            int back = rows - front; //7-3=4
            totalIncome = front * seats * 10 + back * seats * 8;
        }
        return totalIncome;
    }

    private static void printSeats(String[][] arr) {
        System.out.println();
        print2dArray(arr);
        System.out.println();
    }

    private static void checkPriceForSeat(int rows, int seats, String[][] arr, int rowNumber, int seatNumber) {
        int front = rows / 2; // 7/2=3

        if ((rows * seats) <= 60) {
            System.out.println("Ticket price: $10");
        } else if (rowNumber <= front) {
            System.out.println("Ticket price: $10");
        } else {
            System.out.println("Ticket price: $8");
        }
        arr[rowNumber - 1][seatNumber - 1] = "B";
        System.out.println();
    }

    private static int getPriceOfSeat(int rows, int seats, int rowNumber) {
        int front = rows / 2; // 7/2=3
        if ((rows * seats) <= 60) {
            return 10;
        } else if (rowNumber <= front) {
            return 10;
        } else {
            return 8;
        }
    }

    private static void print2dArray(String[][] arr) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i < arr[0].length + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();


        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}