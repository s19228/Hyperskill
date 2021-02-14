package battleship;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Battlefield yourBattlefield = new Battlefield(10, 10);
        Battlefield yourFogOfWar = new Battlefield(10, 10);

        Battlefield opponentBattlefield = new Battlefield(10, 10);
        Battlefield opponentFogOfWar = new Battlefield(10, 10);

        Scanner scanner = new Scanner(System.in);
        int[] shipsLengthsArray = {5, 4, 3, 3, 2};
        String[] shipNames = {
                "Aircraft Carrier",
                "Battleship",
                "Submarine",
                "Cruiser",
                "Destroyer"
        };

        int[] pos = new int[2];

        //placing ships on the map

        System.out.println("Player 1, place your ships on the game field");
        System.out.println();
        yourBattlefield.show();

        puttingShipsOnBatlefield(yourBattlefield, scanner, shipsLengthsArray, shipNames, pos);

        pressEnterKey();

        System.out.println("Player 2, place your ships on the game field");
        System.out.println();
        opponentBattlefield.show();

        puttingShipsOnBatlefield(opponentBattlefield, scanner, shipsLengthsArray, shipNames, pos);

        pressEnterKey();


        //starting the game
        String p1 = "Player 1";
        String p2 = "Player 2";

        int p1counter = 5;
        int p2counter = 5;
        List<String> shootsPlayer1 = new ArrayList<>();
        List<String> shootsPlayer2 = new ArrayList<>();

        boolean p1shooting = true;
        boolean shooting = true;

        do {
            if (p1shooting) {

                yourFogOfWar.show();
                System.out.println("---------------------");
                yourBattlefield.show();
                System.out.println();
                System.out.println(p1 + ", it's your turn:");
                System.out.println();

                try {
                    String shoot = scanner.next();
                    if (shootsPlayer1.contains(shoot)) {
                        System.out.println("You hit a ship!");
                        pressEnterKey();
                    } else {
                        shootsPlayer1.add(shoot);
                        int[] point = convertPoint(shoot);
                        boolean isSank;
                        if (point[0] == 0) {
                            System.out.println("Error! You entered the wrong coordinates! Try again:");
                        } else if (opponentBattlefield.battlefield[point[0]][point[1]] == '~') {
                            yourFogOfWar.battlefield[point[0]][point[1]] = 'M';
                            //yourBattlefield.battlefield[point[0]][point[1]] = 'M';
                            System.out.println();
                            System.out.println("You missed!");
                            pressEnterKey();
                        } else {
                            opponentBattlefield.battlefield[point[0]][point[1]] = 'X';
                            yourFogOfWar.battlefield[point[0]][point[1]] = 'X';
                            System.out.println();
                            isSank = checkIsSank(opponentBattlefield, point);
                            if (!isSank) {
                                System.out.println("You hit a ship!");
                                System.out.println();
                                pressEnterKey();
                            } else {
                                p1counter--;
                                if (p1counter > 0) {
                                    System.out.println("You sank a ship!");
                                    pressEnterKey();
                                } else {
                                    System.out.println("You sank the last ship. You won. Congratulations!");
                                    pressEnterKey();
                                    shooting = false;
                                }
                            }
                        }
                    }
                    p1shooting = false;
                } catch (Exception e) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                }
            } else {

                opponentFogOfWar.show();
                System.out.println("---------------------");
                opponentBattlefield.show();
                System.out.println();
                System.out.println(p2 + ", it's your turn");
                try {
                    String shoot = scanner.next();
                    if (shootsPlayer2.contains(shoot)) {
                        System.out.println("You hit a ship!");
                        pressEnterKey();
                    } else {
                        shootsPlayer2.add(shoot);
                        int[] point = convertPoint(shoot);
                        boolean isSank;
                        if (point[0] == 0) {
                            System.out.println("Error! You entered the wrong coordinates! Try again:");
                        } else if (yourBattlefield.battlefield[point[0]][point[1]] == '~') {
                            opponentFogOfWar.battlefield[point[0]][point[1]] = 'M';
                            System.out.println();
                            System.out.println("You missed!");
                            pressEnterKey();
                        } else {
                            yourBattlefield.battlefield[point[0]][point[1]] = 'X';
                            opponentFogOfWar.battlefield[point[0]][point[1]] = 'X';
                            System.out.println();
                            isSank = checkIsSank(yourBattlefield, point);
                            if (!isSank) {
                                System.out.println("You hit a ship!");
                                System.out.println();
                                pressEnterKey();
                            } else {
                                p2counter--;
                                if (p2counter > 0) {
                                    System.out.println("You sank a ship!");
                                    pressEnterKey();
                                } else {
                                    System.out.println("You sank the last ship. You won. Congratulations!");
                                    pressEnterKey();
                                    shooting = false;
                                }
                            }
                        }
                    }
                    //p1shooting = false;
                } catch (Exception e) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                }
                p1shooting = true;
            }
        } while (shooting);


    }

    private static void puttingShipsOnBatlefield(Battlefield yourBattlefield, Scanner scanner,
                                                 int[] shipsLengthsArray, String[] shipNames, int[] pos) {
        for (int i = 0; i < 5; i++) {
            System.out.printf("%nEnter the coordinates of the %s (%d cells):%n%n", shipNames[i], shipsLengthsArray[i]);

            boolean flag = true;
            putShipsOnBattlefield(yourBattlefield, scanner, shipsLengthsArray, shipNames, pos, i, flag);
            System.out.println();
            yourBattlefield.show();
            System.out.println();

        }
    }

    private static void startShooting(Battlefield yourBattlefield, Battlefield fogOfWar, Scanner scanner,
                                      boolean shooting, int counter, List<String> shoots) {
        try {
            while (shooting) {
                String shoot = scanner.next();
                if (shoots.contains(shoot)) {
                    System.out.println("You hit a ship! Try again:");
                    System.out.println();
                    fogOfWar.show();
                } else {
                    shoots.add(shoot);
                    int[] point = convertPoint(shoot);
                    boolean isSank;
                    if (point[0] == 0) {
                        System.out.println("Error! You entered the wrong coordinates! Try again:");
                    } else if (yourBattlefield.battlefield[point[0]][point[1]] == '~') {
                        fogOfWar.battlefield[point[0]][point[1]] = 'M';
                        yourBattlefield.battlefield[point[0]][point[1]] = 'M';
                        fogOfWar.show();
                        System.out.println();
                        System.out.println("You missed. Try again:");
                        System.out.println();
                        fogOfWar.show();
                    } else {
                        yourBattlefield.battlefield[point[0]][point[1]] = 'X';
                        fogOfWar.battlefield[point[0]][point[1]] = 'X';
                        fogOfWar.show();
                        System.out.println();
                        isSank = checkIsSank(yourBattlefield, point);
                        if (!isSank) {
                            System.out.println("You hit a ship! Try again:");
                            System.out.println();
                            fogOfWar.show();
                        } else {
                            counter--;
                            if (counter > 0) {
                                System.out.println("You sank a ship! Specify a new target:");
                            } else {
                                System.out.println("You sank the last ship. You won. Congratulations!");
                                shooting = false;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
        }
    }

    private static void startShootingOnePlayer(Battlefield yourBattlefield, Battlefield fogOfWar, Scanner scanner,
                                               boolean shooting, int counter, List<String> shoots) {
        try {
            while (shooting) {
                String shoot = scanner.next();
                if (shoots.contains(shoot)) {
                    System.out.println("You hit a ship! Try again:");
                    System.out.println();
                    fogOfWar.show();
                } else {
                    shoots.add(shoot);
                    int[] point = convertPoint(shoot);
                    boolean isSank;
                    if (point[0] == 0) {
                        System.out.println("Error! You entered the wrong coordinates! Try again:");
                    } else if (yourBattlefield.battlefield[point[0]][point[1]] == '~') {
                        fogOfWar.battlefield[point[0]][point[1]] = 'M';
                        yourBattlefield.battlefield[point[0]][point[1]] = 'M';
                        fogOfWar.show();
                        System.out.println();
                        System.out.println("You missed. Try again:");
                        System.out.println();
                        fogOfWar.show();
                    } else {
                        yourBattlefield.battlefield[point[0]][point[1]] = 'X';
                        fogOfWar.battlefield[point[0]][point[1]] = 'X';
                        fogOfWar.show();
                        System.out.println();
                        isSank = checkIsSank(yourBattlefield, point);
                        if (!isSank) {
                            System.out.println("You hit a ship! Try again:");
                            System.out.println();
                            fogOfWar.show();
                        } else {
                            counter--;
                            if (counter > 0) {
                                System.out.println("You sank a ship! Specify a new target:");
                            } else {
                                System.out.println("You sank the last ship. You won. Congratulations!");
                                shooting = false;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
        }
    }

    private static void putShipsOnBattlefield(Battlefield yourBattlefield, Scanner scanner,
                                              int[] shipsLengthsArray, String[] shipNames, int[] pos, int i, boolean flag) {
        int startRow;
        int endColumn;
        int endRow;
        int startColumn;
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

            if (setShipOnBattlefield(startRow, startColumn, endRow, endColumn, yourBattlefield)) {
                flag = false;
            } else {
                System.out.printf("%nError! You placed it too close to another one. Try again:%n%n");
            }
        }
    }

    private static boolean checkIsSank(Battlefield yourBattlefield, int[] point) {
        boolean sunk = true;

        for (int i = -1; i < 2; i++) {
            for (int j = -2; j < 3; j++) {
                if (yourBattlefield.battlefield[point[0] + i][point[1] + j] == 'O') {
                    sunk = false;
                    break;
                }
                if (yourBattlefield.battlefield[point[0] - 1][point[1]] == 'X'){
                    if (yourBattlefield.battlefield[point[0] - 2][point[1]] == 'O'){
                        sunk = false;
                        break;
                    }
                }
                if (yourBattlefield.battlefield[point[0] + 1][point[1]] == 'X'){
                    if (yourBattlefield.battlefield[point[0] + 2][point[1]] == 'O'){
                        sunk = false;
                        break;
                    }
                }
                if (yourBattlefield.battlefield[point[0]][point[1] - 2] == 'X'){
                    if (yourBattlefield.battlefield[point[0]][point[1] - 4] == 'O'){
                        sunk = false;
                        break;
                    }
                }
                if (yourBattlefield.battlefield[point[0]][point[1] + 2] == 'X'){
                    if (yourBattlefield.battlefield[point[0]][point[1] + 4] == 'O'){
                        sunk = false;
                        break;
                    }
                }
            }
        }
        return sunk;
    }

    public static boolean setShipOnBattlefield(int starRow_i, int startColumn_i, int endRow_i,
                                               int endColumn_i, Battlefield bat) {
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

    public static void pressEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

