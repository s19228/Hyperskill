package Ksiazka.Programowanie_Wielowatkowe.Synhronizacja_metod.Komunikacja_Miedzywatkowa;

public class Main {
    public static void main(String[] args) {

        /*
      Metoda wait() informuje wywołujący ją wątek, aby oddał monitor i zapadł w sen aż do momentu,
        w którym inny wątek nie wejdzie do monitora i nie wywoła metody notify() ani metody notifyAll().
      Metoda notify() budzi wątek, który wywołał metodę wait() dla tego samego obiektu.
      Metoda notifyAll() budzi wszystkie wątki, które wywołały metodę wait() dla tego samego obiektu. Tylko jeden z tych wątków uzyska dostęp do obiektu.
         */

        Queue queue = new Queue();
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);

        p.t.start();
        c.t.start();


    }
}
