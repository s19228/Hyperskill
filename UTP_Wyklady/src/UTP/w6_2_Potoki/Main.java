package UTP.w6_2_Potoki;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {

    public static void main(String[] args) {

        //Potoki służą do przesyłania danych pomiędzy równolegle działającymi wątkami.

        /*
        Wątek produkujący dane zapisuje je do potoku wyjściowego (PipedWriter lub PipedOutputStream).
        Potok ten za pomocą konstruktorów potokowych klas wejściowych (PipedReader i PipedInputStream) można przyłączyć do strumienia wejściowego, z którego inny watek będzie czytał dane.
        Niech na przyklad obiekt-wątek klasy DataPutter produkuje jakieś dane i umieszcza je w strumieniu wyjściowym, do którego referencję otrzymuje konstruktor.

        Za pomocą potoku możemy połączyć wyjściowy strumień, do którego pisze DataPutter z wejściowym strumieniem czytanym przez DataGetter.
        W tym celu zwiążemy strumień wyjściowy, do którego ma pisać DataPutter z potokiem:
         */
        try {
            PipedOutputStream pout = new PipedOutputStream();

        /*
        i potok ten połączymy ze strumieniem wejściowym, z którego będzie czytał DataGetter.
         */
            PipedInputStream pin = new PipedInputStream(pout);

            new DataPutter(pout).start();
            new DataGetter(pin).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Wątek-Autor pisze teksty, skladając losowo wybrane słowa w wiersze o losowo wybranej liczbie słów. Wiersze te pobiera wątek-Duplikator i rozdysponowuje je do wielu wątków-przepisywaczy (TxtWriter), Każdy z przepisywaczy równolegle  wypisuje tekst Autora w przydzielonynym mu miejscu (nazwiemy je SpaceToWrite).

    }

}
