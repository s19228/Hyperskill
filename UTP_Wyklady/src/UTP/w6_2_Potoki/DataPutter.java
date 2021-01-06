package UTP.w6_2_Potoki;

import java.io.IOException;
import java.io.OutputStream;

/*
        Niech na przyklad obiekt-wątek klasy DataPutter produkuje jakieś dane i umieszcza je w strumieniu wyjściowym, do którego referencję otrzymuje konstruktor.
 */

class DataPutter extends Thread {

    OutputStream out;

    public DataPutter(OutputStream o) {
        out = o;
    }

    public void run() {
        try {
            for (char c = 'a'; c <= 'z'; c++) out.write(c);
            out.close();
        } catch (IOException exc) {
            return;
        }

    }
}
