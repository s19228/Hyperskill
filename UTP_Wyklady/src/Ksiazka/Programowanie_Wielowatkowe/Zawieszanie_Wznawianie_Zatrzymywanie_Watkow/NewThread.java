package Ksiazka.Programowanie_Wielowatkowe.Zawieszanie_Wznawianie_Zatrzymywanie_Watkow;

public class NewThread implements Runnable {

    String name;
    Thread t;
    boolean suspendFlag;

    public NewThread(String threadName) {
        this.name = threadName;
        t = new Thread(this, name);
        System.out.println("Nowy watek: " + t);
        this.suspendFlag = false;
    }

    // To jest punkt startowy wątku
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i + " " + t.getState());
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " został przerwany");
        }
        System.out.println("Wyjście z wątku " + name);
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}

