package Ksiazka.Programowanie_Wielowatkowe.Synhronizacja_metod.Komunikacja_Miedzywatkowa;

public class Consumer implements Runnable {

    Queue queue;
    Thread t;

    public Consumer(Queue queue) {
        this.queue = queue;
        t = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        while (true)
            queue.get();
    }
}
