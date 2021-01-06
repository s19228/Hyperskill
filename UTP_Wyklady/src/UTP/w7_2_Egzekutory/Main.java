package UTP.w7_2_Egzekutory;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        Executor exec = Executors.newFixedThreadPool(2);  // Wykonawca, prowadzący pulę wątków o zadanych maksymalnych rozmiarach
        for (int i =1; i <= 4; i++){
            exec.execute(new Task("Dupa " + i));
        }

        /*
        Usługę zamknięcia dostarcza interfejs ExecutorService, który jest rozszerzeniem interfejsu Executor.
        Metody fabryczne klasy Executors zwracają Wykonawców implementujących ExecutorService
         */

    }


}
