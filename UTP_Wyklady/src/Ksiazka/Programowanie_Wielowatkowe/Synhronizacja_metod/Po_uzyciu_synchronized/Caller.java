package Ksiazka.Programowanie_Wielowatkowe.Synhronizacja_metod.Po_uzyciu_synchronized;

public class Caller implements Runnable{
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
    }

    @Override
    public void run() {
        target.call(msg);
    }
}
