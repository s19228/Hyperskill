package UTP.w8_1_Programowanie_współbieżne_Synchronizatory;

import UTP.w2_1_Progamowanie_Funkcyjne.Filter;

import java.io.*;

public class BalanceThread extends Thread {

    private Balance b;
    private int count;

    public BalanceThread(String name, Balance b, int count) {
        super(name);
        this.b = b;
        this.count = count;
        start();
    }

    @Override
    public void run() {
        PrintStream out = null;
        int wynik = 0;
        try{
        // W pętli wielokrotnie wywołujemy metodę balance()
        // na rzecz obiektu b klasy Balance.
        // Jeżeli wynik metody jest różny od zera - przerywamy działanie pętli
        for (int i = 0; i < count; i++) {
            wynik = b.balance();
            if (wynik != 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + " konczy z wynikiem " + wynik);

                out = new PrintStream(new FileOutputStream("log.txt"));
            }

            System.setOut(out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
