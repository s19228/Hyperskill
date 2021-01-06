package Ksiazka.Programowanie_Wielowatkowe;

public class Watek implements Runnable {

    String s;

    @Override
    public void run() {

        /*
        W ciele tej metody należy umieścić kod implementujący zachowanie nowego wątku. Metoda
        run() może wywoływać inne metody, używać innych klas, deklarować zmienne, podobnie jak czyni
        to wątek główny.
         */

        System.out.println("Wykonywanie watku: Watek");
        for (int n = 50; n > 0; n--) {
            System.out.println("Wątek A " + n);
            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                System.out.println("Przerwanie pobocznego watku!");
            }
        }
        System.out.println("Koniec.");
    }
}
