package battleship;

public class Battlefield {

    char[][] battlefield;

    public Battlefield(int rows, int columns) {
        battlefield = new char[rows + 2][columns * 2 + 4];
        for (int i = 0, battlefieldLength = battlefield.length; i < battlefieldLength; i++) {
            char[] row = battlefield[i];
            for (int j = 0; j < row.length; j += 2) {
                row[j] = '~';
                row[j + 1] = ' ';
            }
        }
    }

    public void show() {
        System.out.print("  ");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        char ch = 'A';
        for (int i = 1; i < battlefield.length - 1; i++) {
            System.out.print(ch + " ");
            for (int j = 2; j < battlefield[i].length - 2; j++) {
                System.out.print(battlefield[i][j]);
            }
            System.out.println();
            ch++;
        }
    }
}
