package Ksiazka.Programowanie_Wielowatkowe;

public class Main {

    public static void main(String[] args) {

        /*
        Aby utworzyć nowy wątek, wystarczy rozszerzyć klasę Thread lub zaimplementować interfejs Runnable

        getName() Pobiera nazwę wątku
        getPriority() Pobiera priorytet wątku
        isAlive() Sprawdza, czy wątek nadal działa
        join() Czeka na zakończenie wątku
        run() Miejsce rozpoczęcia wykonywania wątku
        sleep() Zawieszenie wątku na określony czas
        start() Uruchomienie wątku przez wywołanie metody run()
         */

        //Thread.currentThread()... - sterowanie glownym watkiem

        Thread t = Thread.currentThread();
        System.out.println("Aktualny (glowny) watek to: " + t);

        //Zmiana nazwy watku
        t.setName("Glowny watek");

        System.out.println("Aktualny (glowny) watek to: " + t);

        for (int n = 5; n > 0; n--) {
            System.out.println(n);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Przerwanie glownego watku!");
            }
        }

        // Wyświetli: nazwa wątku, jego priorytet, nazwa grupy, do której należy.

        Watek w = new Watek();
        Thread t2 = new Thread(w);
        t2.start(); // Utworzony wątek nie jest automatycznie uruchamiany — w tym celu trzeba wywołać metodę start() zdefiniowaną w klasie Thread.
                    // W zasadzie metoda start() inicjuje wywołanie metody run().

        //albo

        WatekOpozniony wo = new WatekOpozniony();
        Thread t3 = new Thread(wo, "Moj wlasny watek");
        t3.start();




    }


}
