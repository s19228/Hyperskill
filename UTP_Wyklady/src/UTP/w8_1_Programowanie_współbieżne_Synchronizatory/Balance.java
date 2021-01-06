package UTP.w8_1_Programowanie_współbieżne_Synchronizatory;

public class Balance {
    private int number = 0;

    public int balance() {
        number++;
        number--;
        return number;
    }
}
