package UTP.w7_1_Programowanie_Wspolbiezne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        // Aby uruchomić wątek należy stworzyć obiekt klasy Thread i  użyć metody start() wobec tego obiektu.

        Watek w = new Watek();
        Thread watek = new Thread(w);


        Watek2 w2 = new Watek2();
        Thread watek2 = new Thread(w2);
        watek.start();
        watek2.start();

        System.out.println("//////////////////////////");

        InnyWatek drugiWatek = new InnyWatek();
        drugiWatek.start();

        WatekExec wx = new WatekExec();
        wx.execute(() -> {
        });

        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (int i=1; i<=4; i++) {
            exec.execute(new Task("Task " + i));
        }
        Thread.yield(); //Wątek wywołujący metodę zrzeka się czasu procesora
        exec.shutdown(); //ponieważ metoda shutdown() zamyka ExecutorService, zadanie "Task after shutdown" nie zostanie uruchomione
        // (powstanie wyjątek RejectedExecutionException; ten wyjątek może powstawać również wtedy, gdy ExecutorService z innych powodów
        // niż zamknięcie odmawia wykonania zadania).

        try {
            exec.execute(new Task("Task after shutdown"));
        } catch (RejectedExecutionException  exc) {
            exc.printStackTrace();
        }
        try {
            exec.awaitTermination(5, TimeUnit.SECONDS);
        } catch(InterruptedException exc) { exc.printStackTrace(); }
        System.out.println("Terminated: " + exec.isTerminated());

        /*
        Kończenie pracy wątku
        Wątek kończy pracę w sposób naturalny wtedy, gdy zakończy się jego metoda run().
        Jeśli chcemy programowo zakończyć pracę wątku, to  należy zapewnić w metodzie run() sprawdzenie warunków zakończenia (ustalanych programowo) i jeśli są spełnione - spowodować wyjście z run()
        albo przez "dobiegnięcie do końca", albo przez return.
        Warunki zakończenia mogą być formułowane w postaci wartości jakiejś zmiennej, które są ustalane przez inne fragmenty kodu programu (wykonywane w innym wątku).
         */

        /*
        ExecutorService dostarcza także metody shutdownNow(), która ma za zadanie zakończyć działanie wszystkich aktualnie wykonujących się zadań (wątków) i zamknąć Wykonawcę.
         */

        

    }

}
