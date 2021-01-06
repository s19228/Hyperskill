package Ksiazka.Programowanie_Wielowatkowe.Tworzenie_i_uruchamianie_nowych_watkow;

import UTP.w1_3_Generixy.Moveable;

public class NewThread implements Runnable {

    Thread t;

    /*
    W ciele konstruktora klasy NewThread tworzymy nowy obiekt typu Thread za pomocą następującego
    wywołania:
    t = new Thread(this, "Przykładowy wątek");
    Przekazanie this jako pierwszego argumentu oznacza, iż nowy wątek ma rozpocząć działanie
    od metody run() zdefiniowanej w aktualnym obiekcie. Wewnątrz metody main() uruchamia wątek
    za pomocą metody start(). Powoduje to rozpoczęcie działania pętli for z metody run(). Następnie
    wątek główny zaczyna wykonywanie pętli for. Oba wątki wykonują się współbieżnie aż do zakończenia
    zawartych w nich pętli.
     */

    public NewThread() {
        t = new Thread(this, "Przykładowy wątek");
        System.out.println("Watek potomny" + t);
    }

    @Override
    public void run() {

        for (int i = 5; i > 0; i--){
            System.out.println("Wątek potomny: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Przerwanie wątku potomnego!");
            }
        }
        System.out.println("***Koniec watkow potomnych***");

    }
}
