package Ksiazka.Programowanie_Wielowatkowe;

public class WatekOpozniony implements Runnable{

    @Override
    public void run() {

        System.out.println("Wykonywanie watku: Watek");
        for (int n = 50; n > 0; n--) {
            System.out.println("Wątek B " + n);
            try {
                Thread.sleep(175);
            } catch (InterruptedException e) {
                System.out.println("Przerwanie pobocznego watku!");
            }
        }
        System.out.println("Koniec.");
    }
}
