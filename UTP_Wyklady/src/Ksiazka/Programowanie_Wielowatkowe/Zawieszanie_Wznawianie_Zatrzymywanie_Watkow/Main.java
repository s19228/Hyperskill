package Ksiazka.Programowanie_Wielowatkowe.Zawieszanie_Wznawianie_Zatrzymywanie_Watkow;

public class Main {

    public static void main(String[] args) {

        /*
        Wystarczy tak zaprojektować metodę run(), by okresowo sama sprawdzała, czy wątek powinien zostać zawieszony, wznowiony lub zatrzymany.
         */
        NewThread ob3 = new NewThread("Trzeci");
        Thread.State third = ob3.t.getState();
        System.out.println(third);

        NewThread ob1 = new NewThread("jeden");
        NewThread ob2 = new NewThread("dwa");

        ob1.t.start();
        ob2.t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ob1.mysuspend();
        System.out.println("Zawieszenie wątku jeden");
        ob1.myresume();
        System.out.println("Wznowienie wątku jeden");
        System.out.println("Zawieszenie wątku dwa");
        ob1.myresume();
        System.out.println("Wznowienie wątku dwa");

        //Oczekiwanie na zakończenie wątków

        System.out.println("Oczekiwanie na zaończenie wątków");
        try {
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Przerwanie wątku głównego");
        }
        System.out.println("Wątek pierwszy is " + ob1.t.getState());
        System.out.println("Wątek drugi is " + ob2.t.getState());
        System.out.println("Koniec wątku głównego");
    }
}
