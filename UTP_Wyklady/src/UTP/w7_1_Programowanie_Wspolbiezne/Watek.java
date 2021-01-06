package UTP.w7_1_Programowanie_Wspolbiezne;

public class Watek implements Runnable {

    /*
    Ale kod, wykonujący się jako wątek (sekwencja działań, wykonująca się równolegle z innymi działaniami programu) określany jest przez obiekt klasy implementującej interfejs Runnable.
    Interfejs ten zawiera deklarację metody run(), która przy implementacji musi być zdefiniowana.
    Właśnie w metodzie run() zapisujemy kod, który będzie wykonywany jako wątek (równolegle z innymi wątkami programu).
    Metoda run() określa co ma robić wątek.
     */

    @Override
    public void run() {
        System.out.println("Dostarczyć w niej definicji metody run (co ma robić wątek). - klasa Wątek");
    }
}
