package Udemy.Kloekcje_Listy_Mapy_Kolejki.Kolejki;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class PrzeszukiwaczPlikow implements Runnable {

    BlockingQueue<File> kolejka;
    String szukaneSlowo;

    public PrzeszukiwaczPlikow(BlockingQueue<File> kolejka, String szukaneSlowo) {
        this.kolejka = kolejka;
        this.szukaneSlowo = szukaneSlowo;
    }

    @Override
    public void run() {
        boolean skonczone = false;

        while (!skonczone) {
            File przeszukiwanyPlik = null;
            try {
                przeszukiwanyPlik = kolejka.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (przeszukiwanyPlik.equals(new File("pusty"))) {

                try {
                    kolejka.put(przeszukiwanyPlik);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                skonczone = true;

            } else szukajSlowa(przeszukiwanyPlik);
        }

    }

    public void szukajSlowa(File przeszukanyPlik) {
        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(przeszukanyPlik)))) {
            int numerLinii = 0;
            while (reader.hasNextLine()){
                numerLinii++;
                if(reader.nextLine().contains(szukaneSlowo)){
                    System.out.println("Szukane slowo znajduje sie w pliku :" + przeszukanyPlik.getPath() + " w linii: " + numerLinii);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




    }


}
