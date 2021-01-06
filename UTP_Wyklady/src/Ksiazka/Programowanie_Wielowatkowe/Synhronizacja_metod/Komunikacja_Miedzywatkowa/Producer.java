package Ksiazka.Programowanie_Wielowatkowe.Synhronizacja_metod.Komunikacja_Miedzywatkowa;

public class Producer implements Runnable{

    Queue queue;
    Thread t;

    public Producer(Queue queue) {
        this.queue = queue;
        t = new Thread(this, "Producent");
    }


    @Override
    public void run() {
        int i = 0;

        while (true){
            queue.put(i++);
        }
    }
}
