package Udemy.Kloekcje_Listy_Mapy_Kolejki.Kolejki;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {

        //*** KOLEJKA ***//

        BlockingQueue <File> kolejka = new ArrayBlockingQueue<File>(5); // LinkedBlockingQueue bez podawania capacity

        new Thread(new PoszukiwaczSciezek(kolejka, sciezkaGlowna)).start();

        for (int i = 0 ; i <=50 ; i++)
            new Thread(new PrzeszukiwaczPlikow(kolejka, "dupa")).start();




    }

    final static private File sciezkaGlowna = new File(System.getProperty("user.dir"));
    final static private String slowoSzukane = "dupa";




}
