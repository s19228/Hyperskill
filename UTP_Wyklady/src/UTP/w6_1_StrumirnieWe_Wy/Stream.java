package UTP.w6_1_StrumirnieWe_Wy;

import java.io.*;

//Metody klas strumieniowych są zazwyczaj odpowiednio przedefiniowane w klasach dziedziczących; polimorfizm zapewnia ich oszczędne i właściwe użycie.
//Dzięki temu możemy np. opracować ogólną klasę udostępniającą rudymentarne kopiowanie strumieni.

public class Stream {

    static void copy(InputStream in, OutputStream out) throws IOException {
        int c;
        while ((c = in.read()) != -1) out.write(c);
    }

    static void copy(Reader in, Writer out) throws IOException {
        int c;
        while ((c = in.read()) != -1) out.write(c);
    }






}
