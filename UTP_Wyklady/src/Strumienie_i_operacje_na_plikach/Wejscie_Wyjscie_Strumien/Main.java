package Strumienie_i_operacje_na_plikach.Wejscie_Wyjscie_Strumien;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        InputStream is;
        OutputStream os;

        Reader reader;
        try {
            Writer writer = new FileWriter("nazwaPliku.txt");

            writer.write("Cokolwiek");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
