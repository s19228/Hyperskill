package UTP.w7_1_Programowanie_Wspolbiezne;

public class Watek2 implements Runnable {
    @Override
    public void run() {
        for (int index = 100; index >= 0; index--)
            System.out.println("Wykonwyanie 2 watku.." + index);
    }
}
