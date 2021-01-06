package Ksiazka.Programowanie_Wielowatkowe.Tworzenie_nowych_watkow_Poprzez_Thread_extends;

// Utworzenie nowego wątku przez rozszerzenie klasy Thread
public class NewThread extends Thread {

    // Utworzenie nowego, drugiego wątku
    public NewThread() {
        super("Przykładowy wątek");
        System.out.println("Wątek potomny: " + this);
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Wątek potomny: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Przerwano działanie potomka.");
        }
        System.out.println("Wyjście z wątku potomka.");
    }
}
