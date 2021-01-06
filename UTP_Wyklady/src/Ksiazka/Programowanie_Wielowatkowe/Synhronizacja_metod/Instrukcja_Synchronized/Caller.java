package Ksiazka.Programowanie_Wielowatkowe.Synhronizacja_metod.Instrukcja_Synchronized;

public class Caller implements Runnable{
    String msg;
    final Callme target;
    Thread t;

    public Caller(Callme targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
    }

    /*
    synchronized(objRef){
    // Synchronizowane instrukcje...
    }

    Parametr objRef to referencja do synchronizowanego obiektu. Blok synchronizujący zapewnia,
    iż wywołanie metody będącej składoskładową objRef będzie wykonywane tylko przez wątek, któremu
    udało się wejść do monitora objRef.
     */

    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}
