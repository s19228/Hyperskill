package Udemy.Kloekcje_Listy_Mapy_Kolejki.Kolejki;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class PoszukiwaczSciezek implements Runnable{

    BlockingQueue<File> kolejka;
    File sciezkaGlowna;

    public PoszukiwaczSciezek(BlockingQueue<File> kolejka, File sciezkaGlowna) {
        this.kolejka = kolejka;
        this.sciezkaGlowna = sciezkaGlowna;
    }

    public void szukajSciezek(File sciezka) throws InterruptedException {
        File [] sciezki = sciezka.listFiles();

        for (int i = 0; i < sciezki.length; i++){
            if (sciezki[i].isDirectory())
                szukajSciezek(sciezki[i]);
            else
                kolejka.put(sciezki[i]);
        }

    }

    @Override
    public void run() {
        try {
            szukajSciezek(sciezkaGlowna);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            kolejka.put(new File("empty"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
