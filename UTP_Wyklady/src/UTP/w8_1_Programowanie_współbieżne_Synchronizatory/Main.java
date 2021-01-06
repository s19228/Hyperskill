package UTP.w8_1_Programowanie_współbieżne_Synchronizatory;

public class Main {

        public static void main(String[] args) {

            int tnum = 5; //Integer.parseInt(args[0]); // liczba wątków
            int count = 1000000; //Integer.parseInt(args[1]); // liczba powtórzeń pętli w run()

            // Tworzymy obiekt klasy balance
            Balance b = new Balance();

            // Tworzymy i uruchamiamy wątki
            Thread[] thread = new Thread[tnum]; // tablica wątków
            for (int i = 0; i < tnum; i++)
                thread[i] = new BalanceThread("W"+(i+1), b, count);

            // czekaj na zakończenie wszystkich wątków
            try {
                for (int i = 0; i < tnum; i++) thread[i].join();
            } catch (InterruptedException exc) {
                System.exit(1);
            }
            System.out.println("Koniec programu");
        }

    }