package Strumienie_i_operacje_na_plikach.Pliki_i_Foldery;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home")); //domyślna ścieżka

        System.out.println(System.getProperty("user.dir")); //domyślna ścieżka
        System.out.println(System.getProperty("user.name")); //domyślna ścieżka

        File plik = new File("srest.txt");

        testujPlik(plik);
        coMogeZrobic(plik);

        //plik.delete();\

        File katalog = new File("Nowy Katalog");
        katalog.mkdir();

        File katalogi = new File("A" + File.separator + "B" + File.separator + "C");
        katalogi.mkdirs();

        File plik2 = new File("C:\\Users\\conra\\IdeaProjects\\UTP_Wyklady\\A\\B\\C", "lekcja1.txt");
        /*
        taki sam zapis:
        File plik2 = new File("A" + File.separator + "B" + File.separator + "C");
         */

        testujPlik(plik2);

        System.out.println(Arrays.toString(plik2.list()));
        System.out.println("---------------");
        Main.wypiszWszystkieSciezcki(new File(System.getProperty("user.home")+"/UTP6dir"));

    }

    public static void wypiszWszystkieSciezcki(File nazwaSciezki)
    {
        String[] nazwyPlikowIKatalogow = nazwaSciezki.list();

        for (int i = 0; i < nazwyPlikowIKatalogow.length; i++)
        {
            File p = new File(nazwaSciezki.getPath(), nazwyPlikowIKatalogow[i]);

            if (p.isFile()); //aby znalezc tylko pliki

            try {
                if (p.isFile())
                {
                    System.out.println(p.getPath());
                    wypiszWszystkieSciezcki(new File(p.getPath()));
                }
            } catch (NullPointerException e) {
                e.getMessage();
            }
        }
    }

    public static void testujPlik(File filename){
        if (!filename.exists()){
            try {
                filename.createNewFile();
                System.out.println("Uworzono nowy plik w katalogu domyslnym");
            } catch (IOException e) {
                System.out.println("Powstał nieoczekiwany błąd ");
                e.printStackTrace();
                e.getMessage();
            }
        }
        else
            System.out.println("Plik instnieje");
}

    public static void coMogeZrobic(File filename){
        if (filename.exists()){
            System.out.println("Czy mogę odczytac? " + filename.canRead());
            System.out.println("Czy mogę zapisać? " + filename.canWrite());
            System.out.println("Czy mogę wykonać? " + filename.canExecute());
            System.out.println("Czy jest ukryty? " + filename.isHidden());
            System.out.println("Czy jest plikiem? " + filename.isFile());
            System.out.println("Ostatnia modyfikacja: " + new Date(filename.lastModified()));
            System.out.println("Dlugość pliku w bajtach: " + filename.length()); // ilość znaków
        }
        else
            System.out.println("Plik nie istnieje");
    }

}
