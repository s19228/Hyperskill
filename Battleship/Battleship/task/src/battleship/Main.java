package battleship;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Battlefield battlefield = new Battlefield(10, 10);
        battlefield.show();
        Scanner scanner = new Scanner(System.in);
        // types of ships and their lengths
        int[] shipsLengthsArray = {5, 4, 3, 3, 2};
        String[] shipNames = {
                "Aircraft Carrier",
                "Battleship",
                "Submarine",
                "Cruiser",
                "Destroyer"
        };

        int[] pos = new int[2];

        for (int i = 0; i < 5; i++) {
            System.out.printf("%nEnter the coordinates of the %s (%d cells):%n%n", shipNames[i], shipsLengthsArray[i]);

            int startRow;
            int startColumn;
            int endRow;
            int endColumn;

            boolean flag = true;
            while (flag) {
                String start = scanner.next();
                String end = scanner.next();

                convert(start, pos);
                startRow = pos[0];
                startColumn = pos[1];

                convert(end, pos);
                endRow = pos[0];
                endColumn = pos[1];

                int shipLength = getLength(startRow, startColumn, endRow, endColumn);

                if (shipLength != shipsLengthsArray[i]) {
                    if (shipLength == 0) {
                        System.out.printf("%nError! Wrong ship location! Try again:%n%n");
                    } else {
                        System.out.printf("%nError! Wrong length of the %s! Try again:%n%n", shipNames[i]);
                    }
                    continue;
                }

                if (setShipOnBattlefield(startRow, startColumn, endRow, endColumn, battlefield)) {
                    flag = false;
                } else {
                    System.out.printf("%nError! You placed it too close to another one. Try again:%n%n");
                }
            }
            System.out.println();
            battlefield.show();
            System.out.println();

        }
        System.out.println("The game starts!");
        System.out.println();
        battlefield.show();

        System.out.println();
        System.out.println("Take a shot!");
        System.out.println();

        boolean shooting = true;

        while (shooting) {

            String shoot = scanner.next();
            int[] point = convertPoint(shoot);

            try {
                if (point[0] == 0) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                } else if (battlefield.battlefield[point[0]][point[1]] == '~') {
                    battlefield.battlefield[point[0]][point[1]] = 'M';
                    battlefield.show();
                    System.out.println();
                    System.out.println("You missed!");
                    System.out.println();
                    shooting = false;
                } else {
                    battlefield.battlefield[point[0]][point[1]] = 'X';
                    System.out.println();
                    System.out.println("You hit a ship!");
                    System.out.println();
                    battlefield.show();
                    shooting = false;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
        }
    }

    public static boolean setShipOnBattlefield(int starRow_i, int startColumn_i, int endRow_i, int endColumn_i, Battlefield bat) {
        int startRow;
        int endRow;
        int startColumn;
        int endColumn;

        if (starRow_i > endRow_i) {
            startRow = endRow_i;
            endRow = starRow_i;
        } else {
            startRow = starRow_i;
            endRow = endRow_i;
        }
        if (startColumn_i > endColumn_i) {
            startColumn = endColumn_i;
            endColumn = startColumn_i;
        } else {
            startColumn = startColumn_i;
            endColumn = endColumn_i;
        }

        for (int i = startRow - 1; i <= endRow + 1; i++) {
            for (int j = startColumn - 1; j <= endColumn + 1; j++) {
                if (bat.battlefield[i][j * 2] != '~') {
                    return false;
                }
            }
        }

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColumn; j <= endColumn; j++) {
                bat.battlefield[i][j * 2] = 'O';
            }
        }
        return true;
    }

    public static int getLength(int headRow, int headCol, int tailRow, int tailCol) {
        int shipLength = 0;
        if (headRow == tailRow) {
            shipLength = Math.abs(headCol - tailCol) + 1;
        } else if (headCol == tailCol) {
            shipLength = Math.abs(headRow - tailRow) + 1;
        }
        return shipLength;
    }

    public static void convert(String position, int[] result) {
        final String PATTERN = "([A-Z])(\\d+)";
        if (result.length < 2) {
            result[0] = -1;
            result[1] = -1;
            return;
        }
        if (position.matches(PATTERN)) {
            Pattern p = Pattern.compile(PATTERN);
            Matcher m = p.matcher(position);

            m.find();

            String row = m.group(1);
            String col = m.group(2);

            result[0] = row.charAt(0) - 'A' + 1;
            result[1] = Integer.parseInt(col);
        } else {
            result[0] = -1;
            result[1] = -1;
        }
    }

    public static int[] convertPoint(String position) {
        int[] tab = {0, 0, 9};

        char letter = position.charAt(0);
        switch (letter) {
            case 'A':
                tab[0] = 1;
                break;
            case 'B':
                tab[0] = 2;
                break;
            case 'C':
                tab[0] = 3;
                break;
            case 'D':
                tab[0] = 4;
                break;
            case 'E':
                tab[0] = 5;
                break;
            case 'F':
                tab[0] = 6;
                break;
            case 'G':
                tab[0] = 7;
                break;
            case 'H':
                tab[0] = 8;
                break;
            case 'I':
                tab[0] = 9;
                break;
            case 'J':
                tab[0] = 10;
                break;
            default:
        }

        if (position.length() == 3 && position.charAt(1) == 49) {
            if (position.charAt(2) == 48) {
                tab[1] = 20;
            } else {
                tab[0] = 0;
            }
        } else {
            int column = position.charAt(1);
            tab[1] = (column - 48) * 2;
        }

        return tab;
    }
}

