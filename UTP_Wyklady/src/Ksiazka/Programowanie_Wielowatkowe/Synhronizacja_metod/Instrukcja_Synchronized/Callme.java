package Ksiazka.Programowanie_Wielowatkowe.Synhronizacja_metod.Instrukcja_Synchronized;

public class Callme {

    synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Przerwano");
        }
        System.out.println("]");

    }
}
