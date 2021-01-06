package Strumienie_i_operacje_na_plikach.FiltrowanieStrumieni;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        InputStream is;
        OutputStream os;
        Reader reader;

            Writer writer = new BufferedWriter(new FileWriter("nazwaPliku.txt"));
            writer.write("Cokolwiek");
            ((BufferedWriter) writer).newLine(); // musimy zrzutować zeby mieć większy dostęp do metod
            writer.write("Lakszama mika fą");
            writer.close();

            // skończyłem na 6 minucie



    }


}
