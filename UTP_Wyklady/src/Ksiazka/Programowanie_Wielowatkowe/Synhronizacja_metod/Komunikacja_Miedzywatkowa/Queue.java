package Ksiazka.Programowanie_Wielowatkowe.Synhronizacja_metod.Komunikacja_Miedzywatkowa;

class Queue {
    int n;
    boolean valueSet = false;

    /*
        Wewnątrz metody get() dochodzi do wywołania metody wait(). Powoduje to zatrzymanie wykonywania
        tej metody aż do momentu, w którym producent dokona powiadomienia o wyprodukowaniu
        nowych danych. Gdy tak się stanie, wykona się pozostały kod metody get(), który pobiera
        dane i wywołuje metodę notify(). W ten sposób konsument informuje producenta, iż może on
        wyprodukować nowe dane. Wewnątrz metody put() metoda wait() zatrzymuje wykonywanie aż
        do momentu, w którym konsument pobierze element z kolejki. Po wznowieniu działania kod
        umieszcza nowy element w kolejce i wywołuje metodę notify(). Informuje ona konsumenta, iż
        może już usunąć kolejny element.
     */

    synchronized int get() {
        while (!valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Złapano InterruptedException");
            }
        System.out.println("Pobrano: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Złapano InterruptedException");
            }
        this.n = n;
        valueSet = true;
        System.out.println("Włożono: " + n);
        notify();
    }
}