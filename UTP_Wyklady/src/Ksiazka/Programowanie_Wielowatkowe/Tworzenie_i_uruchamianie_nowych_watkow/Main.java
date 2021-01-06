package Ksiazka.Programowanie_Wielowatkowe.Tworzenie_i_uruchamianie_nowych_watkow;

public class Main {

    public static void main(String[] args) {

        NewThread nt = new NewThread(); // utworzenie wątku
        nt.t.start(); // uruchomienie watku

        /*
        NewThread nt = new NewThread(); // utworzenie wątku
        Thread t = new Thread(nt);
        nt.start();
         */

        for (int i = 5; i > 0; i--){
            System.out.println("Wątek glowny: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Przerwanie wątku glownego!");
            }
        }
        System.out.println("***Koniec wątku głównego");

    }


}
