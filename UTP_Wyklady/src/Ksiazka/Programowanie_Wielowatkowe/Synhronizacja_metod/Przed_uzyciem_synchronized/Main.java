package Ksiazka.Programowanie_Wielowatkowe.Synhronizacja_metod.Przed_uzyciem_synchronized;

public class Main {
    public static void main(String[] args) {

        Callme target = new Callme();
        Caller one = new Caller(target, "Witaj");
        Caller two = new Caller(target, "synchronizowany");
        Caller three = new Caller(target, "świecie");

        one.t.start();
        two.t.start();
        three.t.start();

        try {
            one.t.join();
            two.t.join();
            three.t.join();
        } catch (InterruptedException e) {
            System.out.println("Przerwano");
        }

    }
}
