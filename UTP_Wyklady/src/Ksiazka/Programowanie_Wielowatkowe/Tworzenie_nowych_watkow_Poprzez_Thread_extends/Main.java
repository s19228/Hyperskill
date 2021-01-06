package Ksiazka.Programowanie_Wielowatkowe.Tworzenie_nowych_watkow_Poprzez_Thread_extends;

public class Main {

    public static void main(String[] args) {

        NewThread nt = new NewThread();
        nt.start();

        for (int i = 5; i > 0; i--){
            try {
                System.out.println("Glowny wątek: " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Przerwano główny wątek");
            }
        }
        System.out.println("***Wyjście z głównego wątku***");

    }


}
