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
}

