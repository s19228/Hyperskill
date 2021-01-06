package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[][] arr = new char[3][3];
        fillArr(arr);
        printArr(arr);

        char currentSymbol = 'X';
        int rows = 3;
        int columns = 3;
        int k = 0;
        boolean xWins = false;
        boolean oWins = false;

        int xCount = 0;
        int oCount = 0;

        boolean flag = true;
        int posX = 0;
        int posY = 0;

        while (flag) {

            Scanner in = new Scanner(System.in);
            System.out.print("Enter the coordinates: ");
            String coords = in.nextLine();

            String[] wordArray = coords.trim().split("\\s+");

            int howManyWords = wordArray.length;

            if (howManyWords == 1 || howManyWords > 2) {
                System.out.println("You should enter numbers!");
            } else {
                if (wordArray[0].length() > 1 || wordArray[1].length() > 1) {
                    System.out.println("You should enter numbers!");
                    flag = true;
                } else if (!wordArray[0].matches("([1-3])") || !wordArray[1].matches("([1-3])")) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    flag = false;
                }
            }

            if (!flag) {
                switch (coords) {
                    case "1 1":
                        posX = 2;
                        posY = 0;
                        break;
                    case "1 2":
                        posX = 1;
                        posY = 0;
                        break;
                    case "1 3":
                        posX = 0;
                        posY = 0;
                        break;
                    case "2 1":
                        posX = 2;
                        posY = 1;
                        break;
                    case "2 2":
                        posX = 1;
                        posY = 1;
                        break;
                    case "2 3":
                        posX = 0;
                        posY = 1;
                        break;
                    case "3 1":
                        posX = 2;
                        posY = 2;
                        break;
                    case "3 2":
                        posX = 1;
                        posY = 2;
                        break;
                    case "3 3":
                        posX = 0;
                        posY = 2;
                        break;
                }

                if (isOccupied(arr, posX, posY)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    flag = true;
                } else {
                    arr[posX][posY] = currentSymbol;
                    flag = true;
                    if (currentSymbol == 'X') {
                        currentSymbol = 'O';
                    } else {
                        currentSymbol = 'X';
                    }
                }
            }

            // x o counter
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (arr[i][j] == 'X') {
                        xCount++;
                    } else if (arr[i][j] == 'O') {
                        oCount++;
                    }
                }
            }

            printArr(arr);


            // rows check
            for (int i = 0; i < rows; i++) {
                if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                    if (arr[i][0] == 'X') {
                        xWins = true;
                    } else if (arr[i][0] == 'O') {
                        oWins = true;
                    }
                }
            }

            check(xWins, oWins);

            // columns check
            for (int i = 0; i < columns; i++) {
                if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                    if (arr[0][i] == 'X') {
                        xWins = true;
                    } else if (arr[0][i] == 'O') {
                        oWins = true;
                    }
                }
            }

            check(xWins, oWins);

            // diagonal chcek
            if ((arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) || (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0])) {
                if (arr[1][1] == 'X') {
                    xWins = true;
                } else if (arr[1][1] == 'O') {
                    oWins = true;
                }
            }

            //System.out.println("X count: " + xCount);
            //System.out.println("O count: " + oCount);

            if (xWins) {
                System.out.println("X wins");
                System.exit(0);
            } else if (oWins) {
                System.out.println("O wins");
                System.exit(0);
            }

            if (xCount + oCount == 9) {
                System.out.println("Draw");
                System.exit(0);
            }

            xCount = 0;
            oCount = 0;

        }
    }

    static boolean isOccupied(char[][] tab, int x, int y) {
        return tab[x][y] == 'O' || tab[x][y] == 'X';
    }

    public static String[] getCoordinates(Scanner in) {
        String coordinates = in.nextLine();
        return coordinates.trim().split("\\s+");
    }

    public static void printArr(char[][] arr) {
        System.out.println("---------");
        for (char[] chars : arr) {
            System.out.print("| ");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(chars[j]);
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public static void fillArr(char[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = ' ';
            }
        }
    }

    public static void check(boolean xWins, boolean oWins) {
        if (xWins && oWins) {
            System.out.println("Impossible");
            System.exit(0);
        } else if (xWins) {
            System.out.println("X wins");
            System.exit(0);
        } else if (oWins) {
            System.out.println("O wins");
            System.exit(0);
        }
    }
}
