package Ksiazka.Programowanie_Wielowatkowe.Tworzenie_wielu_watkow;

public class MyThread implements Runnable {

    Thread t;
    String name;

    public MyThread(String threadname) {
        this.name = threadname;
        t = new Thread(this, name);
        System.out.println("Nowy wątek: " + t);
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Przerwano " + name);
        }
        System.out.println("Zakończenie " + name);
    }
}
