package Ksiazka.Programowanie_Wielowatkowe.Join_i_isAlive;

public class Main {
    public static void main(String[] args) {

        MyThread mt1 = new MyThread("Pierwszy");
        MyThread mt2 = new MyThread("Drugi");
        MyThread mt3 = new MyThread("Trzeci");
        MyThread mt4 = new MyThread("Czwarty");
        MyThread mt5 = new MyThread("Piąty");
        MyThread mt6 = new MyThread("Szósty");
        MyThread mt7 = new MyThread("Siódmy");
        MyThread mt8 = new MyThread("Ósmy");
        MyThread mt9 = new MyThread("Dziewiąty");
        MyThread mt10 = new MyThread("Dziesiąty");

        MyThread[] watki = {mt1, mt2, mt3, mt4, mt5, mt6, mt7, mt8, mt9, mt10};

        mt1.t.setPriority(Thread.MAX_PRIORITY); // ustalanie priorytetu wątków
        mt2.t.setPriority(Thread.MIN_PRIORITY);
        mt3.t.setPriority(Thread.NORM_PRIORITY);
        mt4.t.setPriority(7);

        System.out.println("Priorytet pierwszego wątku to: " + watki[0].t.getPriority());

        for (int i = 0; i < 10; i++) {
            watki[i].t.start();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Wątek: " + (i+1) + " żyje? - " + watki[i].t.isAlive());
        }

        // Oczekiwanie na zakończenie wątków
        try {
            System.out.println("Oczekiwanie na zakończenie wątków.");
            for (int i = 0; i < 10; i++) {
                watki[i].t.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Przerwano wątek główny");
        }


        try {
            // Oczekiwanie na zakończenie pozostałych wątków
            System.out.println("***Uruchomiono wątek główny***");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Przerwano wątek główny");
        }
        System.out.println("Koniec wątku głównego.");

        for (int i = 0; i < 10; i++) {
            System.out.println("Wątek: " + (i+1) + " żyje? - " + watki[i].t.isAlive());
        }

        //Jak łatwo zauważyć, po powrocie z wywołania join() wątki przestały być wykonywane.


    }
}



